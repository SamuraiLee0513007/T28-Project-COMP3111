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
	@Test
	public void testGetRecordsUpTo() {
		Record ri = records.getRecordsUpTo("AFG", LocalDate.of(2021, 7, 20)).lastElement();
		Record r0 = new Record("AFG", LocalDate.of(2021, 7, 20), 925, 142414, 3658.363, 53, 6266, 160.962, 0, 0);
		assertEquals(r0, ri);
	}
	@Test
	public void testGetLatestRecord() {
		Record ri = records.getLatestRecord("AFG", LocalDate.of(2021, 7, 20));
		Record r0 = new Record("AFG", LocalDate.of(2021, 7, 20), 925, 142414, 3658.363, 53, 6266, 160.962, 0, 0);
		assertEquals(r0, ri);		
	}
	@Test
	public void testGetLatestStatistics() {
		StatisticsReport si = records.getLatestStatistics("AFG", LocalDate.of(2021, 7, 20));
		StatisticsReport s0 = new StatisticsReport("AFG", LocalDate.of(2021, 7, 20), 
				new Statistic<Long>(Long.valueOf(925), LocalDate.of(2021, 7, 20)),
				new Statistic<Long>(Long.valueOf(142414), LocalDate.of(2021, 7, 20)),
				new Statistic<Double>(Double.valueOf(3658.363), LocalDate.of(2021, 7, 20)),
				new Statistic<Long>(Long.valueOf(53), LocalDate.of(2021, 7, 20)),
				new Statistic<Long>(Long.valueOf(6266), LocalDate.of(2021, 7, 20)),
				new Statistic<Double>(Double.valueOf(160.962), LocalDate.of(2021, 7, 20)),
				new Statistic<Long>(Long.valueOf(219159), LocalDate.of(2021, 7, 11)),
				new Statistic<Double>(Double.valueOf(0.56), LocalDate.of(2021, 7, 11))
				);
		assertEquals(si, s0);
	}
}
