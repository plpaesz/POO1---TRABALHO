package dominio;

import java.time.LocalDate;

public abstract class BaseParametro {
    protected int codigo;
    protected String marca;
    protected String modelo;
    protected LocalDate anoFabricacao;
    protected double preco;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
   
    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(LocalDate anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public BaseParametro() {
    }

    public BaseParametro(int codigo, String marca, String modelo, LocalDate anoFabricacao, double preco) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.preco = preco;
    }
}
