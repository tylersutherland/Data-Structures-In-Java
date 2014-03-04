package tstructs.list;

public class DoublyLinkedList<T> extends LinkedList<T> {

	public DoublyLinkedList() {}

	public DoublyLinkedList(T[] ts) {
		this();
		this.addAll(ts);
	}

	@Override
	public void add(T value) {
		DoubleNode nodeToAdd = new DoubleNode(value, null, null);
		if (this.head == null) {
			this.head = nodeToAdd;
		} else {
			nodeToAdd.prev = this.tail;
			this.tail.next = nodeToAdd;
		}
		this.tail = nodeToAdd;
		this.size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T set(int index, T value) {
		if (index / 2 < this.size / 2) return super.set(index, value);
		else {
			this.isIndexValid(index);
			DoubleNode curr = (DoubleNode) this.tail;
			for (int i = this.size - 1; i > index; i--) {
				curr = (DoubleNode) curr.prev;
			}
			T removedVal = curr.val;
			curr.val = value;
			return removedVal;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		if (index / 2 < this.size / 2) return super.remove(index);
		else {
			this.isIndexValid(index);
			DoubleNode n = (DoubleNode) this.tail;
			for (int i = this.size - 1; i > index; i--) {
				n = (DoubleNode) n.prev;
			}
			T removed = n.val;
			if (n.next == null) {
				this.tail = n.prev;
				n = null;
			} else {
				((DoubleNode) n.next).prev = n.prev;
				n.prev.next = n.next;
			}
			this.size--;
			return removed;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index / 2 < this.size / 2) return super.get(index);
		else {
			this.isIndexValid(index);
			DoubleNode n = (DoubleNode) this.tail;
			for (int i = this.size - 1; i > index; i--) {
				n = (DoubleNode) n.prev;
			}
			return n.val;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int lastIndexOf(T value) {
		int index = this.size - 1;
		if (value == null) {
			for (DoubleNode n = (DoubleNode) this.tail; n != null; n = (DoubleNode) n.prev) {
				if (n.val == value) return index;
				index--;
			}
		} else {
			for (DoubleNode n = (DoubleNode) this.tail; n != null; n = (DoubleNode) n.prev) {
				if (n.val.equals(value)) return index;
				index--;
			}
		}
		return -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new Itr();
	}

	class DoubleNode extends Node {
		Node	prev;

		DoubleNode(T val, Node next, Node prev) {
			super(val, next);
			this.prev = prev;
		}
	}

}
