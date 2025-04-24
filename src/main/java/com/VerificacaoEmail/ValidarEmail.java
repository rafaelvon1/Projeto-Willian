package com.VerificacaoEmail;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import java.util.Random;

public class ValidarEmail {
    public  void  validar(String email) {
        try {
            Random random = new Random();

            int numeroInteiro = random.nextInt(90000) + 10000;
            SimpleEmail conta = new SimpleEmail();
            conta.setHostName("smtp.gmail.com");
            conta.setSmtpPort(587);
            conta.setAuthentication(System.getenv("EMAIL"), System.getenv("APP_PASSWORD")); // Use App Password se necessário
            conta.setStartTLSRequired(true);
            conta.setFrom(System.getenv("EMAIL"));
            conta.setSubject("Teste de Email via Java");
            conta.setMsg("seu codigo é: " + numeroInteiro);
            conta.addTo(email);
            conta.send();
            
            System.out.println("E-mail enviado com sucesso!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}