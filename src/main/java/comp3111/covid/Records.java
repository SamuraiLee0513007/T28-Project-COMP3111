package comp3111.covid;
import org.apache.commons.csv.*;
import edu.duke.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Records {
   private LocalDate Date;
   private long TotalCases;
   //private float TotalCasesper1M;
   private long TotalDeath;
   //private float TotalDeathper1M;
   private long FullyVaccinated;
   //private float vaccination_rate;
   public Records(String d,long TC,long TD,long FV) {
	   Date = LocalDate.parse(d,DateTimeFormatter.ofPattern("dd/mm/yyyy"));
	   TotalCases = TC;
	   TotalDeath = TD;
	   FullyVaccinated = FV;
   };
   public Records(Records r) {
	   this(r.Date.toString(),r.TotalCases,r.TotalDeath,r.FullyVaccinated);
   }
   public String getDate() {
	   return Date.toString();
   }
   public long getTotalCases() {
	   return TotalCases;
   }
   public float getTotalCasesper1M(long P){
	   return (float)TotalCases*1000000/P;
   }
   public long getTotalDeath() {
	   return TotalDeath;
   }
   public float getTotalDeathper1M(long P) {
	   return (float)TotalDeath*1000000/P;
   }
   public long getFullyVaccninated() {
	   return FullyVaccinated;
   }
   public float getvaccination_rate(long P) {
	   return (float)FullyVaccinated/P;
   }
   public void setDate(String d) {
	   Date = LocalDate.parse(d);
   }
   public void setTotalCases(long TC) {
	   TotalCases = TC;
   }
   public void setTotalDeath(long TD) {
	   TotalDeath = TD;
   }
   public void setFullyVaccninated(long FV){
	   FullyVaccinated = FV;
   }
   public boolean equals(Records Re) {
	   if(Date.equals(Re.Date)&& TotalCases==Re.TotalCases &&
	   TotalDeath==Re.TotalDeath && FullyVaccinated==Re.FullyVaccinated)
		   return true;
	   else
		   return false;
		   
   }
}
