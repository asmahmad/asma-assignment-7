package com.coderscampus.assignment7;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	int size =0;
	Object tempObj = new Object();
	Object[] itemsArray = new Object[10];

	@Override
	public boolean add(T item) {
	
		if (size == itemsArray.length) {
			itemsArray = Arrays.copyOf(itemsArray, itemsArray.length * 2);
		}
		
		itemsArray[size] = item;
		size++;
		return true;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		try {
			if (size == itemsArray.length) {
				itemsArray = Arrays.copyOf(itemsArray, itemsArray.length * 2);
			}
			
			Object[] tempArray = new Object[size+1];
			tempArray[index] = item;
			for (int j=0; j<index; j++) {
				tempArray[j] = this.itemsArray[j];
			}
			
			for (int i = size ; i > index; i--) {
				 tempArray[i] = this.itemsArray[i-1];
			}				
			this.itemsArray = tempArray;
			
			size++;
			return true;			
			
		}catch(IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds. The maximum size of the current list is: " + itemsArray.length);
		}
		return false;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		try {
			return  (T) this.itemsArray[index];	
		
		}catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds. The maximum size of the current list is: " + itemsArray.length);
		}
		return  null;	
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		try {	
				for (int i=index; i < size-1; i++) {
					this.itemsArray[i]=this.itemsArray[i+1];
				}
				
				this.itemsArray[size-1] = null;
				size--;
				return (T) tempObj;	
		}catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds. The current size of this list is: " + size);
		}
		return null;
	}

}
