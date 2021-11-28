package comp3111.covid;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class StatisticsReportTester {

    @Test
    public void getCountry() {
        StatisticsReport temp = new StatisticsReport("ABC", LocalDate.now());
        Assert.assertEquals(temp.getCountry(),"ABC");
        StatisticsReport temp1 = new StatisticsReport("BBB", LocalDate.now());
        Assert.assertEquals(temp1.getCountry(),"BBB");
    }

    @Test
    public void getDate() {
        StatisticsReport temp = new StatisticsReport("ABC", LocalDate.now());
        Assert.assertEquals(temp.getDate(),LocalDate.now());
        StatisticsReport temp1 = new StatisticsReport("BBB", LocalDate.of(2001,01,01));
        Assert.assertEquals(temp1.getDate(),LocalDate.of(2001,01,01));
    }

}