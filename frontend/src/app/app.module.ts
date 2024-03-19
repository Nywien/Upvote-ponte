import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { NavbarComponent } from './components/navbar/navbar.component';
import { IdeaFormComponent } from './components/idea-form/idea-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import { RegisterFormComponent } from './components/register-form/register-form.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { IdeaListComponent } from './components/idea-list/idea-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    IdeaFormComponent,
    RegisterFormComponent,
    LoginFormComponent,
    IdeaListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
