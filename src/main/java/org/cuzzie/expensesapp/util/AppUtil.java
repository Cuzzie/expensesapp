package org.cuzzie.expensesapp.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppUtil {

    public static Date getDate(String dateStr) throws ParseException {
        return getDate(dateStr, "yyyy-MM-dd");
    }

    public static Date getDate(String dateStr, String dateFormat) throws ParseException {
        return new SimpleDateFormat(dateFormat).parse(dateStr);
    }

    public static Date getStartOfMonth(String dateStr) throws ParseException {
        Date date = null;
        String[] dateStrArr = dateStr.split("-");
        if (dateStrArr.length == 2) {
            int year = Integer.parseInt(dateStrArr[0]);
            int month = Integer.parseInt(dateStrArr[1]) - 1;
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            date = cal.getTime();
        }
        return date;
    }

    public static Date getEndOfMonth(String dateStr) throws ParseException {
        Date date = null;
        String[] dateStrArr = dateStr.split("-");
        if (dateStrArr.length == 2) {
            int year = Integer.parseInt(dateStrArr[0]);
            int month = Integer.parseInt(dateStrArr[1]);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.add(Calendar.DATE, -1);
            date = cal.getTime();
        }
        return date;
    }

    public static Date getCurrentStartOfMonth() throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public static Date getCurrentEndOfMonth() throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static String compileError(BindingResult bindingResult) {
        return Optional.ofNullable(bindingResult.getAllErrors())
                .orElse(Collections.emptyList())
                .stream()
                .map(ObjectError::getCode)
                .collect(Collectors.joining(", "));
    }

}
