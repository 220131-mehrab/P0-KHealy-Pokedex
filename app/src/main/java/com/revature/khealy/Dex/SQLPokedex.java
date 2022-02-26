package com.revature.khealy.Dex;

import com.revature.khealy.Domain.Pokemon;
import java.sql.*;
import javax.xml.transform.Result;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SQLPokedex implements Dex  {
    protected List<String> pokemons;
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


    public String getPokemon(String pokeName) {
        boolean found = false;
        Pokemon result = null;
        try{
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test","Kevin",null);
            String query = "SELECT * FROM POKEMON WHERE NAME = '" + pokeName + "'";
            Statement statement = conn.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                result = new Pokemon.Builder()
                        .setID(resultSet.getInt(0))
                        .setName(resultSet.getString("name"))
                        .setType1(resultSet.getString("type1"))
                        .setType2(resultSet.getString("type2"))
                        .build();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
