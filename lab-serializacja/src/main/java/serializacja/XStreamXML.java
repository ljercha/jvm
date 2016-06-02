package serializacja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.thoughtworks.xstream.XStream;

public class XStreamXML extends BaseSerializer{

	@Override
	protected void serialize(List<Login> logins) throws FileNotFoundException, IOException, JAXBException {
	
		XStream xStream = new XStream();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logins.ser"));
		xStream.alias("List", List.class);
		xStream.alias("Login", Login.class);
		out.writeObject(xStream.toXML(logins));
		out.close();


	}

	@Override
	protected void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException, JAXBException {
	    ObjectInputStream in = new ObjectInputStream(new FileInputStream("logins.ser"));
	    
	    XStream xStream = new XStream();		
		xStream.alias("List", List.class);
		xStream.alias("Login", Login.class);
	    ArrayList<Login> result = (ArrayList<Login>)xStream.fromXML((String) in.readObject());

	    in.close();

	    
	}
	
}

