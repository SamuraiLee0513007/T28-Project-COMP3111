package comp3111.covid;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class RecordTester {
	Record record;
	@Before
	public void setUp() throws Exception {
		record = new Record("AFG", LocalDate.of(2020, 2, 24), 1, 1, 0.026, 0, 0, 0, 0, 0);
	}

	@Test
	public void testGetters() {
		assertEquals("AFG", record.getCountry());
		LocalDate.of(2020,2,4).equals(record.getDate());
		assertEquals(Long.valueOf(1), record.getNewCases());
		assertEquals(Long.valueOf(1), record.getTotalCases());
		assertEquals(Double.valueOf(0.026), record.getTotalCasesPerMillion(), 0);
		assertEquals(Long.valueOf(0), record.getNewDeaths());
		assertEquals(Long.valueOf(0), record.getTotalDeaths());
		assertEquals(Double.valueOf(0), record.getTotalDeathsPerMillion(), 0);
		assertEquals(Long.valueOf(0), record.getFullyVaccinated());
		assertEquals(Double.valueOf(0), record.getRateOfVaccination(), 0);
	}
	
	@Test
	public void testEquals() {
		assertEquals(record.equals(record), true);
		assertEquals(record.equals(new Record("AFG", LocalDate.of(2020, 2, 24))), true);
		assertEquals(record.equals(new Record("AFG", LocalDate.of(2020, 2, 25))), false);
	}
	
	@Test
	public void testHashCode() {
		assertEquals(record.hashCode(), "AFG".hashCode() + LocalDate.of(2020, 2, 24).hashCode());
	}
	
}

