package comp3111.covid;
import comp3111.covid.DataAnalysis;
import org.apache.commons.csv.CSVRecord;

public class Records1 {
    private long TotalCases;
    private float TotalCasesper1M;
    private long TotalDeath;
    private float TotalDeathper1M;
    private long FullyVaccninated;
    private float vaccination_rate;
    public Records1(String csvfile, String iso_code){
        long confirmedCases = 0;
        for (CSVRecord rec : DataAnalysis.getFileParser(csvfile)) {

            if (rec.get("iso_code").equals(iso_code)) {
                String s = rec.get("new_cases");
                if (!s.equals("")) {
                    confirmedCases += Long.parseLong(s);
                }
            }
        }
        TotalCases = confirmedCases;

        long confirmedDeaths = 0;
        for (CSVRecord rec : DataAnalysis.getFileParser(csvfile)) {

            if (rec.get("iso_code").equals(iso_code)) {
                String s = rec.get("new_deaths");
                if (!s.equals("")) {
                    confirmedDeaths += Long.parseLong(s);
                }
            }
        }
        TotalDeath = confirmedDeaths;

        long fullyVaccinated = 0;
        long population = 0;
        float rate = 0.0f;
        for (CSVRecord rec : DataAnalysis.getFileParser(csvfile)) {

            if (rec.get("iso_code").equals(iso_code)) {

                String s1 = rec.get("people_fully_vaccinated");
                String s2 = rec.get("population");
                if (!s1.equals("") && !s2.equals("")) {
                    fullyVaccinated = Long.parseLong(s1);
                    population = Long.parseLong(s2);
                }
            }
        }
        if (population !=0)
            rate = (float) fullyVaccinated / population * 100;
        FullyVaccninated = fullyVaccinated;
        vaccination_rate = rate;
        TotalCasesper1M = confirmedCases / population * 100000;
        TotalDeathper1M = confirmedDeaths / population * 100000;
    };
    public Records1(String d,long TC,float TC1,long TD,float TD1,long FV,float v) {
        TotalCases = TC;
        TotalCasesper1M = TC1;
        TotalDeath = TD;
        TotalDeathper1M = TD1;
        FullyVaccninated = FV;
        vaccination_rate = v;
    };
    public long getTotalCases() {
        return TotalCases;
    }
    public float getTotalCasesper1M(){
        return TotalCasesper1M;
    }
    public long getTotalDeath() {
        return TotalDeath;
    }
    public float getTotalDeathper1M() {
        return TotalDeathper1M;
    }
    public long getFullyVaccninated() {
        return FullyVaccninated;
    }
    public float getvaccination_rate() {
        return vaccination_rate;
    }
    public void setTotalCases(long TC) {
        TotalCases = TC;
    }
    public void setTotalCasesper1M(float TC1) {
        TotalCasesper1M = TC1;
    }
    public void setTotalDeath(long TD) {
        TotalDeath = TD;
    }
    public void setTotalDeathper1M(float TD1) {
        TotalDeathper1M = TD1;
    }
    public void setFullyVaccninated(long FV){
        FullyVaccninated = FV;
    }
    public void setvaccination_rate(float r){
        vaccination_rate = r;
    }
}