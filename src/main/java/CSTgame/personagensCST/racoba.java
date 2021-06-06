/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTgame.personagensCST;

import CSTgame.CSTpeca;
import CSTgame.gacha;
import CSTgame.partidaCST;
import CSTgame.time;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import javafx.scene.image.Image;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

/**
 *
 * @author Pedrão Barros
 */
public class racoba extends CSTpeca {
    private Image visual;
    private time timinho;

    public Image getVisual() throws FileNotFoundException {
        if(timinho == time.ORACULO){
             visual = new Image(new FileInputStream("C:\\Users\\Pedrão Barros\\Documents\\NetBeansProjects\\CST\\src\\main\\resources\\grupoxande\\cst\\imagem\\racobaOraculo.png"));
        }else{
             visual = new Image(new FileInputStream("C:\\Users\\Pedrão Barros\\Documents\\NetBeansProjects\\CST\\src\\main\\resources\\grupoxande\\cst\\imagem\\racobaTropa.png"));
        }
       
        return visual;
    }
    
    
    public racoba(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento, String nome, partidaCST partidaCST){
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento, nome);
        this.timinho = timinho;
        setTravaMov(false);
        setInventario(new gacha("Lucky Wheel", partidaCST, 0));
    }
    
    Random aleatorio = new Random();
    
    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possiveisAtaques() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        int contMovimento = 1;
        int rangeAtq;
        if(getInventario().getNomeItem().equals("AK Trovoada")){
            rangeAtq = getRangeMovimento()+3;
        }
        else{
            rangeAtq = getRangeMovimento()-1;
        }
        posicao posTeste = new posicao(0, 0);
        //cima
        posTeste.setCoordenada(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabul().posicaoExiste(posTeste) && contMovimento <= rangeAtq ){
            if(haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
            
            posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna() );
            contMovimento++;
        }
        //direita
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() + 1);
        while(getTabul().posicaoExiste(posTeste) && contMovimento <= rangeAtq ){
            if(haUmaPecaDoOponente(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
            posTeste.setCoordenada(posTeste.getLinha() , posTeste.getColuna() + 1);
            contMovimento++;
        }
        //baixo
          contMovimento = 1;
          posTeste.setCoordenada(posicao.getLinha() + 1, posicao.getColuna() );
          while(getTabul().posicaoExiste(posTeste) && contMovimento <= rangeAtq ){
            if(haUmaPecaDoOponente(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
              posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna() );
              contMovimento++;
          }
        //esquerda
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() - 1);
        while(getTabul().posicaoExiste(posTeste)&& contMovimento <= rangeAtq ){
            if(haUmaPecaDoOponente(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
            posTeste.setCoordenada(posTeste.getLinha() , posTeste.getColuna() - 1);
            contMovimento++;
        }

        return matAux;
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        int contMovimento = 1;
        posicao posTeste = new posicao(0, 0);
        //acima

        posTeste.setCoordenada(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna());
            contMovimento++;
        }
        //abaixo
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() + 1, posicao.getColuna());
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna());
            contMovimento++;
        }
        //esquerda
          contMovimento = 1;
          posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() - 1);
          while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
              matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
              posTeste.setCoordenada(posTeste.getLinha(), posTeste.getColuna() - 1);
              contMovimento++;
          }
        //direita
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() + 1);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() , posTeste.getColuna() + 1);
            contMovimento++;
        }



        return matAux;
    }

    @Override
    public void habilidade(CSTpeca generico) {
        if(getInventario().getNomeItem().equals("Foice")){
            System.out.println(getPosicao().getLinha());
            System.out.println(getPosicao().getLinha()+1);
            posicao posTeste = new posicao (0, 0);
            CSTpeca pecax;
            int lin;
            int col;
            for(lin = getPosicao().getLinha()+1; lin > getPosicao().getLinha()-2; lin--){
                for(col = getPosicao().getColuna()-1; col < getPosicao().getColuna()+2; col++){
                    posTeste.setCoordenada(lin, col);
                    if(getTabul().posicaoExiste(posTeste)){
                        if(haUmaPecaDoOponente(posTeste)){
                            pecax = (CSTpeca) getTabul().peca(posTeste);
                            if(!(pecax instanceof obstaculo)){
                                System.out.println("~~~~~Ceifador de almas~~~~~");
                                System.out.println("Oponente em alcance: " +pecax.getNome()
                                +"\nVida oponente: "+pecax.getVida());
                                setVida(getVida() + (pecax.getVida()/10));
                                pecax.setVida(pecax.getVida() - (pecax.getVida()/10));
                                if(pecax.getVida() <= 0){
                                    pecax.setVida(1);
                                }
                                System.out.println("absorveu: " +pecax.getNome());
                                System.out.println("vida atual do alvo: " +pecax.getVida());
                            }

                        }
                    }
                }
            }
            System.out.println(getNome() +" absorveu vida dos inimigos ao redor e agora seu HP esta em: " +getVida());
            System.out.println("A racofoice atual foi quebrada devido ao poder!");
        }
        ((gacha)getInventario()).atributos(this, aleatorio.nextInt(4)+1);
    }
    
    
}
