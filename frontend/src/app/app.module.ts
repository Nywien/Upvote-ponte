import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {NavbarComponent} from './components/navbar/navbar.component';
import {IdeaFormComponent} from './components/idea-form/idea-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import {RegisterFormComponent} from './components/register-form/register-form.component';
import {LoginFormComponent} from './components/login-form/login-form.component';
import {IdeaListComponent} from './components/idea-list/idea-list.component';
import {NewIdeaListComponent} from './components/new-idea-list/new-idea-list.component';
import {HttpRequestInterceptor} from "./utils/httpRequestInterceptor";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    IdeaFormComponent,
    RegisterFormComponent,
    LoginFormComponent,
    IdeaListComponent,
    NewIdeaListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [ [
    {provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptor, multi: true},
  ],],
  bootstrap: [AppComponent]
})
export class AppModule { }
