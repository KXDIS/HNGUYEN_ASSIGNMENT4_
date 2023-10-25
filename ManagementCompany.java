/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: company management for the plots on a given property
 * Due: 10/24/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: ___Hendrick Nguyen__
*/
import java.util.Arrays;
/** 
 * represents the management company array 
 * @author Hendrick Nguyen
 *
 */
public class ManagementCompany {
	//instantiated values	
	private static final int MGMT_DEPTH = 10;
	private static final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	
	//instantiated strings
	private String name;
	private String taxID;

	//instantiated objects
	private Property[] properties = new Property[MAX_PROPERTY];
	private Plot plot;
	
	
	private static final int MGMT_WIDTH = 10;
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public Property[] getProperties() {
		return properties;
	}
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}
	public Plot getPlot() {
		return plot;
	}
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	public static int getMgmtWidth() {
		return MGMT_WIDTH;
	}
	public static int getMgmtDepth() {
		return MGMT_DEPTH;
	}
	public static int getMaxProperty() {
		return MAX_PROPERTY;
	}




	/**
	 * Constructor no arg constructor that creates a ManagementCompany object using empty strings and the plot set to a Plot with x, y set to 0 , width and depth set to 10.
properties array is initialized here as well.
	 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	/**
	 *  Constructor Creates a ManagementCompany object using the passed information.
plot is set to a Plot with x, y set to 0 , width and depth set to 10
	 * @param name management company name
	 * @param taxID tax id
	 * @param mgmFee management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name; 
		this.taxID = taxID; 
		this.mgmFeePer = mgmFeePer; 
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information.
	 * @param name management company name
	 * @param taxID the tax ID
	 * @param mgmFeePer the management fee per property
	 * @param x x coord beginning
	 * @param y y coord beggining
	 * @param width the width of the property
	 * @param depth the width of the property
	 */
	public ManagementCompany(String name,String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID; 
		this.mgmFeePer = mgmFeePer; 
		this.plot = new Plot(x,y,width,depth);
		this.properties =new Property[MAX_PROPERTY];
	}
/**
 *   Copy Constructor that creates a ManagementCompany object from another ManagementCompany object
 * @param otherCompany another management company
 */
	public ManagementCompany (ManagementCompany otherCompany) {

		this.properties = new Property[MAX_PROPERTY];
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;

	}




	/**
	 *  Creates a property object by copying from another property and adds it to the "properties" array.
	 * @param property a property object
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */

	public  int addProperty(Property property){

		if (property == null) 
		{
			return -2;
		}

		if (!(this.plot.encompasses(property.getPlot()))) 
		{												
			return -3;
		}

		for (int i = 0; i < MAX_PROPERTY; i++) 
		{   	
			if (properties[i] != null) {

				if (property.getPlot().overlaps(properties[i].getPlot())) {

					return -4;
				}  
			} 
		}
		for (int i = 0; i < MAX_PROPERTY; i++) {
        	
            if (properties[i] == null) {
            	
                properties[i] = new Property(property);
                return i;
            }
        }
        return -1;
		

	}

	/**
	 *  Creates a property object with a default plot and adds it to the "properties" array.
	 * @param name property name
	 * @param city location of the property
	 * @param rent monthly rent
	 * @param owner  owner of the property
	 * @param x x location of upper left corner of property's plot
	 * @param y y location of upper left corner of property's plot
	 * @param width width of the property's plot
	 * @param depth depth of the property's plot
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */

	public int addProperty (String name,String city,double rent,String owner, int x, int y, int width,int depth) {

		return addProperty(new Property(name,city,rent,owner,x,y,width,depth));//creating a new object for 

	}

	/**
	 *  Creates a property object and adds it to the "properties" array.
	 * @param name property name
	 * @param city location of the property
	 * @param rent monthly rent
	 * @param owner  owner of the property
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name,String city,double rent,String owner) {		

		return addProperty(new Property(name,city,rent,owner));
	}

/**
 * This method finds a property within the properties array that 
 * has the maximum rent amount and returns the rent amount.
 * @return double, the maximum rent amount
 */

	/**
	 * 
	 * @return int , the index of the property with the maximum rent amount
	 */
	public Property getHighestRentProperty(){	

		 Property highest = properties[0];

		for (int i = 0; i < properties.length; i++) {
		if(properties[i] != null) {
			
		
			if (properties[i].getRentAmount() > highest.getRentAmount()) {
				highest = this.properties[i];
			}
		}
		}
		return highest;
	}

	public boolean isManagementFeeValid() {
       
            return (mgmFeePer < 0 || mgmFeePer > 100);
        
    }

	/**
	 * 
	 * @return true if the maximum amount of properties are 
	 * on the plot
	 */
	
	public boolean isPropertiesFull() {
		return (properties.length == MAX_PROPERTY);

}




/**
 * This method accesses each "Property" object within the array "properties" 
 * and sums up the property rent and returns the total amount.
 * @return the info for rent
 */
	public double getTotalRent() {
		double rent = 0.0;


		for(int i = 0; i< properties.length; i++) {
			
			if (properties[i] != null) 
			{

				rent += properties[i].getRentAmount();
			}

		}


		return rent;
	}


	  public void removeLastProperty() {
	        int position = properties.length - 1;
	        properties[position] = null;
	    }






	/**
	 * Displays the information of all the properties in the "properties" array.
	 */
	@Override
public String toString() {
	return "ManagementCompany [MAX_PROPERTY=" + MAX_PROPERTY + ", mgmFeePer=" + mgmFeePer + ", name=" + name
			+ ", properties=" + Arrays.toString(properties) + ", taxID=" + taxID + ", MGMT_WIDTH=" + MGMT_WIDTH
			+ ", MGMT_DEPTH=" + MGMT_DEPTH + ", plot=" + plot + "]";
}








}









