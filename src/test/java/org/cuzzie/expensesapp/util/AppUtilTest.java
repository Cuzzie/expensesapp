package org.cuzzie.expensesapp.util;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public class AppUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(AppUtilTest.class);

    @Test
    public void testGetDate() throws ParseException {
        Date testDate = java.sql.Date.valueOf(LocalDate.now().withDayOfMonth(15).withMonth(8).withYear(2017));
        Date date = AppUtil.getDate("2017-08-15");
        Assert.assertEquals(testDate, date);
        System.out.println("AppUtil.testGetDate(): expected date = " + testDate + ", provided date = " + date);
    }

    @Test
    public void testGetDateWithDateFormat() throws ParseException {
        Date testDate = java.sql.Date.valueOf(LocalDate.now().withDayOfMonth(15).withMonth(8).withYear(2017));
        Date date = AppUtil.getDate("15/08/2017", "dd/MM/yyyy");
        Assert.assertEquals(testDate, date);
        System.out.println("AppUtil.testGetDateWithDateFormat(): expected date = " + testDate + ", provided date = " + date);
    }

    @Test
    public void testGetStartOfMonth() throws ParseException {
        Date testDate = java.sql.Date.valueOf(LocalDate.now().withDayOfMonth(1).withMonth(8).withYear(2017));
        Date date = AppUtil.getStartOfMonth("2017-08");
        Assert.assertEquals(testDate, date);
        System.out.println("AppUtil.testGetStartOfMonth(): expected date = " + testDate + ", provided date = " + date);
    }

    @Test
    public void testGetEndOfMonth() throws ParseException {
        Date testDate = java.sql.Date.valueOf(LocalDate.now().withDayOfMonth(31).withMonth(8).withYear(2017));
        Date date = AppUtil.getEndOfMonth("2017-08");
        Assert.assertEquals(testDate, date);
        System.out.println("AppUtil.testGetEndOfMonth(): expected date = " + testDate + ", provided date = " + date);
    }

}
