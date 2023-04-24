package com.example.restaurantformanagers.model;

public enum DishType {
    ENTRADA("Entrada"),
    PRATO_PRINCIPAL("Prato principal"),
    SOBREMESA("Sobremesa");

    private final String displayName;

    DishType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static DishType fromString(String text) {
        for (DishType b : DishType.values()) {
            if (b.displayName.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
