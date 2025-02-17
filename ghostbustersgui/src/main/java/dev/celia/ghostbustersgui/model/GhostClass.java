package dev.celia.ghostbustersgui.model;

public enum GhostClass {
    CLASS_I("Clase I - Manifestación menor"),
    CLASS_II("Clase II - Aparición móvil"),
    CLASS_III("Clase III - Entidad inteligente"),
    CLASS_IV("Clase IV - Fantasma histórico"),
    CLASS_V("Clase V - Espíritu antropomorfo"),
    CLASS_VI("Clase VI - Espíritu demoníaco"),
    CLASS_VII("Clase VII - Entidad ultraterrena");
    private final String description;
    GhostClass(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}