package com.example.restaurantforusers;

import com.example.restaurantforusers.dao.UserDAO;
import com.example.restaurantforusers.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CreateUserController {

    @FXML
    private CheckBox CheckBoxInput;

    @FXML
    private TextField NickInput;

    @FXML
    private PasswordField PasswordInput;

    @FXML
    private Button SaveButton;

    @FXML
    void HandleCreateUser(ActionEvent event) {
        User user = new User();
        UserDAO userDAO = new UserDAO();
        Stage stage = (Stage) SaveButton.getScene().getWindow();
        user.setNick(NickInput.getText());
        user.setPassword(PasswordInput.getText());

        if(user.getNick() == null || user.getNick() == null){
            showAlert("Erro ao criar usuário", "Usuário ou senha não podem ser vazios", Alert.AlertType.ERROR);
            stage.close();
            return;
        }
        if(!CheckBoxInput.isSelected()){
            showAlert("Erro no captcha", "Captcha é obrigátorio", Alert.AlertType.ERROR);
            return;
        }
        try{
            userDAO.createUser(user);
            showAlert("Criado com sucesso","Usuário criado com sucesso!", Alert.AlertType.CONFIRMATION);
            stage.close();
        }catch (Exception e){
            showAlert("Erro Interno", "Erro interno ao criar usuário, se persistir procure o suporte", Alert.AlertType.ERROR);
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