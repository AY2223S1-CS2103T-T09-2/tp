package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.order.Order;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    private Order order;

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final PersonCategory personCategory;

    // Data fields
    private final Address address;
    private final Location location;
    private final Set<Tag> tags = new HashSet<>();


    /**
     * Every field must be present and not null, except Location, which is
     * set by default to Singapore.
     */
    public Person(PersonCategory personCategory, Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(personCategory, name, phone, email, address, tags);
        this.personCategory = personCategory;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.location = new Location("Singapore");
        this.tags.addAll(tags);
    }

    /**
     * Every field must be present and not null.
     */
    public Person(PersonCategory personCategory,
                  Name name,
                  Phone phone,
                  Email email,
                  Address address,
                  Location location,
                  Set<Tag> tags) {
        requireAllNonNull(personCategory, name, phone, email, address, tags);
        this.personCategory = personCategory;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.location = location;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }


    public Location getLocation() {
        return location;
    }

    public PersonCategory getPersonCategory() {
        return personCategory;
    }


    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getPersonCategory().equals(getPersonCategory())
                && otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getAddress().equals(getAddress())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(personCategory, name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress())
                .append("; Location: ")
                .append(getLocation());
        return builder.toString();
    }

}
