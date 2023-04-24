package com.example.demo1;

import com.example.demo1.dao.CursoDAO;
import com.example.demo1.enums.Areas;
import com.example.demo1.model.Curso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CursoController {

    @FXML
    private AnchorPane apCurso;
    @FXML
    private Button btnEnviar;

    @FXML
    private ComboBox<String> cbArea;

    @FXML
    private MenuItem itemAluno;

    @FXML
    private Label lblResponse;

    @FXML
    private MenuBar menuBar;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSigla;



    public void clearFields() {

        tfNome.setText("");
        tfSigla.setText("");
        initialize();
    }


    @FXML
    public void initialize() {

        ObservableList<String> optionArea = FXCollections.observableArrayList();

        optionArea.add("humanas");
        optionArea.add("artes");
        optionArea.add("biologicas");
        optionArea.add("exatas");

        cbArea.setItems(optionArea);
        cbArea.setValue(optionArea.get(0));
    }

    @FXML
    void onClickAluno(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("layout.fxml"));
        Scene scene = menuBar.getScene();
        scene.setRoot(newRoot);
    }

    @FXML
    void onClickBtn(ActionEvent event) {

        Stage stage = (Stage) apCurso.getScene().getWindow();

        String nome = tfNome.getText();
        String sigla = tfSigla.getText();
        String area = cbArea.getValue();

        CursoDAO cursoDAO = new CursoDAO();
        Curso c1 = new Curso();

        c1.setNome(nome);
        c1.setSigla(sigla);
        c1.setArea(Areas.valueOf(area));

        try {

            if (Objects.equals(nome, "")) {
                lblResponse.setText("Campo NOME vazio");
                lblResponse.setTextFill(Color.RED);

                return ;
            }
            if (Objects.equals(sigla, "")) {
                lblResponse.setText("Campo SIGLA vazio");
                lblResponse.setTextFill(Color.RED);

                return ;
            }
            if (sigla.length() > 3) {
                lblResponse.setText("SIGLA MAIOR QUE 3");
                lblResponse.setTextFill(Color.RED);

                return ;
            }

            Curso cursoCreated = cursoDAO.create(c1);

            lblResponse.setText("SUCESSO!");
            lblResponse.setTextFill(Color.rgb(14, 191,47));
            clearFields();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
