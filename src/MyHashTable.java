
/*Method based from Allen Weiss' book 
 "Data Structures and Algorithm Analysis in Java" - Chapter 5 */
public class MyHashTable<T> implements A2HashTable<T> {
	
	private static final int DEFAULT_TABLE_SIZE = 20;
	private HashEntry<T>[] array;
	private int currentSize;
	
	public MyHashTable() {
		this(DEFAULT_TABLE_SIZE);
		System.out.println("Created table!");
	}
	
	public MyHashTable(int size) {
		newCells(size);
		emptyCells();
	}

	@Override
	public void insert(T element) {
		int currentPos = findPos(element);
		if(isActive(currentPos)) {
			rehash();
			return;
		}
		
		array[currentPos] = new HashEntry<>(element, true);
		
		if(++currentSize > (array.length/2)) { //The load factor is higher
			rehash();
		}
	}

	@Override
	public void delete(T element) {
	int currentPos = findPos(element);
	if (isActive(currentPos)) {
		array[currentPos].isActive = false;
	}
		
	}

	@Override
	public boolean contains(T element) {
		int currentPos = findPos(element);
		return isActive(currentPos);
	}
	
	private void rehash( )
    {
        HashEntry<T> [ ] oldArray = array;

            // Create duplicate table
        newCells( 2 * oldArray.length );
        currentSize = 0;

            // Copy table
        for( HashEntry<T> entry : oldArray )
            if( entry != null && entry.isActive )
                insert( entry.element );
   }
	
	private void newCells(int size) {
		array = new HashEntry[nextPrime(size)];
	}
	
	private int findPos(T element) {
		int offset = 1;
		int currentPos = getHash(element);
		
		while(array[currentPos] != null && !array[currentPos].element.equals(element)) {
			currentPos += offset;
			offset += 2;
			if(currentPos >= array.length) {
				currentPos -= array.length;
			}
		}
		return currentPos;
	}
	
	private int getHash( T element ) {
        int value = element.hashCode( );

        value %= array.length;
        if( value < 0 )
            value += array.length;

        return value;
    }
	
	private void emptyCells() {
		currentSize = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}
	
	private boolean isActive( int currentPos )
	{
	 return array[ currentPos ] != null && array[ currentPos ].isActive;
	}
	
	private int nextPrime(int number) {
		if( number % 2 == 0 )
            number++;

        for( ; !isPrime( number ); number += 2 )
            ;

        return number;
	}
	
	private boolean isPrime(int prime) {
		for (int i = 2; i <=prime; i++) {
			if(prime % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private class HashEntry<T> {
	public T element;
	public boolean isActive;
	
	public HashEntry( T e ) {
		this( e, true ); 
	}
	public HashEntry( T e, boolean i ) {
		element = e; isActive = i; }
	}

}
