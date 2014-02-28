package tstructs;

public abstract class List<T> {
	class Node {
		T		val;
		Node	next;

		Node(T val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	/**
	 * Adds the value to the end of the list.
	 * 
	 * @param value the value to add.
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
	 * Returns true if the list contains the value
	 * 
	 * @param value
	 *            to check for
	 * @return true if the list contains the value.
	 */
	public abstract boolean contains(T value);

	@Override
	public abstract boolean equals(Object other);

	/**
	 * Returns true if the list is empty
	 * 
	 * @return true if the list is empty
	 */
	public abstract boolean isEmpty();

	/**
	 * Gets the value at this index.
	 * 
	 * @param index the index of the value wanted.
	 * @return the value at this index.
	 */
	public abstract T get(int index);

	/**
	 * Gets the first index of the specified value.
	 * @param value the value to look for.
	 * @return first index of the specified value.
	 */
	public abstract int indexOf(T value);

	/**
	 * Gets the last index of the specified value.
	 * @param value the value to look for.
	 * @return the last index of the specified value.
	 */
	public abstract int lastIndexOf(T value);

	/**
	 * Returns the amount of elements in the list
	 * @return the amount of elements in the list.
	 */
	public abstract int size();

	/**
	 * Gets an array representation of the list.
	 * @return an array with the values of the list
	 */
	public abstract Object[] toArray();

	@Override
	public abstract String toString();

	/**
	 * Adds all of the values of the given array to the list.
	 * @param ts the array of elements to add
	 */
	public abstract void addAll(T[] ts);

	/**
	 * Returns an iterator over the list.
	 * @return an iterator over the list
	 */
	public abstract Iterator<T> iterator();
}
