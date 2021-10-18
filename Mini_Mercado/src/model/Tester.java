package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import exceptions.First_Exception;
import exceptions.Second_Exception;

class Tester {

	Person u = null;

	public void Scenary1(Document t, String n) {
		try {
			u = new Person(t, n);
		} catch (Second_Exception e) {
			fail();
		}
	}
	
	public void Scenary2(Document t, String n) {
		try {
			u = new Person(t, n);
			fail();
		} catch (Second_Exception e) {}
	}
	
	public void Scenary3(Document t, String n) {
		
		try {
			u = new Person(t, n);
			try {
				u.Login();
				fail();
			} catch (First_Exception e) {}
		} catch (Second_Exception e) {
			fail();
		}
		
		
	}

	@Test
	public void testPerson() {
		
		Scenary1(Document.Cedula_Ciudadania, "123456");
	}
	
	@Test
	public void testSecond_Exception() {
		
		Scenary2(Document.Tarjeta_Identidad, "123456");		
	}
	
	

}
