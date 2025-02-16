package dev.celia.ghostbustersgui;

import dev.celia.ghostbustersgui.controller.UserController;
import dev.celia.ghostbustersgui.model.GhostClass;
import dev.celia.ghostbustersgui.model.GhostModel;
import dev.celia.ghostbustersgui.model.UserModel;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListView extends JFrame {
    private final UserController controller;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JComboBox<GhostClass> classFilter;
    private final JTextField monthFilter;
    private final JButton deleteButton;
    private final JButton backButton; 

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
        monthFilter = new JTextField(2);

        JButton filterClassButton = new JButton("Filtrar");
        filterClassButton.addActionListener(e -> filterByClass());

        JButton filterMonthButton = new JButton("Filtrar");
        filterMonthButton.addActionListener(e -> filterByMonth());

        JButton resetButton = new JButton("Resetear Filtros");
        resetButton.addActionListener(e -> loadGhosts(controller.getCapturedGhosts()));

        filterPanel.add(new JLabel("Clase:"));
        filterPanel.add(classFilter);
        filterPanel.add(filterClassButton);
        filterPanel.add(new JLabel("Mes de Captura (1-12):"));
        filterPanel.add(monthFilter);
        filterPanel.add(filterMonthButton);
        filterPanel.add(resetButton);
        add(filterPanel, BorderLayout.NORTH);

     
        JPanel bottomPanel = new JPanel(new BorderLayout());

        backButton = new JButton("Volver al Menú");
        backButton.addActionListener(e -> goToMenu());

        deleteButton = new JButton("Liberar Fantasma");
        deleteButton.addActionListener(e -> releaseGhost());

       
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(backButton);

       
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(deleteButton);

        bottomPanel.add(leftPanel, BorderLayout.WEST);
        bottomPanel.add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        loadGhosts(controller.getCapturedGhosts());
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private void loadGhosts(List<GhostModel> ghosts) {
        tableModel.setRowCount(0);
        for (GhostModel g : ghosts) {
            tableModel.addRow(new Object[]{ g.getID(), g.getName(), g.getGhostClass(), g.getDangerLvl(), g.getCaptureDate() });
        }
    }

    private void filterByClass() {
        GhostClass selectedClass = (GhostClass) classFilter.getSelectedItem();
        List<GhostModel> filteredGhosts = controller.getCapturedGhosts().stream()
                .filter(g -> g.getGhostClass().equals(selectedClass))
                .toList();
        loadGhosts(filteredGhosts);
    }

    private void filterByMonth() {
        String monthText = monthFilter.getText().trim();
        if (monthText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa un mes válido (1-12)", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int month = Integer.parseInt(monthText);
            if (month < 1 || month > 12) {
                JOptionPane.showMessageDialog(this, "Ingresa un mes válido (1-12)", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            List<GhostModel> filteredGhosts = controller.getCapturedGhosts().stream()
                    .filter(g -> {
                        String[] parts = g.getCaptureDate().split("-");
                        return parts.length > 1 && Integer.parseInt(parts[1]) == month;
                    })
                    .toList();
            loadGhosts(filteredGhosts);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un número válido", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void releaseGhost() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un fantasma para liberar", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        // Obtener los datos del fantasma seleccionado
        int id = (int) tableModel.getValueAt(selectedRow, 0);
        String ghostName = (String) tableModel.getValueAt(selectedRow, 1);
        String dangerLevel = (String) tableModel.getValueAt(selectedRow, 3);
    
        // Crear el mensaje de confirmación
        String message = "<html>¿Está seguro que desea liberar al fantasma <b><font color='blue'>" + ghostName + 
                 "</font></b> de peligro <b><font color='red'>" + dangerLevel + "</font></b>?</html>";

        // Mostrar el cuadro de diálogo de confirmación
        int confirm = JOptionPane.showConfirmDialog(this, message, "Confirmar Liberación", JOptionPane.YES_NO_OPTION);
    
        if (confirm == JOptionPane.YES_OPTION) {
            // Si el usuario confirma, liberar el fantasma
            boolean success = controller.releaseGhost(id);
            if (success) {
                JOptionPane.showMessageDialog(this, "Fantasma liberado exitosamente");
                loadGhosts(controller.getCapturedGhosts()); // Recargar la lista
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo liberar el fantasma", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    

    private void goToMenu() {

        SwingUtilities.invokeLater(() -> new MenuView());
        dispose(); 
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