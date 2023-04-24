package com.example.restaurantformanagers;

import com.example.restaurantformanagers.dao.DishDAO;
import com.example.restaurantformanagers.model.Dish;
import com.example.restaurantformanagers.model.DishType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateDishController {

    @FXML
    private CheckBox CheckInput;

    @FXML
    private TextField NameInput;

    @FXML
    private ChoiceBox TypeInput;

    @FXML
    private Button ButtonSave;

    @FXML
    private Label LabelPrincipal;
    private RestaurantController restaurantController;

    private Dish dish;

    @FXML
    public void initialize() {
        TypeInput.setValue(DishType.ENTRADA.getDisplayName());
        TypeInput.getItems().addAll(Arrays.stream(DishType.values())
                .map(DishType::getDisplayName)
                .collect(Collectors.toList()));
    }

    public void setDishToUpdate(Dish dish){
        NameInput.setText(dish.getName());
        TypeInput.setValue(dish.getType().getDisplayName());
        LabelPrincipal.setText("Editar prato");
        this.dish = dish;
    }
    public void setRestaurantController(RestaurantController restaurantController){ this.restaurantController = restaurantController;}

    private void exibirModalDeErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
    @FXML
    void HandleSave(ActionEvent event) {
        Dish dish = new Dish();
        DishDAO dishDAO = new DishDAO();
        dish.setName(NameInput.getText());
        dish.setType(DishType.fromString(TypeInput.getValue().toString()));
        if(dish.getName() == null){
            exibirModalDeErro("Preencha todos os campos");
            return;
        }
        if(!CheckInput.isSelected()){
            exibirModalDeErro("Captcha é obrigatório");
            return;
        }
        if(this.dish != null){
            dish.setId(this.dish.getId());
            dishDAO.update(dish);
        }else {
            dishDAO.create(dish);
        }

        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        if(restaurantController != null){
            restaurantController.initialize();
        }
    }

}
