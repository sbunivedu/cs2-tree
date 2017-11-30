package tree;

public class BinaryTreeNode<T>{
  protected T element;
  protected BinaryTreeNode<T> left, right;

  public BinaryTreeNode(T element){
    this.element = element;
    left = null;
    right = null;
  }

  public T getElement(){
    return element;
  }

  public BinaryTreeNode<T> getLeft(){
    return left;
  }

  public BinaryTreeNode<T> getRight(){
    return right;
  }

  public void setLeft(BinaryTreeNode<T> node){
    left = node;
  }

  public void setRight(BinaryTreeNode<T> node){
    right = node;
  }

  public String toString(){
    return element.toString();
  }

  // return inorder traversal
  public String inorder(){
    String result = "";
    if(left != null){
      result += left.inorder();
    }
    result += this;
    if(right != null){
      result += right.inorder();
    }
    return result;
  }

  public String preorder(){
    String result = "";
    result += this;
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
    result += this;
    return result;
  }

  public void print(){
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