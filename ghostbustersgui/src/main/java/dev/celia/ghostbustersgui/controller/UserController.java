package dev.celia.ghostbustersgui.controller;

import java.util.List;

import dev.celia.ghostbustersgui.model.GhostClass;
import dev.celia.ghostbustersgui.model.GhostModel;
import dev.celia.ghostbustersgui.model.UserModel;

public class UserController {
    private final UserModel userModel;
    private final CreateGhostView createGhostView; 
    private final GhostView ghostView;
    private final DeleteGhostView deleteGhostView;
    private final FilterByMonthView filterByMonthView;
    private final MenuView menuView;

     public UserController(UserModel userModel, CreateGhostView createGhostView, GhostView ghostView, DeleteGhostView deleteGhostView, FilterByMonthView filterByMonthView, MenuView menuView) {
        this.userModel = userModel;
        this.createGhostView = createGhostView;
        this.ghostView = ghostView;
        this.deleteGhostView = deleteGhostView;
        this.filterByMonthView = filterByMonthView;
        this.menuView = menuView;
    }

    public void captureGhost() {
        String name = createGhostView.getGhostName();
        GhostClass ghostClass = createGhostView.selectGhostClass();
        String dangerLevel = createGhostView.getDangerLevel();
        String ability = createGhostView.getAbility();
        String captureDate = createGhostView.getCaptureDate();

        GhostModel newGhost = new GhostModel(name, ghostClass, dangerLevel, ability, captureDate);
        userModel.addGhost(newGhost);
        createGhostView.showCaptureSuccess(name);
    }

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
    }
}
