package addressbook;

import java.util.List;

public class FixedAddressProvider extends AddressProvider {

	public String name = "fixed";

	public List<Contact> provideAddresses() {
		newContacts();
		return contacts;
	}

	public void newContacts(){
		contacts.add(new Contact("Svenja", "Brandt", "12.12.88", "06995881424", "Stresemannring 7", "63225", "Langen"));
		contacts.add(new Contact("Simon", "Brandt", "05.09.94", "06995882253", "Kurt-Tucholsky-Straﬂe 35", "63329", "Egelsbach" ));
		contacts.add(new Contact("Michael", "Brandt", "10.02.64", "06995883801", "Kurt-Tucholsky-Straﬂe 35", "63329", "Egelsbach"));
		contacts.add(new Contact("Susanne", "Winkel", "30.03.65", "06995880000", "Kurt-Tucolsky-Straﬂe 35", "63229", "Egelsbach"));
		contacts.add(new Contact("Svenja", "Winkel", "02.09.96", "06995881424", "Kurt-Tucholsky-Straﬂe 35", "63329", "Egelsbach"));
		contacts.add(new Contact("Jule", "Winkel", "30.09.98", "06995882253", "Kurt-Tucholsky-Straﬂe 35", "63329", "Egelsbach"));
		contacts.add(new Contact("Ingrid", "Knudtsen", "06.11.45", "06995883801", "Berliner Ring 7", "63225", "Langen" ));
		
		return;
	}

	public String getName() {
		return name;
	}




}
