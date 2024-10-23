package pa6;

public class MaxHeap implements Heap {
    private int data[];
    private int maxCapacity = 10;
    private int size = 0;

    public MaxHeap() {
        this.data = new int[maxCapacity];
    }
    public MaxHeap(int capacity){
        this.maxCapacity = capacity;
        this.data = new int[maxCapacity];
    }

    public void insert(int value) {
        ensureCapacity(); // Ensure there is enough capacity to add a new element
        this.data[size] = value;
        this.size++;
        BubbleUpHelper(this.size - 1); // Bubble up the new element
    }

    private void ensureCapacity() {
        if (this.size == this.maxCapacity) {
            this.maxCapacity *= 2; // Double the capacity
            int[] newData = new int[this.maxCapacity];
            for (int i = 0; i < this.size; i++) {
                newData[i] = this.data[i];
            }            
            this.data = newData;
        }
    }

    public void swap(int i, int j) {
        int temp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = temp;
    }

    public void BubbleUpHelper(int i) {
        if (i == 0) {
            return; // Reached the root
        }

        int parentIndex = (i - 1) / 2;
        if (this.data[i] > this.data[parentIndex]) {
            swap(i, parentIndex);
            BubbleUpHelper(parentIndex);
        }
    }

    public int delete() {
        if (isEmpty())
            return -1;
        

        int max = data[0];
        data[0] = data[size - 1];
        size--;
        BubbleDownHelper(0);
        return max;
    }

    public void BubbleDownHelper(int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < this.size && this.data[leftChild] > this.data[largest])
            largest = leftChild;

        if (rightChild < this.size && this.data[rightChild] > this.data[largest])
            largest = rightChild;

        if (largest != index) {
            swap(index, largest);
            BubbleDownHelper(largest);
        }
    }

    public int peek() {
        if (isEmpty()) 
            return -1;

        return this.data[0];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    static int[] heapSort(int[] array) {
        MaxHeap maxHeap = new MaxHeap(array.length);
        
        // Build the heap from the input array
        maxHeap.buildHeap(array);
    
        int[] sortedArray = new int[array.length];
        // Extract elements from the heap
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = maxHeap.delete();
        }
        return sortedArray;
    }
    

    public void buildHeap(int[] array) {
        this.data = new int[array.length];
        this.size = array.length;
        this.maxCapacity = array.length;
        for (int i = 0; i < array.length; i++) {
            this.data[i] = array[i];
        }
        
        for (int i = (this.size / 2) - 1; i >= 0; i--) {
            BubbleDownHelper(i);
        }
    }
}
