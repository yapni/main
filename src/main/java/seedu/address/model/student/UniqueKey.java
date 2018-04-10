package seedu.address.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Random;

/**
 * @@author demitycho
 * Represents a Student's UniqueKey in the address book. Generated by {@code UniqueStudentList.add()} method
 * Guarantees: immutable; is valid as declared in {@link #isValidUniqueKey(String)}
 */
public class UniqueKey {


    public static final String MESSAGE_UNIQUE_KEY_CONSTRAINTS =
            "UniqueKey is a 6 digit hexadecimal string";
    public static final String UNIQUE_KEY_VALIDATION_REGEX = "^(?:[0-9a-fA-F]){6}$";
    public final String uniqueKey;
    /**
     * Constructs a {@code Phone}.
     *
     * @param uniqueKey A valid phone number.
     */
    public UniqueKey(String uniqueKey) {
        requireNonNull(uniqueKey);
        checkArgument(isValidUniqueKey(uniqueKey), MESSAGE_UNIQUE_KEY_CONSTRAINTS);
        this.uniqueKey = uniqueKey;
    }

    /**
     * Generates a random hexadecimal string of length 6
     * @return
     */
    public static UniqueKey generateRandomKey() {
        Random random = new Random();
        int nextInt;
        String finalStringKey = "";
        for (int i = 0; i < 6; i++) {
            nextInt = random.nextInt(16);
            finalStringKey = finalStringKey + Integer.toHexString(nextInt);
        }
        return new UniqueKey(finalStringKey);
    }

    /**
     * Returns true if a given string is a valid student phone number.
     */
    public static boolean isValidUniqueKey(String test) {
        return test.matches(UNIQUE_KEY_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return uniqueKey;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueKey // instanceof handles nulls
                && this.uniqueKey.equals(((UniqueKey) other).uniqueKey)); // state check
    }

    @Override
    public int hashCode() {
        return uniqueKey.hashCode();
    }

}
