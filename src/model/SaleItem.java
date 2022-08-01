package model;

public class SaleItem extends Item{

	
	private String duration;
	private String percentage;
	// Item(String storeID,String itemID, String itemCategory, String itemName, double itemPrice) {
	public SaleItem(String storeID,String itemID, String itemName, String itemCategory, double itemPrice, String duration,String percentage) {
		super(storeID,itemID,itemCategory,itemName,itemPrice);
		this.setDuration(duration);
		this.setPercentage(percentage);

	}



	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

}
