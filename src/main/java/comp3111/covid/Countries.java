package comp3111.covid;

import java.util.*;

import org.apache.commons.csv.CSVRecord;
/**
 * A class for storing the list of countries
 */
public class Countries {
	private static Set<Country> countries = new HashSet<Country>();
	public Countries() { }
	public Countries(String dataset) {
		read(dataset);
	}
	//reads all countries from given dataset

	/**
	 * Read all data from dataset into countries variable
	 * @param dataset
	 */
	public static void read(String dataset) {
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

	/**
	 * A getter for countries
	 * @return A vector of sorted country
	 */
	public static Vector<Country> getCountries() {
		Vector<Country> countriesList = new Vector<Country>(countries);
		Collections.sort(countriesList, Comparator.comparing(Country::getName) );
		return countriesList;
	}

	/**
	 *A static function to convert country name to isocode
	 * @param name
	 * @return
	 */
	public static String toIsoCode(String name) {
		for(Country country : countries) {
			if(name.equals(country.getName())) {
				return country.getIsoCode();
			}
		}
		return null;
	}
}