package comp3111.covid;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryTester {

    @Test
    public void getName() {
        Country temp = new Country("Afghanistan","AFG",38928341);
        Assert.assertEquals(temp.getName(),"Afghanistan");
        Country temp1 = new Country("Africa","OWID_AFR",1340598113);
        Assert.assertEquals(temp1.getName(),"Africa");
    }

    @Test
    public void getIsoCode() {
        Country temp = new Country("Afghanistan","AFG",38928341);
        Assert.assertEquals(temp.getIsoCode(),"AFG");
        Country temp1 = new Country("Africa","OWID_AFR",1340598113);
        Assert.assertEquals(temp1.getIsoCode(),"OWID_AFR");
    }

    @Test
    public void getPopulation() {
        Country temp = new Country("Afghanistan","AFG",38928341);
        Assert.assertEquals(temp.getPopulation(),38928341);
        Country temp1 = new Country("Africa","OWID_AFR",1340598113);
        Assert.assertEquals(temp1.getPopulation(),1340598113);
    }

    @Test
    public void testEquals() {
        Country temp = new Country("Afghanistan","AFG",38928341);
        Country temp1 = new Country("Afghanistan","AFG",38928341);
        Assert.assertEquals(temp1.equals(temp),true);
        temp = new Country("Africa", "OWID_AFR", 1340598113);
        temp1 = new Country("Africa","OWID_AFR",1340598113);
        Assert.assertEquals(temp1.equals(temp),true);
    }

    @Test
    public void testHashCode() {
        Country temp = new Country("Afghanistan","AFG",38928341);
        Assert.assertEquals(temp.hashCode(),64706);
        Country temp1 = new Country("Africa","OWID_AFR",1340598113);
        Assert.assertEquals(temp1.hashCode(),-1992873071);
    }
}