package seedu.address.model.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.order.Order;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Buyer[] getSampleBuyers() {
        return new Buyer[] {
            new Buyer(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends"), null),
            new Buyer(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends"), null),
            new Buyer(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours"), null),
            new Buyer(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family"), null),
            new Buyer(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates"), null),
            new Buyer(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"), null)
        };
    }

//    public static Supplier[] getSampleSuppliers() {
//        return new Supplier[] {
//                new Supplier(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
//                        new Address("Blk 30 Geylang Street 29, #06-40"),
//                        getTagSet("friends")),
//                new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
//                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
//                        getTagSet("colleagues", "friends")),
//                new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
//                        new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
//                        getTagSet("neighbours")),
//                new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
//                        new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
//                        getTagSet("family")),
//                new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
//                        new Address("Blk 47 Tampines Street 20, #17-35"),
//                        getTagSet("classmates")),
//                new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
//                        new Address("Blk 45 Aljunied Street 85, #11-31"),
//                        getTagSet("colleagues"))
//        };
//    }
//
//    public static Deliverer[] getSamplePersons() {
//        return new Person[] {
//                new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
//                        new Address("Blk 30 Geylang Street 29, #06-40"),
//                        getTagSet("friends")),
//                new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
//                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
//                        getTagSet("colleagues", "friends")),
//                new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
//                        new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
//                        getTagSet("neighbours")),
//                new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
//                        new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
//                        getTagSet("family")),
//                new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
//                        new Address("Blk 47 Tampines Street 20, #17-35"),
//                        getTagSet("classmates")),
//                new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
//                        new Address("Blk 45 Aljunied Street 85, #11-31"),
//                        getTagSet("colleagues"))
//        };
//    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Buyer sampleBuyer : getSampleBuyers()) {
            sampleAb.addBuyer(sampleBuyer);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a list of Orders containing the list of strings given.
     */
    public static List<Order> getOrderList() {
        return null;
    }

}
