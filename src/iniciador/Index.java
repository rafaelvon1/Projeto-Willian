package iniciador;
import view.Telas;
import controller.Controller;
//import controller.Controller;
public class Index {
    public static void main(String[] args){
        Telas telalogin = new Telas();
        telalogin.TelaLogin();
    }
    public void inserindo(String email, char[] senha){
        Controller controller = new Controller();
        controller.setEmail(email);
        controller.setSenha(senha);
        controller.setInserir();
        
    }
    
}
