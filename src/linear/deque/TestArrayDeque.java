package linear.deque;

import java.util.LinkedList;
import java.util.List;

import entities.Product;

public class TestArrayDeque {

	static ArrayDeque<Product> deque = new ArrayDeque<>(5); 
	
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
		
		deque.addLast(new Product("Chapéu", 20d));
		deque.addFirst(new Product("Relógio", 250d));
		System.out.println(deque.toString());
		deque.removeFirst();
		deque.removeFirst();
		deque.addLast(new Product("Anel", 450d));
		deque.addLast(new Product("Óculos", 500d));
		System.out.println(deque.toString());
	}
}
