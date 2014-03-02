package tstructs;

public class SinglyLinkedList<T> extends LinkedList<T> {
	public SinglyLinkedList(T[] ts) {
		this();
		this.addAll(ts);
	}

	public SinglyLinkedList() {}

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
