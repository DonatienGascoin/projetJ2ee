package com.j2ee.project.controler.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import javax.faces.application.FacesMessage;

@FacesValidator(value = "check.mail")
public class emailValidator implements Validator{

	private static final String MAIL_PATTERN = "^[a-zA-Z0-9-._]+@[a-zA-Z0-9-._]+.[a-z]+";
	private Pattern pattern;
	private Matcher matcher;

	public emailValidator() {
		pattern = Pattern.compile(MAIL_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage(
					"Mail validation failed : Mail Validation failed please follow the contraint "
							+ MAIL_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
			}
	}	
}