package org.cuzzie.expensesapp;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Cuzzie on 6/20/2017.
 */
public class Constant {

    public enum CategoryType {
        INCOME("I", "Income"),
        EXPENSE("E", "Expenses");

        private final String value;

        private final String description;

        CategoryType(String value, String description) {
            this.value = value;
            this.description = description;
        }

        public String getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        public static String getDescByValue(String value) {
            Optional<CategoryType> categoryType = Arrays.stream(CategoryType.values()).filter(ct -> value.equals(ct.getValue())).findFirst();
            return categoryType.map(CategoryType::getDescription).orElse("");
        }
    }

    public static final String SEC_ROLE_PREFIX = "ROLE_";

    public static final String SEC_ADMIN = "ADMIN";

    public static final String SEC_USER = "USER";
}
