package dev.celia.ghostbustersgui;

import javax.swing.SwingUtilities;

import dev.celia.ghostbustersgui.view.HomeScreen;

public final class App {
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomeScreen::new);
    }
}
