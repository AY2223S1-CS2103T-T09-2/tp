package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.FilterLocCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.LocationContainsKeywordsPredicate;

import java.util.Arrays;

/**
 * Parses input arguments and creates a new DeleteCommand object.
 */
public class FilterLocCommandParser implements Parser<FilterLocCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FilterLocCommand
     * and returns a FilterLocCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public FilterLocCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterLocCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        System.out.println(nameKeywords.length);

        return new FilterLocCommand(new LocationContainsKeywordsPredicate<>(Arrays.asList(nameKeywords)),
                new LocationContainsKeywordsPredicate<>(Arrays.asList(nameKeywords)),
                new LocationContainsKeywordsPredicate<>(Arrays.asList(nameKeywords)));
    }
}
