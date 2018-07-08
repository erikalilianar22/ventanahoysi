/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanahoysi;

import data.dao.UsuariosDao;
import data.entidades.Usuario;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenes.AdminJugador;
import scenes.LoginScene;

/**
 *
 * @author erikav
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        // TODO code application logic here
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
primaryStage.setTitle("Login");
        
        LoginScene loginConent = new LoginScene(){
            @Override
            public void onLogin(String user, String password) {
                Usuario usuario = new Usuario();
                usuario.setUser(user);
                usuario.setPassword(password);
                UsuariosDao controller = new UsuariosDao();
                try{
                    controller.login(usuario);
                    if (usuario.getId() != 0) {
                        AdminJugador adminJugadorContent = new AdminJugador();
                        Scene adimJugadorScene = new Scene(adminJugadorContent.content());
                        primaryStage.setScene(adimJugadorScene);                   
                }
            }catch(Exception e){
                    System.out.println("EL USUARIO O CONTRASEÑA NO COINCIDEN");
            }       
    }
};
        Scene loginScene = new Scene(loginConent.content(), 300, 300);

        primaryStage.setScene(loginScene);
        primaryStage.show();       
    }
    
}
