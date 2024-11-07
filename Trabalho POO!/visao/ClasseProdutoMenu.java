package visao;

import dominio.ClasseProduto;
import java.time.LocalDate;
import java.util.ArrayList;
import servico.ClasseProdutoServico;

public class ClasseProdutoMenu extends BaseMenu {

    private ClasseProdutoServico srv;

    public ClasseProdutoMenu(){
        super();
        this.srv = new ClasseProdutoServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while(opcao != 9)
        {
            Util.ClearConsole();
            System.out.println("Veículo");
            System.out.println("Menu de Opções");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Digite sua opção: ");
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.ClearConsole();
        System.out.println("Listando...");

        ArrayList<ClasseProduto> lista = this.srv.LerTodos();
        for (ClasseProduto cp : lista) {
            this.ImprimirEmLinha(cp);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.ClearConsole();
        System.out.println("Localizando...");

        System.out.print("Informe o código do Veículo: ");
        int codigo = this.scanner.nextInt();

        ClasseProduto cp = this.srv.Ler(codigo);
        if (cp != null){
            this.ImprimirEmLinha(cp);
        }
        else{
            System.out.println("Problema - Veículo não foi encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.ClearConsole();
        System.out.println("Adicionando...");

        System.out.print("Informe a marca do Veículo: ");
        String marca = this.scanner.next();

        System.out.print("Informe o modelo do Veículo: ");
        String modelo = this.scanner.next();

        System.out.print("Informe o preço do Veículo: ");
        double preco = this.scanner.nextDouble();
        
    
        ClasseProduto cp = new ClasseProduto();
        cp.setCodigo(0);
        cp.setMarca(marca);
        cp.setModelo(modelo);
        cp.setPreco(preco);
        cp.setAnoFabricacao(LocalDate.now());
       
        
        ClasseProduto cpnovo = this.srv.Criar(cp);
        if (cpnovo != null){
            System.out.println("Veículo adicionado com sucesso");
        }
        else{
            System.out.println("Problema - Veículo não foi adicionado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.ClearConsole();
        System.out.println("Atualizando...");

        System.out.print("Informe o código do Veículo: ");
        int codigo = this.scanner.nextInt();

        ClasseProduto cp = this.srv.Ler(codigo);
        if (cp != null){
            System.out.print("Informe a nova marca do Veículo: ");
            String marca = this.scanner.next();
            cp.setMarca(marca);

            System.out.print("Informe o novo modelo do Veículo: ");
            String modelo = this.scanner.next();
            cp.setModelo(modelo);

            System.out.print("Informe o novo preço do Veículo: ");
            double preco = this.scanner.nextDouble();
            cp.setPreco(preco);

            if (this.srv.Atualizar(cp) != null){
                System.out.println("Veículo atualizado com sucesso");
            }
            else{
                System.out.println("Problema - Veículo não foi atualizado");
            }
        }
        else{
            System.out.println("Problema - Veículo não foi encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.ClearConsole();
        System.out.println("Removendo...");

        System.out.print("Informe o código do Veículo: ");
        int codigo = this.scanner.nextInt();

        ClasseProduto cp = this.srv.Ler(codigo);
        if (cp != null){
            if (this.srv.Deletar(codigo) != null){
                System.out.println("Veículo removido com sucesso");
            }
            else{
                System.out.println("Problema - Veículo não foi removido");
            }
        }
        else{
            System.out.println("Problema - Veículo não foi encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void ImprimirEmLinha(ClasseProduto cp){
        String msg = "Veículo - ";
        msg += "Código: " + cp.getCodigo() + " | ";
        msg += "Marca: " + cp.getMarca() + " | ";
        msg += "Modelo: " + cp.getModelo() + " | ";
        msg += "Ano de Fabricação: " + cp.getAnoFabricacao() + " | ";
        msg += "Preço: " + cp.getPreco() + " | ";
        System.out.println(msg);
    }    
}
