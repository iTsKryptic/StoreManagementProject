package model;

public class Item {
	private String storeID;
	private String itemID;
	private String itemCategory;
	private String itemName;
	private double itemPrice;

	public Item(String storeID,String itemID, String itemCategory, String itemName, double itemPrice) {
		this.setStoreID(storeID);
		this.itemID = itemID;
		this.itemCategory=itemCategory;
		this.itemName=itemName;
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the itemID
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the itemCategory
	 */
	public String getItemCategory() {
		return itemCategory;
	}

	/**
	 * @param itemCategory the itemCategory to set
	 */
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemPrice
	 */
	public double getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
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
