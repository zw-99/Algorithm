package zw.algorithm.search;

public class Node<T extends Comparable<T>> {
	T key;
	Node<T> parent;
	Node<T> left;
	Node<T> right;
	
	public Node(T key, Node<T> parent, Node<T> left, Node<T> right) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	public T getKey() {
		return this.key;
	}
}
