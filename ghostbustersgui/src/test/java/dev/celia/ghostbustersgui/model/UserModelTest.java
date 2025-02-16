package dev.celia.ghostbustersgui.model;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserModelTest {

    private UserModel userModel;
    
    @Test
    @DisplayName("Test para capturar un fantasma")
    void testAddGhost() {
        userModel = new UserModel();
        GhostModel ghost = new GhostModel("Casper", GhostClass.CLASS_I, "Bajo", "Mimetización", "10-06-2023");
        userModel.addGhost(ghost);
        assertThat(userModel.getGhosts(), hasItem(ghost));
    }
}
