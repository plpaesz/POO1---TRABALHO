package dominio;

import java.time.LocalDate;

public class Produto extends BaseParametro {
    private int codigoSubclasse;
    private double valor;
    public int getCodigoSubclasse() {
        return codigoSubclasse;
    }
    public void setCodigoSubclasse(int codigoSubclasse) {
        this.codigoSubclasse = codigoSubclasse;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Produto() {
        super();
    }
    public Produto(int codigo, String marca, String modelo, LocalDate anoFabricacao, double preco, 
    int codigoSubclasse, double valor) {
        super(codigo, marca, modelo, anoFabricacao, preco);
        this.codigoSubclasse = codigoSubclasse;
        this.valor = valor;
    }

}
