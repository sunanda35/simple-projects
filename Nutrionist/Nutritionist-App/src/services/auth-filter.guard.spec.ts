import { TestBed } from '@angular/core/testing';

import { AuthFilterGuard } from './auth-filter.guard';

describe('AuthFilterGuard', () => {
  let guard: AuthFilterGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthFilterGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
