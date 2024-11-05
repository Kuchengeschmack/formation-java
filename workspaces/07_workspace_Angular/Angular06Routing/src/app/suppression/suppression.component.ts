import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-suppression',
  templateUrl: './suppression.component.html',
  styleUrls: ['./suppression.component.css']
})
export class SuppressionComponent implements OnInit {

  id:number=0;

  constructor(private ar:ActivatedRoute) { }

  ngOnInit(): void {

    this.ar.params.subscribe((pars)=>{
      console.log(pars);
      this.id=pars['pId'];
    });
  }

}
