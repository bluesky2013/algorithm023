package mytest;

/**
 * Created by fuwenchao on 2021/2/22.
 */
public class HeapMy {

    private int[] heap;
    private int capacity;
    private int size;
    public void insert(int num){
        heap[size++] = num;
    }

    private void heapify(){
        int child = size--;
        int parent = child/2;
        while(heap[parent]<heap[child] && parent>0){
            int  tmp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = tmp;
            child = parent;
            parent = child/2;

        }
    }

}
