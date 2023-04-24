package com.example.demo1;

import com.example.demo1.dao.AlunoDAO;
import com.example.demo1.dao.CursoDAO;
import com.example.demo1.model.Aluno;
import com.example.demo1.model.Curso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class HelloController {

    CursoDAO cursoDAO = new CursoDAO();
    AlunoDAO alunoDAO = new AlunoDAO();
    @FXML
    private AnchorPane ap;

    @FXML
    private Button btn;

    @FXML
    private ComboBox<String> cbCurso;

    @FXML
    private CheckBox checkBox;


    @FXML
    private ComboBox<String> cbSexo;

    @FXML
    private TextField tfNome;

    @FXML
    private Label lbl01;

    @FXML
    private MenuItem itemCurso;

    @FXML
    private MenuBar menuBar;
    @FXML
    public void initialize() {

        Curso curso = new Curso();

        ObservableList<String> otionsCurso = FXCollections.observableArrayList();

        List<Curso> cursosList = cursoDAO.findAll();

        for(Curso item : cursosList){
            otionsCurso.add(item.getNome() + "-" + item.getSigla());
        }

        cbCurso.setItems(otionsCurso);
        cbCurso.setValue(otionsCurso.get(0));


        ObservableList<String> optionsSexo = FXCollections.observableArrayList();
        optionsSexo.add("M");
        optionsSexo.add("F");

        cbSexo.setItems(optionsSexo);
        cbSexo.setValue(optionsSexo.get(0));
    }

    public void clearFields() {

        tfNome.setText("");
        checkBox.setSelected(false);
        initialize();
    }

    @FXML
    public void clickBtn(ActionEvent event) {

        Stage stage = (Stage) ap.getScene().getWindow();

        String nome = tfNome.getText();
        String nomeCurso = cbCurso.getValue();
        String sigla = nomeCurso.substring(nomeCurso.length() - 2);
        String sexo = cbSexo.getValue();
        boolean maioridade = checkBox.isSelected();

        Aluno a1 = new Aluno();

        a1.setName(nome);
        a1.setCurso(sigla);
        a1.setSexo(sexo);
        a1.setMaioridade(maioridade);

        try {

            if (Objects.equals(nome, "")) {
                lbl01.setText("Campo NOME Vazio!");
                lbl01.setTextFill(Color.RED);
                clearFields();
                return ;
            }

            Aluno alunoCreated = alunoDAO.create(a1);
            lbl01.setText("SUCESSO!");
            lbl01.setTextFill(Color.rgb(14, 191,47));
            clearFields();

        }
        catch(Exception e) {

            System.out.println(e.getMessage());
            lbl01.setText("ERRO!");
            lbl01.setTextFill(Color.RED);
            clearFields();

        }

    }

    @FXML
    void onClickCurso(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("Curso.fxml"));
        Scene scene = menuBar.getScene();
        scene.setRoot(newRoot);
    }




}