package com.j2ee.project.controler.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import javax.faces.application.FacesMessage;

@FacesValidator(value = "check.pwd")
public class passwordValidator implements Validator{

	private static final String PWD_PATTERN = "^.{4,20}";
	private Pattern pattern;
	private Matcher matcher;

	public passwordValidator() {
		pattern = Pattern.compile(PWD_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage(
					"Password validation failed : Password Validation failed please follow the contraint "
							+ PWD_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
			}
	}	
}