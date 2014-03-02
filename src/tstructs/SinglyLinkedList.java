package tstructs;

public class SinglyLinkedList<T> extends List<T> {
	private Node	head;
	private Node	tail;
	private int		size;

	public SinglyLinkedList(T[] ts) {
		this.addAll(ts);
	}

	public SinglyLinkedList() {}

	@Override
	public void add(T value) {
		Node nodeToAdd = new Node(value, null);
		if (this.head == null) this.head = nodeToAdd;
		else this.tail.next = nodeToAdd;
		this.tail = nodeToAdd;
		this.size++;
	}

	@Override
	public T set(int index, T value) {
		if (index >= this.size || index < 0)
			throw new IndexOutOfBoundsException();
		Node curr = this.head;
		for (int i = 0; i < index; i++)
			curr = curr.next;
		T removedVal = curr.val;
		curr.val = value;
		return removedVal;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException();
		Node n = this.head;
		Node prev = null;
		for (int i = 0; i < index; i++) {
			prev = n;
			n = n.next;
		}
		T removed = n.val;
		if (prev == null) {
			head = n.next;
			n = null;
		} else prev.next = n.next;
		this.size--;
		return removed;
	}

	@Override
	public boolean remove(T value) {
		Node prev = head;
		if (value == null) {
			for (Node curr = head; curr != null; curr = curr.next) {
				if (curr.val == value) {
					if (curr == head) {
						head = curr.next;
					} else {
						prev.next = curr.next;
					}

					curr = null;// Is this explicitly needed?
					this.size--;
					return true;
				}
				prev = curr;
			}
		} else {
			for (Node curr = head; curr != null; curr = curr.next) {
				if (curr.val.equals(value)) {
					if (curr == head) {
						head = curr.next;
					} else {
						prev.next = curr.next;
					}

					curr = null;// Is this explicitly needed?
					this.size--;
					return true;
				}
				prev = curr;
			}
		}
		return false;
	}

	@Override
	public boolean contains(T value) {
		return this.indexOf(value) != -1;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) return true;
		if (!(other instanceof SinglyLinkedList)) return false;
		Iterator<T> iterator = this.iterator();
		Iterator<?> otherIterator = ((SinglyLinkedList<?>) other).iterator();

		while (iterator.hasNext() && otherIterator.hasNext()) {
			T v1 = iterator.next();
			Object v2 = otherIterator.next();

			if (!(v1 == null && v2 == null || v1.equals(v2))) return false;
		}

		return !(iterator.hasNext() || otherIterator.hasNext());

	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException();
		Node n = this.head;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		return n.val;
	}

	@Override
	public int indexOf(T value) {
		int index = 0;
		if (value == null) {
			for (Node n = head; n != null; n = n.next) {
				if (n.val == value) return index;
				index++;
			}
		} else {
			for (Node n = head; n != null; n = n.next) {
				if (n.val.equals(value)) return index;
				index++;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T value) {
		int lastIndex = -1;
		int currentIndex = 0;
		if (value == null) {
			for (Node n = head; n != null; n = n.next) {
				if (n.val == value) lastIndex = currentIndex;
				currentIndex++;
			}
		} else {
			for (Node n = head; n != null; n = n.next) {
				if (n.val.equals(value)) lastIndex = currentIndex;
				currentIndex++;
			}
		}
		return lastIndex;

	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[ ");
		for (Node curr = head; curr != null; curr = curr.next) {
			builder.append(curr.val.toString()).append(", ");
		}
		builder.setLength(builder.length() - 2);
		builder.append(" ]");
		return builder.toString();
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[this.size];
		Node n = this.head;
		for (int i = 0; i < this.size; i++) {
			arr[i] = n.val;
			n = n.next;
		}
		return arr;
	}

	@Override
	public void addAll(T[] ts) {
		for (T t : ts)
			this.add(t);
	}

	@Override
	public Iterator<T> iterator() {
		return new Itr();
	}

	class Itr implements Iterator<T> {
		Node	lastNode	= null;
		Node	next;

		Itr() {
			this.next = SinglyLinkedList.this.head;
		}

		@Override
		public boolean hasNext() {
			return this.next != null;
		}

		@Override
		public T next() {
			// TODO: JDK implementation checks for co-modifiction, see what that
			// is.
			T val = this.next.val;
			this.next = this.next.next;
			return val;
		}

		@Override
		public T remove() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
