package com.company;


public class Heroes {
    String name ;
    int hp, att ;
    public void intro(){
        System.out.println("I am " +name + " My Health Points are " + hp +  " and my attack " + att);

    }

    Heroes(String name, int hp, int att ){
        this.name = name;
        this.hp = hp;
        this.att = att;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }

    public int getAtt(){
        return att;
    }
    public void setAtt(int att){
        this.att = att;
    }

}
