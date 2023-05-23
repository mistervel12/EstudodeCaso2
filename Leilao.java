package EstudodeCaso2;

import java.util.Iterator;
import java.util.ArrayList;


   public class Leilao {
    private ArrayList<Lote> lotes;
    private int numeroProxLote;
    public Leilao() {
    this.lotes = new ArrayList<>();
    this.numeroProxLote = 1;
    }

    public void adicionaLote(String descricao) {
    this.lotes.add(new Lote(this.numeroProxLote, descricao));
    this.numeroProxLote++;
    }
    public void mostraLotes() {
    Iterator<Lote> it = this.lotes.iterator();
    while (it.hasNext()) {
    Lote lote = it.next();
    System.out.println(lote.getNumero() + ": " + lote.getDescricao());
    Lance melhorLance = lote.getMaiorLance();
    if (melhorLance != null) {
    System.out.println(" Lance:" + melhorLance.getValor());
    } else {
    System.out.println(" (Nenhum Lance)");
    }
    }
    }
    public Lote getLote(int numero) {
    if ((numero >= 1) && (numero < this.numeroProxLote)) {
    Lote loteSelecionado = this.lotes.get(numero - 1);
    if (loteSelecionado.getNumero() != numero) {
    System.out.println("Erro!!");
    }
    return loteSelecionado;
    } else {
    System.out.println("Lote numero " + numero + "não existe");
    return null;
    }
    }
    public String close() {
    StringBuilder resultados = new StringBuilder();
    resultados.append("Resultados do leilão:\n");

    Iterator<Lote> it = lotes.iterator();

    while (it.hasNext()) {
        Lote lote = it.next();
        resultados.append("Lote ").append(lote.getNumero()).append(": ").append(lote.getDescricao());
        Lance melhorLance = lote.getMaiorLance();
        if (melhorLance != null) {
            resultados.append(", Lance ganhador: ").append(melhorLance.getValor()).append("\n");
        } else {
            resultados.append(" (Nenhum Lance)\n");
        }
    }

    return resultados.toString();
    
}
    
    
    public ArrayList<Lote> getNaoVendidos() {
    ArrayList<Lote> naoVendidos = new ArrayList<>();

    Iterator<Lote> iterator = lotes.iterator();
    while (iterator.hasNext()) {
        Lote lote = iterator.next();
        if (lote.getMaiorLance() == null) {
            naoVendidos.add(lote);
        }
    }

    return naoVendidos;
}
    public Lote removeLote(int numero) {
    Iterator<Lote> iterator = lotes.iterator();
    while (iterator.hasNext()) {
        Lote lote = iterator.next();
        if (lote.getNumero() == numero) {
            iterator.remove();
            return lote;
        }
    }
    return null;
}
}

