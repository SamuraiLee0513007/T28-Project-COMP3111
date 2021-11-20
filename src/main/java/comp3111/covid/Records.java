package comp3111.covid;
import org.apache.commons.csv.*;
import edu.duke.*;
public class Records {
   private String Date;
   private long TotalCases;
   //private float TotalCasesper1M;
   private long TotalDeath;
   //private float TotalDeathper1M;
   private long FullyVaccinated;
   //private float vaccination_rate;
   public Records(String d,long TC,long TD,long FV) {
	   Date = d;
	   TotalCases = TC;
	   TotalDeath = TD;
	   FullyVaccinated = FV;
   };
   public Records(Records r) {
	   this(r.Date,r.TotalCases,r.TotalDeath,r.FullyVaccinated);
   }
   public String getDate() {
	   return Date;
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
	   return (float)FullyVaccinated*1000000/P;
   }
   public void setDate(String d) {
	   Date = d;
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
	   if(Date.compareTo(Re.Date)==0 && TotalCases==Re.TotalCases &&
	   TotalDeath==Re.TotalDeath && FullyVaccinated==Re.FullyVaccinated)
		   return true;
	   else
		   return false;
		   
   }
}
