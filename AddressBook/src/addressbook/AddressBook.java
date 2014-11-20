package addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddressBook {
	public List<AddressProvider> addressProvider = new ArrayList<AddressProvider>();

	// interface???

	public static void main(String[] args) {

		AddressBook addressBook = new AddressBook();
		addressBook.addressProvider.add(new FixedAddressProvider());
		addressBook.addressProvider.add(new FileAddressProvider());

		if (args.length > 0){
			if(addressBook.checkCommand(args[0])){
				addressBook.processCommand(args);
			}
			else {
				System.out.println("Ungültige Eingabe. Nutze 'list', 'search' oder 'search2'.");
				System.exit(0);
			}
		}
		else {
			System.out.println("Ungültige Eingabe. Nutze 'list', 'search' oder 'search2'.");
			System.exit(0);
		}
	}
	
	public boolean checkCommand(String command){
		if (command.toLowerCase().equals("list")){
			return true;
		}
		else if 
		(command.toLowerCase().equals("search")){
			return true;
		}
		else if 
		(command.toLowerCase().equals("search2")){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void processCommand(String[] args){
		if (args[0].toLowerCase().equals("list")){
			processListCommand(args);
		}
		else if 
		(args[0].toLowerCase().equals("search")){
			processSearchCommand(args);
		}
		else if 
		(args[0].toLowerCase().equals("search2")){
			processSearch2Command(args);
		}
	}
	
	public void processListCommand(String[] args){
		if (args.length > 1){
			System.out.println("Provider: " + args[1]);
			AddressProvider addressProvider = searchAddressProvider(args[1]);
			if (addressProvider == null){
				System.out.println("Der gewählte Adresslieferant ist nicht vorhanden.");
				System.exit(0);
			}
			else listAddressProviderContacts(addressProvider.provideAddresses());
		}
		else listAllAddressProviderContacts();
	}
	
	public AddressProvider searchAddressProvider(String addressProviderName){
		for (int i=0; i<addressProvider.size(); i++){
			if (addressProviderName.toLowerCase().equals(addressProvider.get(i).getName())){
				return addressProvider.get(i);
			}
		}
		return null;
	}
	
	public void listAddressProviderContacts(List<Contact> contacts){
		if (contacts.size()==0){
			System.out.println("Es sind keine Kontakte vorhanden.");
			System.exit(0);
		}
		else
			for (int i=0; i<contacts.size(); i++){
				System.out.println(contacts.get(i));
			}
	}
	
	public void listAllAddressProviderContacts(){
		List<Contact> allContacts = new ArrayList<Contact>();
		for (int i=0; i<addressProvider.size(); i++){
			allContacts.addAll(addressProvider.get(i).contacts);
		}
		listAddressProviderContacts(allContacts);
	}
	
	public void processSearchCommand(String[] args){
		if (args.length == 2 ){
			searchSurname(addressProvider, args[1]);
		}
		else if (args.length == 3){
			AddressProvider source = searchAddressProvider(args[1]);
			if (source != null){
				List<AddressProvider> sourceList = new ArrayList<AddressProvider>();
				sourceList.add(source);
				searchSurname(sourceList, args[2]);
			}
			else{
				System.out.println("Der gewählte Adresslieferant ist nicht vorhanden.");
			}
		}
	}
	
	public void searchSurname(List<AddressProvider> addressProvidersToSearch, String surname){
		boolean found = false;
		List<Contact> currentContactList = new ArrayList<Contact>();
		for (int i = 0; i < addressProvidersToSearch.size(); i++){
			AddressProvider searchedAddressProvider = addressProvidersToSearch.get(i);
			List<Contact> providerContacts = searchedAddressProvider.provideAddresses();
			for (int j = 0; j < providerContacts.size(); j++ ){
				Contact currentContact = providerContacts.get(j);
				if (currentContact.lastName.equalsIgnoreCase(surname)){
					currentContactList.add(currentContact);
					found = true;
				}
			}
		}
		sortContacts(currentContactList, false, false, true);
		System.out.println(currentContactList);	
		if (found == false){
			System.out.println("Es sind keine Kontakte vorhanden.");
		}
	}
	
	public void processSearch2Command(String[] args){
		if (args.length == 2){
			searchGivenName(addressProvider, args[1]);
		}
		else if (args.length == 3){
			AddressProvider source = searchAddressProvider(args[0]);
			if (source != null){
				List<AddressProvider> sourceList = new ArrayList<AddressProvider>();
				sourceList.add(source);
				searchGivenName(sourceList, args[2]);
			}
			else{
				System.out.println("Der gewählte Adresslieferant ist nicht vorhanden.");
			}
		}
	}
	
	public void searchGivenName(List<AddressProvider> addressProvidersToSearch, String givenName){
		boolean found = false;
		List<Contact> currentContactList = new ArrayList<Contact>();
		for (int i = 0; i < addressProvidersToSearch.size(); i++){
			AddressProvider searchedAddressProvider2 = addressProvidersToSearch.get(i);
			for (int j = 0; j < searchedAddressProvider2.contacts.size(); j++){
				Contact currentContact = searchedAddressProvider2.contacts.get(j);
				if (currentContact.firstName.equalsIgnoreCase(givenName)){
					currentContactList.add(currentContact);
					found = true;
				}
			}
		}
		sortContacts(currentContactList, true, true, false);
		System.out.println(currentContactList);
		if (found == false){
			System.out.println("Es sind keine Kontakte vorhanden");
		}
	}

	public List<Contact> sortContacts(List<Contact> unsortetContacts, boolean reverseSort, boolean sortByFirstName, boolean sortByLastName){
		if (reverseSort == true){
			Comparator<Contact> comparator = Collections.reverseOrder(new ContactComparator(sortByFirstName,sortByLastName));
			Collections.sort(unsortetContacts, comparator);
		}
		else{
			Collections.sort(unsortetContacts, new ContactComparator(sortByFirstName, sortByLastName));
		}
		return unsortetContacts;
	}
}
