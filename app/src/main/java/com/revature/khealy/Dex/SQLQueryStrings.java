package com.revature.khealy.Dex;

public class SQLQueryStrings {

    public void CreateQuery(String query){
//        private String selectAll = "Select pokemon.id, name, type1, type2 from pokemon, types where pokemon.type=types.id";
    }

    public String seeAllTables = "--see all tables " +
            "SELECT * FROM TYPES; " +
            "SELECT * FROM POKEDEX;";

    public String readInFromCSV =
    "--READ IN FROM CSV " +
    "DROP TABLE POKEDEX IF EXISTS; " +
    "CREATE TABLE POKEDEX( " +
            "ID INT PRIMARY KEY, " +
            "NUMBER VARCHAR, " +
            "NAME VARCHAR, " +
            "Type1 VARCHAR, " +
            "Type2 VARCHAR, " +
            "Total INTEGER, " +
            "HP INTEGER, " +
            "Atk INTEGER, " +
            "Def INTEGER, " +
            "SpAtk INTEGER, " +
            "SpDef INTEGER, " +
            "Spd INTEGER, " +
            "Species VARCHAR, " +
            "Height VARCHAR, " +
            "Weight VARCHAR " +
    ") " +
    "AS SELECT * FROM CSVREAD('~/npd.csv'); ";


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

    String createTypes2Table = "--CREATE BACKUP " +
        "CREATE TABLE TYPES2 AS SELECT * FROM TYPES; ";

    String theCreatingOfPokedexTableNormalized = "--THE CREATING OF POKEDEX TABLE, NORMALIZED " +
        "DROP TABLE POKEDEX IF EXISTS; " +
        "CREATE TABLE POKEDEX AS SELECT * FROM POKEDEX; " +
        "ALTER TABLE POKEDEX ADD COLUMN (TYPE1ID INTEGER); " +
        "ALTER TABLE POKEDEX ADD FOREIGN KEY (TYPE1ID) REFERENCES TYPES(TYPEID); " +
        "ALTER TABLE POKEDEX ADD COLUMN (TYPE2ID INTEGER); " +
        "ALTER TABLE POKEDEX ADD FOREIGN KEY (TYPE2ID) REFERENCES TYPES(TYPEID); " +
        "UPDATE POKEDEX SET TYPE1ID=(SELECT TYPEID FROM TYPES WHERE TYPES.TYPENAME  = TYPE1); " +
        "UPDATE POKEDEX SET TYPE2ID=(SELECT TYPEID FROM TYPES2 WHERE TYPES2.TYPENAME  = TYPE2); " +
        "ALTER TABLE POKEDEX DROP COLUMN TYPE1; " +
        "ALTER TABLE POKEDEX DROP COLUMN TYPE2; ";

    String seeNormalizedTableAsAWhole = "--see Normalized table as a whole (WORKS NO2) " +
        "SELECT ID, NUMBER, TYPES.TYPENAME TYPE1, TYPE1ID, TYPES.TYPENAME TYPE2, TYPE2ID, TOTAL, " +
        "HP, " +
        "Atk, " +
        "Def, " +
            "SpAtk, " +
            "SpDef, " +
            "Spd, " +
            "Species, " +
            "Height, " +
            "Weight " +
        "FROM POKEDEX LEFT JOIN TYPES ON TYPES.TYPENAME = POKEDEX.TYPE1 LEFT JOIN TYPES2 ON TYPES2.TYPENAME = POKEDEX.TYPE2";

public String initializeDatabase = "--1)READ IN FROM CSV " +
    "DROP TABLE POKEMON IF EXISTS; " +
    "DROP TABLE POKEDEX IF EXISTS; " +
    "DROP TABLE TYPES IF EXISTS; " +
    "DROP TABLE TYPES2 IF EXISTS; " +
    "CREATE TABLE POKEDEX( " +
    "        ID INT PRIMARY KEY, " +
    "        NUMBER VARCHAR, " +
    "        NAME VARCHAR, " +
    "        Type1 VARCHAR, " +
    "        Type2 VARCHAR, " +
    "        Total INTEGER, " +
    "        HP INTEGER, " +
    "        Atk INTEGER, " +
    "        Def INTEGER, " +
    "        SpAtk INTEGER, " +
    "        SpDef INTEGER, " +
    "        Spd INTEGER, " +
    "        Species VARCHAR, " +
    "        Height VARCHAR, " +
    "        Weight VARCHAR " +
    ") " +
    "AS SELECT * FROM CSVREAD('~/npd.csv'); " +




"--2)THE CREATING OF TYPES TABLE " +
    "DROP TABLE TYPES IF EXISTS; " +
    "CREATE TABLE TYPES (TYPEID INT PRIMARY KEY, TYPENAME CHAR(50)); " +
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
    "INSERT INTO TYPES (TYPEID, TYPENAME) VALUES (19,'Water'); " +

"--3)COPYING OF TABLE TYPES TO TYPES2 " +
    "CREATE TABLE TYPES2 AS SELECT * FROM TYPES; " +

"--4)THE CREATING OF POKEDEX TABLE, NORMALIZED " +
    "ALTER TABLE POKEDEX ADD COLUMN (TYPE1ID INTEGER); " +
    "ALTER TABLE POKEDEX ADD FOREIGN KEY (TYPE1ID) REFERENCES TYPES(TYPEID); " +
    "ALTER TABLE POKEDEX ADD COLUMN (TYPE2ID INTEGER); " +
    "ALTER TABLE POKEDEX ADD FOREIGN KEY (TYPE2ID) REFERENCES TYPES(TYPEID); " +
    "UPDATE POKEDEX SET TYPE1ID=(SELECT TYPEID FROM TYPES WHERE TYPES.TYPENAME  = TYPE1); " +
    "UPDATE POKEDEX SET TYPE2ID=(SELECT TYPEID FROM TYPES2 WHERE TYPES2.TYPENAME  = TYPE2); " +
    "ALTER TABLE POKEDEX DROP COLUMN TYPE1; " +
    "ALTER TABLE POKEDEX DROP COLUMN TYPE2; ";
}


/*
public String dropNumbersAndTypes = "--Drop Numbers and Types " +
        "DROP TABLE NUMBERS IF EXISTS; " +
        "DROP TABLE TYPES IF EXISTS; ";

public String createDistinct = "--Create Distinct " +
        "DROP TABLE TYPES IF EXISTS; " +
        "CREATE TABLE TYPES AS SELECT DISTINCT TYPE2 FROM POKEDEX ORDER BY TYPE2 ASC; ";

public String selectDistinct = "--SELECT DISTINCT " +
        "SELECT DISTINCT TYPE2 FROM POKEDEX ORDER BY TYPE2 ASC; ";

    String createBackup = "--CREATE BACKUP " +
        "CREATE TABLE POKEDEXBU AS SELECT * FROM POKEDEX; ";
        */
