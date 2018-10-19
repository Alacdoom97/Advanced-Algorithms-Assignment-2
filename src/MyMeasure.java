
public class MyMeasure implements A2Measure {

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

}
