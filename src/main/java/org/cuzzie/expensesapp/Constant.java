package org.cuzzie.expensesapp;

import java.util.Arrays;

/**
 * Created by Cuzzie on 6/20/2017.
 */
public class Constant {

//    public enum CategoryType {
//        I("Income"),
//        E("Expense");
//
//        private final String displayName;
//
//        CategoryType(String displayName) {
//            this.displayName = displayName;
//        }
//
//        public String getDisplayName() {
//            return displayName;
//        }
//
//        public String getDisplayNameByValue(String value) {
//            return "";
//        }
//    }

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
    }


}
