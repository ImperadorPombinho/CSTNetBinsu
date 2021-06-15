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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pedrão Barros
 */
public class TelaInicialController implements Initializable {
      @FXML
    private AnchorPane anchorpane;
    @FXML
    private ImageView imagem;
    @FXML
    private Button botaoJogar;

    @FXML
    private Button botaoRegras;

    @FXML
    private Button botaoSair;

    @FXML
    void sairDoJogo() {
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
          Stage stage = (Stage) botaoSair.getScene().getWindow();
           stage.close();
    }

    @FXML
    void trocarTelaJogar() throws IOException {
       App.setRoot("jogarInicial");
    }

    @FXML
    void trocarTelaRegras() throws IOException {
        App.setRoot("regrasJogo");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
