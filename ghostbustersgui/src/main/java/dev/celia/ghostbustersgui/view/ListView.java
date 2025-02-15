package dev.celia.ghostbustersgui.view;

import dev.celia.ghostbustersgui.controller.UserController;
import dev.celia.ghostbustersgui.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class ListView extends JFrame {
    private final UserController controller;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JComboBox<GhostClass> classFilter;
    private final JTextField monthFilter;
    private final JButton deleteButton;

    public ListView(UserController controller) {
        this.controller = controller;

        setTitle("Lista de Fantasmas Capturados");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnNames = { "ID", "Nombre", "Clase", "Nivel de Peligro", "Fecha de Captura" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

      
        JPanel filterPanel = new JPanel();

        
        classFilter = new JComboBox<>(GhostClass.values());
        JButton classFilterButton = new JButton("Filtrar por Clase");
        classFilterButton.addActionListener(e -> applyClassFilter());

      
        monthFilter = new JTextField(2);
        JButton monthFilterButton = new JButton("Filtrar por Mes");
        monthFilterButton.addActionListener(e -> applyMonthFilter());

        
        JButton resetButton = new JButton("Resetear");
        resetButton.addActionListener(e -> resetFilters());

        
        filterPanel.add(new JLabel("Clase:"));
        filterPanel.add(classFilter);
        filterPanel.add(classFilterButton);
        filterPanel.add(new JLabel("Mes (1-12):"));
        filterPanel.add(monthFilter);
        filterPanel.add(monthFilterButton);
        filterPanel.add(resetButton);
        add(filterPanel, BorderLayout.NORTH);

        
        deleteButton = new JButton("Liberar Fantasma");
        deleteButton.addActionListener(e -> releaseGhost());
        add(deleteButton, BorderLayout.SOUTH);

        loadGhosts(controller.getCapturedGhosts());

        setVisible(true);
    }

    private void loadGhosts(List<GhostModel> ghosts) {
        tableModel.setRowCount(0);
        for (GhostModel g : ghosts) {
            tableModel.addRow(
                    new Object[]{g.getID(), g.getName(), g.getGhostClass(), g.getDangerLvl(), g.getCaptureDate()});
        }
    }

    private void applyClassFilter() {
        GhostClass selectedClass = (GhostClass) classFilter.getSelectedItem();
        if (selectedClass == null) return;

        List<GhostModel> filteredGhosts = controller.getCapturedGhosts().stream()
                .filter(g -> g.getGhostClass().equals(selectedClass))
                .collect(Collectors.toList());

        loadGhosts(filteredGhosts);
    }

    private void applyMonthFilter() {
        String monthText = monthFilter.getText().trim();
        if (monthText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa un mes válido (1-12)", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int month = Integer.parseInt(monthText);
            if (month < 1 || month > 12) {
                JOptionPane.showMessageDialog(this, "El mes debe estar entre 1 y 12", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            List<GhostModel> filteredGhosts = controller.getCapturedGhosts().stream()
                    .filter(g -> {
                        String[] parts = g.getCaptureDate().split("-");
                        return parts.length >= 2 && Integer.parseInt(parts[1]) == month;
                    })
                    .collect(Collectors.toList());

            loadGhosts(filteredGhosts);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un número válido para el mes", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void resetFilters() {
        classFilter.setSelectedIndex(0);
        monthFilter.setText("");
        loadGhosts(controller.getCapturedGhosts());
    }

    private void releaseGhost() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un fantasma para liberar", "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);
        boolean success = controller.releaseGhost(id);
        if (success) {
            JOptionPane.showMessageDialog(this, "Fantasma liberado exitosamente");
            loadGhosts(controller.getCapturedGhosts());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo liberar el fantasma", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        UserModel userModel = new UserModel();
        UserController controller = new UserController(userModel);

        controller.captureGhost("Fantasma 1", GhostClass.CLASS_I, "Bajo", "Invisibilidad", "01-02-2024");
        controller.captureGhost("Fantasma 2", GhostClass.CLASS_V, "Alto", "Telekinesis", "05-06-2023");
        controller.captureGhost("Fantasma 3", GhostClass.CLASS_III, "Medio", "Poseer objetos", "12-12-2022");

        SwingUtilities.invokeLater(() -> new ListView(controller));
    }
}