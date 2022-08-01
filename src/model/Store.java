package model;

public class Store {
	private String id;
	private String name;
	private String address;
	private String open;
	private String close;

	public Store(String id,String name, String address, String open, String close) {
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setOpen(open);
		this.setClose(close);

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
	 * @return the open
	 */
	public String getOpen() {
		return open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(String open) {
		this.open = open;
	}

	/**
	 * @return the close
	 */
	public String getClose() {
		return close;
	}

	/**
	 * @param close the close to set
	 */
	public void setClose(String close) {
		this.close = close;
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
	
	

}
