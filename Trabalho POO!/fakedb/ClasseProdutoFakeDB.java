package fakedb;

import dominio.ClasseProduto;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClasseProdutoFakeDB 
    extends BaseFakeDB<ClasseProduto> {

    public ClasseProdutoFakeDB(){
        super();
    }

    @Override
    protected void preencherDados() {
        this.tabela = new ArrayList<>();
        this.tabela.add(new ClasseProduto(1,"FIAT", "MOBI", LocalDate.now(), 70000));
    }

}
