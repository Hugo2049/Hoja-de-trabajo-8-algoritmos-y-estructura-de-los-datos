package org.example;

import java.util.Vector;

/**
 * Una implementación de montículo binario utilizando un Vector como base de datos.
 * @param <E> El tipo de elementos que se almacenarán en el montículo, deben ser comparables.
 */
public class VectorHeap<E extends Comparable<E>> {
    protected Vector<E> data; // Vector que almacena los elementos del montículo

    /**
     * Constructor que crea un VectorHeap vacío.
     */
    public VectorHeap() {
        data = new Vector<>();
    }

    /**
     * Constructor que crea un VectorHeap a partir de un vector dado.
     * @param v El vector que contiene los elementos a añadir al montículo.
     */
    public VectorHeap(Vector<E> v) {
        int i;
        data = new Vector<>(v.size());
        for (i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    /**
     * Obtiene el índice del padre de un nodo en el montículo.
     * @param i El índice del nodo.
     * @return El índice del padre del nodo.
     */
    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Obtiene el índice del hijo izquierdo de un nodo en el montículo.
     * @param i El índice del nodo.
     * @return El índice del hijo izquierdo del nodo.
     */
    protected static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Obtiene el índice del hijo derecho de un nodo en el montículo.
     * @param i El índice del nodo.
     * @return El índice del hijo derecho del nodo.
     */
    protected static int right(int i) {
        return (2 * i + 1) + 1;
    }

    /**
     * Realiza el proceso de flotación hacia arriba para mantener la propiedad de montículo.
     * @param leaf El índice del nodo a flotar hacia arriba.
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Añade un nuevo elemento al montículo.
     * @param value El elemento a añadir.
     */
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Realiza el proceso de hundimiento hacia abajo a partir de la raíz para mantener la propiedad de montículo.
     * @param root El índice del nodo raíz.
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Elimina y devuelve el elemento mínimo del montículo.
     * @return El elemento mínimo del montículo, o null si el montículo está vacío.
     */
    public E remove() {
        if (data.size() == 0) return null;
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }
}
