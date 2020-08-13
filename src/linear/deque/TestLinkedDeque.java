package linear.deque;

import entities.Product;

public class TestLinkedDeque {

	static LinkedDeque<Product> deque = new LinkedDeque<>(); 
	
	public static void main(String[] args) {
		deque.addFirst(new Product("Camisa", 80d));
		deque.addFirst(new Product("Tênis", 200d));
		deque.addLast(new Product("Meia", 15d));
		deque.addLast(new Product("Calça", 150d));
		System.out.println(deque.toString());
		System.out.println(deque.first());
		System.out.println(deque.last());
		System.out.println(deque.removeFirst());
		System.out.println(deque.removeLast());
		System.out.println(deque.toString());
		System.out.println(deque.size());
		System.out.println(deque.isEmpty());
	}

}
