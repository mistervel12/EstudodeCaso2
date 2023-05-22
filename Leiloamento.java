
package EstudodeCaso2;
import java.util.ArrayList;
import java.util.Scanner;

public class Leiloamento {
    private Leilao leilao;
    private Scanner scanner;

    public Leiloamento() {
        leilao = new Leilao();
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("========= Sistema de Leilões =========");
            System.out.println("1. Adicionar Lote");
            System.out.println("2. Realizar Lance");
            System.out.println("3. Mostrar Lotes");
            System.out.println("4. Fechar Leilão");
            System.out.println("5. Mostrar Lotes Não Vendidos");
            System.out.println("6. Remover Lote");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarLote();
                    break;
                case 2:
                    realizarLance();
                    break;
                case 3:
                    mostrarLotes();
                    break;
                case 4:
                    fecharLeilao();
                    break;
                case 5:
                    mostrarLotesNaoVendidos();
                    break;
                case 6:
                    removerLote();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void adicionarLote() {
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Descrição do lote: ");
        String descricao = scanner.nextLine();
        leilao.adicionaLote(descricao);
        System.out.println("Lote adicionado com sucesso!");
    }

    private void realizarLance() {
        System.out.print("Número do lote: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Nome do licitante: ");
        String nomeLicitante = scanner.nextLine();
        System.out.print("Valor do lance: ");
        double valorLance = scanner.nextDouble();

        Lote lote = leilao.getLote(numero);
        if (lote != null) {
            Pessoa licitante = new Pessoa(nomeLicitante);
            lote.lancePara(licitante, valorLance);
            System.out.println("Lance registrado com sucesso!");
        }
    }

    private void mostrarLotes() {
        System.out.println("===== LOTES =====");
        leilao.mostraLotes();
        System.out.println("=================");
    }

    private void fecharLeilao() {
        leilao.close();
        System.out.println("Leilão encerrado. Detalhes dos lotes:");
        leilao.mostraLotes();
    }

    private void mostrarLotesNaoVendidos() {
        System.out.println("===== LOTES NÃO VENDIDOS =====");
        ArrayList<Lote> lotesNaoVendidos = leilao.getNaoVendidos();
        if (lotesNaoVendidos.isEmpty()) {
System.out.println("Não há lotes não vendidos.");
} else {
for (Lote lote : lotesNaoVendidos) {
System.out.println("Lote " + lote.getNumero() + ": " + lote.getDescricao());
}
}
System.out.println("=============================");
}
    private void removerLote() {
    System.out.print("Número do lote a ser removido: ");
    int numero = scanner.nextInt();
    scanner.nextLine(); // Limpar o buffer do scanner

    Lote loteRemovido = leilao.removeLote(numero);
    if (loteRemovido != null) {
        System.out.println("Lote " + loteRemovido.getNumero() + " removido com sucesso.");
    } else {
        System.out.println("Lote não encontrado ou não pode ser removido.");
    }
}

}
