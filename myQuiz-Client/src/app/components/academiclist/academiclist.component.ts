import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { AcademicyearService } from '../../services/academicyear.service';
import { Observable } from 'rxjs/Observable';
import { MatTableDataSource, MatSort, MatSortable, MatPaginator } from '@angular/material';
import { AcademicYear } from '../../models/academicyear';
import { FlashMessagesService } from 'angular2-flash-messages';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-academiclist',
  templateUrl: './academiclist.component.html',
  styleUrls: ['./academiclist.component.css']
})
export class AcademiclistComponent implements OnInit {
  private loggedIn = false;
  dataSource;
  displayedColumns = ['#', 'academicname', 'year', 'school', 'actions'];//,'Status'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private academicyearService: AcademicyearService,
    private flashMessagesService: FlashMessagesService,
    private router: Router, private loginService: LoginService,
    private changeDetectorRefs: ChangeDetectorRef
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
    this.academicyearService.getAllAcademic().subscribe(results => {
      if (!results) {
        return;
      } 
      this.dataSource = new MatTableDataSource(results);  
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }
  

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
  onEditClick(id: number) {

    this.router.navigate(['/edit-academic/' + id]);

  }
  onDeleteClick(id: number) {
    if (confirm("Are you sure to delete?")) {
      this.academicyearService.deleteAcademic(id);

      this.flashMessagesService.show("Academic Deleted", { cssClass: 'alert-success', timeout: 4000 });
      this.router.navigate(['/academiclist']);
    }
  }
}
