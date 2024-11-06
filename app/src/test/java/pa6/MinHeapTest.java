
package pa6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {
    
        @Test
        void testInsert() {
            MinHeap heap = new MinHeap(5);
            heap.insert(5);
            heap.insert(3);
            heap.insert(8);
            heap.insert(1);
            heap.insert(2);
            
            assertEquals(1, heap.peek()); 
        }
    
        @Test
        void testDelete() {
            MinHeap heap = new MinHeap(5);
            heap.insert(5);
            heap.insert(3);
            heap.insert(8);
            heap.insert(1);
            
            assertEquals(1, heap.delete());
            assertEquals(3, heap.peek());   
        }
    
        @Test
        void testPeek() {
            MinHeap heap = new MinHeap(5);
            heap.insert(5);
            heap.insert(3);
            heap.insert(8);
            
            assertEquals(3, heap.peek());
        }
    
        @Test
        void testIsEmpty() {
            MinHeap heap = new MinHeap(5);
            assertTrue(heap.isEmpty()); 
            
            heap.insert(5);
            assertFalse(heap.isEmpty()); 
        }
    
        @Test
        void testHeapSort() {
            int[] array = {3, 1, 4, 1, 5, 9, 2, 6};
            int[] sortedArray = MinHeap.heapSort(array);
            int[] expectedArray = {1, 1, 2, 3, 4, 5, 6, 9};
            assertArrayEquals(expectedArray, sortedArray); 
        }
        
        @Test
        void testHeapCapacityIncrease() {
            MinHeap heap = new MinHeap(2);
            heap.insert(5);
            heap.insert(3);
            heap.insert(8); // This should increase the capacity of the heap
            
            assertEquals(3, heap.peek()); // After inserting more than initial capacity, the min should still be correct
        }
    
        @Test
        void testDeleteFromEmptyHeap() {
            MaxHeap heap = new MaxHeap();
            int result = heap.delete();
            assertEquals(-1, result);
        }
        @Test
            void testPeekFromEmptyHeap(){
                MaxHeap heap = new MaxHeap();
                int result = heap.peek();
                assertEquals(-1, result);
            }
    }
    
    
    
    
    