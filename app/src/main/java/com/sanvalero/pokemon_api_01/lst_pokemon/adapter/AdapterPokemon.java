package com.sanvalero.pokemon_api_01.lst_pokemon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanvalero.pokemon_api_01.R;
import com.sanvalero.pokemon_api_01.entities.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPokemon extends RecyclerView.Adapter<AdapterPokemon.ViewHolderPokemon> {

    ArrayList<Pokemon> lstPokemon;

    public AdapterPokemon(ArrayList<Pokemon> lstPokemon) {
        this.lstPokemon = lstPokemon;
    }

    @NonNull
    @Override
    public AdapterPokemon.ViewHolderPokemon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lst_pokemon, null, false);

        return new ViewHolderPokemon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPokemon.ViewHolderPokemon holder, int position) {
        holder.etiNombre.setText(lstPokemon.get(position).getName());
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+(position+1)+".png").into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return lstPokemon.size();
    }

    public class ViewHolderPokemon extends RecyclerView.ViewHolder {
        TextView etiNombre;
        ImageView foto;

        public ViewHolderPokemon(@NonNull View itemView) {
            super(itemView);

            etiNombre = (TextView) itemView.findViewById(R.id.idNombre);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> lstPokemon) {

    }
}
