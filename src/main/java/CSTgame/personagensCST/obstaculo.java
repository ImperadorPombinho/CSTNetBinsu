/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTgame.personagensCST;

import CSTgame.CSTpeca;
import CSTgame.time;
import tabuleiroGame.tabuleiro;

/**
 *
 * @author Pedrão Barros
 */
public class obstaculo extends CSTpeca{

    public obstaculo(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento, String nome) {
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento, nome);
        
    }

    
    @Override
    public String toString(){
        return "#";
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];

        return matAux;
    }

    @Override
    public boolean[][] possiveisAtaques() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void habilidade(CSTpeca aliado) {
        
        
    }
    
}
