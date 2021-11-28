package comp3111.covid;

import java.time.LocalDate;

public class Record {
	private String isoCode;
	private LocalDate date;
	private Long newCases;
	private Long totalCases;
	private Double totalCasesPerMillion;
	private Long newDeaths;
	private Long totalDeaths;
	private Double totalDeathsPerMillion;
	private Long fullyVaccinated;
	private Double rateOfVaccination;	// in percentage

	/**
	 * Constructor of record
	 * @param isoCode
	 * @param date
	 */
	public Record(String isoCode, LocalDate date) {
		this.isoCode = isoCode;
		this.date = date;
	}

	/**
	 * Constrctor of record with all data
	 * @param isoCode
	 * @param date
	 * @param newCases
	 * @param totalCases
	 * @param totalCasesPerMillion
	 * @param newDeaths
	 * @param totalDeaths
	 * @param totalDeathsPerMillion
	 * @param fullyVaccinated
	 * @param rateOfVaccination
	 */
	public Record(String isoCode, LocalDate date, 
			Long newCases, Long totalCases, Double totalCasesPerMillion, 
			Long newDeaths, Long totalDeaths, Double totalDeathsPerMillion,
			Long fullyVaccinated, Double rateOfVaccination) {
		this.isoCode = isoCode;
		this.date = date;
		this.newCases = newCases;
		this.totalCases = totalCases;
		this.totalCasesPerMillion = totalCasesPerMillion;
		this.newDeaths = newDeaths;
		this.totalDeaths = totalDeaths;
		this.totalDeathsPerMillion = totalDeathsPerMillion;
		this.fullyVaccinated = fullyVaccinated;
		this.rateOfVaccination = rateOfVaccination;
	}

	/***
	 * Constructor of record with all data
	 * @param isoCode
	 * @param date
	 * @param newCases
	 * @param totalCases
	 * @param totalCasesPerMillion
	 * @param newDeaths
	 * @param totalDeaths
	 * @param totalDeathsPerMillion
	 * @param fullyVaccinated
	 * @param rateOfVaccination
	 */
	public Record(String isoCode, LocalDate date, 
			long newCases, long totalCases, double totalCasesPerMillion, 
			long newDeaths, long totalDeaths, double totalDeathsPerMillion,
			long fullyVaccinated, double rateOfVaccination) {
		this.isoCode = isoCode;
		this.date = date;
		this.newCases = Long.valueOf(newCases);
		this.totalCases = Long.valueOf(totalCases);
		this.totalCasesPerMillion = Double.valueOf(totalCasesPerMillion);
		this.newDeaths = Long.valueOf(newDeaths);
		this.totalDeaths = Long.valueOf(totalDeaths);
		this.totalDeathsPerMillion = Double.valueOf(totalDeathsPerMillion);
		this.fullyVaccinated = Long.valueOf(fullyVaccinated);
		this.rateOfVaccination = Double.valueOf(rateOfVaccination);
	}

	/**
	 * Get isocode
	 * @return String of isocde
	 */
	public String getCountry() {
		return isoCode;
	}

	/**
	 * Get date
	 * @return LocalDate of date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Get newCases
	 * @return Long of new cases
	 */
	public Long getNewCases() {
		return newCases;
	}

	/**
	 * Get totalCases
	 * @return Long of totalCases
	 */
	public Long getTotalCases() {
		return totalCases;
	}

	/**
	 * Get total case per 1M
	 * @return Double of Totalcasesper1M
	 */
	public Double getTotalCasesPerMillion() {
		return totalCasesPerMillion;
	}

	/**
	 * Get new deaths
	 * @return Long of new deaths
	 */
	public Long getNewDeaths() {
		return newDeaths;
	}

	/**
	 * Get total deaths
	 * @return Long of total deaths
	 */
	public Long getTotalDeaths() {
		return totalDeaths;
	}

	/**
	 * Get total deaths per 1M
	 * @return Double of total deaths per 1M
	 */
	public Double getTotalDeathsPerMillion() {
		return totalDeathsPerMillion;
	}

	/**
	 * Get fully vaccinated
	 * @return Long of fully vaccinated
	 */
	public Long getFullyVaccinated() {
		return fullyVaccinated;
	}

	/**
	 * Get rateofvaccination
	 * @return Double of rate of vaccination
	 */
	public Double getRateOfVaccination() {
		return rateOfVaccination;
	}
	@Override
	public boolean equals(Object rhs){
	   if(this == rhs){
	      return true;
	   }
	   if(rhs instanceof Record){
	       Record record = (Record) rhs;
	       return this.isoCode.equals(record.isoCode) && this.date.equals(record.date);
	   }
	   return false;
	}
	@Override
	public int hashCode(){
	   return isoCode.hashCode() + date.hashCode();
	}	
}