package linear.base;

import entities.Product;

public class TestDoublyLinkedList {
	
	static DoublyLinkedList<Product> list = new DoublyLinkedList<>(); 
	
	public static void main(String[] args) {
		list.addFirst(new Product("Camisa", 80d));
		list.addFirst(new Product("Tênis", 200d));
		list.addLast(new Product("Meia", 15d));
		list.addLast(new Product("Calça", 150d));
		System.out.println(list.toString());
		System.out.println(list.first().toString());
		System.out.println(list.last().toString());
		list.removeFirst();
		System.out.println(list.toString());
		list.removeLast();
		System.out.println(list.toString());
		System.out.println(list.size());
	}
}
