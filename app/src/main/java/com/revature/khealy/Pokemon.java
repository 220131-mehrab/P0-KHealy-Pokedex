package com.revature.khealy;

public class Pokemon {
    int ID;
    String Number;
    String Name;
    String Type1;
    String Type2;
    int Total;
    int HP;
    int Atk;
    int Def;
    int SpAtk;
    int SpDef;
    int Spd;
    String Species;
    String Height;
    String Weight;

    public Pokemon(Builder builder){

    }

    //ID,Number,Name,Type1,Type2,Total,HP,Atk,Def,SpAtk,SpDef,Spd,Species,Height,Wei
    String comma = new String(",");
    public String toString(){
        return this.ID + comma + this.Number + comma+ this.Name + comma+
                this.Type1 + comma+this.Type2 + comma+this.HP + comma+
                this.Atk + comma+ this.Def+ comma+ this.SpAtk+ comma+
                this.SpDef + comma+ this.Spd + comma+
                this.Species+ comma+ this.Height+ comma+ this.Weight;
    }


    public static class Builder {
        int ID;
        String Number;
        String Name;
        String Type1;
        String Type2;
        int Total;
        int HP;
        int Atk;
        int Def;
        int SpAtk;
        int SpDef;
        int Spd;
        String Species;
        String Height;
        String Weight;

        //Setters
        public Builder setID(int ID) {
            this.ID = ID;
            return this;
        }

        public Builder setNumber(String number) {
            this.Number = number;
            return this;
        }

        public Builder setName(String name) {
            this.Name = name;
            return this;
        }

        public Builder setType1(String type1) {
            this.Type1 = type1;
            return this;
        }

        public Builder setType2(String type2) {
            this.Type2 = type2;
            return this;
        }

        public Builder setTotal(int Total){
            this.Total = Total;
            return this;
        }

        public Builder setHP(int HP) {
            this.HP = HP;
            return this;
        }

        public Builder setAtk(int atk) {
            this.Atk = atk;
            return this;
        }

        public Builder setDef(int def) {
            this.Def = def;
            return this;
        }

        public Builder setSpAtk(int spAtk) {
            this.SpAtk = spAtk;
            return this;
        }

        public Builder setSpDef(int spDef) {
            this.SpDef = spDef;
            return this;
        }

        public Builder setSpd(int spd) {
            this.Spd = spd;
            return this;
        }

        public Builder setSpecies(String species) {
            this.Species = species;
            return this;
        }

        public Builder setHeight(String height) {
            this.Height = height;
            return this;
        }

        public Builder setWeight(String weight) {
            this.Weight = weight;
            return this;
        }

        public Pokemon build(){
            return new Pokemon(this);
        }
    }

    //getters
    public int getID() {
        return ID;
    }

    public String getNumber() {
        return Number;
    }

    public String getName() {
        return Name;
    }

    public String getType1() {
        return Type1;
    }

    public String getType2() {
        return Type2;
    }

    public int getTotal() {
        return Total;
    }

    public int getHP() {
        return HP;
    }

    public int getAtk() {
        return Atk;
    }

    public int getDef() {
        return Def;
    }

    public int getSpAtk() {
        return SpAtk;
    }

    public int getSpDef() {
        return SpDef;
    }

    public int getSpd() {
        return Spd;
    }

    public String getSpecies() {
        return Species;
    }

    public String getHeight() {
        return Height;
    }

    public String getWeight() {
        return Weight;
    }

}



