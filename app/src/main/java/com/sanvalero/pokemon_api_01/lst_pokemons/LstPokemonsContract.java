package com.sanvalero.pokemon_api_01.lst_pokemons;

import com.sanvalero.pokemon_api_01.lst_pokemons.entities.Pokemon;

import java.util.ArrayList;

public interface LstPokemonsContract {
    public interface View{
        void successLstPokemons(ArrayList<Pokemon> lstPokemon, String msg);
        void failureLstPokemons(String err);
    }
    public interface Presenter{
        // CASO DE USO
        void lstPokemons(Pokemon pokemon);
    }
    public interface Model{
        interface OnLstPokemonsListener{
            void onSuccess(ArrayList<Pokemon> lstPokemon);
            void onFailure(String error);
        }
        void lstPokemonsWS(Pokemon pokemon, OnLstPokemonsListener onLstPokemonsListener);
    }
}
