package com.example.restaurantforusers;

import com.example.restaurantforusers.dao.DishDAO;
import com.example.restaurantforusers.model.Dish;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class RestaurantController {

    @FXML
    private ImageView ImageLogo;

    @FXML
    private TableView<Dish> TableRestaurant;

    @FXML
    private TableColumn<Dish, String> ColumnType;

    @FXML
    private TableColumn<Dish, String> ColumnName;
    @FXML
    private Button ButtonAction;

    @FXML
    private Button ButtonExit;

    private Dish dish;

    @FXML
    void HandleMakeOrder(ActionEvent event) {
        DishDAO dishDAO = new DishDAO();
        this.dish = dish;
        try {
            dishDAO.setOrderToDish(dish);
            showAlert("Sucesso!", "Pedido feito com sucesso", Alert.AlertType.INFORMATION);
        }catch (Exception e){
            showAlert("Erro", "Erro ao fazer pedido", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void HandleExit(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene loginPage = new Scene(loader.load());
            Stage current = (Stage) ButtonAction.getScene().getWindow();

            current.setScene(loginPage);
        } catch (Exception e){
            showAlert("Erro", "Erro ao fazer loggout", Alert.AlertType.ERROR);
        }

    }

    @FXML
    public void initialize() {
        setImageLogo();
        getDishValues();
        ButtonAction.setDisable(true);

        TableRestaurant.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1) {
                     Dish dish = TableRestaurant.getSelectionModel().getSelectedItem();
                    HandleClickRow(dish);
                }
            }
        });
    }


    private void HandleClickRow(Dish dish){
        this.dish = dish;
        ButtonAction.setDisable(false);
    }
    private void showAlert(String title, String contentText, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    private void getDishValues(){
        DishDAO dishDAO = new DishDAO();
        List<Dish> dishes = dishDAO.findAll();

        ObservableList<Dish> dishList = FXCollections.observableArrayList(dishes);
        TableRestaurant.setItems(dishList);


        ColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        ColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableRestaurant.getColumns().setAll(ColumnName, ColumnType);
        TableRestaurant.setFixedCellSize(50);
    }
    private void setImageLogo(){
        Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        ImageLogo.setImage(image);
    }
}
