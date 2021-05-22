import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sdirective',
  templateUrl: './sdirective.component.html',
  styleUrls: ['./sdirective.component.css']
})
export class SdirectiveComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  veryImportantBoolean:boolean = false;
  backgroundColor:string = 'red';
  color: string = 'blue';

  people: string[] = [
    'Kemo',
    `Hi`,
    'PersonFace',
    'Andrew'
  ];

  styles = {
    backgroundColor: "red",
    color: "blue"
  };
  

  changeBoolean(){
    this.veryImportantBoolean = !this.veryImportantBoolean;
  }
}
