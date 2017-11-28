package tree;

public class BinaryTree<T>{
  protected T element;
  protected BinaryTree<T> left, right;

  public BinaryTree(T element, BinaryTree<T> left, BinaryTree<T> right){
    this.element = element;
    this.left = left;
    this.right = right;
  }

  public T getElement(){
    return element;
  }

  public BinaryTree<T> getLeft(){
    return left;
  }

  public BinaryTree<T> getRight(){
    return right;
  }

  public void setElement(T element){
    this.element = element;
  }

  public void setLeft(BinaryTree<T> node){
    left = node;
  }

  public void setRight(BinaryTree<T> node){
    right = node;
  }

  public String toString(){
    return element.toString();
  }

  public String inorder(){
    String result = "";
    if(left != null){
      result += left.inorder();
    }
    result += this.toString();
    if(right != null){
      result += right.inorder();
    }
    return result;
  }

  public String preorder(){
    String result = "";
    result += this.toString();
    if(left != null){
      result += left.preorder();
    }
    if(right != null){
      result += right.preorder();
    }
    return result;
  }

  public String postorder(){
    String result = "";
    if(left != null){
      result += left.postorder();
    }
    if(right != null){
      result += right.postorder();
    }
    result += this.toString();
    return result;
  }

  public void printTree(){
    if (right != null){
      right.recPrint(true, "");
    }
    System.out.println(this);
    if (left != null){
      left.recPrint(false, "");
    }
  }

  private void recPrint(boolean isRight, String indent) {
    if (right != null){
      right.recPrint(true, indent + (isRight ? "        " : " |      "));
    }
    System.out.print(indent);
    if (isRight) {
      System.out.print(" /");
    } else {
      System.out.print(" \\");
    }
    System.out.println("----- "+this);
    if (left != null) {
      left.recPrint(false, indent + (isRight ? " |      " : "        "));
    }
  }
}