import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AcademiclistComponent } from './academiclist.component';

describe('AcademiclistComponent', () => {
  let component: AcademiclistComponent;
  let fixture: ComponentFixture<AcademiclistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AcademiclistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AcademiclistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
