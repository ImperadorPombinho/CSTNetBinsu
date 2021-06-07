/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoxande.cst;

import CSTgame.CSTpeca;
import CSTgame.CSTposicao;
import CSTgame.exececaoCST;
import CSTgame.partidaCST;
import CSTgame.personagensCST.leao;
import CSTgame.personagensCST.miguez;
import CSTgame.personagensCST.racoba;
import static grupoxande.cst.App.*;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import tabuleiroGame.posicao;

/**
 * FXML Controller class
 *
 * @author Pedrão Barros
 */
public class JogarController implements Initializable {
    //partidaCST partidaCST = new partidaCST(tamanhoTabul, tamanhoTabul, ID);
    //partidaCST partidaCST = new partidaCST(tamanhoTabul, tamanhoTabul, ID);
    partidaCST partidaCST = new partidaCST(tamanhoTabul, tamanhoTabul, ID);
    @FXML
    private AnchorPane telaJogar;
    @FXML
    private Label printarPartida;
    @FXML
    private Label statuslabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        inicializarTabuleiro();
        inicialiarTabulImagens();
        setupInicial();
        printarPartida.setText(UI.printarPartida(partidaCST, nomes));
         statuslabel.setText(UI.printarStatus(partidaCST.getJogador().getPecaAtual(), tamanhoTabul));
     

    }

    
