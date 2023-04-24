package com.example.restaurantforusers;

import com.example.restaurantforusers.dao.UserDAO;
import com.example.restaurantforusers.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgetPasswordController {

    @FXML
    private Button ButtonSave;

    @FXML
    private TextField NickInput;

    @FXML
    private PasswordField PasswordInput;

    @FXML
    void HandleSave(ActionEvent event) {
        UserDAO userDAO = new UserDAO();
        String nick = NickInput.getText();
        String password = PasswordInput.getText();
        Stage stage = (Stage) ButtonSave.getScene().getWindow();

        if(nick == null || nick == null){
            showAlert("Erro ao recuperar senha", "Usuário ou senha não podem ser vazios", Alert.AlertType.ERROR);
            stage.close();
            return;
        }
        try{
            userDAO.resetPassword(nick,password);
            showAlert("Sucesso!","Se o usuário existir a senha foi alterada com sucesso", Alert.AlertType.CONFIRMATION);
            stage.close();
        }catch (Exception e){
            showAlert("Erro Interno", "Erro interno ao recuperar usuário, se persistir procure o suporte", Alert.AlertType.ERROR);
            stage.close();
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
