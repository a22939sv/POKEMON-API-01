package com.sanvalero.pokemon_api_01.lst_pokemon.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.sanvalero.pokemon_api_01.R;
import com.sanvalero.pokemon_api_01.entities.Pokemon;
import com.sanvalero.pokemon_api_01.lst_pokemon.LstPokemonContract;
import com.sanvalero.pokemon_api_01.lst_pokemon.adapter.AdapterPokemon;
import com.sanvalero.pokemon_api_01.lst_pokemon.presenter.LstPokemonPresenter;

import java.util.ArrayList;

public class LstPokemonActivity extends AppCompatActivity implements LstPokemonContract.View {
    private LstPokemonPresenter lstPokemonPresenter;
    RecyclerView recyclerPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_pokemons);

        initComponents();
        initPresenter();
        initData();
    }

    private void initComponents() {
        recyclerPokemon = (RecyclerView) findViewById(R.id.RecyclerId);
    }

    private void initPresenter() {
        lstPokemonPresenter = new LstPokemonPresenter(this);
    }

    private void initData() {
        lstPokemonPresenter.lstPokemon(null); // SELECT * FROM SIMPSON
    }

    @Override
    public void successLstPokemon(ArrayList<Pokemon> lstPokemon, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        recyclerPokemon.setLayoutManager(new LinearLayoutManager(this));

        AdapterPokemon adapter = new AdapterPokemon(lstPokemon);
        recyclerPokemon.setAdapter(adapter);
    }

    @Override
    public void failureLstPokemon(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}