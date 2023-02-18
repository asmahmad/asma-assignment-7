package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {
	//Test Driven Methodology:
	//Step 1: Write a failing test.
	//Step 2: Write the business logic to make the test pass.
	//Step 3: Refactor your code.
	//Step 4: Repeat

	@Test
	void should_add_items_to_list() {
		//Three A's
		//Arrange - Setup your test case, Act - invoking the code, Assert - expected behavior and actual behavior
		
		//Arrange:
		CustomList<Integer> sut = new CustomArrayList<>();
		
		//Act:
		addItems(sut,1000);
		sut.add(1001);
		
		//Assert:
		assertEquals(1,sut.get(0)); // Checking if items are successfully added to the list Expected: 1 , Actual: ?
		assertEquals(1001,sut.get(1000)); // Checking if the item 1001 is add at the end of the list Expected: 1001 , Actual: ?
		assertEquals(1001, sut.getSize()); // Expected: 1001 , Actual : ?		
	}
	
	@Test
	void should_add_items_at_index() {
		//Three A's
		//Arrange - Setup your test case, Act - invoking the code, Assert - expected behavior and actual behavior
				
		//Arrange:
		CustomList<Integer> sut = new CustomArrayList<>();
				
		//Act:
		addItems(sut,100);
		sut.add(0,5);
		sut.add(30,80);
		sut.add(9999,2000); //Checking Index Out Of Bound Exception -> Expected on Console: Index out of bounds. The maximum size of the current list is: 1280
	
		//Assert:
		assertEquals(5,sut.get(0)); //Checking if the item 5 is add at the given index: 0  -> Expected: 5 , Actual: ?
	//	assertEquals(80,sut.get(30)); //Checking if the item 80 is add at the given index: 30  -> Expected: 30 , Actual: ?
	//	assertEquals(1002, sut.getSize()); //Checking if the length of the list is adjusting if we add more items to it -> Expected: 1002 , Actual: ?
	}
	
	@Test
	void should_remove_items_at_index() {
		//Three A's
		//Arrange - Setup your test case, Act - invoking the code, Assert - expected behavior and actual behavior
		
		//Arrange:
		CustomList<Integer> sut = new CustomArrayList<>();
		
		//Act:
		addItems(sut,10);
		sut.remove(9);
		sut.remove(8);
		sut.add(0,90);
		sut.add(900);
		sut.add(901);
		sut.add(903);
		sut.remove(2000);// Checking Index out of Bound Exception
		sut.get(3000);//Checking Index out of Bound Exception
		
		//Assert:
		assertEquals(903, sut.get(11));//Checking if the item: 1 is removed at index:0  -> Expected: 2 , Actual: ? 
		assertEquals(12, sut.getSize());//Checking if the length of the list is adjusting if we remove more items to it -> Expected: 999 , Actual: ?
	}
	
	@Test
	void should_multiple_add_multiple_remove_at_index() {
		//Three A's
		//Arrange - Setup your test case, Act - invoking the code, Assert - expected behavior and actual behavior
		
		//Arrange:
		CustomList<Integer> sut = new CustomArrayList<>();
		
		//Act:
		addItems(sut,1000);
		sut.add(5,5);
		sut.add(10,10);
		sut.add(15,15);
		sut.remove(0);
		sut.remove(1);
		sut.get(9000);//Checking Index out of bound Exception
		//Assert:
		assertEquals(5, sut.get(2)); //Checking if the items are successfully removed from the list and the rest move to the left -> Expected: 5 at index: 2 , Actual: ?
		assertEquals(10, sut.get(8)); //Checking if the items are successfully removed from the list and the rest move to the left -> Expected: 10 at index:8 , Actual: ?
		assertEquals(1001,sut.getSize());//Checking while adding and removing items the size of the list is maintained. -> Expected: 1001, Actual: ? 
	}
	public static void addItems(CustomList<Integer> sut, int size) {
		for(int i =0; i<size;i++)
		sut.add((i+1));
	}
}
