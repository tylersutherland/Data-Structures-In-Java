package tstructs;

public class ArrayList<T> extends List<T> {

	private Object[]			array;
	private int					currentCapacity;

	/** In addition to being the default this is also the minimum **/
	private final static int	INITIAL_CAPACITY	= 10;

	public ArrayList() {
		this(INITIAL_CAPACITY);
	}

	public ArrayList(int initialCapacity) {
		initialCapacity = initialCapacity < INITIAL_CAPACITY ? INITIAL_CAPACITY
				: initialCapacity;
		this.array = new Object[initialCapacity];
		this.currentCapacity = initialCapacity;
		this.size = 0;
	}

	public ArrayList(T[] ts) {
		this();
		this.addAll(ts);
	}

	@Override
	public void add(T value) {
		this.growArrayTo(this.size + 1);
		this.array[this.size] = value;
		this.size++;
	}

	private void growArrayTo(int newSize) {
		if (newSize > currentCapacity) {
			Object[] newArray = new Object[currentCapacity * 2];
			for (int i = 0; i < currentCapacity; i++) {
				newArray[i] = this.array[i];
			}
			currentCapacity *= 2;
			this.array = newArray;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T set(int index, T value) {
		this.isIndexValid(index);
		T oldValue = (T) this.array[index];
		this.array[index] = value;
		return oldValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		this.isIndexValid(index);
		T removedValue = (T) this.array[index];
		this.shiftArrayLeft(index + 1);
		this.size--;
		this.shrinkArrayTo(this.size);
		return removedValue;
	}

	private void shrinkArrayTo(int newSize) {
		if (newSize < currentCapacity / 2) {
			currentCapacity /= 2;
			currentCapacity = currentCapacity < INITIAL_CAPACITY ? INITIAL_CAPACITY
					: currentCapacity;
			currentCapacity += currentCapacity % 2 != 0 ? 1 : 0;

			Object[] newArray = new Object[currentCapacity];
			for (int i = 0; i < currentCapacity; i++) {
				newArray[i] = this.array[i];
			}
			this.array = newArray;
		}

	}

	@Override
	public boolean remove(T value) {
		if (value == null) {
			for (int i = 0; i < this.size; i++) {
				if (this.array[i] == value) {
					this.shiftArrayLeft(i + 1);
					this.size--;
					this.shrinkArrayTo(this.size);
					return true;
				}
			}
		} else {
			for (int i = 0; i < this.size; i++)
				if (this.array[i].equals(value)) {
					this.shiftArrayLeft(i + 1);
					this.size--;
					this.shrinkArrayTo(this.size);
					return true;
				}
		}
		return false;
	}

	private void shiftArrayLeft(int start) {
		assert start > 0;
		for (int i = start; i < this.size; i++) {
			this.array[i - 1] = this.array[i];
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		this.isIndexValid(index);
		return (T) this.array[index];
	}

	@Override
	public int indexOf(T value) {
		if (value == null) {
			for (int i = 0; i < this.size; i++) {
				if (this.array[i] == value) return i;
			}
		} else {
			for (int i = 0; i < this.size; i++) {
				if (this.array[i].equals(value)) return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T value) {
		int lastIndex = -1;
		if (value == null) {
			for (int i = 0; i < this.size; i++) {
				if (this.array[i] == value) {
					lastIndex = i;
				}
			}
		} else {
			for (int i = 0; i < this.size; i++) {
				if (this.array[i].equals(value)) {
					lastIndex = i;
				}
			}
		}
		return lastIndex;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[this.size];
		for (int i = 0; i < this.size; i++) {
			arr[i] = this.array[i];
		}
		return arr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[ ");
		for (int i = 0; i < this.size; i++) {
			builder.append(this.array[i].toString()).append(", ");
		}
		builder.setLength(builder.length() - 2);
		builder.append(" ]");
		return builder.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new Itr();
	}

	class Itr implements Iterator<T> {
		int	nextIndex;

		Itr() {
			this.nextIndex = 0;
		}

		@Override
		public boolean hasNext() {
			return this.nextIndex < ArrayList.this.size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			// TODO: JDK implementation checks for co-modifiction, see what that
			// is.
			T val = (T) ArrayList.this.array[this.nextIndex];
			this.nextIndex++;
			return val;
		}

		@Override
		public T remove() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public int currentCapacity() {
		return currentCapacity;
	}
}
