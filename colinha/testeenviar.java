package view;
import controller.Controller;
public class testeenviar {

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.setEmail("rafael");
        controller.setSenha("1234");
        testecadastro testecadastro = new testecadastro();
        testecadastro.cadastrar(controller); //chamando o metodo cadastro da class testecadastro

    }
}