package tstructs;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest extends ListTest {

	@Before
	public void setUp() {
		a = new DoublyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
		b = new DoublyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
	}

	@Test
	public void testAdd() {
		c = new DoublyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4 });
		super.testAdd();
	}

	@Test
	public void testSet() {
		c = new DoublyLinkedList<Integer>(new Integer[] { 2, 2, 4, 4, 6 });
		super.testSet();
	}

	@Test
	public void testRemoveInt() {
		c = new DoublyLinkedList<Integer>(new Integer[] { 2, 4 });
		super.testRemoveInt();
	}

	@Test
	public void testRemoveT() {
		c = new DoublyLinkedList<Integer>(new Integer[] { 2, 4 });
		super.testRemoveT();
	}

	@Test
	public void testEqualsObject() {
		c = new DoublyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
		super.testEqualsObject();

	}

	@Test
	public void testIsEmpty() {
		c = new DoublyLinkedList<Integer>();
		super.testIsEmpty();
	}

	@Test
	public void testLastIndexOf() {
		c = new DoublyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5, 1, 2,
				3, 4, 5 });
		super.testLastIndexOf();
	}

	@Test
	public void testAddAll() {
		c = new DoublyLinkedList<Integer>();
		super.testAddAll();
	}
}
