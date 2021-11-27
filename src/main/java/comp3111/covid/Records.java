package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.commons.csv.CSVRecord;

public class Records {
	private Set<Record> records = new HashSet<Record>();
	public Records() { }
	public Records(String dataset) {
		read(dataset);
		//int count = 0;
		//for(Record r : records) {
		//		System.out.println(count+" "+r.getCountry()+" "+r.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		//		count++;
		//}
	}

	//reads all records from given dataset into records
	public void read(String dataset) {
		for (CSVRecord rec : DataAnalysis.getFileParser(dataset)) {
			Record newRecord = null;
			String isoCode = "";
			LocalDate date = null;
			long newCases = 0;
			long totalCases = 0;
			double totalCasesPerMillion = 0;
			long newDeaths = 0;
			long totalDeaths = 0;
			double totalDeathsPerMillion = 0;
			long fullyVaccinated = 0;
			double rateOfVaccination = 0;
			String s;
			s = rec.get("iso_code");
			if (!s.equals("")) {
				isoCode = s;
			}
			s = rec.get("date");
			if (!s.equals("")) {
				String[] d = s.split("-|/");
				date = LocalDate.of(Integer.parseInt(d[2]), Integer.parseInt(d[0]), Integer.parseInt(d[1]));
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
				totalCasesPerMillion = Double.parseDouble(s);
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
				totalDeathsPerMillion = Double.parseDouble(s);
			}
			s = rec.get("people_fully_vaccinated");
			if (!s.equals("")) {
				fullyVaccinated = Long.parseLong(s);
			}
			s = rec.get("people_fully_vaccinated_per_hundred");
			if (!s.equals("")) {
				rateOfVaccination = Double.parseDouble(s);
			}
			newRecord = new Record(isoCode, date, newCases, totalCases, totalCasesPerMillion, newDeaths, totalDeaths, totalDeathsPerMillion, fullyVaccinated, rateOfVaccination);
			records.add(newRecord);
			//System.out.println("Country:"+isoCode+" Date:"+date);
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

	public Vector<Record> getRecords(String isoCode) {
		Vector<Record> records = new Vector<>();
		for(Record record : this.records) {
			//System.out.println(isoCode);
			if(record.getCountry().equals(isoCode)) {
				records.add(record);
			}
		}
		Collections.sort(records, Comparator.comparing(Record::getDate) );
		return records;
	}

	public Record getLatestRecord(String isoCode, LocalDate date) {
		LocalDate latest = null;
		Record latestRecord = null;
		for(Record record : records) {
			System.out.println(record.getCountry()+"  "+record.getDate() );
			if(record.getCountry().equals(isoCode) && (latest == null || record.getDate().isAfter(latest))&&(record.getDate().isBefore(date)||(record.getDate().equals(date)) )) {
				latest = record.getDate();
				latestRecord = record;
			}
		}
		return latestRecord;
	}
}