package com.revature.khealy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pokedex {


    protected List<String> pokemonsAsStrings;
    protected List<Pokemon> pokemons;
    //private File file;
    private InputStream file;


    public Pokedex(String filename) {
        this.pokemonsAsStrings = new ArrayList<>();

        try {
            //this.file = new FileInputStream("Server/app/src/main/java/Server/" + filename);
            //File file = new File(filename);
            this.file = getClass().getClassLoader().getResourceAsStream(filename);
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        loadAsStrings();
        load();
    }

    private void loadAsStrings() {

        Scanner scanner = new Scanner(this.file, "UTF-8");
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            this.pokemonsAsStrings.add(scanner.next());
        }
        scanner.close();
    }

    private void load(){
        String tempArray[];
        String pokeString = "";

        Scanner scanner = new Scanner(this.file, "UTF-8");
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
/*
    public ArrayList<pokemon> getPokemons(){
        return this.pokemons;
    }
*/
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
