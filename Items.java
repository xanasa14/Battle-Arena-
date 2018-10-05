package com.company;

public class Items {
    String name;
    int quantity;
    int healingPoints;

    Items(String name, int quantity, int healingPoints) {
        this.name = name;
        this.quantity = quantity;
        this.healingPoints = healingPoints;
    }

    public void setHealingPoints(int healingPoints) {
        this.healingPoints = healingPoints;
    }

    public int getHealingPoints() {
        return healingPoints;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
