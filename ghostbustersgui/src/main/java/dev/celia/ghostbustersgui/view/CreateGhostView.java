package dev.celia.ghostbustersgui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import dev.celia.ghostbustersgui.controller.UserController;
import dev.celia.ghostbustersgui.model.GhostClass;

public class CreateGhostView extends JFrame {
    public JTextField nameField;
    public JComboBox<GhostClass> ghostClassCombo;
    public JComboBox<String> dangerLevelCombo;
    public JTextField abilityField;
    public JTextField captureDateField;
    public JButton captureButton;
    
    private final UserController userController;

    public CreateGhostView(UserController userController) {
        this.userController = userController;
        initComponents();
    }

    private void initComponents() {
        setTitle("Captura de Fantasmas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setUndecorated(true);
        UIManager.put("Panel.background", new Color(11, 7, 15));

        Font customFont = utils.loadCustomFont("/fonts/font.ttf").deriveFont(14f);
        utils.setUIFont(customFont);

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        mainPanel.setBackground(new Color(11, 7, 15));
        add(mainPanel);

        JPanel createGhostPanel = new JPanel(new GridBagLayout());
        createGhostPanel.setPreferredSize(new Dimension(550, 550));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        JLabel title = new JLabel("Captura de Fantasmas", SwingConstants.CENTER);
        title.setFont(customFont.deriveFont(Font.BOLD, 30f));
        title.setForeground(Color.RED);
        createGhostPanel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        labelFields(createGhostPanel, "Nombre del fantasma:", nameField = new JTextField(), gbc);
        labelFields(createGhostPanel, "Clase del fantasma:", ghostClassCombo = new JComboBox<>(GhostClass.values()), gbc);
        labelFields(createGhostPanel, "Nivel de peligro:", dangerLevelCombo = new JComboBox<>(new String[]{"Bajo", "Medio", "Alto", "Crítico"}), gbc);
        labelFields(createGhostPanel, "Habilidad del fantasma:", abilityField = new JTextField(), gbc);
        labelFields(createGhostPanel, "Fecha de captura (DD-MM-AAAA):", captureDateField = new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        captureButton = new JButton("Capturar Fantasma");
        utils.ButtonUtils.applyHoverEffect(captureButton);
        buttonPanel.add(captureButton);
        createGhostPanel.add(buttonPanel, gbc);

        mainPanel.add(createGhostPanel);
        captureButton.addActionListener(e -> captureGhost());
    }

    private void labelFields(JPanel panel, String labelText, JComponent field, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        panel.add(label, gbc);
    
        gbc.gridx = 1;
        gbc.weightx = 0.9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(field, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
    }

    private void captureGhost() {
        String name = nameField.getText().trim();
        if (name.isEmpty() || !name.matches(".*[a-zA-Z]+.*")) {
            showError("El nombre debe contener al menos una letra.");
            return;
        }
    
        GhostClass ghostClass = (GhostClass) ghostClassCombo.getSelectedItem();
        String dangerLevel = ((String) dangerLevelCombo.getSelectedItem()).toLowerCase();
    
        String ability = abilityField.getText().trim();
        if (ability.isEmpty() || !ability.matches(".*[a-zA-Z]+.*")) {
            showError("La habilidad debe contener al menos una letra.");
            return;
        }
    
        String captureDate = captureDateField.getText().trim();
        if (!captureDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
            showError("Formato de fecha inválido. Por favor, use DD-MM-AAAA.");
            return;
        }
    
        userController.captureGhost(name, ghostClass, dangerLevel, ability, captureDate);
    
        SwingUtilities.invokeLater(() -> {
            captureMessage(name);
        });
    }
    

    public void captureMessage(String name) {

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/ghost_min.png"));

        JPanel messagePanel = new JPanel(new BorderLayout());

        Font customFont = utils.loadCustomFont("/fonts/font.ttf").deriveFont(14f);

        JLabel captureLabel = new JLabel("¡Fantasma " + name + " capturado con éxito!", JLabel.CENTER);
        captureLabel.setFont(customFont.deriveFont(Font.BOLD, 16f));
        messagePanel.add(captureLabel, BorderLayout.NORTH);
        
        JLabel iconLabel = new JLabel(icon, JLabel.CENTER);
        messagePanel.add(iconLabel, BorderLayout.CENTER);
        
        JPanel captBtn = new JPanel(new FlowLayout());
        
        JButton anotherGhostButton = new JButton("Crear otro fantasma");
        utils.ButtonUtils.applyHoverEffect(anotherGhostButton);
        anotherGhostButton.setFont(customFont);
        
        JButton backToMenuButton = new JButton("Volver al menú");
        utils.ButtonUtils.applyHoverEffect(backToMenuButton);
        backToMenuButton.setFont(customFont);
        
        captBtn.add(anotherGhostButton);
        captBtn.add(backToMenuButton);
        
        messagePanel.add(captBtn, BorderLayout.SOUTH);
        
        JDialog dialog = new JDialog(this, "Captura Exitosa", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
        dialog.add(messagePanel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        
        anotherGhostButton.addActionListener(e -> {
            dialog.dispose();
            cleanFields();
        });

        backToMenuButton.addActionListener(e -> {
            dispose();
            userController.openMenuView();
        });

        dialog.setVisible(true);
    }

    public void cleanFields() {
        SwingUtilities.invokeLater(() -> {
            nameField.setText("");
            abilityField.setText("");
            captureDateField.setText("");
            ghostClassCombo.setSelectedIndex(0);
            dangerLevelCombo.setSelectedIndex(0);
            nameField.requestFocus();
            revalidate();
            repaint();
        });
    }

    public void showError(String message) {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        ImageIcon errorIcon = new ImageIcon(getClass().getResource("/images/ghost_error.png"));
       
        JPanel errorPanel = new JPanel(new BorderLayout());

        JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel iconLabel = new JLabel(errorIcon);
        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.RED);
        messageLabel.setFont(utils.loadCustomFont("/fonts/font.ttf").deriveFont(Font.BOLD, 14f));

        messagePanel.add(iconLabel);
        messagePanel.add(messageLabel);
        errorPanel.add(messagePanel, BorderLayout.CENTER);

        JButton okButton = new JButton("Aceptar");
        okButton.setBackground(new Color(35, 182, 60));
        okButton.setFocusPainted(false);

        JPanel errorButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        errorButtonPanel.add(okButton);
        errorPanel.add(errorButtonPanel, BorderLayout.SOUTH);

        JDialog dialog = new JDialog(this, "Error", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
        dialog.add(errorPanel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setLocationRelativeTo(this);

        okButton.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }
}