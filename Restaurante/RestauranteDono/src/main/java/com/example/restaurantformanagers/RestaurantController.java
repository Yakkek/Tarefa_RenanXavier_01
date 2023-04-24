package com.example.restaurantformanagers;

import com.example.restaurantformanagers.dao.DishDAO;
import com.example.restaurantformanagers.model.Dish;
import com.example.restaurantformanagers.model.DishType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class RestaurantController {

    @FXML
    private TableView<Dish> TableDish;

    @FXML
    private ImageView ImageLogo;
    @FXML
    private Button ButtonReload;
    @FXML
    private Button ButtonSave;


    private void getDishValues(){
        DishDAO dishDAO = new DishDAO();
        List<Dish> dishes = dishDAO.findAll();

        ObservableList<Dish> dishList = FXCollections.observableArrayList(dishes);
        TableDish.setItems(dishList);



        TableColumn<Dish, String> nameColumn = new TableColumn<>("Nome");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Dish, Integer> numberOrdersColumn = new TableColumn<>("N° de pedidos");
        numberOrdersColumn.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));

        TableColumn<Dish, DishType> typeColumn = new TableColumn<>("Tipo");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        RestaurantController restaurantController = this;
        TableColumn<Dish, Void> editColumn = new TableColumn<>("Editar");
        editColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editarButton = new Button("Editar");

            {
                editarButton.setOnAction(event -> {
                    Dish dish = getTableRow().getItem();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("create-dish.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                        CreateDishController dialogController = loader.getController();
                        dialogController.setDishToUpdate(dish);
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        dialogController.setRestaurantController(restaurantController);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.showAndWait();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(editarButton);
                }
            }
        });

        TableColumn<Dish, Void> deleteColumn = new TableColumn<>("Excluir");
        deleteColumn.setCellFactory(param -> new TableCell<>() {
            private final Button excluirButton = new Button("Excluir");
            {
                excluirButton.setOnAction(event -> {
                    Dish dish = getTableRow().getItem();
                    dishDAO.delete(dish.getId());
                    TableDish.getItems().clear();
                    getDishValues();
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(excluirButton);
                }
            }
        });

        centerColumn(nameColumn);
        centerColumn(numberOrdersColumn);
        centerColumn(typeColumn);
        centerColumn(editColumn);
        centerColumn(deleteColumn);

        TableDish.getColumns().setAll(nameColumn, numberOrdersColumn, typeColumn,editColumn, deleteColumn);
        TableDish.setFixedCellSize(50);
    }
    @FXML
    void HandleCreate(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("create-dish.fxml"));
            Parent root = loader.load();
            CreateDishController controller = loader.getController();
            controller.setRestaurantController(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void HandleReload(ActionEvent event) {
        TableDish.getItems().clear();
        getDishValues();
    }

    @FXML
    public void initialize() {
        setImageLogo();
        getDishValues();
    }

    public void centerColumn(TableColumn<?, ?> column) {
        column.setStyle("-fx-alignment: CENTER;");
    }

    private void setImageLogo(){
        Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
        ImageLogo.setImage(image);
    }



}