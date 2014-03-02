package tstructs;

public abstract class List<T> {

	protected int	size;

	/**
	 * Adds the value to the end of the list.
	 * 
	 * @param value
	 *            the value to add.
	 */
	public abstract void add(T value);

	/**
	 * Sets the specified index to the specified value.
	 * 
	 * @param index
	 *            the index of the element being changed.
	 * @param value
	 *            the value being put in the index
	 * @return the previous value at the index.
	 */
	public abstract T set(int index, T value);

	/**
	 * Removes the node at this index.
	 * 
	 * @param index
	 *            the index to remove
	 * @return the removed value
	 */
	public abstract T remove(int index);

	/**
	 * Removes the first node with this value
	 * 
	 * @param value
	 *            to remove
	 * @return true if the value was found and removed
	 */
	public abstract boolean remove(T value);

	/**
	 * Gets the value at this index.
	 * 
	 * @param index
	 *            the index of the value wanted.
	 * @return the value at this index.
	 */
	public abstract T get(int index);

	/**
	 * Gets the first index of the specified value.
	 * 
	 * @param value
	 *            the value to look for.
	 * @return first index of the specified value.
	 */
	public abstract int indexOf(T value);

	/**
	 * Gets the last index of the specified value.
	 * 
	 * @param value
	 *            the value to look for.
	 * @return the last index of the specified value.
	 */
	public abstract int lastIndexOf(T value);

	/**
	 * Gets an array representation of the list.
	 * 
	 * @return an array with the values of the list
	 */
	public abstract Object[] toArray();

	@Override
	public abstract String toString();

	protected void isIndexValid(int index) throws IndexOutOfBoundsException {
		if (index >= this.size || index < 0)
			throw new IndexOutOfBoundsException();
	}

	/**
	 * Returns true if the list contains the value
	 * 
	 * @param value
	 *            to check for
	 * @return true if the list contains the value.
	 */
	public boolean contains(T value) {
		return this.indexOf(value) != -1;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) return true;
		if (!(other instanceof List)) return false;
		Iterator<T> iterator = this.iterator();
		@SuppressWarnings("unchecked") Iterator<?> otherIterator = ((List<T>) other)
				.iterator();

		while (iterator.hasNext() && otherIterator.hasNext()) {
			T v1 = iterator.next();
			Object v2 = otherIterator.next();

			if (!(v1 == null && v2 == null || v1.equals(v2))) return false;
		}

		return !(iterator.hasNext() || otherIterator.hasNext());

	}

	/**
	 * Returns true if the list is empty
	 * 
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Returns the amount of elements in the list
	 * 
	 * @return the amount of elements in the list.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Adds all of the values of the given array to the list.
	 * 
	 * @param ts
	 *            the array of elements to add
	 */
	public void addAll(T[] ts) {
		for (T t : ts)
			this.add(t);
	}

	/**
	 * Returns an iterator over the list.
	 * 
	 * @return an iterator over the list
	 */
	public abstract Iterator<T> iterator();
}
