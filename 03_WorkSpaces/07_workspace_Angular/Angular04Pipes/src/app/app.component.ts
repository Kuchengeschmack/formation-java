import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  // La propriété utilisée pour le pipi Lowercase
  message1 = "TOTO À PARIS";

  // La propriété utilisée pour le pipe Uppercase
  message2 = "toto à paris";

  // Pour le pipe titlecase
  message3 = "tOTO À lILLE";

  // Pour la date
  now = Date.now();

  msg="";
}
