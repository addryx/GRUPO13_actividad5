import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderInvitadoComponent } from './header-invitado.component';

describe('HeaderInvitadoComponent', () => {
  let component: HeaderInvitadoComponent;
  let fixture: ComponentFixture<HeaderInvitadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderInvitadoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderInvitadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
