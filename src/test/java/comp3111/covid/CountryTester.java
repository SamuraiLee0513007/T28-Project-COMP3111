package comp3111.covid;

import static org.junit.Assert.*;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Before;
import org.junit.Test;

public class CountryTester {
	Country c;
	@Before
	public void setUp() throws Exception{
		c = new Country();
	   CSVParser p = DataAnalysis.getFileParser("COVID_Dataset_v1.0.csv");
	   for (CSVRecord rec : p) {
		  if(rec.get("location").equals("Hong Kong")) {
			 String d=null; long TC=0,TD=0,FV=0;
			 c.set_iso_code("HKG");
			 c.set_location("Hong Kong");
			 String P = rec.get("population");
			 long Po = Long.parseLong(P);
			 c.set_population(Po);
			 String tc = rec.get("total_cases");
			 String td = rec.get("total_deaths");
			 String fv = rec.get("people_fully_vaccinated");
			 if(tc.compareTo("")!=0)
		       TC = Long.parseLong(tc);
		     if(td.compareTo("")!=0)
		       TD = Long.parseLong(td);
	         if(fv.compareTo("")!=0)
	            FV = Long.parseLong(fv);
	         d =rec.get("date");
	         Records R =new Records(d,TC,TD,FV);
	         c.addRecords(R);
	         }
		} 
			
	}
	@Test
	public void testNumber() {
	   assertEquals(c.get_occupied(),545);
	}
	@Test 
    public void testCopyConstructor() {
		boolean flag = true;
		Country Co = new Country(c);
		Records [] Cor;
		Records [] Cr;
		Cor = Co.get_records();
		Cr = c.get_records();
		if(c.get_occupied()!=Co.get_occupied()||c.get_capacity()!=Co.get_capacity()||
		    c.get_iso_code().compareTo(Co.get_iso_code())!=0||c.get_location().compareTo(Co.get_location())!=0||
		    c.get_population()!=Co.get_population())
			flag = false;
		for(int i=0;i<c.get_occupied();i++) {
			if(Cor[i].equals(Cr[i])==false)
				flag = false;
		}
		assertTrue(flag);
	}
}
