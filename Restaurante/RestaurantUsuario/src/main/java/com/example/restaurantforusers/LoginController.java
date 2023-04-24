package com.example.restaurantforusers;

import com.example.restaurantforusers.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
public class LoginController {
    @FXML
    private Button CreateUserButton;

    @FXML
    private Button ForgetPasswordButton;

    @FXML
    private CheckBox NotRobotCheckBox;

    @FXML
    private PasswordField PasswordInput;

    @FXML
    private Button SubmitButton;

    @FXML
    private TextField UserInput;

    @FXML
    void HandleCreateUser(ActionEvent event) {
        LoaderModalPage("cadastro-view.fxml");
    }

    @FXML
    void HandleForgetPassword(ActionEvent event) {
        LoaderModalPage("esqueciASenha-view.fxml");
    }


    void LoaderModalPage(String fxmlName){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    void HandleSubmitButton(ActionEvent event) {
        UserDAO userDAO = new UserDAO();
        String nick = UserInput.getText();
        String password = PasswordInput.getText();

        if(nick == null || password == null){
            showAlert("Erro ao criar usuário", "Usuário ou senha não podem ser vazios", Alert.AlertType.ERROR);
            return;
        }
        if(!NotRobotCheckBox.isSelected()){
            showAlert("Erro no captcha", "Captcha é obrigátorio", Alert.AlertType.ERROR);
            return;
        }

        try{
            boolean logged = userDAO.login(nick,password);
            if(logged){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("restaurant-view.fxml"));
                Scene restaurantPage = new Scene(loader.load());
                Stage current = (Stage) SubmitButton.getScene().getWindow();

                current.setScene(restaurantPage);
            }else{
                showAlert("Erro!","Senha ou Usuario incorretos", Alert.AlertType.ERROR);
            }

        }catch (Exception e){
            showAlert("Erro Interno", "Erro interno ao realizar login, se persistir procure o suporte", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String contentText, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}