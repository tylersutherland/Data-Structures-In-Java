package tstructs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest extends ListTest {

	@Before
	public void setUp() {
		a = new SinglyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
		b = new SinglyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
	}

	@Test
	public void testAdd() {
		a = new SinglyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4 });

		a.add(5);

		assertThat(a, is(b));
	}

	@Test
	public void testSet() {
		a = new SinglyLinkedList<Integer>(new Integer[] { 2, 2, 4, 4, 6 });

		a.set(0, 1);
		a.set(2, 3);
		a.set(4, 5);

		assertThat(a, is(b));
	}

	@Test
	public void testRemoveInt() {
		b = new SinglyLinkedList<Integer>(new Integer[] { 2, 4 });

		a.remove(2);
		a.remove(3);
		a.remove(0);

		assertThat(a, is(b));
	}

	@Test
	public void testRemoveT() {
		b = new SinglyLinkedList<Integer>(new Integer[] { 2, 4 });

		a.remove(new Integer(3));
		a.remove(new Integer(5));
		a.remove(new Integer(1));

		assertThat(a, is(b));
	}

	@Test
	public void testEqualsObject() {
		c = new SinglyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
		super.testEqualsObject();

	}

	@Test
	public void testIsEmpty() {
		c = new SinglyLinkedList<Integer>();
		super.testIsEmpty();
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
		a = new SinglyLinkedList<Integer>(new Integer[] { 1, 2, 3, 4, 5, 1, 2,
				3, 4, 5 });

		assertThat(a.lastIndexOf(1), is(5));
		assertThat(a.lastIndexOf(3), is(7));
		assertThat(a.lastIndexOf(5), is(9));
	}

	@Test
	public void testAddAll() {
		b = new SinglyLinkedList<Integer>();
		super.testAddAll();
	}
}
