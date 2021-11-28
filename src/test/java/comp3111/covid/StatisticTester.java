package comp3111.covid;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class StatisticTester {

    @Test
    public void getValue() {
        Statistic<Integer> temp = new Statistic<Integer>(1, LocalDate.now());
        Assert.assertEquals(temp.getValue(),(Integer) 1);
        Statistic<Integer> temp1 = new Statistic<Integer>(2, LocalDate.now());
        Assert.assertEquals(temp1.getValue(),(Integer)2);
        Statistic<String> temp2 = new Statistic<String>("HI", LocalDate.now());
        Assert.assertEquals(temp2.getValue(),"HI");
    }

    @Test
    public void getDate() {
        Statistic<Integer> temp = new Statistic<Integer>(1, LocalDate.now());
        Assert.assertEquals(temp.getDate(),LocalDate.now());
        Statistic<String> temp2 = new Statistic<>("HI", LocalDate.of(2001,12,1));
        Assert.assertEquals(temp2.getDate(),LocalDate.of(2001,12,1));
    }
}