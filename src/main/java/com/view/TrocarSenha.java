package com.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.Index;

public class TrocarSenha extends JFrame {
    /**
     * 
     */
    public void Trocar() {
        // Configuração da janela
        setTitle("Recuperar Senha");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new GridBagLayout());

        // Painel central
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 60, 50, 60));

        // Título
        JLabel titleRecuperar = new JLabel("Recuperar Senha");
        titleRecuperar.setFont(new Font("Arial", Font.BOLD, 24));
        titleRecuperar.setForeground(Color.WHITE);
        titleRecuperar.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel titleAlterar = new JLabel("Alterar Senha");
        titleAlterar.setFont(new Font("Arial", Font.BOLD, 24));
        titleAlterar.setForeground(Color.WHITE);
        titleAlterar.setAlignmentX(Component.CENTER_ALIGNMENT);
        
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

        JButton btnAlterar = new JButton("Alterar");
        estilizarBotao(btnAlterar);

        JLabel lblEsqueceuSenha = new JLabel("<html><a href=''>Esqueceu a senha?</a></html>");
        lblEsqueceuSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        JButton btnVoltar = new JButton("Voltar");
        estilizarBotao(btnVoltar);
        btnVoltar.setBackground(Color.RED);

        // Ação do botão "Cadastrar"
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textEmail.getText().toLowerCase();
                
                
                if (
                    email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha o campo!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else{
                    com.Index index = new Index();
                    if (index.FormatandoDadosLogin(email) == 0) {
                       
                    }
                    else{
                        if(index.VerificacaoExitoEmail() == 0) 
                        {
                            JOptionPane.showMessageDialog(null, "Email nao encontrado no banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        else
                        {
                            System.out.println("passou da formatação");
                        
                        index.enviarCodigo(email);
                        index.TelaPopup(email);
                        if (index.validarCodigo() == 0) {
                            
                        }
                        else{
                            // Remove o campo de e-mail da tela
                            panel.removeAll();
                            
                            // Adiciona campo para nova senha
                            panel.add(titleAlterar);
                            panel.add(Box.createVerticalStrut(20));
                            panel.add(labelSenha);
                            panel.add(textSenha);
                            panel.add(Box.createVerticalStrut(30));
                            panel.add(btnAlterar);
                            panel.add(Box.createVerticalStrut(10));
                            panel.add(btnVoltar);

                            // Atualiza visual
                            panel.revalidate();
                            panel.repaint();




                            btnAlterar.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    String senha = new String(textSenha.getPassword());
                                    if (senha.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Preencha o campo!", "Erro", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                    else{
                                        if (index.FormatandoDadosRedefinirSenha(senha) == 0) {
                                            JOptionPane.showMessageDialog(null, "Senha invalida", "Erro", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else{
                                            index.AlterarSenha();
                                            TelaLogin login = new TelaLogin();
                                            login.Login(); 
                                            dispose();
                                        }
                                    }
                                }
                            });


                        }

                        }
                        
                        
                    }
                }     
            }
        });

        // Ação do botão "Voltar"
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin login = new TelaLogin();
                login.Login();
                
                dispose();
            }
        });


        // açao do link "Esqueceu a senha?"
        
        


        // Adicionar componentes ao painel
        panel.add(titleRecuperar);
        panel.add(Box.createVerticalStrut(20));
        panel.add(labelEmail);
        panel.add(textEmail);
        
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
