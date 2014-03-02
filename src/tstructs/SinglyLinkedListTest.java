package tstructs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {

	SinglyLinkedList<Integer>	a;
	SinglyLinkedList<Integer>	b;

	@Before
	public void setUp() {
		a = new SinglyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
		b = new SinglyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
	}

	@Test
	public void testAdd() {
		SinglyLinkedList<Integer> a = new SinglyLinkedList<Integer>(
				new Integer[] { 1, 2, 3, 4 });

		a.add(5);

		assertThat(a, is(b));
	}

	@Test
	public void testSet() {
		SinglyLinkedList<Integer> a = new SinglyLinkedList<Integer>(
				new Integer[] { 2, 2, 4, 4, 6 });

		a.set(0, 1);
		a.set(2, 3);
		a.set(4, 5);

		assertThat(a, is(b));
	}

	@Test
	public void testRemoveInt() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>(
				new Integer[] { 2, 4 });

		a.remove(2);
		a.remove(3);
		a.remove(0);

		assertThat(a, is(b));
	}

	@Test
	public void testRemoveT() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>(
				new Integer[] { 2, 4 });

		a.remove(new Integer(3));
		a.remove(new Integer(5));
		a.remove(new Integer(1));

		assertThat(a, is(b));
	}

	@Test
	public void testContains() {
		assertTrue(a.contains(1) && a.contains(3) && a.contains(5));
	}

	@Test
	public void testEquals() {
		SinglyLinkedList<Integer> c = new SinglyLinkedList<Integer>(
				new Integer[] { 1, 2, 3, 4, 5 });

		assertThat(a, is(b));
		assertThat(b, is(c));
		assertThat(a, is(c));

		assertThat(a, is(b));
		assertThat(b, is(a));

		assertThat(a, is(a));
	}

	@Test
	public void testIsEmpty() {
		SinglyLinkedList<Integer> a = new SinglyLinkedList<Integer>();

		for (int i = 0; i < 5; i++)
			b.remove(0);

		assertThat(a.size(), is(0));
		assertThat(b.size(), is(0));
	}

	@Test
	public void testGet() {
		assertThat(a.get(0), is(1));
		assertThat(a.get(2), is(3));
		assertThat(a.get(4), is(5));
	}

	@Test
	public void testIndexOf() {
		assertThat(a.indexOf(1), is(0));
		assertThat(a.indexOf(3), is(2));
		assertThat(a.indexOf(5), is(4));
	}

	@Test
	public void testLastIndexOf() {
		SinglyLinkedList<Integer> a = new SinglyLinkedList<Integer>(
				new Integer[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 });

		assertThat(a.lastIndexOf(1), is(5));
		assertThat(a.lastIndexOf(3), is(7));
		assertThat(a.lastIndexOf(5), is(9));
	}

	@Test
	public void testSize() {
		assertThat(a.size(), is(5));
	}

	@Test
	public void testToString() {
		assertThat(a.toString(), is("[ 1, 2, 3, 4, 5 ]"));
	}

	@Test
	public void testToArray() {
		assertThat(a.toArray(), is(new Object[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	public void testAddAll() {
		SinglyLinkedList<Integer> b = new SinglyLinkedList<Integer>();

		for (int i = 0; i < 5; i++)
			b.add(i + 1);

		assertThat(a, is(b));
	}
}
