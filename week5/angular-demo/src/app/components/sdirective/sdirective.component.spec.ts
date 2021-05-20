import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SdirectiveComponent } from './sdirective.component';

describe('SdirectiveComponent', () => {
  let component: SdirectiveComponent;
  let fixture: ComponentFixture<SdirectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SdirectiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SdirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
