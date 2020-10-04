package seedu.address.testutil;

import seedu.address.model.PersonAddressBook;
import seedu.address.model.information.Person;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private PersonAddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new PersonAddressBook();
    }

    public AddressBookBuilder(PersonAddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withPerson(Person person) {
        addressBook.addPerson(person);
        return this;
    }

    public PersonAddressBook build() {
        return addressBook;
    }
}
