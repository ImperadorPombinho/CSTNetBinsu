/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoxande.cst;

import static grupoxande.cst.App.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Pedrão Barros
 */
public class JogarInicialController implements Initializable {
    @FXML
    private ComboBox<Integer> tamanhoBox;
    private List <Integer> tamanhos = new ArrayList<>();
    private ObservableList<Integer> obtamanhos;
    @FXML
    private TextField nome1;

    @FXML
    private TextField nome2;

    @FXML
    private Button botaoIR;

    @FXML
    void irJogar(ActionEvent event) throws IOException {
       nomes[0] = nome1.getText();
       nomes[1] = nome2.getText();
       tamanhoTabul = tamanhoBox.getSelectionModel().getSelectedItem();
       tabuleiro = new Rectangle[tamanhoTabul][tamanhoTabul];
       imagens = new ImageView[tamanhoTabul][tamanhoTabul];
       App.setRoot("jogar");
    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTamanhos();
    } 
    void carregarTamanhos(){
        tamanhos.add(10);
        tamanhos.add(20);
        tamanhos.add(26);
        obtamanhos = FXCollections.observableArrayList(tamanhos);
        tamanhoBox.setItems(obtamanhos);
    }
    
}
