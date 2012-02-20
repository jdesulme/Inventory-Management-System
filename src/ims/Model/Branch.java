package ims.Model;

/**
 * @author Minh, Kumar, Jean
 * @version 02/17/2012
 */

public class Branch {
	
	//Declare attributes
	private String branchName;
	private String branchAddress;
	private String branchPhone;
	private String cityOrProvince;
	
	/*
	 * Constructor
	 */
	public Branch (String inName, String inAddress, String inPhone, String cityOrProvince)
	{
		this.branchName = inName;
		this.branchAddress = inAddress;
		this.branchPhone = inPhone;
		this.cityOrProvince = cityOrProvince;		
	}
	
	/*
	 * Accessor for branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/*
	 * Mutator for branchName
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/*
	 * Accessor for branchAddress
	 */
	public String getBranchAddress() {
		return branchAddress;
	}
	
	/*
	 * Mutator for branchAddress
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	/*
	 * Accessor for branchPhone
	 */
	public String getBranchPhone() {
		return branchPhone;
	}

	/*
	 * Mutator for branchPhone
	 */
	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	/*
	 * Accessor for cityOrProvince
	 */
	public String getCityOrProvince() {
		return cityOrProvince;
	}

	/*
	 * Mutator for cityOrProvince
	 */
	public void setCityOrProvince(String cityOrProvince) {
		this.cityOrProvince = cityOrProvince;
	}
	
	
}
