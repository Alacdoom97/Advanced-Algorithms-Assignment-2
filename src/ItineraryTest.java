
public class ItineraryTest {

	public static void main(String[] args) {
		A2Direction[] a2 = new A2Direction[] {A2Direction.RIGHT, A2Direction.RIGHT, A2Direction.RIGHT, A2Direction.DOWN, A2Direction.LEFT, A2Direction.LEFT, A2Direction.UP, A2Direction.UP,
												A2Direction.RIGHT, A2Direction.DOWN, A2Direction.DOWN};
		MyItinerary mi = new MyItinerary(a2);
		
		System.out.println("Width of Itinerary before rotation: " + mi.widthOfItinerary());
		System.out.println("Height of Itinerary before rotation: " + mi.heightOfItinerary());
		mi.rotateRight();
		System.out.println("Width of Itinerary after rotation: " + mi.widthOfItinerary());
		System.out.println("Height of Itinerary after rotation: " + mi.heightOfItinerary());
	}

}
