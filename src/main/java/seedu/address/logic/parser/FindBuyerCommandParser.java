package seedu.address.logic.parser;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Buyer;
import seedu.address.model.person.Deliverer;
import seedu.address.model.person.PersonCategory;
import seedu.address.model.person.Supplier;

import java.util.function.Predicate;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class FindBuyerCommandParser implements Parser<FindCommand> {
    public static final String PARSE_WORD = "find-b";

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public FindCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        Predicate<Buyer> bPredicate = PredicateParser.parseBuyer(trimmedArgs);
        Predicate<Deliverer> dPredicate = new Predicate<Deliverer>() {
            @Override
            public boolean test(Deliverer deliverer) {
                return false;
            }
            public boolean equals(Object object) {
                return object instanceof Predicate;
            }
        };
        Predicate<Supplier> sPredicate = new Predicate<Supplier>() {
            @Override
            public boolean test(Supplier supplier) {
                return false;
            }
            public boolean equals(Object object) {
                return object instanceof Predicate;
            }
        };

        return new FindCommand(bPredicate, dPredicate, sPredicate,
                PersonCategory.getFromString("Buyer"));
    }
}
