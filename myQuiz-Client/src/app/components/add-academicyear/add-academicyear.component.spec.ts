import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAcademicyearComponent } from './add-academicyear.component';

describe('AddAcademicyearComponent', () => {
  let component: AddAcademicyearComponent;
  let fixture: ComponentFixture<AddAcademicyearComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddAcademicyearComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAcademicyearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
