package search.sequential;

public class SimpleSequentialSearch {
	
	public int search(int[] array, int value) {
		for(int i = 0; i < array.length; i++)
			if(array[i] == value)
				return i;
		
		return -1;
	}
	
	public int search(String[] array, String value) {
		for(int i = 0; i < array.length; i++)
			if(array[i].equals(value))
				return i;
		
		return -1;
	}
}
