import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionBenchmark {

	static ArrayList<Long> methodTimeReflection = new ArrayList<Long>();
	static ArrayList<Long> methodTimesNormal = new ArrayList<Long>();

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		
		Class<Foo> reflection = (Class<Foo>) Class.forName("Foo");
		Method  method = reflection.getDeclaredMethod ("silniaRekurencyjnie", Long.class);
		
		Foo normal = new Foo();
		
		for(int i = 2000;i < 12000;i++)
		{
			long startTime = System.nanoTime();
			method.invoke (reflection, 10);
			long stopTime = System.nanoTime();
			methodTimeReflection.add(stopTime - startTime);

			long startTime2 = System.nanoTime();
			normal.silniaIteracyjne(10); 
			long stopTime2 = System.nanoTime();
			methodTimesNormal.add(stopTime2 - startTime2);
			
		}
		}
	
	

	
}
