package serializacja;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

public abstract class BaseSerializer {

	public long testSerialization(List<Login> logins) throws FileNotFoundException, IOException, JAXBException {
		long t1 = System.currentTimeMillis();
		serialize(logins);
		long processingTime = System.currentTimeMillis() - t1;
		return processingTime;
	}
	
	public long testDeserialization(List<Login> logins) throws FileNotFoundException, IOException, ClassNotFoundException, JAXBException {
		long t1 = System.currentTimeMillis();
		deserialize();
		long processingTime = System.currentTimeMillis() - t1;
		return processingTime;
	}
	
	protected abstract void serialize(List<Login> logins) throws FileNotFoundException, IOException, JAXBException;

	protected abstract void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException, JAXBException;
	
}
