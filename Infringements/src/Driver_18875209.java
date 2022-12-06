//NAME: SUMBUDDHA BHANDARI
//Student Id: 18875209
public class Driver_18875209 {
	private String licenceNum;
	private String licenceClass;
	private String firstName;
	private String lastName;
	private String address;
	private String suburb;
	private String postCode;
	private int demeritPoints;

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode
	 *            the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	private String licenceStatus;

	/**
	 * @param licenceNum
	 * @param licenceClass
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param suburb
	 * @param demeritPoints
	 * @param licenceStatus
	 */
	public Driver_18875209(String licenceNum, String licenceClass, String firstName, String lastName, String address,
			String suburb, int demeritPoints, String licenceStatus) {
		super();
		this.licenceNum = licenceNum;
		this.licenceClass = licenceClass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.suburb = suburb;
		this.demeritPoints = demeritPoints;
		this.licenceStatus = licenceStatus;
	}

	/**
	 * @return the licenceNum
	 */
	public String getLicenceNum() {
		return licenceNum;
	}

	/**
	 * @param licenceNum
	 *            the licenceNum to set
	 */
	public void setLicenceNum(String licenceNum) {
		this.licenceNum = licenceNum;
	}

	/**
	 * @return the licenceClass
	 */
	public String getLicenceClass() {
		return licenceClass;
	}

	/**
	 * @param licenceClass
	 *            the licenceClass to set
	 */
	public void setLicenceClass(String licenceClass) {
		this.licenceClass = licenceClass;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the suburb
	 */
	public String getSuburb() {
		return suburb;
	}

	/**
	 * @param suburb
	 *            the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	/**
	 * @return the demeritPoints
	 */
	public int getDemeritPoints() {
		return demeritPoints;
	}

	/**
	 * @param demeritPoints
	 *            the demeritPoints to set
	 */
	public void setDemeritPoints(int demeritPoints) {
		this.demeritPoints = demeritPoints;
	}

	/**
	 * @return the licenceStatus
	 */
	public String getLicenceStatus() {
		return licenceStatus;
	}

	/**
	 * @param licenceStatus
	 *            the licenceStatus to set
	 */
	public void setLicenceStatus(String licenceStatus) {
		this.licenceStatus = licenceStatus;
	}

}
