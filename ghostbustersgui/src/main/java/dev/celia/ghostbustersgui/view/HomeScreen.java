package dev.celia.ghostbustersgui.view;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.awt.FontFormatException;
import java.io.InputStream;

import javax.swing.plaf.FontUIResource;

import dev.celia.ghostbustersgui.view.utils.ButtonUtils;

public class HomeScreen {
    public static void main(String[] args) {
        
        //Cargar la fuente desde utils
        Font customFont = utils.loadCustomFont("/fonts/GHOSTBUS.TTF");
        //Aplicarla a toda la UI
        utils.setUIFont(customFont);
        
        
        
                JFrame frame = new JFrame ("Ghostbusters");
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);
        
        
                //Imagen  de fondo
        
                java.net.URL imageURL = HomeScreen.class.getClassLoader().getResource("images/home.png");
        
                ImageIcon background = new ImageIcon(imageURL);
                JLabel backgroundLabel = new JLabel(background);
                backgroundLabel.setBounds(0,0,800,600);
        
                //Titulo
        
                JLabel titleLabel = new JLabel("<html><div style='text-align: center;'>Bienvenido a la central<br>Cazafantasmas</div></html>", SwingConstants.CENTER);
                titleLabel.setBounds(10, 0, 800, 130);
                titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD,35f));
                titleLabel.setForeground(new ColorUIResource(234,0,0));
                titleLabel.setOpaque(true); 
                titleLabel.setBackground(new Color(0, 0, 0, 200));
        
                // Botón
        
                JButton goMenu = new JButton("<html><div style='text-align: center;'>Acceder al<br>contenedor de almacenamiento</div><html>");
                goMenu.setBounds(275, 200, 250, 100);
                ButtonUtils.applyHoverEffect(goMenu);
                goMenu.setFont(goMenu.getFont().deriveFont(15f));
        
                //Barra de carga (oculto antes de darle al botón)
        
                JProgressBar progressBar = new JProgressBar();
                progressBar.setBounds(250, 480, 300, 50);
                progressBar.setForeground(new javax.swing.plaf.ColorUIResource(204, 70, 50)); 
                progressBar.setBackground(new javax.swing.plaf.ColorUIResource(200, 200, 200)); 
                progressBar.setStringPainted(true);
                progressBar.setVisible(false);
        
                //Mensaje de carga (oculto antes de darle al botón)
        
                JLabel loadingLabel = new JLabel("Accediendo al contenedor de almacenamiento de fantasmas...", SwingConstants.CENTER);
                loadingLabel.setBounds(160, 430, 475, 40);
                loadingLabel.setVisible(false);
                loadingLabel.setFont(loadingLabel.getFont().deriveFont(Font.BOLD, 11f));
                loadingLabel.setForeground(new ColorUIResource(234,0,0));
                loadingLabel.setOpaque(true); 
                loadingLabel.setBackground(new Color(0, 0, 0, 230));
        
                //Funcionalidad del botón
        
                goMenu.addActionListener(e -> {
                    goMenu.setEnabled(false); // botón desactivado mientras la barra carga
                    loadingLabel.setVisible(true);
                    progressBar.setVisible(true);
                    //Simular la carga con SwingWorker
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        @Override
                        protected Void doInBackground() throws InterruptedException {
                            for (int i = 0; i <= 100; i += 5) {
                                progressBar.setValue(i);
                                Thread.sleep(80); // Simula la carga de 100% en 3 segundos
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
        
            public static void setUIFont(FontUIResource font) {
                UIManager.put("Label.font", font);
                UIManager.put("Button.font", font);
                UIManager.put("TextField.font", font);
                UIManager.put("TextArea.font", font);
                UIManager.put("CheckBox.font", font);
                UIManager.put("RadioButton.font", font);
                UIManager.put("ComboBox.font", font);
                UIManager.put("List.font", font);
                UIManager.put("Table.font", font);
                UIManager.put("Menu.font", font);
                UIManager.put("MenuItem.font", font);
                UIManager.put("ToolTip.font", font);
            }}