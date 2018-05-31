package aed.compress;

import es.upm.aedlib.Position;
import es.upm.aedlib.Entry;
import es.upm.aedlib.tree.*;
import es.upm.aedlib.priorityqueue.*;

public class Huffman {
	private BinaryTree<Character> huffmanTree;

	public Huffman(String text) {
		this.huffmanTree = constructHuffmanTree(text);
	}

	private BinaryTree<Character> constructHuffmanTree(String text) {
		PriorityQueue<Integer, BinaryTree<Character>> Q;
		Q = new SortedListPriorityQueue<Integer,BinaryTree<Character>>();
		BinaryTree<Character> u;
		for (int c = 0; c < countChars(text).length; c++) {
			if (countChars(text)[c] > 0) {
				u = new AttachableLinkedBinaryTree<Character>();
				u.addRoot((char) c);
				Q.enqueue(countChars(text)[c], u);
			}
		}
		while (Q.size() > 1) {
			Entry<Integer, BinaryTree<Character>> left = Q.dequeue();
			Entry<Integer, BinaryTree<Character>> right = Q.dequeue();
			AttachableLinkedBinaryTree<Character> t;
			t = new AttachableLinkedBinaryTree<Character>();
			t.addRoot(' ');
			t.attach(t.root(), left.getValue(), right.getValue());
			Q.enqueue(left.getKey() + right.getKey(), t);
		}
		return Q.first().getValue();
	}

	public static int[] countChars(String text) {
		// CAMBIA este metodo
		int[] solucion = new int[256];
		for (int i = 0; i < 256; i++) {
			solucion[i] = 0;
		}
		for (int j = 0; j < text.length(); j++) {
			solucion[text.codePointAt(j)] = auxCountChars(text, text.charAt(j));
		}
		return solucion;
	}

	public static int auxCountChars(String text, char y) {

		int cont = 0;
		for (int i = 0; i < text.length(); i++) {
			if (y == text.charAt(i))
				cont++;
		}
		return cont;
	}
}



