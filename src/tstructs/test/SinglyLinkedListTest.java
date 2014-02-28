package tstructs.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tstructs.SinglyLinkedList;

public class SinglyLinkedListTest {

	@Test
	public void testRemoveByObject() {
		SinglyLinkedList<Integer> a = new SinglyLinkedList<>(new Integer[] { 1,
				2, 3, 4, 5 });
		SinglyLinkedList<Integer> b = new SinglyLinkedList<>(new Integer[] { 2,
				3, 4, 5 });
		a.remove((Integer) 1);
		assertThat(a, is(b));

	}

	@Test
	public void testSet() {
		SinglyLinkedList<Integer> a = new SinglyLinkedList<>(new Integer[] { 1,
				2, 3, 4, 5 });
		SinglyLinkedList<Integer> b = new SinglyLinkedList<>(new Integer[] { 1,
				2, 100, 4, 5 });

		a.set(2, 100);
		assertThat(a, is(b));
	}

	@Test
	public void testEquals() {
		SinglyLinkedList<Integer> a = new SinglyLinkedList<>(new Integer[] { 1,
				2, 3, 4, 5, 6 });
		SinglyLinkedList<Integer> b = new SinglyLinkedList<>(new Integer[] { 1,
				2, 3, 4, 5, 6 });
		SinglyLinkedList<Integer> c = new SinglyLinkedList<>(new Integer[] { 1,
				2, 3, 4, 5, 6 });
		SinglyLinkedList<Integer> d = new SinglyLinkedList<>(new Integer[] { 1,
				2, 3, 4, 5 });
		// Reflexive
		assertThat(a, is(a));
		// Symmetric
		assertThat(a, is(b));
		assertThat(b, is(a));
		// Transitive
		assertThat(b, is(c));
		assertThat(a, is(c));

		assertThat(a, not(d));
	}

	@Test
	public void testDefaultIsEmpty() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testRemoveByIndexEdge1() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new Integer[] {
				1, 2, 3, 4, 5, 6 });

		assertEquals((Integer) 1, list.remove(0));
		assertEquals(5, list.size());
	}

	@Test
	public void testRemoveByIndexEdge2() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new Integer[] {
				1, 2, 3, 4, 5, 6 });

		assertEquals((Integer) 1, list.remove(0));
		assertEquals(5, list.size());
	}

	@Test
	public void testAdd() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for (int i = 0; i < 10; i++)
			list.add(i);
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>(
				new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		SinglyLinkedList<Integer> list3 = new SinglyLinkedList<Integer>(
				new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		SinglyLinkedList<Integer> list4 = new SinglyLinkedList<Integer>(
				new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 });

		assertThat(list, is(list2));
		assertThat(list, not(list3));
		assertThat(list, not(list4));
	}

	@Test
	public void testSize() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for (int i = 0; i < 10; i++)
			list.add(i);
		assertEquals(10, list.size());
	}

}
