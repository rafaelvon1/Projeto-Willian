package com.VerificacaoEmail;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import java.util.Random;

public class verificaremail {
    public static void main(String[] args) {
        try {
            Random random = new Random();

            int numeroInteiro = random.nextInt(90000) + 10000;
            SimpleEmail email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthentication(System.getenv("EMAIL"), System.getenv("APP_PASSWORD")); // Use App Password se necessário
            email.setStartTLSRequired(true);
            email.setFrom(System.getenv("EMAIL"));
            email.setSubject("Teste de Email via Java");
            email.setMsg("seu codigo é: " + numeroInteiro);
            email.addTo("rafaelvon514@gmail.com");
            email.send();
            
            System.out.println("E-mail enviado com sucesso!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}