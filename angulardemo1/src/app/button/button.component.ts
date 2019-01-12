import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {

  showPW = false;
  logArray = [];
  logNumber = 0;

  constructor() { }

  ngOnInit() {
  }

  onButton() {
   this.showPW = !this.showPW;
   this.logArray.push(++this.logNumber);
//    this.logArray.push(this.logArray.length + 1);
  }
}
