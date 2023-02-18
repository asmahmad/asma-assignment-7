package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
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
			
			tempObj = this.itemsArray[index];
			size++;
			for (int i = itemsArray.length-1; i > index+1; i--) {
				this.itemsArray[i] =this.itemsArray[i-1];
			}
			
			this.itemsArray[index] = item;
			this.itemsArray[index+1] = tempObj;
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
			tempObj = this.itemsArray[index];
			if(index == size-1) {
				this.itemsArray[index]=null;
				Object[] itemsArrayTemp = new Object[this.itemsArray.length-1];
				int i=0;
				while(this.itemsArray[i] != null) {
					itemsArrayTemp[i]=this.itemsArray[i];
					i++;
				}
				
				this.itemsArray =itemsArrayTemp;
				size = this.itemsArray.length;
			}else if(index >0 || index < size) {
				for (int i = index; i < size; i++) {
					this.itemsArray[i] = this.itemsArray[i+1];
				}
				
				size--;
				return (T) tempObj;
			}	
		}catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds. The current size of this list is: " + size);
		}
		return null;
	}

}
