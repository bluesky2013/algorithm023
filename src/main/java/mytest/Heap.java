package my_test;

/**
 * Created by fuwenchao on 2021/2/22.
 */
public class Heap {

    private int[] arr;
    private int capacity;
    private int count;
    public Heap(int capacity){
        this.capacity = capacity;
        //用数组存储表示完全二叉树时，也可以从下标为0开始，只是这样做的话，计算左子节点时，会多一次加法运算
        //这里使用从1开始存储数据
        arr = new int[this.capacity+1];
        this.capacity = capacity;
        count  = 0;
    }
    public void insert(int num){
        ++count;
        arr[count] = num;
        int i = count;
        while(i/2>0 && arr[i/2]< arr[i]){
            swap(i/2, i );
        }
    }

    private void swap(int pos1, int pos2 ){
        int tmp  = this.arr[pos1];
        this.arr[pos1] = this.arr[pos2];
        this.arr[pos2] = tmp;
    }

    public void removeMax(){
        arr[1] = arr[count];
        count--;
        int i = 1;
        while(true){
            int maxPos = i;
            if(2*i<=capacity && arr[2*i]>arr[i]){
                maxPos = 2*i;
            }
            if((2*i+1)<=capacity && arr[maxPos]<arr[2*i+1]){
                maxPos = 2*i+1;
            }
            if (maxPos == i){
                break;
            }
            swap(maxPos, i);
            i = maxPos;
        }

    }

    public void heapify(int arr[], int endPos, int i){

        while(true){
            int maxPos = i;
            if(2*i<=endPos && arr[2*i]>arr[maxPos]){
                maxPos = 2*i;
            }
            if((2*i+1)<=endPos && arr[2*i+1]>arr[maxPos]){
                maxPos = 2*i+1;
            }
            if(maxPos == i){
                break;
            }
            i = maxPos;
        }

    }

    public void buildHeap(int[] arr){
        int n  = arr.length-1;
        for(int i = n/2; i>=1; i-- ){
            heapify(arr, n, i);
        }
    }
}
