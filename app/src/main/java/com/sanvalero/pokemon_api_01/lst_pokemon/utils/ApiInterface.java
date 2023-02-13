package com.sanvalero.pokemon_api_01.lst_pokemon.utils;

import com.sanvalero.pokemon_api_01.entities.Pokemon;
import com.sanvalero.pokemon_api_01.entities.PokemonRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    /*https://pokeapi.co/api/v2/pokemon?limit=0&offset=0*/
    @GET("pokemon")
    Call<PokemonRespuesta> getPokemons(
                                @Query("limit") int limit,
                                @Query("offset") int offset);
}
