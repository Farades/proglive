package ru.mtplab;

/**
 * Created by tess on 14.01.2015.
 */
public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer, String> pq = new PriorityQueue<Integer, String>();
        System.out.println("Create size: " + pq.queueSize());
        pq.insert(32, "Value 32-1");
        pq.insert(19, "Value 19-1");
        pq.insert(22, "Value 22-1");
        pq.insert(1,  "Value  1-1");
        pq.insert(5,  "Value  5-1");
        pq.insert(19, "Value 19-2");
        pq.insert(83, "Value 83-1");
        System.out.println("After size: " + pq.queueSize());
        System.out.println(pq);
        System.out.println(pq.getMax());
        System.out.println(pq.getMax());
        System.out.println(pq.getMax());
        System.out.println(pq.getMax());
        System.out.println(pq.getMax());
        System.out.println(pq.getMax());
        System.out.println(pq.getMax());
    }
}
