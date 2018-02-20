import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatTableModule, MatSortModule, MatInputModule, MatPaginatorModule,MatSelectModule,MatCardModule } from '@angular/material';

@NgModule({
    imports: [
        MatButtonModule,
        MatTableModule,
        MatSortModule,
        MatInputModule,
        MatPaginatorModule,
        MatSelectModule,
        MatCardModule
    ],
    exports: [
        MatButtonModule,
        MatTableModule,
        MatSortModule,
        MatInputModule,
        MatPaginatorModule,
        MatSelectModule,
        MatCardModule
    ]
})

export class MaterialModule { }