import java.util.Arrays;

public class MyMeasure implements A2Measure {

	private int min1, max1, min2, max2, median1, median2;
	private int[] tempArray1, tempArray2;
	
	public MyMeasure(int[] array1, int[] array2) {
		
	}

	@Override
	public boolean isSameCollection(int[] array1, int[] array2) {
		checkAndSort(array1, array2);
		if (array1.length != array2.length) {
			return false;
		}
		for (int i = 0; i < array1.length; i++) {
			if(tempArray1[i] != tempArray2[i]) {
				return false;
			} else {
				continue;
			}
		}
		return true;
	}

	@Override
	public int minDifferences(int[] array1, int[] array2) {
		checkAndSort(array1, array2);
		if (array1.length != array2.length) {
			System.out.println("The 2 arrays' lengths are not the same!");
			return 0;
		}
		int sum = 0;
		
		for (int i = 0; i < array1.length; i++) {
			int diff = 0;
			diff = tempArray1[i] - tempArray2[i];
			sum += (diff*diff);
		}
		return sum	;
	}

	@Override
	public int[] getPercentileRange(int[] arr, int lower, int upper) {
		checkSingleArray(arr);
		int[] percentArray = sortArray(arr, max1);
		int[] newArray = new int[arr.length];
		int arrLength = arr.length;
		float fLower = lower;
		float fHigher = upper;
		int lowPer = Math.round(fLower/100 * arrLength);
		int highPer = Math.round(fHigher/100 * arrLength);
		
		for (int i = lowPer; i < highPer; i++) {
			newArray[i] = percentArray[i];
		}
		
		
		return newArray;
	}

	public void checkArray(int[] arr, int[] arr2) {
		int tempMin = 0;
		int tempMin2 = 0;
		int tempMax = 0;
		int tempMax2 = 0;
		for (int i : arr) {
			if (i < tempMin) {
				tempMin = i;
				min1 = tempMin;
			} else if (i > tempMax) {
				tempMax = i;
				max1 = tempMax;
			}
		}
		for (int i : arr2) {
			if (i < tempMin2) {
				tempMin2 = i;
				min2 = tempMin2;
			} else if (i > tempMax2) {
				tempMax2 = i;
				max2 = tempMax2;
			}
		}
	}
	
	private void checkSingleArray(int[] arr) {
		int tempMin = 0;
		int tempMin2 = 0;
		int tempMax = 0;
		int tempMax2 = 0;
		for (int i : arr) {
			if (i < tempMin) {
				tempMin = i;
				min1 = tempMin;
			} else if (i > tempMax) {
				tempMax = i;
				max1 = tempMax;
			}
		}
	}

	private int[] sortArray(int[] arr, int maxValue) {
		
	    int numCounts[] = new int[maxValue + 1];

	    
	    for (int num : arr) {
	        numCounts[num]++;
	    }

	    int[] sortedArray = new int[arr.length];
	    int currentSortedIndex = 0;

	    
	    for (int num = 0; num < numCounts.length; num++) {
	        int count = numCounts[num];

	        for (int i = 0; i < count; i++) {

	            sortedArray[currentSortedIndex] = num;
	            currentSortedIndex++;
	        }
	    }

	    return sortedArray;
	}
	
	private void checkAndSort(int [] array1, int [] array2) {
		checkArray(array1, array2);
		tempArray1 = sortArray(array1, max1);
		tempArray2 = sortArray(array2, max2);
	}

}
