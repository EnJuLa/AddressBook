package addressbook;

import java.util.ArrayList;
import java.util.List;

public abstract class AddressProvider {

	public List<Contact> contacts = new ArrayList<Contact>();

	public abstract List<Contact> provideAddresses();

	public abstract String getName();

}



