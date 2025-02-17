package dev.celia.ghostbustersgui.controller;

import java.util.List;

import javax.swing.SwingUtilities;

import dev.celia.ghostbustersgui.model.GhostClass;
import dev.celia.ghostbustersgui.model.GhostModel;
import dev.celia.ghostbustersgui.model.UserModel;
import dev.celia.ghostbustersgui.view.CreateGhostView;
import dev.celia.ghostbustersgui.view.HomeScreen;
import dev.celia.ghostbustersgui.view.ListView;
import dev.celia.ghostbustersgui.view.MenuView;

public class UserController {
    private final UserModel userModel;
 

    public UserController(UserModel userModel) {
        this.userModel = userModel;
      
    }
    public void openHomeScreen() {
        new HomeScreen(this).setVisible(true);
    }

    public void openMenuView() {
        new MenuView(this).setVisible(true);
    }

    public void openCreateGhostView() {
        new CreateGhostView(this).setVisible(true);
    }

    public void openListView() {
        SwingUtilities.invokeLater(() -> new ListView(this));
    }

    public void captureGhost(String name, GhostClass ghostClass, String dangerLevel, String ability,
            String captureDate) {
        GhostModel newGhost = new GhostModel(name, ghostClass, dangerLevel, ability, captureDate);
        userModel.addGhost(newGhost);
    }

    public List<GhostModel> getCapturedGhosts() {

        List<GhostModel> ghosts = userModel.getGhosts();
        return ghosts;
    }

    public boolean releaseGhost(int id) {
        return userModel.deleteGhost(id);
    }
    public List<GhostModel> filterGhostsByClass(GhostClass ghostClass) { 
        return userModel.filterByClass(ghostClass); 
    }

}
