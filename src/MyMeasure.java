
public class MyMeasure implements A2Measure {
	
	private int min1, max1, min2, max2, median1, median2;

	@Override
	public boolean isSameCollection(int[] array1, int[] array2) {
		if(array1.length != array2.length) {
		return false;
		} else if (array1.equals(array2)) {
			return true;
		}
		return false;
	}

	@Override
	public int minDifferences(int[] array1, int[] array2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getPercentileRange(int[] arr, int lower, int upper) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void checkArray(int[] arr, int[] arr2) {
		int tempMin = 0;
		int tempMax = 0;
		for (int i : arr) {
			if(i < tempMin ) {
				tempMin = i;
				min1 = tempMin;
			} else if( i > tempMax) {
				tempMax = i;
				max1 = tempMax;
			}
		}
	}
	
	private void sortArray(int[] arr) {
		
	}

}
