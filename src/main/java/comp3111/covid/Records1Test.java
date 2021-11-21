package comp3111.covid;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Records1Test {
    Records1 R;

    @Before
    public void setUp() throws Exception {
        R = new Records1("COVID_Dataset_v1.0.csv", "AFG");
    }

    @Test
    public void testFullyVaccninated() {
        assertEquals(R.getFullyVaccninated(),219159);
    }

    @Test
    public void testvaccination_rate() {
        assertEquals(R.getvaccination_rate(),0.5629,0.001);
    }

}