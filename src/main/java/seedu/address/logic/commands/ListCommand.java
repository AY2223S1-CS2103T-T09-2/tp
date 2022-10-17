package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredBuyerList(Model.PREDICATE_SHOW_ALL_BUYERS);
        model.updateFilteredSupplierList(Model.PREDICATE_SHOW_ALL_SUPPLIERS);
        model.updateFilteredDelivererList(Model.PREDICATE_SHOW_ALL_DELIVERERS);
        model.updateFilteredPetList(Model.PREDICATE_SHOW_ALL_PETS);
        model.updateFilteredOrderList(Model.PREDICATE_SHOW_ALL_ORDERS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
