import { Component, OnInit , ViewChild} from '@angular/core';
import { Teacher } from '../../models/teacher';
import { TeacherService } from '../../services/teacher.service';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { MatTableDataSource, MatSort, MatSortable, MatPaginator } from '@angular/material';

@Component({
  selector: 'app-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent implements OnInit {

  private selectedTeacher: Teacher;
  private checked: boolean;
  private teachers: Teacher[];
  private allChecked: boolean;
  // private removeBookList: Book[] = new Array();

  private loggedIn = false;
  dataSource;
  displayedColumns = ['#', 'teachername', 'phonenumber', 'email','address','school', 'actions'];//,'Status'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private router:Router,
    private teacherService: TeacherService,
    private flashMessagesService: FlashMessagesService,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    this.loginService.checkSession().subscribe(
      result => {
        this.loggedIn = true;
      },
      error => {
        this.loggedIn = false;
      }
    );
    this.dataSource = null;
     
    this.getTeacherList();
  }
  getTeacherList() {
    this.dataSource = null;
    this.teacherService.getAllTeachers().subscribe(
      res => {
        console.log(res.json());
        this.teachers=res.json();
        this.dataSource = new MatTableDataSource(res.json());
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      }, 
      error => {
        console.log(error);
      }
      );
  }
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
  onEditClick(id: number) {

    this.router.navigate(['/edit-teacher/' + id]);

  }
  onDeleteClick(id: number) {
    if (confirm("Are you sure to delete?")) {
      // this.teacherService.delete(id);

      // this.flashMessagesService.show("Teacher Deleted", { cssClass: 'alert-success', timeout: 4000 });
      this.router.navigate(['/teachers']);
    }
  }
}
