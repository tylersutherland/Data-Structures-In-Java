package tstructs.list;

public interface Iterator<T> {
	public boolean hasNext();

	public T next();

	public T remove();
}