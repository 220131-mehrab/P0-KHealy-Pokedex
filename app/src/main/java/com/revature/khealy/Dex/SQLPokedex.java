package com.revature.khealy.Dex;

import com.revature.khealy.Domain.Pokemon;
import java.sql.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLPokedex implements Dex  {
    protected List<Pokemon> pokemons;
    private InputStream file;

    public SQLPokedex(String filename) {
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
        Pokemon result = null;
        try{
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test","Kevin",null);
            String query = "SELECT * FROM POKEDEX";
            Statement statement = conn.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                //ID,Number,Name,Type1,Type2,Total,HP,Atk,Def,SpAtk,SpDef,Spd,Species,Height,Weight
                result = new Pokemon.Builder()
                        .setID(resultSet.getInt("id"))
                        .setNumber(resultSet.getString("number"))
                        .setName(resultSet.getString("name"))
                        .setType1(resultSet.getString("type1"))
                        .setType2(resultSet.getString("type2"))
                        .setTotal(resultSet.getInt("total"))
                        .setHP(resultSet.getInt("hp"))
                        .setAtk(resultSet.getInt("atk"))
                        .setDef(resultSet.getInt("def"))
                        .setSpAtk(resultSet.getInt("spatk"))
                        .setSpDef(resultSet.getInt("spdef"))
                        .setSpd(resultSet.getInt("spd"))
                        .setSpecies(resultSet.getString("species"))
                        .setHeight(resultSet.getString("height"))
                        .setWeight(resultSet.getString("weight"))
                        .build();
                this.pokemons.add(result);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Pokemon> getPokemons() {
        load();
        return (ArrayList<Pokemon>) this.pokemons;
    }

    public String getPokemon(String pokeName) {
        boolean found = false;
        Pokemon result = null;
        try{
            if(!pokeName.contains("!@#$%^&**()_+-=|/*-+\"\':;")) {
                System.out.println("starting connection");
                Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "Kevin", null);
                String query = "SELECT * FROM POKEDEX WHERE NAME = '" + pokeName + "'";
                Statement statement = conn.createStatement();
                statement.execute(query);
                ResultSet resultSet = statement.getResultSet();

                while (resultSet.next() && (!found)) {
                    result = new Pokemon.Builder()
                            .setID(resultSet.getInt("id"))
                            .setNumber(resultSet.getString("number"))
                            .setName(resultSet.getString("name"))
                            .setType1(resultSet.getString("type1"))
                            .setType2(resultSet.getString("type2"))
                            .setTotal(resultSet.getInt("total"))
                            .setHP(resultSet.getInt("hp"))
                            .setAtk(resultSet.getInt("atk"))
                            .setDef(resultSet.getInt("def"))
                            .setSpAtk(resultSet.getInt("spatk"))
                            .setSpDef(resultSet.getInt("spdef"))
                            .setSpd(resultSet.getInt("spd"))
                            .setSpecies(resultSet.getString("species"))
                            .setHeight(resultSet.getString("height"))
                            .setWeight(resultSet.getString("weight"))
                            .build();
                    found = true;
                    System.out.println(result);
                }
                conn.close();
            }
            else{
                throw new Exception ("exception");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


}
