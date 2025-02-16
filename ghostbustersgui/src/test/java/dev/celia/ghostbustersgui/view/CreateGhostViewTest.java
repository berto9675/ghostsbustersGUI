package dev.celia.ghostbustersgui.view;

import java.util.concurrent.CountDownLatch;

import javax.swing.SwingUtilities;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import dev.celia.ghostbustersgui.controller.UserController;
import dev.celia.ghostbustersgui.model.GhostClass;

public class CreateGhostViewTest {
    private CreateGhostView createGhostView;
    private UserController userControllerMock;

    @BeforeEach
    void setUp() throws Exception {
        userControllerMock = mock(UserController.class);

        CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(() -> {
            createGhostView = new CreateGhostView(userControllerMock);
            createGhostView.setVisible(true);
            latch.countDown();
        });
        latch.await();
    }

    @Test
    @DisplayName("Test para capturar fantasmas")
    void testCaptureGhost() {
        SwingUtilities.invokeLater(() -> {
            createGhostView.nameField.setText("Casper");
            createGhostView.ghostClassCombo.setSelectedIndex(1);
            createGhostView.dangerLevelCombo.setSelectedItem("Medio");
            createGhostView.abilityField.setText("Invisibilidad");
            createGhostView.captureDateField.setText("15-02-2025");
            createGhostView.captureButton.doClick();
        });

        ArgumentCaptor<String> nameCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<GhostClass> classCaptor = ArgumentCaptor.forClass(GhostClass.class);
        ArgumentCaptor<String> dangerCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> abilityCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> dateCaptor = ArgumentCaptor.forClass(String.class);

        verify(userControllerMock, timeout(1000)).captureGhost(
            nameCaptor.capture(),
            classCaptor.capture(),
            dangerCaptor.capture(),
            abilityCaptor.capture(),
            dateCaptor.capture()
        );

        assertThat(nameCaptor.getValue(), is("Casper"));
        assertThat(dangerCaptor.getValue(), is("medio"));
        assertThat(abilityCaptor.getValue(), is("Invisibilidad"));
        assertThat(dateCaptor.getValue(), is("15-02-2025"));
    }
    
    @Test
    @DisplayName("Test para limpiar los campos del formulario")
    void testCleanFields() throws Exception {
 
        createGhostView.nameField.setText("Casper");
        createGhostView.abilityField.setText("Invisibilidad");
        createGhostView.captureDateField.setText("12-12-2024");
        createGhostView.ghostClassCombo.setSelectedIndex(2);
        createGhostView.dangerLevelCombo.setSelectedIndex(1);

        createGhostView.cleanFields();

        SwingUtilities.invokeAndWait(() -> {});

        assertThat(createGhostView.nameField.getText(), is(emptyString()));
        assertThat(createGhostView.abilityField.getText(), is(emptyString()));
        assertThat(createGhostView.captureDateField.getText(), is(emptyString()));
        assertThat(createGhostView.ghostClassCombo.getSelectedIndex(), is(0));
        assertThat(createGhostView.dangerLevelCombo.getSelectedIndex(), is(0));
    }
}