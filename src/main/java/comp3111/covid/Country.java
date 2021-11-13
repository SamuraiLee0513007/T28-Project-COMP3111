package comp3111.covid;
public class Country {
     private String location, iso_code;
     private long population;
     private Records records[];
     private int capacity, occupied;
     public Country() {
    	 capacity = 5; 
         occupied = 0;
    	 population = 0;
    	 iso_code = location = null;
    	 records = new Records[capacity];
     }
     public Country(String lo,String iso,long po) {
    	 location = lo;
    	 iso_code = iso;
    	 capacity = 5;
    	 records = new Records[capacity];
    	 occupied = 0;
    	 population = po;
     }
     public Country(Country c) {
    	 location = c.location;
    	 iso_code = c.iso_code;
    	 population = c.population; 
    	 set_records(c.records);
     }
     private void EnlargeStorageWMultiple(int minCapacity){
         Records temp[] = new Records[capacity*minCapacity];
         for (int i=0; i < capacity; i++)
             temp[i] = new Records(records[i]);
         records = temp;
         capacity *= minCapacity;
     }
     public void addRecords(Records element){
         // double the capacity if all the allocated space is utilized
         if (occupied == capacity)
             EnlargeStorageWMultiple(2); 
         records[occupied] = new Records(element);
         occupied++;
     }
     public Records[] get_records() {
    	 Records[] temp= new Records[capacity];
    	 for(int i=0;i<capacity;i++) {
    		 if(records[i]!=null)
    			 temp[i] = new Records(records[i]);
    	 }
    	 return temp;
     }
     public String get_iso_code() {
    	 return iso_code;
     }
     public String get_location() {
    	 return location;
     }
     public long get_population() {
    	 return population;
     }
     public int get_capacity() {
    	 return capacity;
     }
     public int get_occupied() {
    	 return occupied;
     }
     private void set_records(Records[] r){
    	 Records[] temp= new Records[r.length];
    	 int count=0;
    	 for(int i=0;i<r.length;i++) {
    		 if(r[i]!=null) {
    			 temp[i] = new Records(r[i]);
    	         count++;
    		   }
    		 }
    	 occupied = count;
    	 capacity = r.length;
    	 records = temp;
     }
     public void set_population(long P) {
    	 population = P;
     }
     public void set_occupied(int O) {
    	 occupied = O;
     }
     public void set_iso_code(String iso) {
    	 iso_code = iso;
     }
     public void set_location(String lo) {
    	 location = lo;
     }
     public void set_capacity(int c) {
    	 capacity = c;
     }
     
}
