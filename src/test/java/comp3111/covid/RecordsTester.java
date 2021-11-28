package comp3111.covid;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class RecordsTester {
	Records records;
	@Before
	public void setUp() throws Exception {
		records = new Records("COVID_dataset_v1.0.csv");
	}
	@Test
	public void testGetRecord() {
		Record r1 = records.getRecord("AFG", LocalDate.of(2020, 2, 24));
		Record r2 = new Record("AFG", LocalDate.of(2020, 2, 24), 1, 1, 0.026, 0, 0, 0, 0, 0);
		assertEquals(r1, r2);
	}
	@Test
	public void testGetRecords() {
		Vector<Record> result = records.getRecords("AFG");
		Record r0 = new Record("AFG", LocalDate.of(2020, 2, 24), 1, 1, 0.026, 0, 0, 0, 0, 0);
		Record rn = new Record("AFG", LocalDate.of(2021, 7, 20), 925, 142414, 3658.363, 53, 6266, 160.962, 0, 0);
		assertEquals(r0, result.firstElement());
		assertEquals(rn, result.lastElement());
	};
}
