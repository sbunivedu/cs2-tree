package tree;

public class BinaryTree{
  private Object element;
  protected BinaryTree left, right;

  public BinaryTree(Object element, BinaryTree left, BinaryTree right){
    this.element = element;
    this.left = left;
    this.right = right;
  }

  public Object getElement(){
    return element;
  }

  public BinaryTree getLeft(){
    return left;
  }

  public BinaryTree getRight(){
    return right;
  }

  public void setElement(Object element){
    this.element = element;
  }

  public void setLeft(BinaryTree node){
    left = node;
  }

  public void setRight(BinaryTree node){
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
}