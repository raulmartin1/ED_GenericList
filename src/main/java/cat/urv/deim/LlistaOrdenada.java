package cat.urv.deim;

import cat.urv.deim.exceptions.ElementNoTrobat;
import cat.urv.deim.exceptions.PosicioForaRang;

public class LlistaOrdenada<E extends Comparable<E>> implements ILlistaGenerica<E> {
private Node<E> fantasma;

public LlistaOrdenada() {
    this.fantasma=new Node<>(null);
    this.fantasma.seguent=null;
}

    private static class Node<E> {
        private E dada;
        private Node<E> seguent;

        public Node(E dada) {
            this.dada=dada;
            this.seguent=null;
        }
    }

    public void inserir(E e) {
        Node<E> nouNode = new Node<>(e);

        if(esBuida()) fantasma.seguent=nouNode;
        else {

        Node<E> actual = fantasma.seguent;
        Node<E> anterior = fantasma;

        while (actual != null && actual.dada.compareTo(nouNode.dada)<0) {
            anterior = actual;
            actual = actual.seguent;
        }
        nouNode.seguent = actual;
        anterior.seguent= nouNode;
    }
    }

    public void esborrar(E e) throws ElementNoTrobat {
        Node<E> actual = fantasma;
        while (actual.seguent != null && actual.seguent.dada.compareTo(e) != 0) {
            actual = actual.seguent;
        }
        if (actual.seguent==null) {
            throw new ElementNoTrobat();
        }
        actual.seguent=actual.seguent.seguent;
    }

    public E consultar(int pos) throws PosicioForaRang {
        Node<E> actual = fantasma.seguent;
        if (pos <0) {
            throw new PosicioForaRang();
        }
        for (int i=0; actual != null && i<pos; i++) {
            actual=actual.seguent;
        }
        if(actual==null) {
            throw new PosicioForaRang();
        }
        return actual.dada;
    }

    public int buscar(E e) throws ElementNoTrobat {
        Node<E> actual = fantasma;
        int i=0;
        while(actual.seguent != null){
        if(actual.seguent.dada.equals(e)) {
            return i;
        }
        else{
            actual=actual.seguent;
            i++;
        }
    }
        throw new ElementNoTrobat();
    }

    public boolean existeix(E e) {
        try {
            buscar(e);
            return true;
        } catch (ElementNoTrobat e1) {
            return false;
        }
    }

    public boolean esBuida() {
        return fantasma.seguent == null;
    }

    public int numElements() {
    Node<E> actual=fantasma.seguent;
    int numElements=0;
    while(actual!=null) {
        numElements++;
        actual=actual.seguent;
    }
    return numElements;
    }

    public Object[] elements() {
       Node<E> actual = fantasma.seguent;
        int numElem= numElements();
        Object[] dades = new Object[numElem];

        for(int i=0; actual!=null; i++) {
            dades[i]=actual.dada;
            actual=actual.seguent;
        }
        return dades;
    }

}
