package dev.celia.ghostbustersgui.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GhostClassTest {
    @Test
    @DisplayName("Test GhostClass")
    public void testGetDescription() {
        GhostClass ghostClassI = GhostClass.CLASS_I;
        GhostClass ghostClassII = GhostClass.CLASS_II;
        GhostClass ghostClassIII = GhostClass.CLASS_III;
        GhostClass ghostClassIV = GhostClass.CLASS_IV;
        GhostClass ghostClassV = GhostClass.CLASS_V;
        GhostClass ghostClassVI = GhostClass.CLASS_VI;
        GhostClass ghostClassVII = GhostClass.CLASS_VII;
        assertThat(ghostClassI.getDescription(), is("Clase I - Manifestación menor"));
        assertThat(ghostClassII.getDescription(), is("Clase II - Aparición móvil"));
        assertThat(ghostClassIII.getDescription(), is("Clase III - Entidad inteligente"));
        assertThat(ghostClassIV.getDescription(), is("Clase IV - Fantasma histórico"));
        assertThat(ghostClassV.getDescription(), is("Clase V - Espíritu antropomorfo"));
        assertThat(ghostClassVI.getDescription(), is("Clase VI - Espíritu demoníaco"));
        assertThat(ghostClassVII.getDescription(), is("Clase VII - Entidad ultraterrena"));
    }

}
