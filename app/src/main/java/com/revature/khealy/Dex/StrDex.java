package com.revature.khealy.Dex;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface StrDex {
    List<String> strPokemons = null;
    InputStream file = null;

    private void loadAsString() {
        strPokemons = new ArrayList<strPokemon>();
        Scanner scanner = new Scanner(this.file, "UTF-8");
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String resultPokeString = scanner.next();
            this.strPokemons.add(resultPokeString);
        }
        scanner.close();
    }

    String getPokemon(String name);

    ArrayList<strPokemon> getPokemons();
}


