import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
    selector: 'app-alert-dialog',
    templateUrl: './alert-dialog.component.html',
    styleUrls: ['./alert-dialog.component.scss']
})
export class AlertDialogComponent implements OnInit {
  title: String;
  message: string;
  showAccept = null;
  showCancel = null;
  showClose = null;

  constructor(
    private dialogRef: MatDialogRef<any>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.title = data.title;
    this.message = data.message;
    this.showAccept = data.showAccept;
    this.showCancel = data.showCancel;
    this.showClose = data.showClose
  }

  ngOnInit(): void { }

  accept() {
    this.dialogRef.close(true);
  }

  close() {
    this.dialogRef.close(null);
  }

  cancel() {
    this.dialogRef.close(false);
  }
}
