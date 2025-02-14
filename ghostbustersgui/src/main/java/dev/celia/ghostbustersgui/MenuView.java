package dev.celia.ghostbustersgui;


import javax.swing.*;
import java.awt.*;



public class MenuView extends JFrame {


    public MenuView() {


        setTitle("Ghostbusters");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        java.net.URL imageUrl = getClass().getClassLoader().getResource("images/menu.png");

        ImageIcon backgroundIcon = new ImageIcon(imageUrl); 
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

        JLabel titulo = new JLabel("Menú Principal", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(0, 0, 0, 150));
        titulo.setPreferredSize(new Dimension(800, 50));
        add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridBagLayout());
        panelBotones.setOpaque(false); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); 

        // Botones
        JButton capturar = new JButton("Capturar Fantasma");
        JButton ver = new JButton("Ver Fantasmas");
        JButton salir = new JButton("Salir");

        Color colorFondo = new Color(35, 182, 60);
        Color colorTexto = new Color(255, 255, 255);
        Font fuente = new Font("Arial", Font.BOLD, 16);

        for (JButton btn : new JButton[]{capturar, ver, salir}) {
            btn.setBackground(colorFondo);
            btn.setForeground(colorTexto);
            btn.setFont(fuente);
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(200, 40)); 
        }

        gbc.gridy = 0;
        panelBotones.add(capturar, gbc);
        gbc.gridy = 1;
        panelBotones.add(ver, gbc);
        gbc.gridy = 2;
        panelBotones.add(salir, gbc);

        salir.addActionListener(e -> {
            String[] opciones = {"Sí", "No"};
            int respuesta = JOptionPane.showOptionDialog(
                this, 
                "¿Estás seguro de que deseas salir?", 
                "Confirmar salida", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE, 
                null, 
                opciones, 
                opciones[1] 
            );
        
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        
        
        add(panelBotones, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuView::new);
    }


}
