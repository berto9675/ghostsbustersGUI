package dev.celia.ghostbustersgui;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class HomeScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Ghostbusters");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //Imagen  de fondo

        java.net.URL imageURL = HomeScreen.class.getClassLoader().getResource("images/fondo.png");

        ImageIcon background = new ImageIcon(imageURL);
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0,0,700,700);

        //Titulo

        JLabel titleLabel = new JLabel("<html><div style='text-align: center;'>¡Bienvenido a la central<br>Cazafantasmas!</div></html>", SwingConstants.CENTER);
        titleLabel.setBounds(50, 100, 700, 100);
        titleLabel.setFont(new javax.swing.plaf.FontUIResource("Arial", FontUIResource.BOLD, 40));
        titleLabel.setForeground(new ColorUIResource(234,0,0));

        // Botón

        JButton goMenu = new JButton("<html>Acceder al<br>contenedor<html>");
        goMenu.setBounds(250, 250, 200, 100);
        
        
        goMenu.setOpaque(true);
        goMenu.setContentAreaFilled(true);
        goMenu.setBorderPainted(true);
        goMenu.setFocusPainted(false); 
        goMenu.setFont(new javax.swing.plaf.FontUIResource("Arial", FontUIResource.BOLD, 20));
        goMenu.setForeground(new ColorUIResource(255,255,255));
        goMenu.setBackground(new ColorUIResource(35,182,60));

        //Barra de carga (oculto antes de darle al botón)

        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(200, 400, 300, 50);
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);

        //Mensaje de carga (oculto antes de darle al botón)

        JLabel loadingLabel = new JLabel("Accediendo al contenedor de almacenamiento de fantasmas...", SwingConstants.CENTER);
        loadingLabel.setBounds(50, 350, 600, 50);
        loadingLabel.setVisible(false);
        loadingLabel.setFont(new javax.swing.plaf.FontUIResource("Arial", FontUIResource.BOLD, 15));

        //Funcionalidad del botón

        goMenu.addActionListener(e -> {
            goMenu.setEnabled(false); // botón desactivado mientras la barra carga
            loadingLabel.setVisible(true);
            progressBar.setVisible(true);
            //Simular la carga con SwingWorker
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws InterruptedException {
                    for (int i = 0; i <= 100; i += 10) {
                        progressBar.setValue(i);
                        Thread.sleep(50); // Simula la carga de 100% en 3 segundos
                    }
                    return null;
                }

                @Override
                protected void done() {
                    frame.dispose(); // Cierra la ventana de inicio
                    new Menu(); // Abre la ventana del "menú" desde la clase
                }
            };

            worker.execute(); // Inicia la barra de carga
        });

        frame.add(titleLabel);
        frame.add(goMenu);
        frame.add(progressBar);
        frame.add(loadingLabel);
        frame.add(backgroundLabel);
        frame.setVisible(true);
    }
}