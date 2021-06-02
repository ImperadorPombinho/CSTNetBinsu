/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoxande.cst;

import static grupoxande.cst.App.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Pedrão Barros
 */
public class JogarController implements Initializable {

       @FXML
    private AnchorPane telaJogar;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < tamanhoTabul; i++) {
            for (int j = 0; j < tamanhoTabul; j++) {
                tabuleiro[i][j] = new Rectangle(i*50, j*50, 50, 50);
                if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)){
                    tabuleiro[i][j].setStyle("-fx-fill : white;");
                }else{
                    tabuleiro[i][j].setStyle("-fx-fill : green;");
                }
                    
                telaJogar.getChildren().add(tabuleiro[i][j]);
                
            }
        }
    }    
    
}
