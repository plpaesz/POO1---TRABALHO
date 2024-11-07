package dominio;

import java.time.LocalDate;

public class ClasseProduto extends BaseParametro {

    public ClasseProduto(){
        super();
    }
    
    public ClasseProduto(int codigo, String marca, String modelo, LocalDate anoFabricacao, double preco ){
        super(codigo, marca, modelo, anoFabricacao, preco);
    }
}