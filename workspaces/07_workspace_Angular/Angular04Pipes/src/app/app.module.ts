import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { InverserPipePipe } from './inverser-pipe.pipe';
import { RepeterPipePipe } from './repeter-pipe.pipe';

@NgModule({
  declarations: [
    AppComponent,
    InverserPipePipe,
    RepeterPipePipe
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