private void inicialiarTabulImagens(){
    for (int i = 0; i < tamanhoTabul; i++) {
        for (int j = 0; j < tamanhoTabul; j++) {
            imagens[i][j] = new ImageView();
            imagens[i][j].setFitHeight(50);
            imagens[i][j].setFitWidth(50);
            imagens[i][j].setLayoutX(0);
            imagens[i][j].setLayoutY(0);
            imagens[i][j].setX(j*50);
            imagens[i][j].setY(i*50);
            telaJogar.getChildren().add(imagens[i][j]);
        }
    }
}
    @FXML
    private Button botaoAtacar;

    @FXML
   public  void fazerAtaque(ActionEvent event) {
         Alert alerta = new Alert(Alert.AlertType.ERROR);
    alerta.setTitle("ERRO");
    try {
        TextInputDialog pegarposicao = new TextInputDialog();
        pegarposicao.setTitle("posição");
        pegarposicao.setHeaderText("Me de a posição incial do personagem a ser movido");
        pegarposicao.setContentText("Valor: ");
        pegarposicao.showAndWait();
        posicao = pegarposicao.getResult();
        CSTposicao atacante = UI.traduzirPosicao(10, posicao);
        //printarTabuleiroPossiveisMovimento(mover);
        printarTabuleiroPossiveisAtaques(atacante);
        pegarposicao = new TextInputDialog();
        pegarposicao.setTitle("posição");
        pegarposicao.setHeaderText("Me de a posição final do personagem a ser movido");
        pegarposicao.setContentText("Valor: ");
        pegarposicao.showAndWait();
        posicaoFinal = pegarposicao.getResult();

        CSTposicao atacado = UI.traduzirPosicao(10, posicaoFinal);
        animacaoAtaque(atacado.toPosicao());
        partidaCST.perfomaceAtaque(atacante, atacado);
        
           //partidaCST.perfomaceFazerMovimento(mover, movido);
     }catch(InputMismatchException e){
          alerta.setHeaderText("FALHA AO DIGTAR");
          alerta.setContentText(e.getMessage());
          alerta.show();
          
      }catch(exececaoCST e){
          alerta.setHeaderText("FALHA EM RELAÇÃO AO JOGO");
          alerta.setContentText(e.getMessage());
          alerta.show();
      }
    resetarTabuleiro();
    printarPartida.setText(UI.printarPartida(partidaCST, nomes));
    statuslabel.setText(UI.printarStatus(partidaCST.getJogador().getPecaAtual(), tamanhoTabul));
    }
    @FXML
    private Button botaoMovimentar;

    @FXML
    public void fazerMovimentoo(ActionEvent event){
     Alert alerta = new Alert(Alert.AlertType.ERROR);
    alerta.setTitle("ERRO");
    try {
    TextInputDialog pegarposicao = new TextInputDialog();
    pegarposicao.setTitle("posição");
    pegarposicao.setHeaderText("Me de a posição incial do personagem a ser movido");
    pegarposicao.setContentText("Valor: ");
    pegarposicao.showAndWait();
    posicao = pegarposicao.getResult();
    CSTposicao mover = UI.traduzirPosicao(10, posicao);
    printarTabuleiroPossiveisMovimento(mover);
    pegarposicao = new TextInputDialog();
    pegarposicao.setTitle("posição");
    pegarposicao.setHeaderText("Me de a posição final do personagem a ser movido");
    pegarposicao.setContentText("Valor: ");
    pegarposicao.showAndWait();
    posicaoFinal = pegarposicao.getResult();
   
    CSTposicao movido = UI.traduzirPosicao(10, posicaoFinal);
    
       partidaCST.perfomaceFazerMovimento(mover, movido);
     }catch (FileNotFoundException ex) {
           alerta.setHeaderText("FALHA EM ARQUIVO");
           alerta.setContentText("Arquivo nao encontrado");
           alerta.show();
      }catch(InputMismatchException e){
          alerta.setHeaderText("FALHA AO DIGTAR");
          alerta.setContentText(e.getMessage());
          alerta.show();
          
      }catch(exececaoCST e){
          alerta.setHeaderText("FALHA EM RELAÇÃO AO JOGO");
          alerta.setContentText(e.getMessage());
          alerta.show();
      }
    resetarTabuleiro();
    printarPartida.setText(UI.printarPartida(partidaCST, nomes));
     statuslabel.setText(UI.printarStatus(partidaCST.getJogador().getPecaAtual(), tamanhoTabul));
    
//posicao = JOptionPane.showInputDialog("Qual posição esta a peça a ser movida");
    }
    @FXML
    public void usarHabilidade(ActionEvent event) {
         Alert alerta = new Alert(Alert.AlertType.ERROR);
         alerta.setTitle("ERRO");
         try {
            TextInputDialog pegarposicao = new TextInputDialog();
            pegarposicao.setTitle("posição");
            pegarposicao.setHeaderText("Me de a posição incial do personagem que vai utilizar uma habilidade");
            pegarposicao.setContentText("Valor: ");
            pegarposicao.showAndWait();
            posicao = pegarposicao.getResult();
            CSTposicao origem = UI.traduzirPosicao(10, posicao);
            //printarTabuleiroPossiveisMovimento(mover);
            if(partidaCST.getJogador().getPecaAtual() instanceof racoba){
                partidaCST.perfomaceHabilidade(origem, origem);
            }else{
                
            
            pegarposicao = new TextInputDialog();
            pegarposicao.setTitle("posição");
            pegarposicao.setHeaderText("Me de a posição final do personagem que vai sofrer a habilidade");
            pegarposicao.setContentText("Valor: ");
            pegarposicao.showAndWait();
            posicaoFinal = pegarposicao.getResult();
            CSTposicao destino = UI.traduzirPosicao(10, posicaoFinal);
            partidaCST.perfomaceHabilidade(origem, destino);
            }
     }catch(InputMismatchException e){
          alerta.setHeaderText("FALHA AO DIGTAR");
          alerta.setContentText(e.getMessage());
          alerta.show();
          
      }catch(exececaoCST e){
          alerta.setHeaderText("FALHA EM RELAÇÃO AO JOGO");
          alerta.setContentText(e.getMessage());
          alerta.show();
      }
    
    printarPartida.setText(UI.printarPartida(partidaCST, nomes));
     statuslabel.setText(UI.printarStatus(partidaCST.getJogador().getPecaAtual(), tamanhoTabul));
    }
