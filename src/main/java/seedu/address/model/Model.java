package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.person.Buyer;
import seedu.address.model.person.Deliverer;

import seedu.address.model.person.Person;
import seedu.address.model.person.Supplier;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Buyer> PREDICATE_SHOW_ALL_BUYERS = unused -> true;
    Predicate<Supplier> PREDICATE_SHOW_ALL_SUPPLIERS = unused -> true;
    Predicate<Deliverer> PREDICATE_SHOW_ALL_DELIVERERS = unused -> true;


    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasBuyer(Buyer buyer);
    boolean hasSupplier(Supplier supplier);
    boolean hasDeliverer(Deliverer person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deleteBuyer(Buyer target);
    void deleteSupplier(Supplier target);
    void deleteDeliverer(Deliverer target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addBuyer(Buyer buyer);
    void addSupplier(Supplier supplier);
    void addDeliverer(Deliverer deliverer);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setBuyer(Buyer target, Buyer editedBuyer);
    void setSupplier(Supplier target, Supplier editedSupplier);
    void setDeliverer(Deliverer target, Deliverer editedDeliverer);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Buyer> getFilteredBuyerList();
    ObservableList<Supplier> getFilteredSupplierList();
    ObservableList<Deliverer> getFilteredDelivererList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredBuyerList(Predicate<Buyer> predicate);
    void updateFilteredSupplierList(Predicate<Supplier> predicate);
    void updateFilteredDelivererList(Predicate<Deliverer> predicate);
}
