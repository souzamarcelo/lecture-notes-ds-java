package sort.merge;

import java.util.Comparator;

import linear.list.List;

public class GenericMergeSort<E> {
	
	E[] tempMergArr;
	Comparator<E> comp;
	
	public GenericMergeSort() {
		this(new DefaultComparator<E>());
	}
	
	public GenericMergeSort(Comparator<E> c) {
		comp = c;
	}
	
	public void sort(E[] array) {
        tempMergArr = (E[]) (new Object[array.length]);
        mergeSort(array, 0, array.length - 1);
    }
	
	private void mergeSort(E[] array, int start, int end) {
        if (start < end) {
            int middle = start + ((end - start) / 2);
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            mergeParts(array, start, middle, end);
        }
    }
 
    private void mergeParts(E[] array, int start, int middle, int end) {
 
        for (int i = start; i <= end; i++) {
            tempMergArr[i] = array[i];
        }
        
        int i = start;
        int j = middle + 1;
        int k = start;
        while (i <= middle && j <= end) {
        	if(comp.compare(tempMergArr[i], tempMergArr[j]) < 0) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
    
    public void sort(List<E> array) {
        tempMergArr = (E[]) (new Object[array.size()]);
        mergeSort(array, 0, array.size() - 1);
    }
	
    private void mergeSort(List<E> array, int start, int end) {
        if (start < end) {
            int middle = start + ((end - start) / 2);
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            mergeParts(array, start, middle, end);
        }
    }
 
    private void mergeParts(List<E> array, int start, int middle, int end) {
 
        for (int i = start; i <= end; i++) {
            tempMergArr[i] = array.get(i);
        }
        
        int i = start;
        int j = middle + 1;
        int k = start;
        while (i <= middle && j <= end) {
        	if(comp.compare(tempMergArr[i], tempMergArr[j]) < 0) {
                array.set(k, tempMergArr[i]);
                i++;
            } else {
                array.set(k, tempMergArr[j]);
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array.set(k, tempMergArr[i]);
            k++;
            i++;
        }
    }
}
