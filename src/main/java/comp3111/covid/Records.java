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
			String isoCode = null;
			LocalDate date = null;
			Long newCases = null;
			Long totalCases = null;
			Double totalCasesPerMillion = null;
			Long newDeaths = null;
			Long totalDeaths = null;
			Double totalDeathsPerMillion = null;
			Long fullyVaccinated = null;
			Double rateOfVaccination = null;
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
            if(record.getCountry().equals(isoCode)) {
                records.add(record);
            }
        }
        Collections.sort(records, Comparator.comparing(Record::getDate) );
        return records;
    }

	public Vector<Record> getRecordsUpTo(String isoCode, LocalDate date) {
        Vector<Record> records = new Vector<>();
        for(Record record : this.records) {
            if(record.getCountry().equals(isoCode) && !record.getDate().isAfter(date)) {
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
			if(record.getCountry().equals(isoCode) && (latest == null || record.getDate().isAfter(latest))) {
				latest = record.getDate();
				latestRecord = record;
			}
		}
		return latestRecord;
	}
	
	public StatisticsReport getLatestStatistics(String isoCode, LocalDate date) {
		StatisticsReport latestStatistics = null;
		Statistic<Long> newCases = null;
		Statistic<Long> totalCases = null;
		Statistic<Double> totalCasesPerMillion = null;
		Statistic<Long> newDeaths = null;
		Statistic<Long> totalDeaths = null;
		Statistic<Double> totalDeathsPerMillion = null;
		Statistic<Long> fullyVaccinated = null;
		Statistic<Double> rateOfVaccination = null;	// in percentage
		Vector<Record> records = getRecordsUpTo(isoCode, date);
		Collections.reverse(records);
		for(Record record : records) {
			if(newCases == null && record.getNewCases() != null) {
				newCases = new Statistic<Long>(record.getNewCases(), record.getDate());
			}
			if(totalCases == null && record.getTotalCases() != null) {
				totalCases = new Statistic<Long>(record.getTotalCases(), record.getDate());
			}
			if(totalCasesPerMillion == null && record.getTotalCasesPerMillion() != null) {
				totalCasesPerMillion = new Statistic<Double>(record.getTotalCasesPerMillion(), record.getDate());
			}
			if(newDeaths == null && record.getNewDeaths() != null) {
				newDeaths = new Statistic<Long>(record.getNewDeaths(), record.getDate());
			}
			if(totalDeaths == null && record.getTotalDeaths() != null) {
				totalDeaths = new Statistic<Long>(record.getTotalDeaths(), record.getDate());
			}
			if(totalDeathsPerMillion == null && record.getTotalDeathsPerMillion() != null) {
				totalDeathsPerMillion = new Statistic<Double>(record.getTotalDeathsPerMillion(), record.getDate());
			}
			if(fullyVaccinated == null && record.getFullyVaccinated() != null) {
				fullyVaccinated = new Statistic<Long>(record.getFullyVaccinated(), record.getDate());
			}
			if(rateOfVaccination == null && record.getRateOfVaccination() != null) {
				rateOfVaccination = new Statistic<Double>(record.getRateOfVaccination(), record.getDate());
			}
		}
		if(newCases == null) {
			newCases = new Statistic<Long>(Long.valueOf(0));
		}
		if(totalCases == null) {
			totalCases = new Statistic<Long>(Long.valueOf(0));
		}
		if(totalCasesPerMillion == null) {
			totalCasesPerMillion = new Statistic<Double>(Double.valueOf(0));
		}
		if(newDeaths == null) {
			newDeaths = new Statistic<Long>(Long.valueOf(0));
		}
		if(totalDeaths == null) {
			totalDeaths = new Statistic<Long>(Long.valueOf(0));
		}
		if(totalDeathsPerMillion == null) {
			totalDeathsPerMillion = new Statistic<Double>(Double.valueOf(0));
		}
		if(fullyVaccinated == null) {
			fullyVaccinated = new Statistic<Long>(Long.valueOf(0));
		}
		if(rateOfVaccination == null) {
			rateOfVaccination = new Statistic<Double>(Double.valueOf(0));
		}
		latestStatistics = new StatisticsReport(isoCode, date, newCases, totalCases, totalCasesPerMillion, newDeaths, totalDeaths, totalDeathsPerMillion, fullyVaccinated, rateOfVaccination);
		return latestStatistics;
	}
}
