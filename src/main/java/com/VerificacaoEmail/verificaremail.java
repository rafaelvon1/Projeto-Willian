package com.VerificacaoEmail;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class verificaremail {
    public static void main(String[] args) {
        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthentication("rafaelvon514@gmail.com", ""); // Use App Password se necessário
            email.setStartTLSRequired(true);
            email.setFrom("rafaelvon514@gmail.com");
            email.setSubject("Teste de Email via Java");
            email.setMsg("Olá, este é um e-mail enviado usando Apache Commons Email!");
            email.addTo("rafaelvon514@gmail.com");
            email.send();
            
            System.out.println("E-mail enviado com sucesso!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}