/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabuleiroGame;

import CSTgame.CSTposicao;

/**
 *
 * @author Pedrão Barros
 */
public class posicao {
    private int linha;
    private int coluna;
    

    public posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
    public int getLinha() {
        return linha;
    }
    public void setLinha(int linha) {
        this.linha = linha;
    }
    public int getColuna() {
        return coluna;
    }
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    public void setCoordenada(int linha, int coluna){
        setLinha(linha);
        setColuna(coluna);
    }
    //metodos:
    @Override
    public String toString(){
        return getLinha() + ", " + getColuna();
    }
    public boolean posicaoExiste(posicao posTeste) {
		return false;
	}

    
}
