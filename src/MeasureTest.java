
public class MeasureTest {

	public static void main(String[] args) {
		int[] array1 = new int[] {2, 5, 3, 9};
		int[] array2 = new int[] {15, 12, 1, 3};
		int[] array3 = new int[] {44, 44, 45, 32, 27, 34, 40, 47, 11, 37};
		
		MyMeasure mm = new MyMeasure(array1, array2);
		
		
		/*if(mm.isSameCollection(array1, array2)) {
			System.out.println("The collection is the same!");
		}
		else {
			System.out.println("The collections are not the same!");
		}*/
		int summ = mm.minDifferences(array1, array2);
		if(summ == 0) {
			System.out.println("");
		} else {
			System.out.println("sum of the differences squared: " + summ);
		}
		int[] temp = mm.getPercentileRange(array3, 25, 55);
		System.out.print("[ ");
		for(int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				System.out.print(temp[i] + " ");
			}
		}
		System.out.println("]");
		
		
	}

}
