package org.trmga.genericutility;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * This class contains all the reusable java logics and methods.
 * @author TYSS Pavithran
 */
public class JavaUtility {
	
	/**
	 * This method is used to generate random string data.
	 * @return
	 */
	public String getRandomData() {
		
		UUID uniqueNum=UUID.randomUUID();
		
		String ranData = uniqueNum.toString().replaceAll("[^a-zA-Z]", "");
		
		return ranData;
	}
	
	/**
	 * This method is used to generate random number.
	 * @return
	 */
	public int getrandomNumber() {
		
		Random random = new Random();
		
		return random.nextInt(100000);	}

	/**
	 * This method is used to capture current system date and time 
	 * @return
	 */
	public String getTimeStamp() {
		
		return LocalDateTime.now().toString().replace(":", "_");
	}

	
}
