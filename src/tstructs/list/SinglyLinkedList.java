package tstructs.list;

public class SinglyLinkedList<T> extends LinkedList<T> {
	public SinglyLinkedList(T[] ts) {
		this();
		this.addAll(ts);
	}

	public SinglyLinkedList() {}

	@Override
	public void add(T value) {
		Node nodeToAdd = new Node(value, null);
		if (this.head == null) {
			this.head = nodeToAdd;
		} else {
			this.tail.next = nodeToAdd;
		}
		this.tail = nodeToAdd;
		this.size++;
	}

	@Override
	public int lastIndexOf(T value) {
		int lastIndex = -1;
		int currentIndex = 0;
		if (value == null) {
			for (Node n = this.head; n != null; n = n.next) {
				if (n.val == value) {
					lastIndex = currentIndex;
				}
				currentIndex++;
			}
		} else {
			for (Node n = this.head; n != null; n = n.next) {
				if (n.val.equals(value)) {
					lastIndex = currentIndex;
				}
				currentIndex++;
			}
		}
		return lastIndex;

	}

	@Override
	public Iterator<T> iterator() {
		return new Itr();
	}

}
