package lab06;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThreadSafeLocal {

	  private ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {

	        @Override
	        protected DateFormat initialValue() {
	            return new SimpleDateFormat("dd-MM-yyyy");
	        } 
	    };
	    

	    public Date parse(String dateString) throws ParseException {
	        return df.get().parse(dateString);
	    } 

		public static void main(String[] args) {
			
	        final ThreadSafeLocal tl = new ThreadSafeLocal();

	        ExecutorService executorService = Executors.newFixedThreadPool(2);

	        Runnable run = new Runnable() {
	            public void run() {
	                while (true) {
	                    try {
	                        tl.parse("2016-03-03");
	                    } catch (ParseException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        };
	        executorService.execute(run);
	        executorService.execute(run);

	        executorService.shutdown();
	    }
}
