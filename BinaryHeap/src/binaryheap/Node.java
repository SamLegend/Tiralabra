/*
 * This is a simple Node object
 */
package binaryheap;

/**
 *
 * @author sam
 */
public class Node {
    
    public Node parent;
    public Node leftChild;
    public Node rightChild;
    
    public int payload;
    
    public Node (int pay,Node p, Node l, Node r){
        
        parent = p;
        leftChild = l;
        rightChild = r;
        payload = pay;
        
    }
    
}
