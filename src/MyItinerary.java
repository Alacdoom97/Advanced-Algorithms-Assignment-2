public class MyItinerary implements A2Itinerary<A2Direction> {
	
	private A2Direction[] path;
	private String[] intersection = new String[100];
	private MyHashTable<Coordinates> mht;
	private Coordinates coords;
	private int minX, minY, maxX, maxY, x, y, width, height, counter;
	
	public MyItinerary(A2Direction[] course) {
		mht = new MyHashTable();
		coords = new Coordinates();
		path = course;
		iterate();
	}

	@Override
	public A2Direction[] rotateRight() {
		mht.emptyCells();
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
		iterate();
		return path;
	}

	@Override
	public int widthOfItinerary() {		
		return maxX-minX;
	}

	@Override
	public int heightOfItinerary() {
		
		return maxY-minY;
	}

	@Override
	public int[] getIntersections() { 
		int[] section = new int[100];
		int count = 0;
		for (int i = 0; i < intersection.length; i++) {
			if(intersection[i] != null) {
				section[count] = i;
				count++;
			}
		}
		return section;
	}
	
	private void addToTable(int a, int b) {
		coords = new Coordinates();
		coords.setX(a);
		coords.setY(b);
		String convert = "(" + a + ", " + b + ")";
		if(!mht.contains(convert)) {
		mht.insert(convert);
		} else {
			intersection[counter] = convert;
		}
	}
	
	public void iterate() {
		minX = 0;
		minY = 0;
		maxX = 0;
		maxY = 0;
		x = 0;
		y = 0;
		counter = 0;
		for(A2Direction a : path) {
			if(a == A2Direction.LEFT) {
				x--;
				if(x < minX) {
					minX = x;
				}
				addToTable(x,y);
			} else if(a == A2Direction.UP) {
				y++;
				if(y > maxY) {
					maxY = y;
				}
				addToTable(x,y);
			} else if(a == A2Direction.RIGHT) {
				x++;
				if(x > maxX) {
					maxX = x;
				}
				addToTable(x,y);
			} else {
				y--;
				if(y < minY) {
					minY = y;
				}
				addToTable(x,y);
			}
			counter++;
			System.out.print(a + " ");
		}
		System.out.println(" ");
	}
	
	private class Coordinates {
		int x = 0;
		int y = 0;
		
		private Coordinates() {
			
		}
		
		public int getX () {
			return x;
		}
		public void setX (int value) {
			x = value;
		}
		public int getY () {
			return y;
		}
		public void setY (int value) {
			y = value;
		}
	}
    
}
