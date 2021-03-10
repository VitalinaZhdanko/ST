package com.zhdanko.equipment;

abstract class HouseholdEquipment {
    final String name;

    public HouseholdEquipment(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HouseholdEquipment{" +
                "name='" + name + '\'' +
                '}';
    }
}