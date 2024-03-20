import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IdeaFormComponent} from "./components/idea-form/idea-form.component";
import {RegisterFormComponent} from "./components/register-form/register-form.component";
import {LoginFormComponent} from "./components/login-form/login-form.component";
import {IdeaListComponent} from "./components/idea-list/idea-list.component";
import {NewIdeaListComponent} from "./components/new-idea-list/new-idea-list.component";

const routes: Routes = [
  {path: "idea-form", component: IdeaFormComponent},
  {path: "register", component: RegisterFormComponent},
  {path: "login", component: LoginFormComponent},
  {path: "idea-list", component: IdeaListComponent},
  {path: "new-idea-list", component: NewIdeaListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
