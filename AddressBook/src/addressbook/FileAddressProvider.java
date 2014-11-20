package addressbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileAddressProvider extends AddressProvider {

	public String name = "file";

	public List<Contact> provideAddresses() {
		return contacts;
	}

	public String getName() {
		return name;
	}
	public void readContacts(){
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("contacts.csv");
			br = new BufferedReader(fr);
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
				if (fr!=null) fr.close();
			}catch (IOException e){
				System.err.println("Error2 :" +e);
			}
		
		}
	}
	
	
}