package index;
import view.TelaLogin;
import controller.Controller;
//import controller.Controller;
public class Index {
    public static void main(String[] args){
        TelaLogin telalogin = new TelaLogin();
        telalogin.Tela();
    }
    public void inserindo(String email, char[] senha){
        Controller controller = new Controller();
        controller.setEmail(email);
        controller.setSenha(senha);
        controller.setInserir();
        
    }
    
}
