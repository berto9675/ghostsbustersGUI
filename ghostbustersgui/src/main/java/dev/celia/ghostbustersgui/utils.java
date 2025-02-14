package dev.celia.ghostbustersgui;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

public class utils {

    public class ButtonUtils {
        public static void applyHoverEffect(JButton button) {
            Color normalColor = Color.decode("#23b63c");
            Color hoverColor = Color.WHITE;
            Color textColor = Color.WHITE;
            Color textHoverColor = normalColor;
            button.setBackground(normalColor);
            button.setForeground(textColor);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setBackground(hoverColor);
                    button.setForeground(textHoverColor);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    button.setBackground(normalColor);
                    button.setForeground(textColor);
                }
            });
        }
    }

    public static Font loadCustomFont(String path) {
        try {
            InputStream fontStream = utils.class.getResourceAsStream(path);
            if (fontStream != null) {
                Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
                return font;
            } else {
                throw new IOException("No se pudo cargar la fuente: " + path);
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, 12);
        }
    }

    // Método para aplicar la fuente a toda la UI
    public static void setUIFont(Font font) {
        FontUIResource fontUI = new FontUIResource(font);
        UIManager.put("Label.font", fontUI);
        UIManager.put("Button.font", fontUI);
        UIManager.put("TextField.font", fontUI);
        UIManager.put("TextArea.font", fontUI);
        UIManager.put("CheckBox.font", fontUI);
        UIManager.put("RadioButton.font", fontUI);
        UIManager.put("ComboBox.font", fontUI);
        UIManager.put("List.font", fontUI);
        UIManager.put("Table.font", fontUI);
        UIManager.put("Menu.font", fontUI);
        UIManager.put("MenuItem.font", fontUI);
        UIManager.put("ToolTip.font", fontUI);
    }



}
