package urldatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;



public class Application {
	//Scanner Object to use commonly
	private static Scanner scanner = new Scanner(System. in);
	//lineSeperator  to use commonly to avoid unwanted rebundancy
	private static String lineSeperator ="\n"+"-------------------------------------------------------"+"\n";
	
	public static void main(String[] args) {
		 System.out.println("Welcome to the Application"+lineSeperator);
		 //object to hold the URL details instead of a database call
		 List<UrlModel> urlDataList = new ArrayList<>();
		
		String command="";
		do {
		     System.out.println(lineSeperator+" Enter any valid commands from the Below List and hit Enter..");
		     System.out.println(" 1.Store a new URL : storeurl ");
		     System.out.println(" 2.Get a  URL      : get");
		     System.out.println(" 3.URL usage Count : count");
		     System.out.println(" 4.List URL        : list");
		     System.out.println(" 5.Exit Program    : exit");
		     System.out.println(lineSeperator+"Waiting for your Entry .......");
		    
		     command = scanner. nextLine();
		    
		     if("storeurl".equalsIgnoreCase(command)){
		    	 storeUrl(urlDataList);
		     }else if("get".equalsIgnoreCase(command)){
		    	 getUrl(urlDataList);
		    	 
		     }else if("count".equalsIgnoreCase(command)){
		    	 countUsage(urlDataList);
		     }else if("list".equalsIgnoreCase(command)){
		    	 listUrls(urlDataList);
		     }else{
		    	 System.out.println("Invalid command:  "+"\""+command+"\""+lineSeperator);
		     }
		     
		   }while( !"exit".equalsIgnoreCase(command) );
		
		System.out.println("Application ended...!!!"+lineSeperator); 
	}

	/**
	 * List Url and counts as Json list
	 * @param urlDataList
	 */
	private static void listUrls(List<UrlModel> urlDataList) {
		String json = new Gson().toJson(urlDataList);
		System.out.println("List in JSON Format");
		System.out.println(json + lineSeperator);
		
	}

	/**
	 * Find the usage count of given URL
	 * @param urlDataList
	 */
	private static void countUsage(List<UrlModel> urlDataList) {
		System.out.println("Enter the url to be counted and hit Enter.."+lineSeperator);
		String url=scanner. nextLine();
		boolean found=false;
		for(UrlModel siteUrl:urlDataList){
			if(url.equalsIgnoreCase(siteUrl.getSiteURL())){
				System.out.println("Usage Count: "+siteUrl.getUsageCount()+lineSeperator);
				found=true;
			}
		}
		if(!found){
			System.out.println(url+" is not available in the system"+lineSeperator);
		}
		
	}

	/**
	 * Get unique key of the provided URL
	 * @param urlDataList
	 */
	private static void getUrl(List<UrlModel> urlDataList) {
		System.out.println("Enter the url and hit Enter.."+lineSeperator);
		String url=scanner. nextLine();
		boolean found=false;
		for(UrlModel siteUrl:urlDataList){
			if(url.equalsIgnoreCase(siteUrl.getSiteURL())){
				System.out.println("Unique ID:"+siteUrl.getUniqueKey()+"\n");
				siteUrl.setUsageCount(siteUrl.getUsageCount()+1);
				found=true;
			}
		}
		if(!found){
			System.out.println(url+" is not available in the system"+lineSeperator);
		}
	}

	/**
	 * Store a New URl to the system
	 * @param urlDataList
	 */
	private static void storeUrl(List<UrlModel> urlDataList) {
		System.out.println("Enter the url to be saved and hit Enter.."+lineSeperator);
		String url=scanner. nextLine();
   	 	boolean alreadySaved=false;
		for(UrlModel siteUrl:urlDataList){
			if(url.equalsIgnoreCase(siteUrl.getSiteURL())){
				alreadySaved= true;
			}
		}
		if(!alreadySaved){
			UrlModel newURl =new UrlModel();
			newURl.setSiteURL(url);
			newURl.setUsageCount(0);
			urlDataList.add(newURl);
		}else{
			System.out.println(url+" already available."+lineSeperator);
		}
	}
	

}