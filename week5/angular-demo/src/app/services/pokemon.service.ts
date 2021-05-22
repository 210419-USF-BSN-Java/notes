import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Pokemon } from '../models/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) { }

  myNumber: number =42;

  getPokemonById(id: number): Observable<Pokemon>{
    return this.http.get('https://pokeapi.co/api/v2/pokemon/'+id).pipe(
      map(response => response as Pokemon)
    );
  };
}
