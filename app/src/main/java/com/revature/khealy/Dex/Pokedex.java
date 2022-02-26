package com.revature.khealy.Dex;

import com.revature.khealy.Domain.Pokemon;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pokedex implements StrDex  {
    protected List<String> pokemons;
    private InputStream file;

    public Pokedex(String filename) {
        this.pokemons = new ArrayList<>();

        try {
            this.file = getClass().getClassLoader().getResourceAsStream(filename);
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        load();

    }

    private void load() {
        Scanner scanner = new Scanner(this.file, StandardCharsets.UTF_8);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String resultPokeString = scanner.next();
            this.pokemons.add(resultPokeString);
        }
        scanner.close();
    }

    @Override
    public ArrayList<Pokemon> getPokemons() {
        load();
        return this.pokemons;
    }


    public String getPokemon(String PokeName) {
        boolean found = false;
        String result = "";
        for (String pokemon : this.pokemonsAsStrings){
            if (pokemon.contains(PokeName) && !found){
                result = pokemon;
                found = true;
            }
        }
        return result;
    }


}
