package com.sanvalero.pokemon_api_01.lst_pokemon;

import com.sanvalero.pokemon_api_01.entities.Pokemon;

import java.util.ArrayList;

public interface LstPokemonContract {
    public interface View{
        void successLstPokemon(ArrayList<Pokemon> lstPokemon, String msg);
        void failureLstPokemon(String err);
    }
    public interface Presenter{
        // CASO DE USO
        void lstPokemon(Pokemon pokemon);
    }
    public interface Model{
        interface OnLstPokemonListener{
            void onSuccess(ArrayList<Pokemon> lstPokemon);
            void onFailure(String error);
        }
        void lstPokemonWS(Pokemon pokemon, OnLstPokemonListener onLstPokemonListener);
    }
}
