package comp3111.covid;

import java.util.*;

import org.apache.commons.csv.CSVRecord;

public class Countries {
	private static Set<Country> countries = new HashSet<Country>();
	public Countries() {
		
	}
	
	//reads all countries from given dataset
	public static void read(String dataset) throws Exception {
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
			if(!countries.contains(newCountry)) {
				countries.add(newCountry);
			}
		}
	}
	
	public static Vector<String> getCountries() {
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
		for (Country x : countries)
			hashSet.add(x.getName());
		Vector<String> countriesList = new Vector<String>();
		countriesList.addAll(hashSet);
		Collections.sort(countriesList );
		return countriesList;
	}
}