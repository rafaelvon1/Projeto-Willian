package view;
import javax.swing.*;

import iniciador.Index;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Telas {

    public void TelaLogin() {
        ImageIcon imageIcon = new ImageIcon("view\\imagens\\icons8-favicon-16.png"); // Substitua pelo caminho da sua imagem
        Image image = imageIcon.getImage(); // Obter a imagem
         

        // Criar a janela principal
        JFrame frame = new JFrame("Tela de Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLayout(new FlowLayout());

        
        // Criar os componentes
        JLabel labelEmail = new JLabel("Email:");
        JTextField textEmail = new JTextField(20); // Campo de texto para o email
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  // Alinha os componentes na vertical
        frame.add(panel);

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField textSenha = new JPasswordField(20); // Campo de texto para a senha
        
        JButton botaoEnviar = new JButton("Enviar"); // Botão de envio
        
        // Adicionando o JLabel à janela
       
        
        // Adicionar os componentes ao painel
        panel.add(labelEmail);
        panel.add(Box.createVerticalStrut(10)); // Espaço entre os componentes
        panel.add(textEmail);
        panel.add(Box.createVerticalStrut(10)); // Espaço entre os componentes
        panel.add(labelSenha);
        panel.add(Box.createVerticalStrut(10)); // Espaço entre os componentes
        panel.add(textSenha);
        panel.add(Box.createVerticalStrut(20)); // Espaço maior antes do botão
        panel.add(botaoEnviar);
        frame.setIconImage(image);
        // Definir o comportamento do botão ao ser clicado
        botaoEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter os valores dos campos de texto
                String email = textEmail.getText();
                char[] senha = textSenha.getPassword();
                
                iniciador.Index index = new Index();
                index.inserindo(email, senha);
                // Exibir os dados coletados
                JOptionPane.showMessageDialog(frame, "Email: " + email + "\nSenha: " + new String(senha));
            }
        });
        
        // Tornar a janela visível
        frame.setVisible(true);
    }
}
