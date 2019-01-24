import { Injectable, EventEmitter } from '@angular/core';
import { Recipe } from './recipe.model';
import { Ingredient } from '../shared/ingredient.model';

@Injectable({ providedIn: 'root' })
export class RecipeService {

    recipeSelected = new EventEmitter<Recipe>();
    private recipes: Recipe[] = [
        new Recipe('A Test Recipe',
            'This is simply a test',
            'https://upload.wikimedia.org/wikipedia/commons/1/15/Recipe_logo.jpeg',
            [
                new Ingredient('noodles', 100),
                new Ingredient('meat sauce', 2)
            ]),
        new Recipe('Another Test Recipe',
            'This is simply a test',
            'https://upload.wikimedia.org/wikipedia/commons/1/15/Recipe_logo.jpeg',
            [
                new Ingredient('buns', 2),
                new Ingredient('patty', 1)
            ])
    ];

    getRecipes() {
        return this.recipes.slice();
    }
}
