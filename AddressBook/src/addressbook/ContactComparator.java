package addressbook;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {

	private boolean sortByFirstName;
	private boolean sortByLastName;
	
	@Override
	public int compare(Contact arg0, Contact arg1) {
		String firstname = arg0.firstName;
		String firstname2 = arg1.firstName;
		String lastname = arg0.lastName;
		String lastname2 = arg1.lastName;

		if (sortByLastName == true && sortByFirstName == false){
			return lastname.compareToIgnoreCase(lastname2);
		}
		else if (sortByLastName == false && sortByFirstName == true){
			return firstname.compareToIgnoreCase(firstname2);
		}
		else{
			int tmp = lastname.compareToIgnoreCase(lastname2);
			if (tmp == 0){
				return firstname.compareToIgnoreCase(firstname2);
			}
			else{
				return tmp;
			}
		}
	}
	
	public ContactComparator(boolean sortByFirstName, boolean sortByLastName){
		this.sortByFirstName = sortByFirstName;
		this.sortByLastName = sortByLastName;
	}
}
