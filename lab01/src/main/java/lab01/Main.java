package lab01;

public class Main {

	public static long heapSize = 0;
	
	public static void main(String[] args) {
		int i = 0;
		
		try
		{
		BigBoom(i);
		}
		catch(OutOfMemoryError exception)
		{
			System.out.println("We got our OutOfMemoryError expection! " + exception.getMessage());
		}
	}
	
	public static void BigBoom(int n) {
		int[][] tab = new int[1000][1000];
		heapSize += 1000000 * 4; // int = 32 bits
		System.out.println(n + ". Heap size(bytes):" + heapSize);
		BigBoom(n + 1);
	}
}
