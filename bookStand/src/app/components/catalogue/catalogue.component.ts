import { Component, OnInit } from '@angular/core';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.scss']
})
export class CatalogueComponent implements OnInit {

  constructor(private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  addToCart(): void {
    this.openSnackBar('"Los Viajes de Guilliver" añadido');
  }

  openSnackBar(message: string): void {
    this._snackBar.open(
      message,
      "OK (3s)",
      {
        panelClass: 'snackbar',
        horizontalPosition: 'right',
        verticalPosition: 'bottom',
        duration: 3000
      }
    );
  }

}
