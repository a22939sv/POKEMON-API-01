package com.sanvalero.pokemon_api_01.lst_pokemon.presenter;

import com.sanvalero.pokemon_api_01.lst_pokemon.LstPokemonContract;
import com.sanvalero.pokemon_api_01.entities.Pokemon;
import com.sanvalero.pokemon_api_01.lst_pokemon.model.LstPokemonModel;

import java.util.ArrayList;

public class LstPokemonPresenter implements LstPokemonContract.Presenter {
    private LstPokemonModel lstPokemonModel;
    private LstPokemonContract.View view;

    public LstPokemonPresenter(LstPokemonContract.View view) {
        this.view = view;
        lstPokemonModel = new LstPokemonModel();
    }

    @Override
    public void lstPokemon(Pokemon pokemon) {
        lstPokemonModel.lstPokemonWS(pokemon, new LstPokemonContract.Model.OnLstPokemonListener() {
            @Override
            public void onSuccess(ArrayList<Pokemon> lstSimpson) {
                if (lstSimpson != null && lstSimpson.size() > 0) {
                    view.successLstPokemon(lstSimpson, "He recogido los datos correctamente!!!");
                } else {
                    view.failureLstPokemon("Los datos no han llegado correctamente!!!");
                }
            }

            @Override
            public void onFailure(String error) {
                view.failureLstPokemon("Error al recoger los datos!!!");
            }
        });
    }
}
