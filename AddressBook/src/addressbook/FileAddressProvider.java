package addressbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class FileAddressProvider extends AddressProvider {

	public String name = "file";

	public List<Contact> provideAddresses() {
		return null;
	}

	public String getName() {
		return name;
	}
	public void readContacts() throws IOException{ 	
		FileReader fr = new FileReader("contacts.csv");
		BufferedReader br = new BufferedReader(fr);
		
		String zeile = "";
		
		while (zeile != null){
			processCsvLine(zeile);
			zeile = br.readLine();
		}	
		br.close();
	}
	public processCsvLine(final String data){
		final StringTokenizer st = new StringTokenizer(data, ";");
		while (st.hasMoreTokens()){
			return;
		}
	}
	
}