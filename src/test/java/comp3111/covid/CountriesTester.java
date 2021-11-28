package comp3111.covid;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CountriesTester {

    @Test
    public void read() {
        Countries.read("COVID_Dataset_v1.0.csv");
        Assert.assertEquals(Countries.getCountries().size(), 231);
        Assert.assertEquals(Countries.getCountries().contains(new Country("Afghanistan","AFG",38928341)), true);
    }

    @Test
    public void getCountries() {
        Countries.read("COVID_Dataset_v1.0.csv");
        Assert.assertEquals(Countries.getCountries().size(), 231);
        Assert.assertEquals(Countries.getCountries().contains(new Country("Africa","OWID_AFR",1340598113)), true);
    }

    @Test
    public void toIsoCode() {
        Countries.read("COVID_Dataset_v1.0.csv");
        Assert.assertEquals(Countries.toIsoCode("Hong Kong"), "HKG");
        Assert.assertEquals(Countries.toIsoCode("Honduras"), "HND");
        Assert.assertEquals(Countries.toIsoCode("Bahrain"), "BHR");
    }
}