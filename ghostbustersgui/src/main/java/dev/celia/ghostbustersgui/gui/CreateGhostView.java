package dev.celia.ghostbustersgui.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dev.celia.ghostbustersgui.controller.UserController;
import dev.celia.ghostbustersgui.model.GhostClass;

public class CreateGhostView extends JFrame {
    private JTextField nameField;
    private JComboBox<GhostClass> ghostClassCombo;
    private JComboBox<String> dangerLevelCombo;
    private JTextField abilityField;
    private JTextField captureDateField;
    private JButton captureButton;
    
    private final UserController controller;

    public CreateGhostView(UserController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        setTitle("Captura de Fantasmas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        formPanel.add(new JLabel("Introduzca el nombre del fantasma:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Seleccione la clase del fantasma:"));
        ghostClassCombo = new JComboBox<>(GhostClass.values());
        formPanel.add(ghostClassCombo);

        formPanel.add(new JLabel("Seleccione el nivel de peligro:"));
        String[] dangerOptions = {"Bajo", "Medio", "Alto", "Crítico"};
        dangerLevelCombo = new JComboBox<>(dangerOptions);
        formPanel.add(dangerLevelCombo);

        formPanel.add(new JLabel("Introduzca la habilidad del fantasma:"));
        abilityField = new JTextField();
        formPanel.add(abilityField);

        formPanel.add(new JLabel("Introduzca la fecha de captura (DD-MM-AAAA):"));
        captureDateField = new JTextField();
        formPanel.add(captureDateField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        captureButton = new JButton("Capturar Fantasma");
        buttonPanel.add(captureButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        captureButton.addActionListener(e -> validateAndSendData());
    }

    private void validateAndSendData() {
        String name = nameField.getText().trim();
        if (name.isEmpty() || !name.matches(".*[a-zA-Z]+.*")) {
            showError("El nombre debe contener al menos una letra.");
            return;
        }

        GhostClass ghostClass = (GhostClass) ghostClassCombo.getSelectedItem();
        String dangerLevel = ((String) dangerLevelCombo.getSelectedItem()).toLowerCase();

        String ability = abilityField.getText().trim();
        if (ability.isEmpty() || !ability.matches(".*[a-zA-Z]+.*")) {
            showError(" La habilidad debe contener al menos una letra.");
            return;
        }

        String captureDate = captureDateField.getText().trim();
        if (!captureDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
            showError("Formato de fecha inválido. Por favor, use DD-MM-AAAA.");
            return;
        }

        controller.captureGhost(name, ghostClass, dangerLevel, ability, captureDate);
    }

    public void showCaptureSuccess(String name) {
        JOptionPane.showMessageDialog(this, "¡Fantasma \"" + name + "\" capturado con éxito!");
        nameField.setText("");
        abilityField.setText("");
        captureDateField.setText("");
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.WARNING_MESSAGE);
    }
}