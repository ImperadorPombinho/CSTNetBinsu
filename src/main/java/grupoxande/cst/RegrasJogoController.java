/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoxande.cst;

import ClassesTela.personagem;
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

/**
 * FXML Controller class
 *
 * @author Pedrão Barros
 */
public class RegrasJogoController implements Initializable {

   
    @FXML
    private ComboBox<personagem> cbPersonagem;
    private List<personagem> personagens = new ArrayList<>();
    private ObservableList<personagem> obpersonagem;

    @FXML
    private Button botaoSelecionar;

    @FXML
    private Button botaoVoltar;

    @FXML
    void selecionarPersonagem(ActionEvent event) throws IOException {
        personagem perescolhido = cbPersonagem.getSelectionModel().getSelectedItem();
        if("Leão".equals(perescolhido.getNome().intern())){
            App.setRoot("leao");
        }
        if("Racoba".equals(perescolhido.getNome().intern())){
            App.setRoot("racoba");
        }
        if("Henridog".equals(perescolhido.getNome().intern())){
            App.setRoot("henridog");
        }
        if("Juao".equals(perescolhido.getNome().intern())){
            App.setRoot("juao");
        }
        if("Miguez".equals(perescolhido.getNome().intern())){
            App.setRoot("miguez");
        }
    }

    @FXML
    void voltarTela(ActionEvent event) throws IOException {
        App.setRoot("telaInicial");
          
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       carregarPersonagem();
    }
    void carregarPersonagem(){
        personagem per1 = new personagem("Leão", 10, 10, 10, 10);
        personagem per2 = new personagem("Henridog", 10, 10, 10, 10);
        personagem per3 = new personagem("Juao", 10, 10, 10, 10);
        personagem per4 = new personagem("Racoba", 10, 10, 10, 10);
        personagem per5 = new personagem("Miguez", 10, 10, 10, 10);
        personagens.add(per1);
        personagens.add(per2);
        personagens.add(per3);
        personagens.add(per4);
        personagens.add(per5);
        obpersonagem = FXCollections.observableArrayList(personagens);
        cbPersonagem.setItems(obpersonagem);
    }
    
}
