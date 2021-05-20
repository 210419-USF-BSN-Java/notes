import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { MycompComponent } from './components/mycomp/mycomp.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { SdirectiveComponent } from './components/sdirective/sdirective.component';

const routes: Routes = [
  {
    path:'mycomp',
    component: MycompComponent
  },{
    path:'databinding',
    component: DatabindingComponent
  },{
    path:'sdirective',
    component: SdirectiveComponent
  }
] 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
