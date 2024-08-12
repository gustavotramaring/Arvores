import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    pai = atual;
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if (esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public boolean remover(int valor) {
        No atual = this.raiz;
        No pai = null;
        boolean esquerda = false;
        while (atual != null && atual.getValor() != valor) { //busca o nó para remover
            pai = atual;
            if (valor < atual.getValor()) {
                esquerda = true;
                atual = atual.getEsq();
            } else {
                esquerda = false;
                atual = atual.getDir();
            }
        }
        if (atual == null) { //se o nó não for encontrado ele finaliza o programa
            return false;
        }
        if (atual.getEsq() == null && atual.getDir() == null) { //folha
            if (atual == raiz) {
                raiz = null;
            } else if (esquerda) {
                pai.setEsq(null); //remove à esquerda do pai do numero inserido
            } else {
                pai.setDir(null); //remove à direita do pai do numero inserido
            }
        }
        else if (atual.getEsq() == null) { //nó tem apenas 1 filho
            if (atual == raiz) {
                raiz = atual.getDir();
            } else if (esquerda) {
                pai.setEsq(atual.getDir());
            } else {
                pai.setDir(atual.getDir());
            }
        } else if (atual.getDir() == null) {
            if (atual == raiz) {
                raiz = atual.getEsq();
            } else if (esquerda) {
                pai.setEsq(atual.getEsq());
            } else {
                pai.setDir(atual.getEsq());
            }
        }
        else { //nó tem dois filhos
            No sucessor = obterSucessor(atual);
            if (atual == raiz) {
                raiz = sucessor;
            } else if (esquerda) {
                pai.setEsq(sucessor);
            } else {
                pai.setDir(sucessor);
            }
            sucessor.setEsq(atual.getEsq());
        }
        return true;
    }

        private No obterSucessor(No no) {
        No sucessorPai = no;
        No sucessor = no;
        No atual = no.getDir();
        while (atual != null) {
            sucessorPai = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }
        if (sucessor != no.getDir()) {
            sucessorPai.setEsq(sucessor.getDir());
            sucessor.setDir(no.getDir());
        }
        return sucessor;
    }
}






















