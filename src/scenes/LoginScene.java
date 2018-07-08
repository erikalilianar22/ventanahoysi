/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author erikav
 */
public abstract class LoginScene {
    public VBox content() {
        // User Edit
        Label userLabel = new Label("User:");
        TextField user = new TextField();
        HBox userLayout = new HBox(10);
        userLayout.setPadding(new Insets(0, 10, 0, 0));
        userLayout.setAlignment(Pos.CENTER_RIGHT);
        userLayout.getChildren().addAll(userLabel, user);


        // Password
        Label passwordLabel = new Label("Password:");
        PasswordField password = new PasswordField();
        HBox passwordLayout = new HBox(10);
        passwordLayout.setAlignment(Pos.CENTER_RIGHT);
        passwordLayout.getChildren().addAll(passwordLabel, password);

        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(10, 0, 0, 10));

        Button loginButton = new Button("Iniciar");

        loginButton.setOnAction(event -> {
            onLogin(user.getText(), password.getText());
        });

        loginLayout.getChildren().addAll(userLayout, passwordLayout, loginButton);
        loginLayout.setAlignment(Pos.CENTER);

        return  loginLayout;
    }

    public abstract void onLogin(String user, String password);
    
    
}
