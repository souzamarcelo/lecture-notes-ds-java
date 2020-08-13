package sort.insertion;

public class InsertionSort {
	
	public void sort(int[] array) {
		int temp;
		for(int i = 1; i < array.length; i++) {
			for(int j = i ; j > 0 ; j--){
                if(array[j] < array[j - 1]){
                    swap(j, j - 1, array);
                }
            }
		}
	}
	
	private void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
