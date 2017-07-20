package org.cuzzie.expensesapp;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Cuzzie on 6/20/2017.
 */
public class Constant {

    public enum CategoryType {
        INCOME("I"),
        EXPENSE("E");

        private final String value;

        CategoryType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static String getNameByValue(String value) {
            Optional<CategoryType> categoryType = Arrays.stream(CategoryType.values()).filter(ct -> value.equals(ct.getValue())).findFirst();
            return categoryType.map(CategoryType::name).orElse("");
        }
    }

    public static final String SEC_ROLE_PREFIX = "ROLE_";

    public static final String SEC_ADMIN = "ADMIN";

    public static final String SEC_USER = "USER";
}
