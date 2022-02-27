package com.revature.khealy.Dex;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public interface StrDex {
    List<String> pokemons = null;
    InputStream file = null;

    String getPokemon(String name);

    public ArrayList<String> getPokemons();
}
