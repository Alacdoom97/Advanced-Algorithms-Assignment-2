


public class MyItinerary implements A2Itinerary<A2Direction> {
	
	private A2Direction[] path;
	private Coordinates coords;
	private int left, right, up, down, width, height;
	
	public MyItinerary(A2Direction[] course) {
		coords = new Coordinates();
		path = course;
		iterate();
	}

	@Override
	public A2Direction[] rotateRight() {
		for(int i = 0; i < path.length; i++) {
			if(path[i] == A2Direction.LEFT) {
				path[i] = A2Direction.UP;
			} else if(path[i] == A2Direction.UP) {
				path[i] = A2Direction.RIGHT;
			} else if(path[i] == A2Direction.RIGHT) {
				path[i] = A2Direction.DOWN;
			} else {
				path[i] = A2Direction.LEFT;
			}
		}
		return path;
	}

	@Override
	public int widthOfItinerary() {
		int diff = Math.abs((left-right));
		int currentWidth;
		
		if(diff == 0) {
			return left;
		} else if(diff % 2 == 1) {
			currentWidth = ((left + right)/2) + 1;
		} else {
			if(right < left) {
				currentWidth = left;
			}
			else {
				currentWidth = right;
			}
			
		}
		
		return currentWidth;
	}

	@Override
	public int heightOfItinerary() {
		
		return 0;
	}

	@Override
	public int[] getIntersections() {
		
		return null;
	}
	
	public void iterate() {
		for(A2Direction a : path) {
			if(a == A2Direction.LEFT) {
				left++;
			} else if(a == A2Direction.UP) {
				up++;
			} else if(a == A2Direction.RIGHT) {
				right++;
			} else {
				down++;
			}
			System.out.print(a + " ");
		}
		System.out.println(" ");
	}
	
	private class Coordinates {
		int x = 0;
		int y = 0;
		
		private Coordinates() {
			
		}
		
	}
    
}
