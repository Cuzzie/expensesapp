package org.cuzzie.expensesapp.util;

import org.cuzzie.expensesapp.model.MyUserPrincipal;
import org.cuzzie.expensesapp.model.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppUtil {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static Date getDate(String dateStr) throws ParseException {
        return getDate(dateStr, DEFAULT_DATE_FORMAT);
    }

    public static Date getDate(String dateStr, String dateFormat) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate parsedDate = LocalDate.parse(dateStr, formatter);
        return java.sql.Date.valueOf(parsedDate);
    }

    public static Date getStartOfMonth(String dateStr) throws ParseException {
        dateStr += "-01";
        return getDate(dateStr);
    }

    public static Date getEndOfMonth(String dateStr) throws ParseException {
        Date date = null;
        String[] dateStrArr = dateStr.split("-");
        if (dateStrArr.length == 2) {
            int year = Integer.parseInt(dateStrArr[0]);
            int month = Integer.parseInt(dateStrArr[1]);
            LocalDate localDate = LocalDate.of(year, month + 1, 1);
            localDate = localDate.minusDays(1);
            date = java.sql.Date.valueOf(localDate);
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

    public static User getCurrentUser() {
        User currentUser = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            // Only proceed if user is logged in
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                MyUserPrincipal userDetails = (MyUserPrincipal) authentication.getPrincipal();
                currentUser = userDetails.getUser();
            }
        }
        return currentUser;
    }

    public static int getCurrentUserId() {
        return Optional.ofNullable(getCurrentUser()).map(User::getId).orElse(-1);
    }

}
