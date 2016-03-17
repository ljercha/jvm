import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PojoToJson {
	
	public static String toJson(Object o) throws IllegalArgumentException, IllegalAccessException {

	Class objectClass = o.getClass();

	Field[] field = objectClass.getDeclaredFields();
	
	StringBuilder sb = new StringBuilder("{");

	for(int i=0;i<field.length;i++) {
		field[i].setAccessible(true);
		
		if(Collection.class.isAssignableFrom(field[i].getType())) 
		{			
			Iterator items =  ((Collection) field[i].get(o)).iterator();
			sb.append("\"" + field[i].getName() + "\":[");
			while(items.hasNext())
			{

				Object tmp = items.next();
				boolean singleField = tmp.getClass().equals(String.class);

				if(singleField)
					sb.append("\"");
				sb.append(tmp);
				if(singleField)
					sb.append("\"");
				if(items.hasNext())
						sb.append(",");

				}
			sb.append("]");
			if(i < field.length-1) 
				sb.append(",");
			else
				sb.append("}");
			
		}
		else
		{
			
		sb.append("\"");
		
		sb.append(field[i].getName());
		sb.append("\":");
		boolean singleField = field[i].get(o).getClass().equals(String.class);
		
		if(singleField)
			sb.append("\"");
		if(field[i] != null)
			sb.append(field[i].get(o));
		else
			sb.append("null");
		if(singleField)
			sb.append("\"");
		if(i < field.length-1) 
			sb.append(",");
		else
			sb.append("}");
		}
	}
	return sb.toString();	
	}
}
