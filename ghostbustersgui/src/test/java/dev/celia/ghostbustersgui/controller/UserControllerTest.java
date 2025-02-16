package dev.celia.ghostbustersgui.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import dev.celia.ghostbustersgui.model.GhostClass;
import dev.celia.ghostbustersgui.model.GhostModel;
import dev.celia.ghostbustersgui.model.UserModel;

public class UserControllerTest {
    private UserModel userModelMock;
    private UserController userController;

    @Test
    @DisplayName("Test para capturar un fantasma")
    void testCaptureGhost() {
        
        userModelMock = mock(UserModel.class);
        userController = new UserController(userModelMock);

        String name = "Casper";
        GhostClass ghostClass = GhostClass.CLASS_II;
        String dangerLevel = "Medio";
        String ability = "Invisibilidad";
        String captureDate = "15-02-2025";

        ArgumentCaptor<GhostModel> captor = ArgumentCaptor.forClass(GhostModel.class);

        userController.captureGhost(name, ghostClass, dangerLevel, ability, captureDate);

        verify(userModelMock).addGhost(captor.capture());

        GhostModel capturedGhost = captor.getValue();

        assertThat(capturedGhost, is(notNullValue()));
        assertThat(capturedGhost.getName(), is(name));
        assertThat(capturedGhost.getGhostClass(), is(ghostClass));
        assertThat(capturedGhost.getDangerLvl(), is(dangerLevel));
        assertThat(capturedGhost.getAbility(), is(ability));
        assertThat(capturedGhost.getCaptureDate(), is(captureDate));
    }
}
