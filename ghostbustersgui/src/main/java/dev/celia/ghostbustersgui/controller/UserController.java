package dev.celia.ghostbustersgui.controller;

import dev.celia.ghostbustersgui.model.GhostClass;
import dev.celia.ghostbustersgui.model.GhostModel;
import dev.celia.ghostbustersgui.model.UserModel;
import dev.celia.ghostbustersgui.view.CreateGhostView;
import dev.celia.ghostbustersgui.view.HomeScreen;
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

    public void captureGhost(String name, GhostClass ghostClass, String dangerLevel, String ability, String captureDate) {
        GhostModel newGhost = new GhostModel(name, ghostClass, dangerLevel, ability, captureDate);
        userModel.addGhost(newGhost);
        }
}

/*
    public void showCapturedGhosts() {
        List<GhostModel> ghosts = userModel.getGhosts();
        ghostView.showGhosts(ghosts);
    }

    public void releaseGhost() {
        int id = deleteGhostView.getGhostDeleteID();
        boolean success = userModel.deleteGhost(id);
        if (success) {
            deleteGhostView.messageRelease();
        } else {
            deleteGhostView.messageReleaseFailed(id);
        }
    }

    public void filterGhostsByClass() {
        GhostClass ghostClass = createGhostView.selectGhostClass();
        List<GhostModel> filtered = userModel.filterByClass(ghostClass);
        ghostView.showGhosts(filtered);
    }

    public void filterGhostsByMonth() {
        int month = filterByMonthView.getFilterMonth();
        List<GhostModel> filtered = userModel.filterByMonth(month);
        ghostView.showGhosts(filtered);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            int option = menuView.showMenuAndGetOption();

            switch (option) {
                case 1 -> captureGhost();
                case 2 -> showCapturedGhosts();
                case 3 -> releaseGhost();
                case 4 -> filterGhostsByClass();
                case 5 -> filterGhostsByMonth();
                case 6 -> {
                    AsciiArt.printAsciiArt("exit.txt");
                    AsciiArt.printAsciiArt("ghost.txt");
                    exit = true;
                }
            }
        }
    }*/