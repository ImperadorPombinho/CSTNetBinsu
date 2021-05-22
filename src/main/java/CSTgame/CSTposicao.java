/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTgame;

import tabuleiroGame.posicao;

/**
 *
 * @author Pedrão Barros
 */
public class CSTposicao {
    private char coluna;
    private int linha;
    private int linhaMax;

    public int getColuna() {
        return coluna;
    }
    public void setColuna(char coluna) {
        this.coluna = coluna;
    }
    public int getLinha() {
        return linha;
    }
    public void setLinha(int linha) {
        this.linha = linha;
    }
    public int getLinhaMax() {
        return linhaMax;
    }

 
    public CSTposicao(char coluna, int linha, int linhaMax) {
        if(coluna < 'A' || coluna > 'Z' || linha < 1 || linha > linhaMax){
            throw new exececaoCST("erro instanciando CSTposiçao, valores permitidos de A1 ate Z"+linhaMax);
        }
        this.coluna = coluna;
        this.linha = linha;
        this.linhaMax = linhaMax;
        
    }

    public posicao toPosicao(){
        return new posicao(getLinhaMax() - getLinha(), getColuna() - 'A');
    }
    public CSTposicao voltaCsTposicao(posicao posicao, int linhas){
        return new CSTposicao((char)('A' + posicao.getColuna()), linhas - getLinha(), linhas);
    }
    @Override
    public String toString(){
        return "" + getColuna() + getLinha();
    }


}
