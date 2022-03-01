package com.revature.khealy.Dex;

public class CSVtoSQL {

    public void CreateQuery(String query){
//        private String selectAll = "Select pokemon.id, name, type1, type2 from pokemon, types where pokemon.type=types.id";
    }

    String seeAllTables = "--see all tables " +
            "SELECT * FROM TYPES; " +
            "SELECT * FROM NUMBERS; " +
            "SELECT * FROM POKEDEX;";

    String dropNumbersAndTypes = "--Drop Numbers and Types " +
            "DROP TABLE NUMBERS IF EXISTS; " +
            "DROP TABLE TYPES IF EXISTS; ";

    String createDistinct = "--Create Distinct " +
            "DROP TABLE TYPES IF EXISTS; " +
            "CREATE TABLE TYPES AS SELECT DISTINCT TYPE2 FROM POKEDEX ORDER BY TYPE2 ASC; ";


    String selectDistinct = "--SELECT DISTINCT " +
            "SELECT DISTINCT TYPE2 FROM POKEDEX ORDER BY TYPE2 ASC; ";

    String createTypesTable = "--CREATE TYPES TABLE " +
        "CREATE TABLE TYPES (TYPEID INT, TYPENAME CHAR(50)); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (1,null); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (2,'Bug'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (3,'Dark'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (4,'Dragon'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (5,'Electric'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (6,'Fairy'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (7,'Fighting'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (8,'Fire'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (9,'Flying'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (10,'Ghost'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (11,'Grass'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (12,'Ground'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (13,'Ice'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (14,'Normal'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (15,'Poison'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (16,'Psychic'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (17,'Rock'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (18,'Steel'); " +
        "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (19,'Water'); ";

    String createBackup = "--CREATE BACKUP " +
        "CREATE TABLE POKEDEXBU AS SELECT * FROM POKEDEX; ";

    String seeNormalizedTableAsWhole = "--See Normalized table as whole "+
        "SELECT POKEDEX.ID, POKEDEX.NAME, TYPES.TYPENAME " +
        "FROM POKEDEX " +
        "JOIN TYPES " +
        "ON POKEDEX.TYPE1ID = TYPES.TYPEID " +
        "JOIN TYPES " +
        "ON POKEDEX.TYPE2ID = TYPES.TYPEID " +
        "ORDER BY POKEDEX.ID ASC; ";

    String theCreatingOfPokemonTableNormalized = "--THE CREATING OF POKEMON TABLE, NORMALIZED " +
        "DROP TABLE POKEMON IF EXISTS; " +
        "CREATE TABLE POKEMON AS SELECT * FROM POKEDEX; " +
        "ALTER TABLE POKEMON ADD COLUMN (TYPE1ID INTEGER); " +
        "ALTER TABLE POKEMON ADD FOREIGN KEY (TYPE1ID) REFERENCES TYPES(TYPEID); " +
        "ALTER TABLE POKEMON ADD COLUMN (TYPE2ID INTEGER); " +
        "ALTER TABLE POKEMON ADD FOREIGN KEY (TYPE2ID) REFERENCES TYPES(TYPEID); " +
        "UPDATE POKEMON SET TYPE1ID=(SELECT TYPEID FROM TYPES WHERE TYPES.TYPENAME  = TYPE1); " +
        "UPDATE POKEMON SET TYPE2ID=(SELECT TYPEID FROM TYPES WHERE TYPES.TYPENAME  = TYPE2); " +
        "ALTER TABLE POKEMON DROP COLUMN TYPE1; " +
        "ALTER TABLE POKEMON DROP COLUMN TYPE2; ";
}
