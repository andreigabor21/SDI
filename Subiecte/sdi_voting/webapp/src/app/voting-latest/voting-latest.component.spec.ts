import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {VotingLatestComponent} from './voting-latest.component';

describe('VotingLatestComponent', () => {
  let component: VotingLatestComponent;
  let fixture: ComponentFixture<VotingLatestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [VotingLatestComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VotingLatestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
