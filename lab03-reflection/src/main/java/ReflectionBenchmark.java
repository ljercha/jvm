import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionBenchmark {

	static ArrayList<Long> methodTimeReflection = new ArrayList<Long>();
	static ArrayList<Long> methodTimesNormal = new ArrayList<Long>();
	static ArrayList<Long> readTimesReflection = new ArrayList<Long>();
	static ArrayList<Long> readTimesNormal = new ArrayList<Long>();
	static ArrayList<Long> saveTimesReflection = new ArrayList<Long>();
	static ArrayList<Long> savedTimesNormal = new ArrayList<Long>();
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		// TODO Auto-generated method stub
		
		Class<Foo> reflection = (Class<Foo>) Class.forName("Foo");
		Method  method = reflection.getDeclaredMethod ("silniaIteracyjne", int.class);
		
	    Method[] allMethods = reflection.getDeclaredMethods();
	    Object o = reflection.newInstance();
		
		Foo normal = new Foo();
		
		for(int i = 5000;i < 25000;i++)
		{
			long startTime = System.nanoTime();
			method.invoke (o, 10);
			long stopTime = System.nanoTime();
			methodTimeReflection.add(stopTime - startTime);
			
			long startTime2 = System.nanoTime();
			normal.silniaIteracyjne(10); 
			long stopTime2 = System.nanoTime();
			methodTimesNormal.add(stopTime2 - startTime2);
			
			
			Field readField;
			int data;
			startTime = System.nanoTime();
			readField = reflection.getDeclaredField("odczyt");
			data = readField.getInt(o);
			stopTime = System.nanoTime();
			readTimesReflection.add(stopTime - startTime);
			

			int data2;
			startTime = System.nanoTime();
			data2 = normal.odczyt;
			stopTime = System.nanoTime();
			readTimesNormal.add(stopTime - startTime);
			
			
			Field saveField;
			startTime = System.nanoTime();
			saveField = reflection.getDeclaredField("zapis");
			saveField.setInt(o, 30000);
			stopTime = System.nanoTime();
			saveTimesReflection.add(stopTime - startTime);
			

			startTime = System.nanoTime();
			normal.zapis = 30000;
			stopTime = System.nanoTime();
			savedTimesNormal.add(stopTime - startTime);
			
			
			
			
			//System.out.println("REFLEKSJA:" + (stopTime - startTime));

			
			//System.out.println("NORMAL:" + (stopTime2 - startTime2));
		}
		
		System.out.println("REFLEKSJA wywolanie metody:" + average(methodTimeReflection) + " ns");
		System.out.println("REFLEKSJA odczytanie zmiennej:"+ average(readTimesReflection) + " ns");
		System.out.println("REFLEKSJA zapisanie zmiennej:"+ average(saveTimesReflection) + " ns");
		

		System.out.println("NORMALNE wywolanie metody:"+ average(methodTimesNormal) + " ns");
		System.out.println("NORMALNE odczytanie zmiennej:"+ average(readTimesNormal) + " ns");
		System.out.println("NORMALNE zapisanie zmiennej:"+ average(savedTimesNormal));


		
		}
	
	
	
	public static double average(List<Long> list) {
	    // 'average' is undefined if there are no elements in the list.
	    if (list == null || list.isEmpty())
	        return 0.0;
	    // Calculate the summation of the elements in the list
	    long sum = 0;
	    int n = list.size();
	    // Iterating manually is faster than using an enhanced for loop.
	    for (int i = 0; i < n; i++)
	        sum += list.get(i);
	    // We don't want to perform an integer division, so the cast is mandatory.
	    return ((double) sum) / n;
	}

	
}
