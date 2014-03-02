package tstructs;

public class ArrayList<T> extends List<T> {

	private Object[]	array;

	public ArrayList() {
		this(10);
	}

	public ArrayList(int initialCapacity) {
		this.array = new Object[initialCapacity];
		this.size = 0;
	}

	public ArrayList(T[] ts) {
		this();
		this.addAll(ts);
	}

	@Override
	public void add(T value) {
		this.canArrayHold(this.size + 1);
		this.array[this.size] = value;
		this.size++;
	}

	private void canArrayHold(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public T set(int index, T value) {
		this.isIndexValid(index);
		@SuppressWarnings("unchecked") T oldValue = (T) this.array[index];
		this.array[index] = value;
		return oldValue;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(T value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
