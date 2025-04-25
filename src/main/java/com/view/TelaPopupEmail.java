package com.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPopupEmail extends JDialog {
    public String email; // Atributo para armazenar o e-mail
    public void setEmail(String email) {
        this.email = email;
        System.out.println("Email: " + email);
    }

    public TelaPopupEmail(JFrame parent, String email, int codigo) {
        super(parent, "Verificar E-mail", true); // true = modal
        setLayout(new BorderLayout());
        
        JLabel label = new JLabel("e-mail: " + this.email);
        JTextField campoCodigo = new JTextField(10);
        JButton botaoVerificar = new JButton("Verificar");

        JPanel painel = new JPanel();
        painel.add(label);
        painel.add(campoCodigo);
        painel.add(botaoVerificar);

        add(painel, BorderLayout.CENTER);

        // Exemplo de ação do botão
        botaoVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigoDigitado = Integer.parseInt(campoCodigo.getText());
                if (codigoDigitado == codigo) {
                    JOptionPane.showMessageDialog(TelaPopupEmail.this, "Código digitado: " + codigoDigitado + "Código correto", "Sucesso", JOptionPane.ERROR_MESSAGE);
                    return ;
                    
                }
                // Aqui você pode comparar com o código gerado
                else {
                    JOptionPane.showMessageDialog(TelaPopupEmail.this, "Código incorreto", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                dispose(); // Fecha a janelinha
            }
        });

        setSize(300, 120);
        setLocationRelativeTo(parent); // Centraliza sobre a tela principal
    }
}
