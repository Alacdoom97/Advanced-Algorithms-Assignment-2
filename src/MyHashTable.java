/*Method based from Allen Weiss' book
 "Data Structures and Algorithm Analysis in Java" - Chapter 5 */
public class MyHashTable<AnyType> implements A2HashTable {

    private static final int DEFAULT_TABLE_SIZE = 17;
    private HashEntry<AnyType>[] array;
    private int currentSize;

    public MyHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    // lambda is currentSize / array.length()
    public MyHashTable(double limit) {
        newCells(limit);
        emptyCells();
    }

    @Override
    public void insert(Object element) {
        int currentPos = findPos(element);
        if (isActive(currentPos)) {
            rehash();
            return;
        }
        array[currentPos] = new HashEntry(element, true);
        if (currentSize / array.length > 0.5)  //Load factor has surpassed the limit of 0.5. Rehash to guarantee an empty position
        {
            rehash();
        }
    }

    @Override
    public void delete(Object element) {
        int currentPos = findPos(element);
        if (isActive(currentPos)) {
            array[currentPos].isActive = false;
        }
    }

    @Override
    public boolean contains(Object element) {
        int currentPos = findPos(element);
        return isActive(currentPos);
    }

    private void rehash() {
        HashEntry<AnyType>[] oldArray = array; // Creating duplicate table
        newCells(2 * oldArray.length);
        currentSize = 0;
        for (HashEntry<AnyType> entry : oldArray) // Copying the table
        {
            if (entry != null && entry.isActive) {
                insert(entry.element);
            }
        }
    }

    private void newCells(double size) {
        array = new HashEntry[(int) nextPrime(size)];
    }

    private int findPos(Object element) {
        int offset = 1;
        int currentPos = getHash(element);
        while (array[currentPos] != null && !array[currentPos].element.equals(element)) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    private int getHash(Object element) {
        int value = element.hashCode();
        value %= array.length;
        if (value < 0) {
            value += array.length;
        }
        return value;
    }

    private void emptyCells() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    private double nextPrime(double number) {
        if (number % 2 == 0) {
            number++;
        }
        while (!isPrime(number)) {
            number += 2;
        }
        return number;
    }

    private boolean isPrime(double prime) {
        if (prime == 2 || prime == 3) {
            return true;
        }
        if (prime == 1 || prime % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= prime; i += 2) {
            if (prime % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public void iterate() {
    	for(MyHashTable<AnyType>.HashEntry<AnyType> a : array) {
    		if(a != null) {
    			if(a.isActive)
    		System.out.println(a.toString() + " ");
    		}
    	}
    }

    private class HashEntry<AnyType> {
        public AnyType element;
        public boolean isActive;

        public HashEntry(AnyType aT) {
            this(aT, true);
        }

        public HashEntry(AnyType aT, boolean i) {
            element = aT;
            isActive = i;
        }
    }
}
