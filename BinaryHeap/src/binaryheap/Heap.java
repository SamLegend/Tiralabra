package binaryheap;
import java.util.*;

/**
 *
 * @author sam
 */
public class Heap {
    /*Create basic nodes*/
    private Node root;
    private Node last;
    private int nodes=0;
    /*
     *  Inserts a node to the heap. 
     */
    public void insert(int payload){
        if (nodes != 0){
            last=root;
            
            nodes++; //update node count
            
            Node iNode = new Node(payload,null,null,null);
            /*Get route to insertion point*/
            Stack path = findPlace(nodes);
            
            /*Go to the insertion place*/
            while(path.size()>1){
                int turn = ((Integer)path.pop()).intValue();
                if ( turn == 0){
                     last = last.leftChild;
                  } else {
                     last = last.rightChild;
                  }

             }
            int goal = ((Integer) path.pop()).intValue();
            if (goal == 0){
                  iNode.parent =last;
                  last.leftChild = iNode;
            }else {
                  iNode.parent=last;
                  last.rightChild = iNode;
            }
            last = iNode;
            
            /*upheap*/
            while (last.parent != null){
                if (last.payload > last.parent.payload){
                   int temp = last.payload;
                   last.payload = last.parent.payload;
                   last.parent.payload = temp;
                   last = last.parent;
                } else {break;}
            }

        }else{
          root = new Node(payload,null,null,null);
          nodes++; 
        }
        
    }

/*
 * Deletes and returns the item from top of the heap.    
 * If heap is empty, returs -1
 */    
public int delete(){
    
    /*Handle special cases*/
    if(nodes == 0){
        return -1;
    }
    if(nodes ==1){
        nodes--;
        return root.payload;
    }
    
    last=root;
    Node del = last;
    int top = last.payload;
    
    /*fetch the last element*/
    Stack vika = findPlace(nodes);
    
    /*actually find it*/
    while(vika.size()>1){
                int fin = ((Integer) vika.pop()).intValue();
                if ( fin == 0){
                  last = last.leftChild;              
                } else {
                  last = last.rightChild;
                }
          }
    int goal = ((Integer)vika.pop()).intValue();
            if (goal == 0){
                del = last;
                last = last.leftChild;
                del.leftChild = null;
            }else {
                del = last;
                last = last.rightChild;
                del.rightChild = null;
            }
    
    /*the swap*/
    root.payload = last.payload;

    /*'kill' the node*/
    nodes--;
    
    last=root;
    
    /*heapify*/
    while(last.leftChild != null){
        int largest = last.payload;
        int nyan = largest;
        del = last;
        if((last.leftChild==null)&&(last.rightChild)==null){break;}

        if(largest < last.leftChild.payload){
               largest = last.leftChild.payload;
               del = last.leftChild;
        }
        
        if((last.rightChild != null)&&(largest < last.rightChild.payload)){
               largest = last.rightChild.payload;
               del = last.rightChild;
        }
        
        if(nyan != del.payload){
        
           int temp = last.payload;
           last.payload = del.payload;
           del.payload = temp;
        
        }else {break;}
        last = del;
    }
    return top;
    
}
/*
 * Helper funtion for mapping route to node
 * using neat tree properties.
 */
    private Stack findPlace(int node){
        /* log n*/
        Stack pino = new Stack();
        int cn = node;
        while (cn > 1){
            if (cn%2 == 0){
                pino.push(new Integer(0)); //left
            }else {
                pino.push(new Integer(1)); //right
            }
            cn = (int)cn/2;
        }
        
        return pino;
    }
    
    /*
     * Inefficiently prints the tree, for debugging
     */
    public void printTree(){
        last=root; 
        for(int i=1; i <= nodes; i++){
          Stack find = findPlace(i);
        
          while(!find.empty()){
                int fail = ((Integer) find.pop()).intValue();
                if ( fail == 0){
                  last = last.leftChild;
                } else {
                  last = last.rightChild;
                }
          }
          System.out.print(last.payload +",");
          last=root;
        }
        System.out.println("");
    }
    
}
