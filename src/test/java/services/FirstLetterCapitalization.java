package services;

public class FirstLetterCapitalization {
    public String capitalizeFirstLetter(String stringWhereFirstShouldCapitalized) {
        int fromBeginningOfTheString = 0;
        int tillTheEndOfTheFirstLetter = 1;

        int startingFromSecondLetter = 1;

        return stringWhereFirstShouldCapitalized.substring(fromBeginningOfTheString, tillTheEndOfTheFirstLetter).toUpperCase()
                + stringWhereFirstShouldCapitalized.substring(startingFromSecondLetter);
    }
}
