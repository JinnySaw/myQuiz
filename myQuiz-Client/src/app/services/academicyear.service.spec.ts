import { TestBed, inject } from '@angular/core/testing';

import { AcademicyearService } from './academicyear.service';

describe('AcademicyearService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AcademicyearService]
    });
  });

  it('should be created', inject([AcademicyearService], (service: AcademicyearService) => {
    expect(service).toBeTruthy();
  }));
});
