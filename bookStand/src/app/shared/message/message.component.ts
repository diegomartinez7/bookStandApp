import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {
  title: string;
  body: string;
  actions: any = [];

  constructor(
      public dialogRef: MatDialogRef<any>,
      @Inject(MAT_DIALOG_DATA) public data: any
  ) {
      this.title = this.data.title;
      this.body = this.data.body;
      this.actions = this.data.actions;
  }

  ngOnInit(): void {
  }

}
