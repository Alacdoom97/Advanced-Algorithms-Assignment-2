
public class ItineraryTest {

	public static void main(String[] args) {
		A2Direction[] a2 = new A2Direction[] {A2Direction.LEFT, A2Direction.DOWN, A2Direction.DOWN, A2Direction.RIGHT, A2Direction.UP, A2Direction.LEFT};
		MyItinerary mi = new MyItinerary(a2);
		
		mi.rotateRight();
		System.out.println("Width of Itinerary: " + mi.widthOfItinerary());
	}

}
