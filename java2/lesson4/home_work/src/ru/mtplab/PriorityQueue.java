package ru.mtplab;

import java.util.ArrayList;
import java.util.List;

/**
 * Очередь с приоритетами на основании бинарной кучи.
 * Бинарную кучу удобно хранить в виде одномерного массива или списка.
 */
public class PriorityQueue<K extends Comparable<K>, T> {
    // Список в котором хранятся все вершины бинарной кучи.
    private List<Vertex<K, T>> data = new ArrayList<Vertex<K, T>>();


    public void insert(K priority, T value) {
        Vertex<K, T> vertex = new Vertex<K, T>(priority, value);
        data.add(vertex);

        int i = this.queueSize() - 1;
        int parent = (i - 1) / 2;

        while ( i > 0 && (this.data.get(parent).compareTo(this.data.get(i)) < 0) ) {
            Vertex<K, T> temp = this.data.get(i);
            this.data.set(i, this.data.get(parent));
            this.data.set(parent, temp);

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public T getMax() {
        Vertex<K, T> res = this.data.get(0);
        this.data.set(0, this.data.get(this.queueSize() - 1));
        this.data.remove(this.queueSize() - 1);
        heapify(0);
        heapify(0);
        return res.getValue();
    }

    public int queueSize() {
        return data.size();
    }

    public void heapify(int i) {
        int leftChild;
        int rightChild;
        int largestChild;

        while (true) {
            leftChild  = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            // Левый потомок больше родителя?
            if ( leftChild < this.queueSize() && (this.data.get(leftChild).compareTo(this.data.get(largestChild)) > 0) ) {
                largestChild = leftChild;
            }

            // Правый потомок больше родителя?
            if ( rightChild < this.queueSize() && (this.data.get(rightChild).compareTo(this.data.get(largestChild)) > 0) ) {
                largestChild = rightChild;
            }

            if (largestChild == i) {
                break;
            }

            Vertex<K, T> temp =this.data.get(i);
            this.data.set(i, this.data.get(largestChild));
            this.data.set(largestChild, temp);
            i = largestChild;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Vertex<K, T> vertex : this.data) {
            res.append("[" + vertex.getPriority() + "] => " + vertex.getValue() + "\n");
        }
        return res.toString();
    }

    // Вершина бинарной кучи
    private class Vertex<V extends Comparable<V>, E> implements Comparable {
        private V priority;
        private E value;

        public Vertex(V priority, E value) {
            this.priority = priority;
            this.value = value;
        }

        public V getPriority() {
            return priority;
        }

        public E getValue() {
            return value;
        }

        @Override
        public int compareTo(Object o) {
            Vertex vertex = (Vertex)o;
            return this.priority.compareTo((V)vertex.getPriority());
        }
    }
}
