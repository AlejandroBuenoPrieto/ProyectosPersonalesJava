package aed.compress;

import es.upm.aedlib.Position;
import es.upm.aedlib.tree.*;


public class AttachableLinkedBinaryTree<E> extends LinkedBinaryTree<E> implements AttachableBinaryTree<E> {

  public void attach(Position<E> pos, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
    // CAMBIA este metodo
	  Position<E> copia = pos;
	  pos = this.insertLeft(pos, leftTree.root().element());
	  auxAttach(pos,leftTree,leftTree.root());
	  pos=copia;
	  pos=this.insertRight(pos, rightTree.root().element());
	  auxAttach(pos,rightTree,rightTree.root());
  }
  public void auxAttach(Position<E> pos,BinaryTree<E> y,Position<E> a){
	  
  if(y.hasLeft(a)){
	  this.insertLeft(pos, y.left(a).element());
	  auxAttach(this.left(pos),y,y.left(a));
  }
  if(y.hasRight(a)){
	  this.insertRight(pos, y.right(a).element());
	  auxAttach(this.right(pos),y,y.right(a));
  }
  }
}
