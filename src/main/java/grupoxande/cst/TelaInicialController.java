/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoxande.cst;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Pedrão Barros
 */
public class TelaInicialController implements Initializable {

   
    @FXML
    private Button botaoJogar;

    @FXML
    private Button botaoRegras;

    @FXML
    private Button botaoSair;

    @FXML
    void sairDoJogo() {
        //nada por enquanto
    }

    @FXML
    void trocarTelaJogar() {
        //nada por enquanto
        
    }

    @FXML
    void trocarTelaRegras() throws IOException {
        App.setRoot("regrasJogo");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
