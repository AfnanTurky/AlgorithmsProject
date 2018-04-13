/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;



/**
 *
 * @author Afnan AlOtaibi
 */
public class MinPriorityQueue {

    private vertex[] array;
    private int heapSize;

    public MinPriorityQueue(vertex[] array) {
        this.array = array;
        this.heapSize = this.array.length;
        buildMinHeap();
    }

    public vertex extractMin() {
        vertex temp = array[0];
        swap(0, heapSize - 1, array);
        heapSize--;
        sink(0);
        return temp;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void buildMinHeap() {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            sink(i);
        }
    }

    public void decreaseKey( vertex key) {
        int i=findIndex(key);
        int  p;
        while(i>0){
            p=parentIndex(i);
            if(array[i].compareTo(array[p])>=0)
                break;
            
            swap(i,p,array);
            i=p;
        }
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private void sink(int index) {
        int smallestIndex = index;
        int left = left(index);
        int right = right(index);
        if (left < heapSize && array[left].compareTo(array[smallestIndex]) < 0) {
            smallestIndex = left;
        }
        if (right < heapSize && array[right].compareTo(array[smallestIndex]) < 0) {
            smallestIndex = right;
        }
        if (index != smallestIndex) {
            swap(smallestIndex, index, array);
            sink(smallestIndex);
        }
    }

    public vertex min() {
        return array[0];
    }

    private void swap(int i, int j, vertex[] array) {
        vertex temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int findIndex(vertex key) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]==key)
                return i;
        }
    
    return -1;
    }

   

}
