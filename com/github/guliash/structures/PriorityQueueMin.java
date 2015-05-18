package com.github.guliash.structures;

import com.github.guliash.interfaces.ID;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by gulash on 17.05.15.
 */
public class PriorityQueueMin<T extends ID> {

    private ArrayList<T> heap = new ArrayList<>();
    private int size = 0;
    private Comparator<T> cmp;
    private int[] index2heapPos;

    public PriorityQueueMin(int maxNumber, Comparator<T> cmp) {
        index2heapPos = new int[maxNumber];
        this.cmp = cmp;
    }

    public PriorityQueueMin(T[] a, int maxNumber, Comparator<T> cmp) {
        this(maxNumber, cmp);
        for(int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    private void heapifyDown(int pos) {
        int smallest = pos;
        if(2 * pos + 1 < size) {
            if(cmp.compare(heap.get(pos), heap.get(2 * pos + 1)) > 0) {
                smallest = 2 * pos + 1;
            }
        }
        if(2 * pos + 2 < size) {
            if(cmp.compare(heap.get(smallest), heap.get(2 * pos + 2)) > 0) {
                smallest = 2 * pos + 2;
            }
        }
        if(smallest != pos) {
            swap(pos, smallest);
            heapifyDown(smallest);
        }
    }

    private void heapifyUp(int pos) {
        int parent = (pos - 1) / 2;
        while(pos != 0 && cmp.compare(heap.get(parent), heap.get(pos)) > 0) {
            swap(parent, pos);
            pos = parent;
            parent = (pos - 1) / 2;
        }
    }

    public void increaseKey(T obj) {
        heapifyDown(index2heapPos[obj.getID()]);
    }

    public void decreaseKey(T obj) {
        heapifyUp(index2heapPos[obj.getID()]);
    }

    public void insert(T obj) {
        if(heap.size() == size) {
            heap.add(obj);
        } else {
            heap.set(size, obj);
        }
        index2heapPos[obj.getID()] = size;
        heapifyUp(size++);
    }

    public void delete(T obj) {
        delete(index2heapPos[obj.getID()]);
    }

    public void delete(int pos) {
        swap(pos, --size);
        heapifyDown(pos);
    }

    public T min() {
        if(size != 0) {
            return heap.get(0);
        }
        return null;
    }

    public T extractMin() {
        if(size == 0) {
            return null;
        }
        T obj = heap.get(0);
        delete(0);
        return obj;
    }

    public int size() {
        return size;
    }

    private void swap(int a, int b) {
        T obj1 = heap.get(a);
        T obj2 = heap.get(b);
        index2heapPos[obj1.getID()] = b;
        index2heapPos[obj2.getID()] = a;
        heap.set(a, obj2);
        heap.set(b, obj1);
    }
}
