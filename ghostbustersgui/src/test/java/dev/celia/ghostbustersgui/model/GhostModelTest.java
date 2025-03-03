package dev.celia.ghostbustersgui.model;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class GhostModelTest {

    @Test
    @DisplayName("Test GhostConstructor")
    public void testGhostConstructor() {
        GhostModel ghost = new GhostModel("Casper", GhostClass.CLASS_II, "Bajo", "Leer la mente", "01-01-2025");
        assertThat(ghost.getID(), greaterThan(0));
        assertThat(ghost.getName(), is("Casper"));
        assertThat(ghost.getGhostClass(), is(GhostClass.CLASS_II));
        assertThat(ghost.getDangerLvl(), is("Bajo"));
        assertThat(ghost.getAbility(), is("Leer la mente"));
        assertThat(ghost.getCaptureDate(), is("01-01-2025"));
    }

    @Test
    @DisplayName("Test ToString")
    public void testToString() {
        GhostModel ghost = new GhostModel("Casper", GhostClass.CLASS_II, "Bajo", "Leer la mente", "01-01-2025");
        String expectedOutput = String.format("%-3d %-20s %-35s %-8s %s",
        ghost.getID(),
        ghost.getName(),
        ghost.getGhostClass().getDescription(),
        ghost.getDangerLvl(),
        ghost.getCaptureDate());
        assertThat(ghost.toString(), is(expectedOutput));
    }
}