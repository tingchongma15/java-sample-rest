package com.tcma.ui;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.inject.Inject;

import com.tcma.rest.PersonService;

@RequestScoped
@Named("sample")
public class Sample {
	private String name;

	@Inject
	private PersonService personService;

	public void saySample() {
		try {
			String response = personService.dateTime(name);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(response));
		}catch(Exception e){
			System.out.println(e.getCause());
			if(e.getCause() != null && e.getCause() instanceof ConstraintViolationException) {
				ConstraintViolationException ex = (ConstraintViolationException) e.getCause();
				String violations = "";
				for(ConstraintViolation<?> cv: ex.getConstraintViolations()) {
					violations += cv.getMessage() + "\n";
					System.err.println("Violations: "+violations);
				}
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(violations));
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}