/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoxande.cst;

import CSTgame.ManipuladorDeArquivo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pedrão Barros
 */
public class VencedorController implements Initializable {

    @FXML
    private AnchorPane vencedorTela;

    @FXML
    private Button botaoSim;

    @FXML
    private Button botaoNao;

    @FXML
    private Label vencedor;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vencedor.setText(App.nomeVencedor);
    } 
 

    @FXML
    void continuarJogar(ActionEvent event) {
        try {
            App.setRoot("jogarInicial");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    @FXML
    void fecharJogo(ActionEvent event) {
          Alert info = new Alert(Alert.AlertType.INFORMATION);
          info.setTitle("Mensagem de saida");
          String info2 = null;
          try {

              info2 = ManipuladorDeArquivo.lerArquivo("C:\\Users\\Pedrão Barros\\Documents\\NetBeansProjects\\CST\\src\\main\\java\\grupoxande\\cst\\creditos.txt");

          } catch (IOException ex) {
              ex.printStackTrace();
          }
          info.setHeaderText("Obrigado por jogar");
          info.setContentText(info2);
          info.showAndWait();
        Stage stage = (Stage) botaoNao.getScene().getWindow();
        stage.close();
    }
    
}
