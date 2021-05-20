import { Component, OnInit } from '@angular/core';

@Component({
  templateUrl: './databinding.component.html',
  selector: 'app-databinding',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  constructor() { }


  ngOnInit(): void {
  }

  myName:string = 'Kevin';
  /*
    document.getElementBy...().innerHTML = name;
  */
  count:number = 0;
  countColor: string = 'red-text';

  increment(value: number){
    this.count += value;

    if(this.count%5 == 0){
      this.countColor = 'blue-text';
    } else{
      this.countColor = 'red-text';
    }
  }
}
