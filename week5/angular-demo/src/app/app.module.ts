import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MycompComponent } from './components/mycomp/mycomp.component';
import { NavComponent } from './components/nav/nav.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { FormsModule } from '@angular/forms';
import { SdirectiveComponent } from './components/sdirective/sdirective.component';
import { MyPipePipe } from './pipes/my-pipe.pipe';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    MycompComponent,
    DatabindingComponent,
    SdirectiveComponent,
    MyPipePipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
