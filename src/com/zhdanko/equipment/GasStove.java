package com.zhdanko.equipment;

public class GasStove extends HouseholdEquipment implements PlugIn {
    public GasStove(String name) {
        super(name);
    }

    @Override
    public void plugIn() {
        System.out.println(this.name + " plug in");
    }
}