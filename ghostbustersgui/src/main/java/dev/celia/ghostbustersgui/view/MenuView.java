package dev.celia.ghostbustersgui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dev.celia.ghostbustersgui.controller.UserController;

public class MenuView extends JFrame {

    private final UserController userController;

    public MenuView(UserController userController) {
        this.userController = userController;

        setTitle("Ghostbusters");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setUndecorated(true);

        java.net.URL imageUrl = getClass().getClassLoader().getResource("images/menu.png");

        ImageIcon backgroundIcon = new ImageIcon(imageUrl); 
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

        Font customFont = utils.loadCustomFont("/fonts/font.ttf");
        utils.setUIFont(customFont);

        JLabel titulo = new JLabel("Menú Principal", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(28f));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(0, 0, 0, 150));
        titulo.setPreferredSize(new Dimension(800, 50));
        add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridBagLayout());
        panelBotones.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); 
              
        gbc.gridy = 0;
        panelBotones.add(Box.createVerticalStrut(80), gbc);
        
        JButton capturar = new JButton("Capturar Fantasma");
        JButton ver = new JButton("Ver Fantasmas");
        JButton salir = new JButton("Salir");
        
        Color colorFondo = new Color(35, 182, 60);
        Color colorTexto = new Color(255, 255, 255);
        Font fuente = customFont.deriveFont(16f);
        
        for (JButton btn : new JButton[]{capturar, ver, salir}) {
            btn.setBackground(colorFondo);
            btn.setForeground(colorTexto);
            btn.setFont(fuente);
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(200, 40)); 
        }

        gbc.gridy = 1;
        gbc.weighty = 0;
        panelBotones.add(capturar, gbc);
        gbc.gridy = 2;
        panelBotones.add(ver, gbc);
        gbc.gridy = 3;
        panelBotones.add(salir, gbc);

        capturar.addActionListener(e -> {
            this.dispose();
            userController.openCreateGhostView();
        });
        
        salir.addActionListener(e -> exitConfirmation());
        
        add(panelBotones, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void exitConfirmation() {

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/logo_back.png"));

        Image scaledImage = originalIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);

        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBackground(new Color(0, 0, 0));

        JLabel iconLabel = new JLabel(icon, JLabel.CENTER);
        messagePanel.add(iconLabel, BorderLayout.CENTER);
        
        Font customFont = utils.loadCustomFont("/font.ttf").deriveFont(20f);
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton yesButton = new JButton("Sí, salir");
        utils.ButtonUtils.applyHoverEffect(yesButton);
        yesButton.setFont(customFont);
        btnPanel.setBackground(new Color(0,0,0));

        JButton noButton = new JButton("Cancelar");
        utils.ButtonUtils.applyHoverEffect(noButton);
        noButton.setFont(customFont);

        btnPanel.add(yesButton);
        btnPanel.add(noButton);
        messagePanel.add(btnPanel, BorderLayout.SOUTH);

        JDialog dialog = new JDialog(this, "Confirmar Salida", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(getLayout());
        dialog.add(messagePanel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setLocationRelativeTo(this);

        yesButton.addActionListener(e -> {
            exitFarewell();
        });

        noButton.addActionListener(e -> {
            dialog.dispose();
        });

        dialog.setVisible(true);
    }

    private void exitFarewell() {
        JDialog farewell = new JDialog(this, "¡Adiós Cazafantasma!", true);
        farewell.setLayout(new BorderLayout());
    
        Font customFont = utils.loadCustomFont("/font.ttf").deriveFont(15f);
    
        ImageIcon farewellIcon = new ImageIcon(getClass().getResource("/images/ghostpeace.jpg"));
        Image scaledFarewell = farewellIcon.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledFarewell);
    
        JLabel scaledLabel = new JLabel(scaledIcon);
        scaledLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        JLabel farewellLabel = new JLabel(
            "<html><div style='text-align: center;'>¡Operación completada en el Contenedor de almacenamiento de fantasmas!<br>"
            + "Recuerda: Ningún trabajo es demasiado grande, ningún honorario es demasiado alto...<br>"
            + "¡Gracias por proteger Asturias y la integridad del más allá!</div></html>", 
            SwingConstants.CENTER
        );
    
        farewellLabel.setFont(customFont);
        farewellLabel.setForeground(Color.WHITE);
        farewellLabel.setOpaque(true);
        farewellLabel.setBackground(Color.BLACK);
        farewellLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.BLACK);
        contentPanel.add(scaledLabel);
        contentPanel.add(farewellLabel);
        
        JButton okButton = new JButton("Cerrar");
        okButton.addActionListener(e -> System.exit(0));
        utils.ButtonUtils.applyHoverEffect(okButton);
        okButton.setFont(customFont);
        okButton.setPreferredSize(new Dimension(150, 40));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(okButton);
    
        farewell.getContentPane().setBackground(Color.BLACK);
        farewell.add(contentPanel, BorderLayout.CENTER);
        farewell.add(buttonPanel, BorderLayout.SOUTH);
        farewell.pack();
        farewell.setLocationRelativeTo(this);
        farewell.setVisible(true);
    }
}