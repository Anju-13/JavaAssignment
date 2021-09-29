package urldatabase;



import java.util.UUID;

public class UrlModel {
	
	UUID  uniqueKey ;
	
	String siteURL;
	
	int usageCount;
	
	
	public UrlModel() {
		this.uniqueKey=UUID.randomUUID();
	}

	public UUID getUniqueKey() {
		return uniqueKey;
	}

	public String getSiteURL() {
		return siteURL;
	}

	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}

	public int getUsageCount() {
		return usageCount;
	}

	public void setUsageCount(int usageCount) {
		this.usageCount = usageCount;
	}
	
	

}