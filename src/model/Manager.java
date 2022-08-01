package model;

public class Manager {
	private String id;
	private String name;
	private String address;
	private String password;
	private String storeID;
	
	public Manager(String id,String name, String address,String password,String storeID) {
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setPassword(password);
		this.setStoreID(storeID);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the storeID
	 */
	public String getStoreID() {
		return storeID;
	}

	/**
	 * @param storeID the storeID to set
	 */
	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}
	

}
