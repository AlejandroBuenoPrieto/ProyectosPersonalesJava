package aed.ejercicios.arrays;

import java.util.Iterator;

import es.upm.aedlib.indexedlist.IndexedList;

public class ArrayIndexedList<E> implements IndexedList<E> {
	private E[] A;
	private int capacity = 6 ;
	private int size ;
	protected void checkIndex(int i, int n)
			throws IndexOutOfBoundsException {
			if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i) ;
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size + 1) ;
		for(int j=size-1;j>=i;j--){
		   A[j]=A[j-1];
		}
		A[i]= e;
		size ++;
	}

	@Override
	public E get(int arg0) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E removeElementAt(int r) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkIndex(r, size());
		E temp = A[r];
		for(int i=r;i<size-1;i++){
			A[i]=A[i+1];
		}
		size--;
		
		return temp;

	}

	@Override
	public E set(int arg0, E arg1) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray(E[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
