package sort.merge;

import java.util.Arrays;
import linear.list.ArrayList;
import linear.list.List;

public class TestMergeSort {

	public static void main(String[] args) {
		
		System.out.println("Testing simple merge sort...");
		int[] intArray = {11, 5, 1, 18, 4, 4, 6, 12, 3, 9};
		MergeSort mergeSort = new MergeSort();
		System.out.println(Arrays.toString(intArray));
		mergeSort.sort(intArray);
		System.out.println(Arrays.toString(intArray));
		System.out.println();
		
		GenericMergeSort<Card> genericMergeSort = new GenericMergeSort<>();
		
		System.out.println("Testing generic merge sort on an array...");
		Card[] cardArray = {
				new Card(3, 'A'),
				new Card(6, 'B'),
				new Card(1, 'B'),
				new Card(4, 'B'),
				new Card(8, 'A'),
				new Card(1, 'B'),
				new Card(12, 'B'),
				new Card(7, 'A'),
				new Card(6, 'A')
		};
		
		
		System.out.println(Arrays.toString(cardArray));
		genericMergeSort.sort(cardArray);
		System.out.println(Arrays.toString(cardArray));
		System.out.println();
		
		System.out.println("Testing generic merge sort on a list...");
		List<Card> cardList = new ArrayList<>();
		cardList.add(0, new Card(3, 'A'));
		cardList.add(0, new Card(6, 'B'));
		cardList.add(0, new Card(1, 'B'));
		cardList.add(0, new Card(4, 'B'));
		cardList.add(0, new Card(8, 'A'));
		cardList.add(0, new Card(1, 'B'));
		cardList.add(0, new Card(12, 'B'));
		cardList.add(0, new Card(7, 'A'));
		cardList.add(0, new Card(6, 'A'));
		System.out.println(cardList.toString());
		genericMergeSort.sort(cardList);
		System.out.println(cardList.toString());
		System.out.println();
	}
	
	private static class Card implements Comparable<Card> {
		int number;
		char suit;
		
		public Card(int n, char s) {
			number = n;
			suit = s;
		}
		
		public int compareTo(Card o) {
			int x = ((Integer) number).compareTo(o.number);
			if(x != 0) {
				return x;
			} else {
				if(suit == 'A' && o.suit == 'B')
					return -1;
				if(suit == 'B' && o.suit == 'A')
					return 1;
			}
			return 0;
		}
		
		public String toString() {
			return "[" + number + " " + suit + "]";
		}
	}
}