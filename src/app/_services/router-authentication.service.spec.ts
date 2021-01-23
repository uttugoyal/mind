import { TestBed } from '@angular/core/testing';

import { RouterAuthenticationService } from './router-authentication.service';

describe('RouterAuthenticationService', () => {
  let service: RouterAuthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RouterAuthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
