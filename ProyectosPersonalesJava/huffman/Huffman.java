package aed.huffman;

import es.upm.aedlib.Position;
import es.upm.aedlib.tree.*;
/**
 * Defines metodos for Huffman encoding of text strings.
 */
public class Huffman {
    private LinkedBinaryTree<Character> huffmanTree;
    
    public Huffman(LinkedBinaryTree<Character> huffmanTree) {
      // NO CAMBIA ESTE METODO!!! Esta usado durante las pruebas
      this.huffmanTree = huffmanTree;
    }

    /**
     * Creates a Huffman tree (and stores it in the attribute huffmanTree).
     * The shape of the (binary) tree is
     * defined by the array of char-codes.
     */
    public Huffman(CharCode[] paths) {
	this.huffmanTree = new LinkedBinaryTree<Character>();
	// CAMBIA
	huffmanTree.addRoot('|');
	Position <Character> iz = huffmanTree.root();
	for(int i=0;i<paths.length;i++){
		String aux= paths[i].getCode();
        char [] a = aux.toCharArray();
		for(int j=0;j<aux.length();j++){
			if(a[j]=='0'){
				if(this.huffmanTree.hasLeft(iz)){
					iz = this.huffmanTree.left(iz);
				}
				else
				iz = huffmanTree.insertLeft(iz,'.');
			}
			if(a[j]=='1'){
				if(this.huffmanTree.hasRight(iz)){
					iz = this.huffmanTree.right(iz);
				}
				else{
					iz= huffmanTree.insertRight(iz,'.');
				}
				
			}
		}
		if(a[aux.length()-1]=='1') 
			huffmanTree.set(iz, paths[i].getCh());
		else
			huffmanTree.set(iz, paths[i].getCh());
		
	 iz = huffmanTree.root();
	}
	}
    

    //////////////////////////////////////////////////////////////////////


    /**
     * Huffman encodes a text, returning a new text string
     * containing only characters '0' and '1'.
     */
    
    public String encode(String text) {
	// CAMBIA
	// llama el metodo findCharacterCode
    	Position<Character> pos = this.huffmanTree.root();
		String path = "";
		String sol = "";
		for (int i = 0; i < text.length(); i++) {
			Character let = text.charAt(i);
			sol += findCharacterCode(let,this.huffmanTree,pos,path);
		}
		return sol;
    }

    // CAMBIA e UTILIZA si quiereis
    private String findCharacterCode(Character ch, 
			     BinaryTree<Character> tree,
			     Position<Character> pos,
			     String path) {
    	
	// Return null if character not found, and otherwise the
	// string of "0" and "1" that lead to the node with the characters
    	String sol = null;
		boolean si = false;
		// Return null if character not found, and otherwise the
		// string of "0" and "1" that lead to the node with the character

		if (pos.element() == ch) return path;
		if(tree.hasLeft(pos)){
			Position <Character> left = tree.left(pos);
			sol = findCharacterCode(ch,tree,left, path + "0");
			if(sol == null){
				si = true;
			}
		}
		if(tree.hasLeft(pos) && si){
			Position <Character> right = tree.right(pos);
			sol = findCharacterCode(ch,tree,right, path + "1");
		}

		return sol; 		  
    }


    //////////////////////////////////////////////////////////////////////

    /**
     * Given the Huffman encoded text argument (a string of only
     * '0' and '1's), returns the corresponding normal text.
     */
    public String decode(String encodedText) {
	// CAMBIA
    	int i=0;
    	String solucion="";
    	Position<Character> cursor = this.huffmanTree.root();
    	while(i<encodedText.length()){
    		if(encodedText.charAt(i)=='1'){
    			cursor= this.huffmanTree.right(cursor);
    		}
    		if(encodedText.charAt(i)=='0'){
    			cursor=this.huffmanTree.left(cursor);
    		}
    		if(!cursor.element().equals('.') && !cursor.element().equals(' ')){
    			solucion=solucion.concat(cursor.element().toString());
    			cursor=this.huffmanTree.root();
    		}
    		i++;
    	}
    	return solucion;
    }
}


