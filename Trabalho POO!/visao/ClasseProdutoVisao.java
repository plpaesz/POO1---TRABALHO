package visao;

import dominio.ClasseProduto;
import java.time.LocalDate;
import java.util.ArrayList;
import servico.ClasseProdutoServico;

public class ClasseProdutoVisao {
    
    private ClasseProdutoServico srv;

    public ClasseProdutoVisao(){
        this.srv = new ClasseProdutoServico();
    }

    public void CriarListar(){
        ClasseProduto cp = new ClasseProduto();
        cp.setCodigo(0);
        cp.setMarca("Teste");
        cp.setModelo("Teste 1");
        cp.setPreco(90000);
        cp.setAnoFabricacao(LocalDate.now());
        this.srv.Criar(cp);
        this.Imprimir(cp);
    }

    public void Exibir(){
        ArrayList<ClasseProduto> lista = this.srv.LerTodos();
        for (ClasseProduto cp : lista) {
            this.Imprimir(cp);
        }
    }

    private void Imprimir(ClasseProduto cp){
        System.out.println("Classe de Produto");
        System.out.println("Código: " + cp.getCodigo());
        System.out.println("Marca: " + cp.getMarca());
        System.err.println("Preço" + cp.getPreco());
        System.out.println("Ano da fabricação: " + cp.getAnoFabricacao());
    }

    public void ExibirEmLinha(){
        ArrayList<ClasseProduto> lista = this.srv.LerTodos();
        for (ClasseProduto cp : lista) {
            this.ImprimirEmLinha(cp);
        }
    }

    private void ImprimirEmLinha(ClasseProduto cp){
        String msg = "Veiculo - ";
        msg += "Código: " + cp.getCodigo() + " | ";
        msg += "Marca: " + cp.getMarca() + " | ";
        msg += "Modelo: " + cp.getModelo() + " | ";
        msg += "Preco: " + cp.getPreco() + " | ";
        msg += "Ano da fabricação: " + cp.getAnoFabricacao();
        System.out.println(msg);
    }
}
