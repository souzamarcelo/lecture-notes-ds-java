package linear.stack;

import entities.Product;

public class TestArrayStack {
	
	static ArrayStack<Product> stack = new ArrayStack<>(); 
	
	public static void main(String[] args) {
		
		stack.push(new Product("Camisa", 80d));
		stack.push(new Product("Tênis", 200d));
		stack.push(new Product("Meia", 15d));
		stack.push(new Product("Calça", 150d));
		System.out.println(stack.toString());
		System.out.println(stack.pop().toString());
		System.out.println(stack.top().toString());
		System.out.println(stack.toString());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.isEmpty());
	}
}
