package comp3111.covid;

public class Country {
	private String name;
	private String isoCode;
	private long population;
	public Country(String name, String isoCode, long population) {
		this.name = name;
		this.isoCode = isoCode;
		this.population = population;
	}

	/**
	 * Getter of name
	 * @return String of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter of isocode
	 * @return String of isocode
	 */
	public String getIsoCode() {
		return isoCode;
	}

	/**
	 * Getter of population
	 * @return Long of population
	 */
	public long getPopulation() {
		return population;
	}
	@Override
	public boolean equals(Object country){
	   if(this == country){
	      return true;
	   }
	   if(country instanceof Country){
	       Country c = (Country) country;
	       return this.isoCode.equals(c.isoCode);
	   }
	   return false;
	}
	@Override
	public int hashCode(){
	   return isoCode.hashCode();
	}
}