import java.util.Arrays;

public class ItineraryTest {

	public static void main(String[] args) {
		A2Direction[] a2 = new A2Direction[] {A2Direction.RIGHT, A2Direction.RIGHT, A2Direction.RIGHT, A2Direction.DOWN, A2Direction.LEFT, A2Direction.LEFT, A2Direction.UP, A2Direction.UP,
												A2Direction.RIGHT, A2Direction.DOWN, A2Direction.DOWN};
		MyItinerary mi = new MyItinerary(a2);
		
		System.out.println("Width of Itinerary before rotation: " + mi.widthOfItinerary());
		System.out.println("Height of Itinerary before rotation: " + mi.heightOfItinerary());
		System.out.println(" ");
		System.out.print("[");
		for (int i = 0; i < mi.getIntersections().length; i++) {
			if (mi.getIntersections()[i] != 0) {
				System.out.print(mi.getIntersections()[i] + ", ");
			}
		}
		System.out.println("]");
		System.out.println(" ");
		mi.rotateRight();
		System.out.println("Width of Itinerary after rotation: " + mi.widthOfItinerary());
		System.out.println("Height of Itinerary after rotation: " + mi.heightOfItinerary());
		System.out.println(" ");
		System.out.print("[");
		for (int i = 0; i < mi.getIntersections().length; i++) {
			if (mi.getIntersections()[i] != 0) {
				System.out.print(mi.getIntersections()[i] + ",");
			}
		}
		System.out.println("]");
		System.out.println(" ");
	}

}
