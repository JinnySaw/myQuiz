import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { FlashMessagesModule } from 'angular2-flash-messages'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MaterialModule } from './material.module';

import { AppComponent } from './app.component';
import { QuizListComponent } from './components/quiz-list/quiz-list.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AddQuizComponent } from './components/add-quiz/add-quiz.component';
import { EditQuizComponent } from './components/edit-quiz/edit-quiz.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { SettingsComponent } from './components/settings/settings.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

// Services
import { QuizService } from './services/quiz.service';
import { LoginService } from './services/login.service';
import { SchoolService } from './services/school.service';
import { AcademicyearService } from './services/academicyear.service'; 

import { SchoolsComponent } from './components/schools/schools.component';
import { AddSchoolComponent } from './components/add-school/add-school.component';
import { EditSchoolComponent } from './components/edit-school/edit-school.component';
import { AcademicyearComponent } from './components/academicyear/academicyear.component';
import { AddAcademicyearComponent } from './components/add-academicyear/add-academicyear.component'; 
import { AcademiclistComponent } from './components/academiclist/academiclist.component';
import { EditAcademicComponent } from './components/edit-academic/edit-academic.component';
import { routing } from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    QuizListComponent,
    DashboardComponent,
    AddQuizComponent,
    EditQuizComponent,
    NavbarComponent,
    SidebarComponent,
    LoginComponent,
    RegisterComponent,
    SettingsComponent,
    PageNotFoundComponent,
    SchoolsComponent,
    AddSchoolComponent,
    EditSchoolComponent,
    AcademicyearComponent,
    AddAcademicyearComponent,
    EditAcademicComponent,
    AcademiclistComponent,
    EditAcademicComponent,
  ],
  imports: [
    BrowserModule,
    // import RouterModule and parse in our appRoute
    //RouterModule.forRoot(appRoutes),
    routing,
    HttpModule,
    FormsModule,
    FlashMessagesModule.forRoot(),
    MaterialModule,
    BrowserAnimationsModule
  ],
  providers: [
    QuizService,
    LoginService,
    SchoolService,
    AcademicyearService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
