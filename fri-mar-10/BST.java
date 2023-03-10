public class BST extends Node {

  public BST(int num) {
    super(num); 
  }

  public int largestValue() {
    if (this.right == null) return this.key;
    else return ((BST)this.right).largestValue();
  } 

  public BST remove(int value) {
    if (this.key == value) 
      if (this.left == null)       return (BST)this.right;
      else if (this.right == null) return (BST)this.left;
      else if (this.left == null)  return (BST)this.right;
      else {
        int num = ((BST)this.left).largestValue(); 
        this.key = num; 
        this.left = ((BST)this.left).remove(num);      
      }
    else if (this.key < value) this.right = ((BST)this.right).remove(value);   
    else                       this.left  =  ((BST)this.left).remove(value);
    return this;    
  }

  public void insert(int num) {
    if (num == this.key) return; 
    else { 
      if (num < this.key) {
        if (this.left == null) this.left = new BST(num); 
        ((BST)this.left).insert(num); 
      } else {
        if (this.right == null) this.right = new BST(num); 
        ((BST)this.right).insert(num); 
      }
    } 
  } 

  public boolean find(int what) {
    if (what == this.key) return true; 
    else if (what < this.key) {
      if (this.left == null) return false; 
      else return ((BST)this.left).find(what);
    } else { 
      if (this.right == null) return false; 
      else return ((BST)this.right).find(what);
    }
  } 

  public static void main(String[] args) {
    BST a = null;
    for (String arg : args) {
      System.out.println( "Inserting: " + arg ); 
      int num = Integer.parseInt( arg );
      if (a == null) { 
        a = new BST(num); 
      } else {
        a.insert(num); 
      }
      a.display();
    }
    int what = 7;
    System.out.println("Is " + what + " in the tree? Answer: " + a.find(what)); 
    for (int i = 0; i < 3; i++) {
      int num = a.key; 
      System.out.println("Removing " + num); 
      a = a.remove(num); 
      a.display();
    }

  } 
}
