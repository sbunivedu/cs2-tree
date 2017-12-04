package tests;

import tree.Heap;

public class HeapTest
{
  public static void main(String [] args)
  {
    Heap h = new Heap();
    h.insert("A");
    h.insert("B");
    h.insert("C");
    h.insert("D");
    h.insert("E");
    h.insert("F");
    h.insert("G");

    System.out.println("Here is the heap: "+ h);

    while (!h.isEmpty()){
      h.remove();
      System.out.println("Here is the heap: "+ h);
    }
  }
}
