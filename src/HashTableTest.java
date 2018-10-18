
public class HashTableTest {

	public static void main(String[] args) {
		System.out.println("BEGIN MARCH SPARTANS!!!!");
		MyHashTable hashy = new MyHashTable(13);
		System.out.println("Starting");

		long startTime = System.currentTimeMillis();
		System.out.println("Counting started: " + startTime);

		System.out.println("Checking... (no more output means success)");
		
		hashy.insert(59);
		hashy.insert(21);
		hashy.insert(23);

		long endTime = System.currentTimeMillis();

		System.out.println("Elapsed time: " + (endTime - startTime));
	}

}
