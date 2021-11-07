package comp3111.covid;

import org.apache.commons.csv.*;
import edu.duke.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class RecordsTester {
	Records R;
	@Before
	public void setUp() throws Exception {
	   CSVParser p = DataAnalysis.getFileParser("COVID_Dataset_v1.0.csv");
	   String d=null; long TC=0,TD=0,FV=0; float TC1=0,TD1=0,v=0;
	   for (CSVRecord rec : p) {
		  if(rec.get("location").equals("Hong Kong")&&rec.get("date").equals("7/20/2021")) {
			 d =rec.get("date");
			 String tc = rec.get("total_cases");
		     TC = Long.parseLong(tc);
		     String tc1 = rec.get("total_cases_per_million");
		     TC1 = Float.parseFloat(tc1);
		     String td = rec.get("total_deaths");
		     TD = Long.parseLong(td);
	         String td1 = rec.get("total_deaths_per_million");	 
	         TD1 = Float.parseFloat(td1);
	         String fv = rec.get("people_fully_vaccinated");
	         FV = Long.parseLong(fv);
	         long Po;
	         String P = rec.get("population");
	         Po = Long.parseLong(P);
	         v = (float)FV/Po;
	         }
		} 
		R = new Records(d,TC,TC1,TD,TD1,FV,v);	
	}
	
	@Test
	public void testFullyVaccinated() {
		assertEquals(R.getFullyVaccninated(),2065375);
	}
	@Test
	public void testTotalCases() {
		assertEquals(R.getTotalCases(),11965);
	}
	@Test 
	public void testTotalCasesper1M(){
		assertEquals(R.getTotalCasesper1M(),(float)1595.974,0.001);
	}
	@Test 
	public void testTotalDeath() {
		assertEquals(R.getTotalDeath(),212);
	}
	@Test 
	public void testTotalDeathper1M() {
		assertEquals(R.getTotalDeathper1M(),(float)28.278,0.001);
	}
	@Test
    public void TestDate() {
    	assertEquals(R.getDate(),"7/20/2021");
    }
	@Test 
	public void Testrate() {
		assertEquals(R.getvaccination_rate(),0.275493,0.001);
	}
}
