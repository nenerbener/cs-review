import { Component, OnInit } from '@angular/core';
import { Recipe } from '../recipe.model';

@Component({
  selector: 'app-recipelist',
  templateUrl: './recipelist.component.html',
  styleUrls: ['./recipelist.component.css']
})
export class RecipelistComponent implements OnInit {

recipes: Recipe[] = [
    new Recipe('A Test Recipe',
    'This is simply a test',
    'https://www.bbcgoodfood.com/sites/default/files/guide/guide-image/2018/06/chicken-wings-main.jpg'),
    new Recipe('A Test Recipe',
    'This is simply a test',
    'https://www.bbcgoodfood.com/sites/default/files/guide/guide-image/2018/06/chicken-wings-main.jpg')
];
  constructor() { }

  ngOnInit() {
  }

}
