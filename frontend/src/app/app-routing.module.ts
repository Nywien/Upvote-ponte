import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {IdeaFormComponent} from "./components/idea-form/idea-form.component";

const routes: Routes = [
  {path:"idea-form", component: IdeaFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
