import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {VotingAllComponent} from './voting-all.component';

describe('VotingAllComponent', () => {
  let component: VotingAllComponent;
  let fixture: ComponentFixture<VotingAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [VotingAllComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VotingAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
