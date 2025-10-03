package org.esprim.tpfoyer.entities;

public enum type_chambre {
    SIMPLE("simple"),
    DOUBLE("double"),
    TRIPLE("triple");

    private final String value;

    type_chambre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}