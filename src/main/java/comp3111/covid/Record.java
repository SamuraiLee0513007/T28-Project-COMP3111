package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.commons.csv.CSVRecord;

public class Record {
	private String isoCode;
	private LocalDate date;
	private long newCases;
	private long totalCases;
	private long totalCasesPerMillion;
	private long newDeaths;
	private long totalDeaths;
	private long totalDeathsPerMillion;
	private long fullyVaccinated;
	private double rateOfVaccination;	// in percentage
	public Record(String isoCode, LocalDate date) {
		this.isoCode = isoCode;
		this.date = date;
	}
	public Record(String isoCode, LocalDate date, 
			long newCases, long totalCases, long totalCasesPerMillion, 
			long newDeaths, long totalDeaths, long totalDeathsPerMillion,
			long fullyVaccinated, double rateOfVaccination) {
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
	public long getNewCases() {
		return newCases;
	}
	public long getTotalCases() {
		return totalCases;
	}
	public long getTotalCasesPerMillion() {
		return totalCasesPerMillion;
	}
	public long getNewDeaths() {
		return newDeaths;
	}
	public long getTotalDeaths() {
		return totalDeaths;
	}
	public long getTotalDeathsPerMillion() {
		return totalDeathsPerMillion;
	}
	public long getFullyVaccinated() {
		return fullyVaccinated;
	}
	public double getRateOfVaccination() {
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
