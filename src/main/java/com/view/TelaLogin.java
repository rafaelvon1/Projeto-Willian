package com.view;
import javax.swing.*;
import com.Index;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    public void Login() {
        // Configuração da janela
        setTitle("login");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new GridBagLayout());

        // Painel central
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        // Título
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Campos de entrada
       
        JLabel labelEmail = new JLabel("Email:");
        estilizarLabel(labelEmail);
        JTextField textEmail = new JTextField(20);

        JLabel labelSenha = new JLabel("Senha:");
        estilizarLabel(labelSenha);
        JPasswordField textSenha = new JPasswordField(20);

        // Botões
        JButton btnEnviar = new JButton("Enviar");
        estilizarBotao(btnEnviar);

        JButton btnVoltar = new JButton("Voltar");
        estilizarBotao(btnVoltar);
        btnVoltar.setBackground(Color.RED);

        // Ação do botão "Cadastrar"
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textEmail.getText().toLowerCase();
                String senha = new String(textSenha.getPassword());
                
                if (
                    email.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else{
                    com.Index index = new Index();
                    if (index.FormatandoDadosLogin(email) == 0) {
                       
                    }
                    else{
                        System.out.println("passou da formatação");
                        if (index.VerificacaoExitoSenha(email) == 0 || index.VerificacaoExitoEmail() == 0) {
                            JOptionPane.showMessageDialog(null, "Senha ou email incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        else{
                            index.enviarCodigo(email);
                            index.TelaPopup(email);
                            if (index.validarCodigo() == 0) {
                            
                            }
                            else{
                                System.out.println("usuario logado com sucesso!");
                            }
                        }
                    }
                }     
            }
        });

        // Ação do botão "Voltar"
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.Principal();
                dispose();
            }
        });

        // Adicionar componentes ao painel
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(labelEmail);
        panel.add(textEmail);
        panel.add(Box.createVerticalStrut(10));
        panel.add(labelSenha);
        panel.add(textSenha);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btnEnviar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnVoltar);

        // Adicionar painel à janela
        add(panel);

        setVisible(true);
    }

    // Método para estilizar labels
    private void estilizarLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    // Método para estilizar botões
    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBackground(new Color(30, 144, 255));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastro());
    }
}
