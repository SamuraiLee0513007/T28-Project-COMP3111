package comp3111.covid;

import java.time.LocalDate;

public class StatisticsReport {
	private String isoCode;
	private LocalDate date;
	private Statistic<Long> newCases;
	private Statistic<Long> totalCases;
	private Statistic<Double> totalCasesPerMillion;
	private Statistic<Long> newDeaths;
	private Statistic<Long> totalDeaths;
	private Statistic<Double> totalDeathsPerMillion;
	private Statistic<Long> fullyVaccinated;
	private Statistic<Double> rateOfVaccination;	// in percentage
	public StatisticsReport(String isoCode, LocalDate date) {
		this.isoCode = isoCode;
		this.date = date;
	}
	public StatisticsReport(String isoCode, LocalDate date, 
			Statistic<Long> newCases, Statistic<Long> totalCases, Statistic<Double> totalCasesPerMillion, 
			Statistic<Long> newDeaths, Statistic<Long> totalDeaths, Statistic<Double> totalDeathsPerMillion,
			Statistic<Long> fullyVaccinated, Statistic<Double> rateOfVaccination) {
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

	/**
	 * Get country
	 * @return country
	 */
	public String getCountry() {
		return isoCode;
	}

	/**
	 * Get date
	 * @return date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Get newcases
	 * @return newcases
	 */
	public Statistic<Long> getNewCases() {
		return newCases;
	}

	/**
	 * Get total cases
	 * @return total cases
	 */
	public Statistic<Long> getTotalCases() {
		return totalCases;
	}

	/**
	 * Get totalcases per 1M
	 * @return totalcases per 1M
	 */
	public Statistic<Double> getTotalCasesPerMillion() {
		return totalCasesPerMillion;
	}

	/**
	 * Get new deaths
	 * @return new deaths
	 */
	public Statistic<Long> getNewDeaths() {
		return newDeaths;
	}

	/**
	 * Get total deaths
	 * @return total deaths
	 */
	public Statistic<Long> getTotalDeaths() {
		return totalDeaths;
	}

	/**
	 * Get total deaths per 1M
	 * @return total deaths per 1M
	 */
	public Statistic<Double> getTotalDeathsPerMillion() {
		return totalDeathsPerMillion;
	}

	/**
	 * Get fully vaccinated
	 * @return fully vaccinated
	 */
	public Statistic<Long> getFullyVaccinated() {
		return fullyVaccinated;
	}

	/**
	 * Get rate of vaccination
	 * @return rate of vaccination
	 */
	public Statistic<Double> getRateOfVaccination() {
		return rateOfVaccination;
	}
	@Override
	public boolean equals(Object rhs){
	   if(this == rhs){
	      return true;
	   }
	   if(rhs instanceof Record){
	       StatisticsReport report = (StatisticsReport) rhs;
	       return this.isoCode.equals(report.isoCode) && this.date.equals(report.date);
	   }
	   return false;
	}
	@Override
	public int hashCode(){
	   return isoCode.hashCode() + date.hashCode();
	}	
}