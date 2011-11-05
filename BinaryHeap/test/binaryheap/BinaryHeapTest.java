package binaryheap;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author sam
 */
public class BinaryHeapTest {

    /**
     * Just a couple of tests.
     */
    @Test
    public void testMain() {
        System.out.println("Basic insert");

        Heap keko = new Heap();
        for (int i = 0; i <= 500;i++){
        keko.insert(i);
        }
        for (int y=0;y <= 500;y++){   
         assertEquals(500-y,keko.delete());
         }
        Random rgen = new Random(); 
        int[] testi = new int[501];
        
        for (int i=0; i<testi.length; i++) {
         testi[i] = i;
        }
        for (int i=0; i<testi.length; i++) {
           int randomPosition = rgen.nextInt(testi.length);
           int temp = testi[i];
           testi[i] = testi[randomPosition];
           testi[randomPosition] = temp;
        }
        
        Heap keko2 = new Heap();
        System.out.println("Randomized insert");
       
        for (int i = 0;i<testi.length;i++){
        keko2.insert(testi[i]);
        }
        for (int y=0;y <= 500;y++){   
        assertEquals(500-y,keko2.delete());
        }    
        
        Heap keko3 = new Heap();
        System.out.println("Deleting from empty");
        assertEquals(-1,keko3.delete());
        
        Heap keko4 = new Heap();
        System.out.println("Insert 1, delete 1 and check if empty");
        keko4.insert(1);
        keko4.delete();
        assertEquals(-1,keko4.delete());
        
        
    }
}
