import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAcademicComponent } from './edit-academic.component';

describe('EditAcademicComponent', () => {
  let component: EditAcademicComponent;
  let fixture: ComponentFixture<EditAcademicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditAcademicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAcademicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
