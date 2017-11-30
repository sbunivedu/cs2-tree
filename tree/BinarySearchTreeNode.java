package tree;

public class BinarySearchTreeNode<T> extends BinaryTreeNode<T>{
  public BinarySearchTreeNode(T element){
    super(element);
  }

  public BinarySearchTreeNode<T> getLeft(){
    return (BinarySearchTreeNode<T>) left;
  }

  public BinarySearchTreeNode<T> getRight(){
    return (BinarySearchTreeNode<T>) right;
  }

  public void setLeft(BinarySearchTreeNode<T> node){
    left = node;
  }

  public void setRight(BinarySearchTreeNode<T> node){
    right = node;
  }

  public void insert(T element){
    BinarySearchTreeNode<T> node = new BinarySearchTreeNode<T>(element);
    Comparable<T> newElement = (Comparable<T>) element;
    if(newElement.compareTo(this.element) == 0) {
      // replace current node
      this.element = element;
    }
    else if(newElement.compareTo(this.element) < 0){
      // insert in left
      if (left == null){
        setLeft(node);
      }else {
        getLeft().insert(element);
      }
    }else{
      // insert in right
      if (right == null){
        setRight(node);
      }else {
        getRight().insert(element);
      }
    }
  }

  public T search(T element){
    Comparable target = (Comparable) element;
    if(target.compareTo(this.element) == 0){
      return element;
    }else if(target.compareTo(this.element) < 0){
      // search in left
      if(left == null){
        return null;
      }else{
        return getLeft().search(element);
      }
    }else{
      // search in right
      if(right == null){
        return null;
      }else{
        return getRight().search(element);
      }
    }
  }

  // return the updated node, which can be null.
  public BinarySearchTreeNode<T> delete(T element){
    Comparable target = (Comparable) element;
    if(target.compareTo(this.element) == 0){
      if(left == null && right == null){
        return null;
      }else if(right != null){
        // promote right child, graft left to be
        // the left most descendent of right
        BinarySearchTreeNode<T> current = getRight();
        while(current.left != null){
          current = current.getLeft();
        }
        current.left = left;
        return getRight();
      }
    }else if(target.compareTo(this.element) < 0){
      left = getLeft().delete(element);
    }else{
      right = getRight().delete(element);
    }
    return this;
  }
}