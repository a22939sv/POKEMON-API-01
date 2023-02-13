package com.sanvalero.pokemon_api_01.lst_pokemon.model;

import com.sanvalero.pokemon_api_01.entities.PokemonRespuesta;
import com.sanvalero.pokemon_api_01.lst_pokemon.LstPokemonContract;
import com.sanvalero.pokemon_api_01.entities.Pokemon;
import com.sanvalero.pokemon_api_01.lst_pokemon.utils.ApiClient;
import com.sanvalero.pokemon_api_01.lst_pokemon.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstPokemonModel implements LstPokemonContract.Model {

    @Override
    public void lstPokemonWS(Pokemon pokemon, OnLstPokemonListener onLstPokemonListener) {
        getPokemonService(onLstPokemonListener);
    }

    public void getPokemonService(final OnLstPokemonListener onLstPokemonListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<PokemonRespuesta> call = apiService.getPokemons(0,0);
        call.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                PokemonRespuesta pokemonRespuesta = response.body();
                ArrayList<Pokemon> lstPokemon = pokemonRespuesta.getResults();

                onLstPokemonListener.onSuccess(lstPokemon);
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                onLstPokemonListener.onFailure(t.getMessage());
            }
        });
    }
}
