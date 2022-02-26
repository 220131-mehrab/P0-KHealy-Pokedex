package com.revature.khealy.Dex;


import com.revature.khealy.Domain.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrPokedex implements StrDex {

    protected List<String> pokemons;

    StrPokedex (){
        this.pokemons = new ArrayList<>();

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
        Scanner scanner = new Scanner(this.file, "UTF-8");
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String resultPokeString = scanner.next();
            this.strPokemons.add(resultPokeString);
        }
        scanner.close();
    }
}
