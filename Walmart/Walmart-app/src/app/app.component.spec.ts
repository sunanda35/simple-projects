import { AppComponent } from './app.component';

describe('AppComponent', () => {
  let fixture: AppComponent;
  beforeEach(() => {
    fixture = new AppComponent();
  });
  it('It should have a title AngularJest', () => {
    expect(fixture.title).toEqual('eCommerceApp');
  });
});
