package com.revature.khealy.Dex;

import com.revature.khealy.Domain.Pokemon;
import org.h2.message.DbException;

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
    private String dburl = new String("jdbc:h2:~/test");
    public Connection conn = null;
    public SQLQueryStrings sqlQueryStrings = new SQLQueryStrings();
    public ResultSet resultSet = null;

    /**
     * Constructor
     */
    public SQLPokedex() {
        this.pokemons = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(dburl, "Kevin", null);
            this.file = getClass().getClassLoader().getResourceAsStream("npd.csv");
            createFromCSV(conn);
            load(conn);
        } catch (DbException dbe){
            System.out.println("Database Error");
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }


/**
     * This method creates a database from a csv file
     * @param conn: a connection to the database
     */
    public void createFromCSV(Connection conn) {
        try {
            String query1 = sqlQueryStrings.initializeDatabase;
//            String query1 = sqlQueryStrings.readInFromCSV;
//            String query2 = sqlQueryStrings.createTypesTable;
//            String query3 = sqlQueryStrings.theCreatingOfPokemonTableNormalized;
//            String query4 = sqlQueryStrings.seeNormalizedTableAsAWhole;
            Statement statement = null;
//            statement = conn.createStatement();
//            statement.execute(query1);
//            statement = conn.createStatement();
//            statement.execute(query2);
//            statement = conn.createStatement();
//            statement.execute(query3);
            statement = conn.createStatement();
            statement.execute(query1);
            this.resultSet = statement.getResultSet();
        } catch (SQLException e) {
            System.err.println("SQL Problem");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Error");
            e.printStackTrace();
        }
    }


    /**
     * This method takes in a connection and loads the database
     * @param conn
     */

    private void load(Connection conn) {
        Pokemon result = null;
        try{
//            Connection conn = DriverManager.getConnection("jdbc:h2:~/test","Kevin",null);
            String query = sqlQueryStrings.seeNormalizedTableAsAWhole;
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


/**
     * Arraylist<Pokemon> getPokemons(): this method loads the pokemons from the
     * database, then returns the list
     * @return Arraylist<Pokemon>
     *
     */

    @Override
    public ArrayList<Pokemon> getPokemons() {
        load(conn);
        return (ArrayList<Pokemon>) this.pokemons;
    }


/**
     * getPokemon(String ):  This method takes a stirng and searches
     * for it in the sql database.
     * @param pokeName:  A Pokeman name as a string to search for
     * @return a result converted to a string
     */

    public String getPokemon(String pokeName) {
        boolean found = false;
        Pokemon result = null;
        try{
            //Avoid sql injections
            if(!pokeName.contains("!@#$%^&**()_+-=|/*-+\"\':;")) {
                System.out.println("starting connection");
                Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "Kevin", null);
                String query = sqlQueryStrings.seeNormalizedTableAsAWholeMeth(pokeName);
                System.out.println(query);
                Statement statement = conn.createStatement();
                System.out.println("Starting query");
                statement.execute(query);
                System.out.println("Finishing query.");
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
                    System.out.println(result.toString());
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



/**
     * Return the first Pokemon Object that matches.
     * @param pokeName
     * @return
     */

    public Pokemon getPokemonObject(String pokeName) {
        boolean found = false;
        Pokemon result = null;
        try{
            //Avoid sql injections
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
                    System.out.println(result.toString());
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
        return result;
    }
}

