package dev.celia.ghostbustersgui.model;

public class GhostModel {
    public static int idCounter = 1;
    public int id;
    public String name;
    public GhostClass ghostClass;
    public String dangerLvl;
    public String ability;
    public String captureDate;

    public GhostModel(String name, GhostClass ghostClass, String dangerLvl, String ability, String captureDate) {

        this.id = idCounter++;
        this.name = name;
        this.ghostClass = ghostClass;
        this.dangerLvl = dangerLvl;
        this.ability = ability;
        this.captureDate = captureDate;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GhostClass getGhostClass() {
        return ghostClass;
    }

    public String getDangerLvl() {
        return dangerLvl;
    }

    public String getAbility() {
        return ability;
    }

    public String getCaptureDate() {
        return captureDate;
    }
    @Override
    public String toString() {
        return String.format("%-3d %-20s %-35s %-8s %s",
                id, name, ghostClass.getDescription(), dangerLvl, captureDate);
    }
}
