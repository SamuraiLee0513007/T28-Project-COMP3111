package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.commons.csv.CSVRecord;

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
	public Record(String isoCode, LocalDate date) {
		this.isoCode = isoCode;
		this.date = date;
	}
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
	public String getCountry() {
		return isoCode;
	}
	public LocalDate getDate() {
		return date;
	}
	public Long getNewCases() {
		return newCases;
	}
	public Long getTotalCases() {
		return totalCases;
	}
	public Double getTotalCasesPerMillion() {
		return totalCasesPerMillion;
	}
	public Long getNewDeaths() {
		return newDeaths;
	}
	public Long getTotalDeaths() {
		return totalDeaths;
	}
	public Double getTotalDeathsPerMillion() {
		return totalDeathsPerMillion;
	}
	public Long getFullyVaccinated() {
		return fullyVaccinated;
	}
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
