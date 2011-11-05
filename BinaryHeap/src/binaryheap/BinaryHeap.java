/*
 * Useless file created by NetBeans.
 * 
 */
package binaryheap;

/**
 *
 * @author sam
 */
public class BinaryHeap {

    public static void main(String[] args) {
        
        System.out.println("Why not binary heap?");
        Heap keko = new Heap();
        keko.delete();
        for (int i = 0; i <= 5;i++){
        keko.insert(i);
        }
       for (int y=0;y <= 7;y++){   
       System.out.println(keko.delete());
       }
    }
}
