package linear.list;

import entities.Product;

public class TestArrayList {
	static List<Product> list = new ArrayList<>();
	
	public static void main(String[] args) {
		list.add(0, new Product("Camisa", 80d));
		list.add(0, new Product("Tênis", 200d));
		list.add(2, new Product("Meia", 15d));
		list.add(2, new Product("Calça", 150d));
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.set(1, new Product("Chinelo", 60d)));
		System.out.println(list.toString());
		System.out.println(list.remove(2));
		System.out.println(list.toString());
		System.out.println(list.get(1));
	}
}
