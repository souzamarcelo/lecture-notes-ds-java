package linear.positional_list;

import entities.Product;

public class TestLinkedPositionalList {
	
	static LinkedPositionalList<Product> list = new LinkedPositionalList<>();
	
	public static void main(String[] args) {
		Position<Product> p1 = list.addFirst(new Product("Camisa", 80d));
		Position<Product> p2 = list.addFirst(new Product("Tênis", 200d));
		Position<Product> p3 = list.addLast(new Product("Meia", 15d));
		Position<Product> p4 = list.addLast(new Product("Calça", 150d));
		System.out.println(list.toString());
		System.out.println(list.first().getElement());
		System.out.println(list.last().getElement());
		System.out.println(list.after(p2).getElement());
		System.out.println(list.before(p4).getElement());
		list.addAfter(p1, new Product("Chinelo", 60d));
		System.out.println(list.toString());
		list.set(p1, new Product("Óculos", 500d));
		System.out.println(list.toString());
		System.out.println(list.remove(p2));
		
		//Uncomment to test the exceptions
		//list.addAfter(p2, new Produto("Notebook", 2000d));
		//OtherPosition<Product> other = new OtherPosition<>();
		//list.remove(other);
		
		System.out.println(list.toString());
	}
	
	private static class OtherPosition<E> implements Position<E> {
		public E getElement() {
			return null;
		}
		
	}
}







