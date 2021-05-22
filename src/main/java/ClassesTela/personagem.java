/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesTela;

/**
 *
 * @author Pedrão Barros
 */
public class personagem {
    private String nome;
    private int ataque;
    private int defesa;
    private int range;
    private int vida;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public personagem(String nome, int ataque, int defesa, int range, int vida) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.range = range;
        this.vida = vida;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
