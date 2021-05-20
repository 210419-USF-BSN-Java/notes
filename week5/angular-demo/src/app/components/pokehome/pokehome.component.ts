import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokehome',
  templateUrl: './pokehome.component.html',
  styleUrls: ['./pokehome.component.css']
})
export class PokehomeComponent implements OnInit {

  constructor(private pokeService: PokemonService) { }

  ngOnInit(): void {
  }

  // ?: to specify that it's ok for the value to be null/und
  pokemon?: Pokemon;

  getPokemon(value:any): void{
    this.pokeService.getPokemonById(value).subscribe(
      response => {
        this.pokemon = response;
      }
    );
  }
}
