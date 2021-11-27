package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.commons.csv.CSVRecord;

public class Records {
	private Set<Record> records = new HashSet<Record>();

	//reads all records from given dataset into records
	public void read(String dataset) throws Exception {
		for (CSVRecord rec : DataAnalysis.getFileParser(dataset)) {
			String isoCode = "";
			LocalDate date = null;
			long newCases = 0;
			long totalCases = 0;
			long totalCasesPerMillion = 0;
			long newDeaths = 0;
			long totalDeaths = 0;
			long totalDeathsPerMillion = 0;
			long fullyVaccinated = 0;
			double rateOfVaccination = 0;
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
			s = rec.get("total_cases");
			if (!s.equals("")) {
				totalCases = Long.parseLong(s);
			}
			s = rec.get("total_cases_per_million");
			if (!s.equals("")) {
				totalCasesPerMillion = Long.parseLong(s);
			}
			s = rec.get("new_deaths");
			if (!s.equals("")) {
				newDeaths = Long.parseLong(s);
			}
			s = rec.get("total_deaths");
			if (!s.equals("")) {
				totalDeaths = Long.parseLong(s);
			}
			s = rec.get("total_deaths_per_million");
			if (!s.equals("")) {
				totalDeathsPerMillion = Long.parseLong(s);
			}
			s = rec.get("people_fully_vaccinated");
			if (!s.equals("")) {
				fullyVaccinated = Long.parseLong(s);
			}
			s = rec.get("people_fully_vaccinated_per_hundred");
			if (!s.equals("")) {
				rateOfVaccination = Double.parseDouble(s);
			}
			Record newRecord = new Record(isoCode, date, newCases, totalCases, totalCasesPerMillion, newDeaths, totalDeaths, totalDeathsPerMillion, fullyVaccinated, rateOfVaccination);
			records.add(newRecord);
		}
	}
	
	public Record getRecord(String isoCode, LocalDate date) {
		Record query = new Record(isoCode, date);
		for(Record record : records) {
			if(record.equals(query)) {
				return record;
			}
		}
		return null;
	}
}