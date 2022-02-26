package com.revature.khealy.Dex;


import com.revature.khealy.Domain.Pokemon;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrPokedex implements StrDex {

    protected List<String> strPokemons;
    private InputStream file;

    StrPokedex (String filename){
        this.strPokemons = new ArrayList<>();

        try {
            this.file = getClass().getClassLoader().getResourceAsStream(filename);
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        loadAsString();
    }

    private void loadAsString() {
        strPokemons = new ArrayList<String>();
        Scanner scanner = new Scanner(this.file, StandardCharsets.UTF_8);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String resultPokeString = scanner.next();
            this.strPokemons.add(resultPokeString);
        }
        scanner.close();
    }

    @Override
    public String getPokemon(String pokemonStirng) {
        boolean found = false;
        String result = "";
        for (String poke : this.pokemons){
            if (!found){
                if (poke.equals(pokemonStirng)){
                    result = poke;
                    found = true;
                };
            }
        }
        if (!found){
            return null;
        }
        else {
            return result;
        }
    }

    @Override
    public ArrayList<String> getPokemons() {
        return (ArrayList<String>) this.pokemons;
    }
}
