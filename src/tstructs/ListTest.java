package tstructs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public abstract class ListTest {
	List<Integer>	a;
	List<Integer>	b;
	List<Integer>	c;

	@Before
	public abstract void setUp();

	@Test
	public void testContains() {
		assertTrue(a.contains(1) && a.contains(3) && a.contains(5));
	}

	@Test
	public void testEqualsObject() {
		assertThat(a, is(b));
		assertThat(b, is(c));
		assertThat(a, is(c));

		assertThat(a, is(b));
		assertThat(b, is(a));

		assertThat(a, is(a));
	}

	@Test
	public void testIsEmpty() {
		for (int i = 0; i < 5; i++)
			b.remove(0);

		assertThat(c.size(), is(0));
		assertThat(b.size(), is(0));
	}

	@Test
	public void testSize() {
		assertThat(a.size(), is(5));
	}

	@Test
	public void testAddAll() {
		for (int i = 0; i < 5; i++)
			b.add(i + 1);

		assertThat(a, is(b));
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
	public abstract void testAdd();

	@Test
	public abstract void testSet();

	@Test
	public abstract void testRemoveInt();

	@Test
	public abstract void testGet();

	@Test
	public abstract void testIndexOf();

	@Test
	public abstract void testLastIndexOf();
}
