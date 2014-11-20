package addressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class FileAddressProvider extends AddressProvider {

	public String name = "file";

	public List<Contact> provideAddresses() {
		readContacts();
		return contacts;
	}

	public String getName() {
		return name;
	}
	public void readContacts(){
		Reader r = null;
		BufferedReader br = null;
		
		try {
			r = new FileReader("bin/contacts.csv");
			br = new BufferedReader(r);
			while (true){
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
				String [] contactSplitted = line.split(";");
				Contact contact = new Contact(contactSplitted[0],contactSplitted[1],contactSplitted[2],contactSplitted[3],contactSplitted[4],contactSplitted[5], contactSplitted[6]);
				contacts.add(contact);
			}
		} catch (IOException e){
			System.err.println("Error2 :" +e);
		}finally{
			try{
				if (br!= null) br.close();
				if (r!=null) r.close();
			}catch (IOException e){
				System.err.println("Error2 :" +e);
			}
		
		}
	}
	
	
}