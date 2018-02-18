import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatTableModule, MatSortModule, MatInputModule, MatPaginatorModule,MatSelectModule } from '@angular/material';

@NgModule({
    imports: [
        MatButtonModule,
        MatTableModule,
        MatSortModule,
        MatInputModule,
        MatPaginatorModule,
        MatSelectModule
    ],
    exports: [
        MatButtonModule,
        MatTableModule,
        MatSortModule,
        MatInputModule,
        MatPaginatorModule,
        MatSelectModule
    ]
})

export class MaterialModule { }