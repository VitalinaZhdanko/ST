package com.zhdanko.equipment;

public class Fridge extends HouseholdEquipment implements PlugIn {
    public Fridge(String name) {
        super(name);
    }

    @Override
    public void plugIn() {
        System.out.println(this.name + " plug in");
    }
}

