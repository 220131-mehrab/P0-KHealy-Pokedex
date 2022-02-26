package com.revature.khealy.Dex;

import com.revature.khealy.Domain.Pokemon;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public interface Dex {
    List<Pokemon> pokemons = null;
    InputStream file = null;

    String getPokemon(String name);

    public ArrayList<Pokemon> getPokemons();
}
