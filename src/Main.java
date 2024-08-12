public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(8);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(2);
        arvoreBinaria.inserir(18);

        if (arvoreBinaria.remover(18)) {
            System.out.println("Pre-ordem: ");
            arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        }

    }
}