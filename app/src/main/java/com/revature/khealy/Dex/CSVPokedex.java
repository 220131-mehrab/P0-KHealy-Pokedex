package com.revature.khealy.Dex;

import com.revature.khealy.Domain.Pokemon;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVPokedex implements Dex {
    protected List<Pokemon> pokemons;
    private InputStream file;

    public CSVPokedex(String filename) {
        this.pokemons = new ArrayList<>();
        try {
            this.file = getClass().getClassLoader().getResourceAsStream(filename);
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        load();
    }

    private void load(){
        String tempArray[];
        String pokeString = "";

        Scanner scanner = new Scanner(this.file, StandardCharsets.UTF_8);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            pokeString = scanner.next();
            tempArray = pokeString.split(",");
            //printout to stdout
            for (String pokeStr : tempArray) {
                System.out.println(pokeStr);
            }
            //ID,Number,Name,Type1,Type2,Total,HP,Atk,Def,SpAtk,SpDef,Spd,Species,Height,Weight
            Pokemon pokemon = new Pokemon.Builder()
                    .setID(Integer.parseInt(tempArray[0]))
                    .setNumber(tempArray[1])
                    .setName(tempArray[2])
                    .setType1(tempArray[3])
                    .setType2(tempArray[4])
                    .setTotal(Integer.parseInt(tempArray[5]))
                    .setHP(Integer.parseInt(tempArray[6]))
                    .setAtk(Integer.parseInt(tempArray[7]))
                    .setDef(Integer.parseInt(tempArray[8]))
                    .setSpAtk(Integer.parseInt(tempArray[9]))
                    .setSpDef(Integer.parseInt(tempArray[10]))
                    .setSpd(Integer.parseInt(tempArray[11]))
                    .setSpecies(tempArray[12])
                    .setHeight(tempArray[13])
                    .setWeight(tempArray[14])
                    .build();
            //printout to stdout
            System.out.println(pokemon.toString());
            //must eventually add to Arraylist.
            pokemons.add(pokemon);
        }
        scanner.close();
    }

    public ArrayList<Pokemon> getPokemons() {
        return (ArrayList<Pokemon>) this.pokemons;
    }

    @Override
    public String getPokemon(String pokeName) {
        boolean found = false;
        String result = "";
        for (Pokemon pokemon : this.pokemons){
            if (!found){
                if (pokeName.equals(pokemon.getName())){
                    result = pokemon.getName();
                    found = true;
                }
            }
        }
        if (!found){
            return null;
        }
        else {
            return result;
        }
    }
}




