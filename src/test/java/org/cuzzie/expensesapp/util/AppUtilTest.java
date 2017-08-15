package org.cuzzie.expensesapp.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public class AppUtilTest {

    private Date testDate;

    @Before
    public void initialize() {
        LocalDate date = LocalDate.now();
        testDate = java.sql.Date.valueOf(date.withDayOfMonth(15).withMonth(8).withYear(2017));
    }

    @Test
    public void testGetDate() throws ParseException {
        Date date = AppUtil.getDate("2017-08-15");
        Assert.assertEquals(testDate, date);
    }

    @Test
    public void testGetDateWithDateFormat() throws ParseException {
        Date date = AppUtil.getDate("15/08/2017", "dd/MM/yyyy");
        Assert.assertEquals(testDate, date);
    }

}
