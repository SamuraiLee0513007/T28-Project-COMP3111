package comp3111.covid;
import org.apache.commons.csv.*;
import edu.duke.*;
public class Records {
   private String Date;
   private long TotalCases;
   private float TotalCasesper1M;
   private long TotalDeath;
   private float TotalDeathper1M;
   private long FullyVaccninated;
   private float vaccination_rate;
   public Records(String d,long TC,float TC1,long TD,float TD1,long FV,float v) {
	   Date = d;
	   TotalCases = TC;
	   TotalCasesper1M = TC1;
	   TotalDeath = TD;
	   TotalDeathper1M = TD1;
	   FullyVaccninated = FV;
	   vaccination_rate = v;
   };
   public String getDate() {
	   return Date;
   }
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
   public void setDate(String d) {
	   Date = d;
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
