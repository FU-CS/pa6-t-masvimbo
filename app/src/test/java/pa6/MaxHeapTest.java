
package pa6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {

        @Test
        void testInsert() {
            MaxHeap heap = new MaxHeap(5);
            heap.insert(5);
            heap.insert(3);
            heap.insert(8);
            heap.insert(1);
            heap.insert(2);
            assertEquals(8, heap.peek());
    }

        @Test
        void testDelete() {
            MaxHeap heap = new MaxHeap(5);
            heap.insert(5);
            heap.insert(3);
            heap.insert(8);
            assertEquals(8, heap.delete());
            assertEquals(5, heap.peek());
        }
    
        @Test
        void testPeek() {
            MaxHeap heap = new MaxHeap();
            heap.insert(10);
            heap.insert(20);
            heap.insert(15);
            assertEquals(20, heap.peek());
        }
    
        @Test
        void testIsEmpty() {
            MaxHeap heap = new MaxHeap();
            assertTrue(heap.isEmpty());
            heap.insert(10);
            assertFalse(heap.isEmpty());
        }
    
        @Test
        void testSize() {
            MaxHeap heap = new MaxHeap(5);
            assertEquals(0, heap.size());
            heap.insert(5);
            heap.insert(10);
            assertEquals(2, heap.size());
        }
    
        @Test
        void testHeapSort() {
            int[] array = {3, 1, 4, 1, 5, 9, 2, 6};
            int[] sortedArray = MaxHeap.heapSort(array);
            int[] expectedArray = {9, 6, 5, 4, 3, 2, 1, 1};
            assertArrayEquals(expectedArray, sortedArray);
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
    

