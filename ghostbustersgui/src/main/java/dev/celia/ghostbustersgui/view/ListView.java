package dev.celia.ghostbustersgui.view;

import dev.celia.ghostbustersgui.controller.UserController;
import dev.celia.ghostbustersgui.model.GhostClass;
import dev.celia.ghostbustersgui.model.GhostModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListView extends JFrame {
    public final UserController userController;
    public final JTable table;
    public final DefaultTableModel tableModel;
    public final JComboBox<GhostClass> classFilter;
    public final JTextField monthFilter;
    public final JButton deleteButton;
    public final JButton backButton;

    public ListView(UserController userController) {
    
        Font customFont = utils.loadCustomFont("/fonts/font.ttf");

        this.userController = userController;

        setTitle("Lista de Fantasmas Capturados");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setUndecorated(true);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.font", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("OptionPane.background", new Color(11, 7, 15));
        UIManager.put("Panel.background", new Color(11, 7, 15));

 
        JLabel title = new JLabel("Lista de Fantasmas Capturados", SwingConstants.CENTER);
        title.setFont(customFont.deriveFont(Font.BOLD, 30f));
        add(title, BorderLayout.NORTH);

        String[] columnNames = { "ID", "Nombre", "Clase", "Nivel de Peligro", "Fecha de Captura" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFont(customFont.deriveFont(Font.PLAIN, 14f));
        table.setRowHeight(25);


        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel filterPanel = new JPanel();
        classFilter = new JComboBox<>(GhostClass.values());
        classFilter.setFont(customFont.deriveFont(Font.PLAIN, 14f));

        monthFilter = new JTextField(2);
        monthFilter.setFont(customFont.deriveFont(Font.PLAIN, 14f));

        JButton filterClassButton = new JButton("Filtrar");
        filterClassButton.setFont(customFont.deriveFont(Font.BOLD, 14f));
        utils.ButtonUtils.applyHoverEffect(filterClassButton);
        filterClassButton.addActionListener(e -> filterByClass());

        JButton filterMonthButton = new JButton("Filtrar");
        filterMonthButton.setFont(customFont.deriveFont(Font.BOLD, 14f));
        utils.ButtonUtils.applyHoverEffect(filterMonthButton);
        filterMonthButton.addActionListener(e -> filterByMonth());

        JButton resetButton = new JButton("Resetear Filtros");
        resetButton.setFont(customFont.deriveFont(Font.BOLD, 14f));
        utils.ButtonUtils.applyHoverEffect(resetButton); 
        resetButton.addActionListener(e -> loadGhosts(userController.getCapturedGhosts()));

        
        JLabel classLabel = new JLabel("Clase:");
        classLabel.setFont(customFont.deriveFont(Font.PLAIN, 14f));
        classLabel.setForeground(Color.WHITE); 
        JLabel monthLabel = new JLabel("Mes de Captura (1-12):");
        monthLabel.setFont(customFont.deriveFont(Font.PLAIN, 14f));
        monthLabel.setForeground(Color.WHITE); 

        filterPanel.add(classLabel);
        filterPanel.add(classFilter);
        filterPanel.add(filterClassButton);
        filterPanel.add(monthLabel);
        filterPanel.add(monthFilter);
        filterPanel.add(filterMonthButton);
        filterPanel.add(resetButton);
        add(filterPanel, BorderLayout.NORTH);

        
        JPanel bottomPanel = new JPanel(new BorderLayout());

        backButton = new JButton("Volver al Menú");
        backButton.setFont(customFont.deriveFont(Font.BOLD, 14f));
        utils.ButtonUtils.applyHoverEffect(backButton); 
        backButton.addActionListener(e -> {
            dispose();
            userController.openMenuView();
        });

        deleteButton = new JButton("Liberar Fantasma");
        deleteButton.setFont(customFont.deriveFont(Font.BOLD, 14f));
        utils.ButtonUtils.applyHoverEffect(deleteButton); 
        deleteButton.addActionListener(e -> releaseGhost());

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(backButton);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(deleteButton);

        bottomPanel.add(leftPanel, BorderLayout.WEST);
        bottomPanel.add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        loadGhosts(userController.getCapturedGhosts());
        setLocationRelativeTo(null);
        setVisible(true);

       
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void loadGhosts(List<GhostModel> ghosts) {
        tableModel.setRowCount(0);
        for (GhostModel g : ghosts) {
            tableModel.addRow(new Object[] {
                    g.getID(),
                    g.getName(),
                    g.getGhostClass(),
                    g.getDangerLvl(),
                    g.getCaptureDate()
            });
        }
    }

    public void filterByClass() {
        GhostClass selectedClass = (GhostClass) classFilter.getSelectedItem();
        List<GhostModel> filteredGhosts = userController.filterGhostsByClass(selectedClass);
        loadGhosts(filteredGhosts);
    }

    public void filterByMonth() {
        String monthText = monthFilter.getText().trim();
        if (monthText.isEmpty()) {
            showErrorDialog("Ingresa un mes válido (1-12)");
            return;
        }
        try {
            int month = Integer.parseInt(monthText);
            if (month < 1 || month > 12) {
                showErrorDialog("Ingresa un mes válido (1-12)");
                return;
            }
            List<GhostModel> filteredGhosts = userController.getCapturedGhosts().stream()
                    .filter(g -> {
                        String[] parts = g.getCaptureDate().split("-");
                        return parts.length > 1 && Integer.parseInt(parts[1]) == month;
                    })
                    .toList();
            loadGhosts(filteredGhosts);
        } catch (NumberFormatException e) {
            showErrorDialog("Ingresa un número válido");
        }

    }

    public void releaseGhost() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            showErrorDialog("Selecciona un fantasma para liberar");
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);
        String ghostName = (String) tableModel.getValueAt(selectedRow, 1);
        String dangerLevel = (String) tableModel.getValueAt(selectedRow, 3);

        String message = "<html>¿Está seguro que desea liberar al fantasma <b><font color='blue'>" + ghostName +
                "</font></b> de peligro <b><font color='red'>" + dangerLevel + "</font></b>?</html>";

        int confirm = showConfirmDialogWithCustomStyle( message, "Confirmar Liberación");

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = userController.releaseGhost(id);
            if (success) {
                JOptionPane.showMessageDialog(this, "Fantasma liberado exitosamente");
                loadGhosts(userController.getCapturedGhosts());
            } else {
                showErrorDialog("No se pudo liberar el fantasma");
            }
        }
    }

    public void showErrorDialog(String message) {
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 18));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 16));
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.WARNING_MESSAGE);
    }

     public int showConfirmDialogWithCustomStyle(String message, String title) {
            
            UIManager.put("OptionPane.messageForeground", Color.WHITE);  
            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 18));  
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 16));  
        
           
            return JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        }

}