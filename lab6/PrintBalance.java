package lab6;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


/**
 * TODO A simple class that needs to be localized
 *
 * @author mohan.
 *         Created Mar 27, 2011.
 */
public class PrintBalance{
	
	static ResourceBundle balance;
	
	/**
	 * Simple Java Method that is crying out to be localized.
	 *
	 * @param args
	 */
	public static void main(String args[])
	{	
		Locale currentLocale;
		
//		currentLocale = new Locale("en", "US");
//		currentLocale = new Locale("de", "DE");
		currentLocale = new Locale("fr", "FR");
		
		balance = setupBundle(currentLocale);
		
		String helloWorld = helloWorld();
		String inquiry = inquiry();
		
		System.out.println(helloWorld);
		System.out.println(inquiry);
		
		String name = getName();
		String greeting = greeting(name);
		
		String giveDate = giveDate(new Date(), currentLocale);
		String giveBalance = giveBalance(9876543.21, currentLocale);
		String farewell = farewell();
		
		System.out.println(greeting);
		System.out.println(giveDate);
		System.out.println(giveBalance);
		System.out.println(farewell);
	}
	
	public static ResourceBundle setupBundle(Locale currentLocale) {
		return ResourceBundle.getBundle("BalanceBundle", currentLocale);
	}
	
	public static String helloWorld() {
		// Greeting
		return balance.getString("helloWorld");
	}
	
	public static String inquiry() {
		return balance.getString("inquiry");
	}
	
	public static String getName() {
		Scanner scanInput = new Scanner(System.in);
		
		String name = scanInput.nextLine();
		
		return name;
	}
	
	public static String greeting(String name) {
		String greeting = balance.getString("greeting") + name;
		return greeting;
		
	}
	
	public static String giveDate(Date today, Locale currentLocale) {		
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL, currentLocale);
		String date = df.format(today);
		
		//today's date, balance and bid goodbye
		String dateString = balance.getString("giveDate") + date;
		
		return dateString;
	}
	
	public static String giveBalance(Double amount, Locale currentLocale) {
		NumberFormat regionCurrenyFormat = NumberFormat.getCurrencyInstance(currentLocale);;
		String stringAmount = regionCurrenyFormat.format(amount);
		String balanceString = balance.getString("owe") + stringAmount;		
		return balanceString;
	}
	
	public static String farewell() {
		return balance.getString("farewell");
	}
}