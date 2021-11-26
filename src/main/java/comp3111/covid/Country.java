package comp3111.covid;

public class Country {
	String name;
	String isoCode;
	long population;
	public Country(String name, String isoCode, long population) {
		this.name = name;
		this.isoCode = isoCode;
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public String getIsoCode() {
		return isoCode;
	}
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
	       return this.isoCode == c.isoCode;
	   }
	   return false;
	}
	@Override
	public int hashCode(){
	   return isoCode.hashCode();
	}
}
