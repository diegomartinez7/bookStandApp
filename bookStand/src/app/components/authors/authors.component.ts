import { Component, OnInit } from '@angular/core';
import { AuthorService } from 'src/app/services/author.service';

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.scss']
})
export class AuthorsComponent implements OnInit {
  autores: any = [];

  constructor(private _authorService: AuthorService) { }

  ngOnInit(): void {
    this.getAutores();
  }

  getAutores(): void {
    this._authorService.getAutores().subscribe(res => {
      this.autores = res;
      console.log('Dentro de subscribe');
      console.log(this.autores);
    });
    
    console.log('Fuera de subscribe');
    console.log(this.autores);
  }
}
