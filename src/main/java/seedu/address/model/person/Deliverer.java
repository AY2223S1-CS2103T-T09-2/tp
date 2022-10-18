package seedu.address.model.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.order.Order;
import seedu.address.model.tag.Tag;

/**
 * Represents a deliverer.
 */
public class Deliverer extends Person {

    private final List<Order> orders;

    /**
     * Constructs a deliverer object.
     *
     * @param personCategory By default, it should be PersonCategory.Deliverer
     * @param name The name of this person.
     * @param phone The phone number in string.
     * @param email The email, which will be checked against regex.
     * @param address The address of this person, which will be checked against the regex.
     * @param tags The tags of this person.
     * @param orders The orders that this deliverer is dispatched.
     */
    public Deliverer(PersonCategory personCategory,
                     Name name,
                     Phone phone,
                     Email email,
                     Address address,
                     Set<Tag> tags, List<Order> orders) {
        super(PersonCategory.DELIVERER, name, phone, email, address, tags);
        this.orders = orders;
    }

    /**
     * Constructs a deliverer object.
     * By default, it should be PersonCategory.Deliverer
     *
     * @param name The name of this person.
     * @param phone The phone number in string.
     * @param email The email, which will be checked against regex.
     * @param address The address of this person, which will be checked against the regex.
     * @param tags The tags of this person.
     * @param orders The orders that this deliverer is dispatched.
     */
    public Deliverer(Name name,
                     Phone phone,
                     Email email,
                     Address address,
                     Set<Tag> tags, List<Order> orders) {
        super(PersonCategory.DELIVERER, name, phone, email, address, tags);
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Compares a deliverer with another deliverer in default way in terms of the number of orders that they have.
     * @param deliverer The other buyer being compared.
     * @return The method returns 0 if the deliverer and the other deliverer has the same number of orders.
     *      A value less than 0 is returned if the deliverer has less order than the other deliverer,
     *      and a value greater than 0 if the deliverer has more order than the other deliverer.
     */
    public int compareTo(Deliverer deliverer) {
        return this.orders.size() - deliverer.orders.size();
    }

    /**
     * Converts the delverer's orders from a {@code List} to a {@code ObservableList} and returns the result.
     * @return An {@code ObservableList} instance containing all the deliverer's orders.
     */
    public ObservableList<Order> getOrdersAsObservableList() {
        // TODO: should be FXCollections.observableList(getOrders()) but it causes exception
        return FXCollections.observableList(getOrders() == null ? new ArrayList<>() : getOrders());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other instanceof Deliverer) {
            Deliverer otherDeliverer = (Deliverer) other;
            return super.equals(otherDeliverer) && orders.equals(otherDeliverer.orders);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone(), getEmail(), getAddress(), getTags(), orders);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 1;
        builder.append(super.toString()).append(System.lineSeparator()).append(System.lineSeparator())
                .append("Orders received").append(System.lineSeparator());

        if (orders != null) {
            for (Order order : orders) {
                builder.append("======== Order ").append(i).append(" ========").append(System.lineSeparator())
                        .append("Buyer: ").append(order.getBuyer().getName()).append(System.lineSeparator())
                        .append(order.toString()).append(System.lineSeparator());
                i++;
            }
        }

        return builder.toString();
    }

}
