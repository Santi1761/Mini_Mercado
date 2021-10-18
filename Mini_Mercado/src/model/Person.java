package model;

import java.time.LocalDateTime;
import exceptions.First_Exception;
import exceptions.Second_Exception;

public class Person {
	
	private int day = LocalDateTime.now().getDayOfMonth();;
	private Document type_Document;
	private String variable;
		
	
	public Person(Document type_Document, String variable) throws Second_Exception {
		
		if(type_Document == Document.Tarjeta_Identidad) {
			throw new Second_Exception();
		} else {
			this.type_Document = type_Document;
			this.variable = variable;
		}
	}
	
		
	public void Login() throws First_Exception {
		
		if(day%2 == 0 && getPerson()%2 != 0) {
		} else if(day%2 != 0 && getPerson()%2 == 0) {
		} else {
			throw new First_Exception();
		}
	}
	

	public int getPerson() {
		
		String[] variable2 = variable.split("");
		
		return Integer.parseInt(variable2[(variable2.length-2)]);
	}
	
	public Document getType_Document() {
		
		return type_Document;
	}

	public String getVariable() {
		
		return variable;
	}
	
	
	
	
	
		

}
