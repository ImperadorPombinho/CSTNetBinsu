/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTgame.personagensCST;

import CSTgame.CSTpeca;
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
public class miguez extends CSTpeca {
    Random aleatorio = new Random();
    private int dormindo;
    private partidaCST partida;
    private time timinho;
    private Image visual;

    public Image getVisual() throws FileNotFoundException {
        if(timinho == time.ORACULO){
            visual = new Image(new FileInputStream("C:\\Users\\Pedrão Barros\\Documents\\NetBeansProjects\\CST\\src\\main\\resources\\grupoxande\\cst\\imagem\\miguezOraculo.png"));
        }else{
            visual = new Image(new FileInputStream("C:\\Users\\Pedrão Barros\\Documents\\NetBeansProjects\\CST\\src\\main\\resources\\grupoxande\\cst\\imagem\\miguezTropa.png"));
        }
        
        return visual;
    }
    public miguez(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento, partidaCST partida, String nome) {
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento, nome);
        this.timinho = timinho;
        this.partida = partida;
        setTravaMov(false);
    }

    @Override
    public String toString(){
        return "M";
    }

    public int getDormindo() {
        dormindo = aleatorio.nextInt(10)+1;
        return dormindo;
    }

    public void setDormindo(int dormindo) {
        this.dormindo = dormindo;
    }

    public String dormiuVez(){
        if(getDormindo() == 1){
            partida.proximoTurno();
            return "Miguez acabou dormindo demais e perdeu a jogada!";
        }
        else{ 
        return null;
        }
    }



    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        int contMovimento = 1;
        posicao posTeste = new posicao(0, 0);
        //acima
        
        posTeste.setCoordenada(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
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
          while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
              matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
              posTeste.setCoordenada(posTeste.getLinha(), posTeste.getColuna() - 1);
              contMovimento++;
          }
            //direita
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() + 1);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() , posTeste.getColuna() + 1);
            contMovimento++;
        }


        return matAux;
    }



    @Override
    public boolean[][] possiveisAtaques() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        posicao posTeste = new posicao(0, 0);
        //acima
        posTeste.setCoordenada(getPosicao().getLinha() - 1, getPosicao().getColuna());
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }
        //baixo
        posTeste.setCoordenada(getPosicao().getLinha() + 1, getPosicao().getColuna());
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }
        //esquerda
        posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() - 1);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }
        //direita
        posTeste.setCoordenada(getPosicao().getLinha() , getPosicao().getColuna() + 1);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)&& getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }

        return matAux;
    }
//aa
    @Override
    public void habilidade(CSTpeca generico) {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        posicao posTeste = new posicao(0, 0);
        //acima
        posTeste.setCoordenada(getPosicao().getLinha() - 1, getPosicao().getColuna());
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            generico.setTravaMov(true);
            System.out.println("Congelou a peça selecionada por uma rodada!");
        }
        //abaixo
        posTeste.setCoordenada(getPosicao().getLinha() + 1, getPosicao().getColuna());
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            generico.setTravaMov(true);
            System.out.println("Congelou a peça selecionada por uma rodada!");
        }
        //acima
        posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() - 1);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            generico.setTravaMov(true);
            System.out.println("Congelou a peça selecionada por uma rodada!");
        }
        //acima
        posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() + 1);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            generico.setTravaMov(true);
            System.out.println("Congelou a peça selecionada por uma rodada!");
        }
    }
}
