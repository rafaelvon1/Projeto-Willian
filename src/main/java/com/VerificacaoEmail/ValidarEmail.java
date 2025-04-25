package com.VerificacaoEmail;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import java.util.Random;

public class ValidarEmail {
    public  Integer validar(String email) {
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
            return numeroInteiro; // Retorna o código gerado
            
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return 0; // Retorna null em caso de erro
    }
}