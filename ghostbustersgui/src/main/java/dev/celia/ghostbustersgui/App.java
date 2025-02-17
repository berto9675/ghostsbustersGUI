package dev.celia.ghostbustersgui;

import dev.celia.ghostbustersgui.controller.UserController;
import dev.celia.ghostbustersgui.model.UserModel;

public final class App {
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        UserModel userModel = new UserModel();
        UserController userController = new UserController(userModel);
        userController.openHomeScreen();

    }
}