package seedu.address.logic.parser;

import seedu.address.logic.commands.AddBuyerCommand;
import seedu.address.logic.commands.AddPersonCommand;
import seedu.address.logic.commands.AddSupplierCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.order.Order;
import seedu.address.model.person.Address;
import seedu.address.model.person.Buyer;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonCategory;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Supplier;
import seedu.address.model.pet.Pet;
import seedu.address.model.tag.Tag;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PERSON_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

/**
 * Parses input arguments and creates a new AddSupplierCommand object
 */
public class AddSupplierCommandParser extends AddPersonCommandParser implements Parser<AddSupplierCommand> {

    public AddSupplierCommandParser() {
    }

    /**
     * Parses the given {@code String} of arguments in the context of the AddSupplierCommand
     * and returns an AddSupplierCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddSupplierCommand parse(String args) throws ParseException {

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args,
                        PREFIX_PERSON_CATEGORY,
                        PREFIX_NAME, PREFIX_PHONE,
                        PREFIX_EMAIL,
                        PREFIX_ADDRESS,
                        PREFIX_TAG,
                        PREFIX_ORDER);

        if (!arePrefixesPresent(argMultimap,
                PREFIX_PERSON_CATEGORY,
                PREFIX_NAME, PREFIX_ADDRESS,
                PREFIX_PHONE,
                PREFIX_EMAIL)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddBuyerCommand.MESSAGE_USAGE));
        }

        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).orElse(""));
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).orElse(""));
        Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).orElse(""));
        Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).orElse(""));
        Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));
        Supplier supplier = new Supplier(PersonCategory.BUYER, name, phone, email, address, tagList, null);

        List<Pet> pets = ParserUtil.parsePets(argMultimap.getAllValues(PREFIX_ORDER), supplier);
        supplier.addOrder(pets);

        return new AddSupplierCommand(person);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
