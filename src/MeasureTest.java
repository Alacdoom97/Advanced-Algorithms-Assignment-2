
public class MeasureTest {

	public static void main(String[] args) {
		int[] array1 = new int[] {9, 3, 1, 0};
		int[] array2 = new int[] {9, 3, 1, 0};
		
		MyMeasure mm = new MyMeasure();
		
		
		if(mm.isSameCollection(array1, array2)) {
			System.out.println("The collection is the same!");
		}
		else {
			System.out.println("The collections are not the same!");
		}
	}

}
