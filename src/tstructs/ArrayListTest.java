package tstructs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

	ArrayList<Integer>	a;
	ArrayList<Integer>	b;

	@Before
	public void setUp() {
		a = new ArrayList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
		b = new ArrayList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
	}

	@Test
	public void testAdd() {
		ArrayList<Integer> c = new ArrayList<Integer>(new Integer[] { 1, 2, 3,
				4 });

		c.add(5);

		assertThat(c, is(a));
	}

	@Test
	public void testSet() throws Exception {
		ArrayList<Integer> c = new ArrayList<Integer>(new Integer[] { 2, 2, 4,
				4, 6 });

		c.set(0, 1);
		c.set(2, 3);
		c.set(4, 5);

		assertThat(c, is(a));
	}

	@Test
	public void testRemoveInt() {
		ArrayList<Integer> c = new ArrayList<Integer>(new Integer[] { 2, 4 });

		a.remove(2);
		a.remove(3);
		a.remove(0);

		assertThat(a, is(c));
	}

	@Test
	public void testRemoveT() {
		ArrayList<Integer> c = new ArrayList<Integer>(new Integer[] { 2, 4 });

		a.remove(new Integer(3));
		a.remove(new Integer(5));
		a.remove(new Integer(1));

		assertThat(a, is(c));
	}

	@Test
	public void testContains() {
		assertTrue(a.contains(1) && a.contains(3) && a.contains(5));
	}

	@Test
	public void testEquals() {
		ArrayList<Integer> c = new ArrayList<Integer>(new Integer[] { 1, 2, 3,
				4, 5 });

		assertThat(a, is(b));
		assertThat(b, is(c));
		assertThat(a, is(c));

		assertThat(a, is(b));
		assertThat(b, is(a));

		assertThat(a, is(a));
	}

	@Test
	public void testIsEmpty() {
		List<Integer> c = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++)
			b.remove(0);

		assertThat(c.size(), is(0));
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
		List<Integer> c = new ArrayList<Integer>(new Integer[] { 1, 2, 3, 4, 5,
				1, 2, 3, 4, 5 });

		assertThat(c.lastIndexOf(1), is(5));
		assertThat(c.lastIndexOf(3), is(7));
		assertThat(c.lastIndexOf(5), is(9));
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
		ArrayList<Integer> b = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++)
			b.add(i + 1);

		assertThat(a, is(b));
	}

}
