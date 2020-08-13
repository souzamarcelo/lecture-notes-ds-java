package search.sequential;

import entities.Product;
import linear.list.ArrayList;
import linear.list.List;

public class TestSequentialSearch {

	public static void main(String[] args) {
		
		System.out.println("Simple search test...");
		SimpleSequentialSearch simpleSearch = new SimpleSequentialSearch();
		
		int[] intArray = {5, 4, 1, 8, 19, 33, 12, 4, 9};
		System.out.println("Position of element 19: " + simpleSearch.search(intArray, 19));
		System.out.println("Position of element 4: " + simpleSearch.search(intArray, 4));
		System.out.println("Position of element 25: " + simpleSearch.search(intArray, 25));
		
		String[] stringArray = {"Brasil", "Argentina", "França", "Japão", "Canadá"};
		System.out.println("Position of element Japão: " + simpleSearch.search(stringArray, "Japão"));
		System.out.println("Position of element Argentina: " + simpleSearch.search(stringArray, "Argentina"));
		System.out.println("Position of element Portugal: " + simpleSearch.search(stringArray, "Portugal"));
		System.out.println();
		
		System.out.println("Generic array search...");
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(0, new Student("João", 20));
		studentList.add(0, new Student("Maria", 33));
		studentList.add(0, new Student("Ana", 24));
		studentList.add(0, new Student("José", 53));
		
		Student[] studentArray = {
				new Student("Manuel", 30),
				new Student("Pedro", 18),
				new Student("Isabela", 42),
				new Student("Luiza", 21)
		};
		
		GenericSequentialSearch<Student> searchStudent = new GenericSequentialSearch<>();
		System.out.println(searchStudent.indexOf(studentList, new Student("Ana", 24)));
		System.out.println(searchStudent.indexOf(studentArray, new Student("Ana", 24)));
		System.out.println(searchStudent.indexOf(studentList, new Student("Luiza", 21)));
		System.out.println(searchStudent.indexOf(studentArray, new Student("Luiza", 21)));
		System.out.println(searchStudent.indexOf(studentList, new Student("Pedro", 30)));
		System.out.println(searchStudent.indexOf(studentArray, new Student("Pedro", 30)));
		System.out.println();
		
		System.out.println("Searching element by key...");
		List<Entry<MyKey, Product>> entryList = new ArrayList<>();
		entryList.add(0, new TestEntry<MyKey, Product>(new MyKey(1, 2), new Product("Camiseta", 150d)));
		entryList.add(0, new TestEntry<MyKey, Product>(new MyKey(3, 4), new Product("Calça", 170d)));
		entryList.add(0, new TestEntry<MyKey, Product>(new MyKey(3, 6), new Product("Tênis", 280d)));
		entryList.add(0, new TestEntry<MyKey, Product>(new MyKey(2, 8), new Product("Jaqueta", 450d)));
		System.out.println(entryList.toString());
		
		GenericSequentialEntrySearch<MyKey, Product> searchEntry = new GenericSequentialEntrySearch<>();
		System.out.println(searchEntry.searchElement(entryList, new MyKey(1, 2)));
		System.out.println(searchEntry.searchElement(entryList, new MyKey(3, 6)));
		if(searchEntry.searchElement(entryList, new MyKey(3, 8)) == null)
			System.out.println("Key not found!");
		System.out.println();
	}
	

	private static class Student implements Comparable<Student> {
		String name;
		int age;
		
		public Student(String n, int a) {
			name = n;
			age = a;
		}

		public int compareTo(Student o) {
			if(name.equals(o.name) && age == o.age)
				return 0;
			else if(!name.equals(o.name))
				return name.compareTo(o.name);
			else
				return ((Integer)age).compareTo(o.age);
		}
	}
	
	private static class TestEntry<K, V> implements Entry<K, V> {
		K key;
		V value;
		
		public TestEntry(K k, V v) {
			key = k;
			value = v;
		}
		
		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
		
		public String toString() {
			return key.toString() + "/" + value.toString();
		}
	}
	
	private static class MyKey implements Comparable<MyKey> {
		int a, b;

		public MyKey(int _a, int _b) {
			a = _a;
			b = _b;
		}
		
		public String toString() {
			return a + ";" + b;
		}

		public int compareTo(MyKey o) {
			if(this.a + this.b == o.a + o.b)
				return 0;
			else if((this.a + this.b) < (o.a + o.b))
				return -1;
			else
				return 1;
		}
	}
}