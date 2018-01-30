# MyQuizClient

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.6.5.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).


1. ng new ProjectName
2. cd ProjectName
3. npm install bootstrap@4.0.0-alpha.6 tether jquery --save
4. After installation finished change remove ^ from bootstrap package.json
5. After that run npm install again 
6. Go to angular-cli.json file and find styles, Insert this "../node_modules/bootstrap/dist/css/bootstrap.css"
7. After that find scripts and add these three ""../node_modules/jquery/dist/jquery.js",
        "../node_modules/tether/dist/js/tether.js",
        "../node_modules/bootstrap/dist/js/bootstrap.js"
8. Create components 
    - ng g component components/quiz-list
    - ng g component components/dashboard
    - ng g component components/addQuiz
    - ng g component components/editQuiz
    - ng g component components/navbar
    - ng g component components/sidebar
    - ng g component components/login
    - ng g component components/register
    - ng g component components/settings
    - ng g component components/pageNotFound
9. import { RouterModule, Routes} from ‘@angular/router’; to app.modules.ts
10. Declare these const appRoutes: Routes =[
  {path:'', component: DashboardComponent},
  {path:'register',component:RegisterComponent},
  {path:'login',component: LoginComponent} ]; above @NgModule
11. Inside the imports:[] add new this RouterModule.forRoot(appRoutes)
12. Go to https://v4-alpha.getbootstrap.com/ and search navbar, copy and paste to navbar.component.html
13. insert <app-navbar></app-navbar> to first line of app.component.html
14. Create models Folder under app Folder
15. Create quiz.ts File under models Folder
16. ng g service services/quiz
17. import "import { QuizService } from './services/quiz';" and add QuizService to "provider:[]," at app.module.ts file 
18. install fontawesome "npm install font-awesome --save"
19. add "../node_modules/font-awesome/css/font-awesome.css", above bootstarp to the Style:[] of .angular-cli.json file