/*void partidaIniciada(){
    String resp = "S";
    while("S".equals(resp.intern())){
       while(partidaCST.ispartida()){
        
    } 
    }
    
}*/
    private void printarTabuleiroPossiveisMovimento(CSTposicao origem){
        boolean[][] possiveisMovimentos = partidaCST.possiveisMovimentos(origem);
        for (int i = 0; i < tamanhoTabul; i++) {
            for (int j = 0; j < tamanhoTabul; j++) {
                UI.printarTabuleiroPossiveisAlgumaCoisa(possiveisMovimentos[i][j], i, j);
            }
        }
        
    }
   private void printarTabuleiroPossiveisAtaques(CSTposicao atacante){
        boolean[][] possiveisAtaques = partidaCST.possiveisAtaques(atacante);
        for (int i = 0; i < tamanhoTabul; i++) {
            for (int j = 0; j < tamanhoTabul; j++) {
                UI.printarTabuleiroPossiveisAlgumaCoisa(possiveisAtaques[i][j], i, j);
            }
        }
    }
private void inicializarTabuleiro(){
    for (int i = 0; i < tamanhoTabul; i++) {
        for (int j = 0; j < tamanhoTabul; j++) {
           tabuleiro[i][j] = new Rectangle(j*50, i*50, 50, 50);
                
            if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)){
                tabuleiro[i][j].setStyle("-fx-fill : white;");
            }else{
                tabuleiro[i][j].setStyle("-fx-fill : green;");
                }
                    
            telaJogar.getChildren().add(tabuleiro[i][j]);
                
            }
        }
}
private void resetarTabuleiro(){
    for (int i = 0; i < tamanhoTabul; i++) {
        for (int j = 0; j < tamanhoTabul; j++) {
             if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)){
                tabuleiro[i][j].setStyle("-fx-fill : white;");
            }else{
                tabuleiro[i][j].setStyle("-fx-fill : green;");
                }
        }
    }
}
private void inicializarImagens(char coluna, int linha){
    posicao posicaoinicial = new CSTposicao(coluna, linha, tamanhoTabul).toPosicao();
    CSTpeca visualPeca = partidaCST.acharPecaPorPosicao(posicaoinicial);
    Image visual  = null;

     try{
          if(visualPeca instanceof racoba){
            visual = ((racoba) visualPeca).getVisual();
        
           }else if(visualPeca instanceof miguez){
            visual = ((miguez) visualPeca).getVisual();
           }else if(visualPeca instanceof leao){
               visual = ((leao) visualPeca).getVisual();
           }
          
     }catch(FileNotFoundException e){
         e.printStackTrace();
     }
            imagens[posicaoinicial.getLinha()][posicaoinicial.getColuna()].setImage(visual);
       
}
private void setupInicial(){
    inicializarImagens('B', 8);
    inicializarImagens('B', 7);
    inicializarImagens('B', 6);

       
}
private void animacaoAtaque(posicao atacado){
    Image animacao = null;   
    try {
            animacao = new Image(new FileInputStream("C:\\Users\\Pedrão Barros\\Documents\\NetBeansProjects\\CST\\src\\main\\resources\\grupoxande\\cst\\imagem\\atqanimacao.gif"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    if(imagens[atacado.getLinha()][atacado.getColuna()] != null){
        imagens[atacado.getLinha()][atacado.getColuna()] = new ImageView(animacao);
        imagens[atacado.getLinha()][atacado.getColuna()].setFitHeight(50);
            imagens[atacado.getLinha()][atacado.getColuna()].setFitWidth(50);
            imagens[atacado.getLinha()][atacado.getColuna()].setLayoutX(0);
            imagens[atacado.getLinha()][atacado.getColuna()].setLayoutY(0);
            imagens[atacado.getLinha()][atacado.getColuna()].setX(atacado.getColuna()*50);
            imagens[atacado.getLinha()][atacado.getColuna()].setY(atacado.getLinha()*50);
        telaJogar.getChildren().add(imagens[atacado.getLinha()][atacado.getColuna()]);
    }
}
}
