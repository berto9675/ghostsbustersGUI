package dev.celia.ghostbustersgui.model;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserModelTest {

    private UserModel userModel;
    private GhostModel ghost1;
    private GhostModel ghost2;
    private GhostModel ghost3;

    @BeforeEach
    void setUp() {
        userModel = new UserModel();

        ghost1 = new GhostModel("Pepito", GhostClass.CLASS_I, "Alto", "Invisibilidad", "15-03-2023");
        ghost2 = new GhostModel("Menganito", GhostClass.CLASS_II, "Medio", "Teletransportación", "08-03-2023");
        ghost3 = new GhostModel("Lucifer", GhostClass.CLASS_I, "Crítico", "Grito mortal", "22-05-2023");

        userModel.addGhost(ghost1);
        userModel.addGhost(ghost2);
        userModel.addGhost(ghost3);
    }

    @Test
    @DisplayName("Test para capturar un fantasma")
    void testAddGhost() {
        GhostModel ghost = new GhostModel("Casper", GhostClass.CLASS_I, "Bajo", "Mimetización", "10-06-2023");
        userModel.addGhost(ghost);
        assertThat(userModel.getGhosts(), hasItem(ghost));
    }

    @Test
    @DisplayName("Test para que al añadir un fantasma de null")
    void testAddNullGhost() {
        userModel.addGhost(null);
        assertThat(userModel.getGhosts().size(), is(3));
    }
}
