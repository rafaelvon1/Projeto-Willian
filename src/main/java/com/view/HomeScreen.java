package com.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame {
    public HomeScreen() {
        // Configuração da janela
        setTitle("Home - Minha Aplicação");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(50, 50, 50)); // Cor de fundo escura

        // Título
        JLabel titleLabel = new JLabel("Bem-vindo à Aplicação", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Botão "Entrar"
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntrar.setBackground(new Color(30, 144, 255));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFocusPainted(false);
        btnEntrar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton btnEntra = new JButton("Entrar");
        btnEntra.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntra.setBackground(new Color(30, 144, 255));
        btnEntra.setForeground(Color.WHITE);
        btnEntra.setFocusPainted(false);
        btnEntra.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        // Ação do botão
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou em Entrar!");
            }
        });
        btnEntra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Você clicou em Entrar!");
            }
        });

        // Painel central
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(50, 50, 50));
        centerPanel.add(btnEntrar);
        centerPanel.add(btnEntra);
        panel.add(centerPanel, BorderLayout.CENTER);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem sairItem = new JMenuItem("Sair");

        sairItem.addActionListener(e -> System.exit(0));
        menuArquivo.add(sairItem);

        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);
        setJMenuBar(menuBar);

        // Adiciona o painel à janela
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeScreen());
    }
}

