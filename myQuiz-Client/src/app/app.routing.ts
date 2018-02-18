import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SchoolsComponent } from './components/schools/schools.component';
import { AddSchoolComponent } from './components/add-school/add-school.component';
import { EditSchoolComponent } from './components/edit-school/edit-school.component';
import { AcademicyearComponent } from './components/academicyear/academicyear.component';
import { AddAcademicyearComponent } from './components/add-academicyear/add-academicyear.component'; 
import { AcademiclistComponent } from './components/academiclist/academiclist.component';
import { EditAcademicComponent } from './components/edit-academic/edit-academic.component';
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

const appRoutes: Routes = [
    {
      path: '',
      redirectTo: '/login',
      pathMatch: 'full'
    },
    // School
    { path: 'school', component: SchoolsComponent },
    { path: 'add-school', component: AddSchoolComponent },
    { path: 'edit-school/:id', component: EditSchoolComponent },
  
    { path: 'dashboard', component: DashboardComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
  
    // Academic
    { path: 'academic', component: AcademicyearComponent },
    { path: 'academiclist', component: AcademiclistComponent },
    { path: 'add-academic', component: AddAcademicyearComponent },
    { path: 'edit-academic/:id', component: EditAcademicComponent },
  
    // Quiz
    { path: 'quiz', component: QuizListComponent },
    { path: 'add-quiz', component: AddQuizComponent },
    { path: 'edit-quiz/:id', component: EditQuizComponent }
  ]

  export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);