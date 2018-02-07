import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule} from '@angular/forms';
import { FlashMessagesModule } from 'angular2-flash-messages';

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

const appRoutes: Routes=[
  {path:'',component:DashboardComponent},
  {path:'register',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'add-quiz', component: AddQuizComponent},
  {path:'edit-quiz/:id',component:EditQuizComponent}
]

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
  ],
  imports: [
    BrowserModule,
    // import RouterModule and parse in our appRoute
    RouterModule.forRoot(appRoutes),
    HttpModule,
    FormsModule,
    FlashMessagesModule.forRoot()
  ],
  providers: [
    QuizService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
