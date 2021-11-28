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
	public String getCountry() {
		return isoCode;
	}
	public LocalDate getDate() {
		return date;
	}
	public Statistic<Long> getNewCases() {
		return newCases;
	}
	public Statistic<Long> getTotalCases() {
		return totalCases;
	}
	public Statistic<Double> getTotalCasesPerMillion() {
		return totalCasesPerMillion;
	}
	public Statistic<Long> getNewDeaths() {
		return newDeaths;
	}
	public Statistic<Long> getTotalDeaths() {
		return totalDeaths;
	}
	public Statistic<Double> getTotalDeathsPerMillion() {
		return totalDeathsPerMillion;
	}
	public Statistic<Long> getFullyVaccinated() {
		return fullyVaccinated;
	}
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