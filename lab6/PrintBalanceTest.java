package lab6;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;


public class PrintBalanceTest {
	
	String name = "Tiffany";
	Locale englishLocale = new Locale("en", "US");
	Locale germanLocale = new Locale("de", "DE");
	Locale frenchLocale = new Locale("fr", "FR");
	ResourceBundle englishBundle = PrintBalance.setupBundle(englishLocale);
	ResourceBundle germanBundle = PrintBalance.setupBundle(germanLocale);
	ResourceBundle frenchBundle = PrintBalance.setupBundle(frenchLocale);
	
	@Test
	public void testEnglishHelloWorld() {
		PrintBalance.balance = englishBundle;
		assertEquals("Hello World", PrintBalance.helloWorld());
	}
	
	@Test
	public void testEnglishInquiry() {
		PrintBalance.balance = englishBundle;
		assertEquals("Please enter your name", PrintBalance.inquiry());
	}
	
	@Test
	public void testEnglishGreeting() {
		PrintBalance.balance = englishBundle;
		assertEquals("I am pleased to meet you Tiffany", PrintBalance.greeting(name));
	}
	
	@Test
	public void testEnglishFarewell() {
		PrintBalance.balance = englishBundle;
		assertEquals("Good Bye", PrintBalance.farewell());
	}
	
	@Test
	public void testGermanHelloWorld() {
		PrintBalance.balance = germanBundle;
		assertEquals("Hallo Welt", PrintBalance.helloWorld());
	}
	
	@Test
	public void testGermanInquiry() {
		PrintBalance.balance = germanBundle;
		assertEquals("Tragen Sie bitte Ihren Namen ein", PrintBalance.inquiry());
	}
	
	@Test
	public void testGermanGreeting() {
		PrintBalance.balance = germanBundle;
		assertEquals("Ich freue mich, Sie zu treffen Tiffany", PrintBalance.greeting(name));
	}
	
	@Test
	public void testGermanFarewell() {
		PrintBalance.balance = germanBundle;
		assertEquals("Auf Wiedersehen", PrintBalance.farewell());
	}
	
	@Test
	public void testFrenchHelloWorld() {
		PrintBalance.balance = frenchBundle;
		assertEquals("Bonjour monde", PrintBalance.helloWorld());
	}
	
	@Test
	public void testFrenchInquiry() {
		PrintBalance.balance = frenchBundle;
		assertEquals("Veuillez écrire votre nom", PrintBalance.inquiry());
	}
	
	@Test
	public void testFrenchGreeting() {
		PrintBalance.balance = frenchBundle;
		assertEquals("Je suis heureux de vous rencontrer Tiffany", PrintBalance.greeting(name));
	}
	
	@Test
	public void testFrenchFarewell() {
		PrintBalance.balance = frenchBundle;
		assertEquals("Au revoir", PrintBalance.farewell());
	}
	
	@Test
	public void testEnglishGiveBalance() {
		Double amount = 527648321.23;
		PrintBalance.balance = englishBundle;
		assertEquals("You owe the school $527,648,321.23", PrintBalance.giveBalance(amount, englishLocale));
	}
	
	@Test
	public void testGermanGiveBalance() {
		Double amount = 527648321.23;
		PrintBalance.balance = germanBundle;
		assertEquals("Sie verdanken die Schule 527.648.321,23 €", PrintBalance.giveBalance(amount, germanLocale));
	}
	
	@Test
	public void testFrenchGiveBalance() {
		Double amount = 527648321.23;
		PrintBalance.balance = frenchBundle;
		assertEquals("Vous devez l'école 527 648 321,23 €", PrintBalance.giveBalance(amount, frenchLocale));
	}
}
