package lab06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCrash {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

	    Runnable run = new Runnable() {
	        public void run() {
	            while (true) {
	                try {
	                	simpleDateFormat.parse("03-03-2016");
	                } catch (ParseException e) {
	                    System.out.println("Simple date format not multi threading! " + e.getMessage());
	                }
	            }
	        }
	    };
	
	    executorService.execute(run);
	    executorService.execute(run);
	    
	    executorService.shutdown();
	}

}
