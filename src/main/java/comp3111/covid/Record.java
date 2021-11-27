package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.commons.csv.CSVRecord;

public class Record {
	private String isoCode;
	private LocalDate date;
	private long newCases;
	private long newDeaths;
	private long fullyVaccinated;
	public Record(String isoCode, LocalDate date, long newCases, long newDeaths, long fullyVaccinated) {
		this.isoCode = isoCode;
		this.date = date;
		this.newCases = newCases;
		this.newDeaths = newDeaths;
		this.fullyVaccinated = fullyVaccinated;
	}
	public Record(String isoCode,LocalDate date){

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
	public long getNewDeaths() {
		return newDeaths;
	}
	public long getFullyVaccinated() {
		return fullyVaccinated;
	}
	
	//returns total cases for the specified country as of the specified date
	public static long getTotalCases(Vector<Record> records, String isoCode, LocalDate date) {
		int totalCases = 0;
		for(Record record : records) {
			if(record.getCountry() == isoCode && record.getDate().isBefore(date)) {
				totalCases += record.getNewCases();
			}
		}
		return totalCases;
	}
	
	//returns total deaths for the specified country as of the specified date
	public static long getTotalDeaths(Vector<Record> records, String isoCode, LocalDate date) {
		int totalDeaths = 0;
		for(Record record : records) {
			if(record.getCountry() == isoCode && record.getDate().isBefore(date)) {
				totalDeaths += record.getNewDeaths();
			}
		}
		return totalDeaths;
	}
	
	//reads all records from given dataset and returns them in a vector
	public static Vector<Record> read(String dataset) throws Exception {
		Vector<Record> records = new Vector<Record>();
		for (CSVRecord rec : DataAnalysis.getFileParser(dataset)) {
			String isoCode = "";
			LocalDate date = null;
			long newCases = 0;
			long newDeaths = 0;
			long fullyVaccinated = 0;
			String s;
			s = rec.get("iso_code");
			if (!s.equals("")) {
				isoCode = s;
			}
			s = rec.get("date");
			if (!s.equals("")) {
				date = LocalDate.parse(s, DateTimeFormatter.ofPattern("[MM-dd-yyyy][MM/dd/yyyy"));
			}
			s = rec.get("new_cases");
			if (!s.equals("")) {
				newCases = Long.parseLong(s);
			}
			s = rec.get("new_deaths");
			if (!s.equals("")) {
				newDeaths = Long.parseLong(s);
			}
			s = rec.get("people_fully_vaccinated");
			if (!s.equals("")) {
				fullyVaccinated = Long.parseLong(s);
			}
			Record newRecord = new Record(isoCode, date, newCases, newDeaths, fullyVaccinated);
			records.add(newRecord);
		}
		return records;
	}
	
}