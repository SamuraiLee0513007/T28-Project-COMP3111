package comp3111.covid;

import java.util.*;

import org.apache.commons.csv.CSVRecord;

public class Countries {
	private Set<Country> countries = new HashSet<Country>();
	public Countries() { }
	public Countries(String dataset) throws Exception {
		read(dataset);
	}
	//reads all countries from given dataset
	public void read(String dataset) throws Exception {
		for (CSVRecord rec : DataAnalysis.getFileParser(dataset)) {
			String name = "";
			String isoCode = "";
			long population = 0;
			String s;
			s = rec.get("iso_code");
			if (!s.equals("")) {
				isoCode = s;
			}
			s = rec.get("location");
			if (!s.equals("")) {
				name = s;
			}
			s = rec.get("population");
			if (!s.equals("")) {
				population = Long.parseLong(s);
			}
			Country newCountry = new Country(name, isoCode, population);
			if( countries.contains(newCountry) == false ) {
				countries.add(newCountry);
			}
		}
	}
	public Vector<Country> getCountries() {
		Vector<Country> countriesList = new Vector<Country>(countries);
		Collections.sort(countriesList, Comparator.comparing(Country::getName) );
		return countriesList;
	}
}
