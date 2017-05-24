package com.j2ee.project.controler.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;

@FacesValidator(value = "check.pwd2")
public class password2Validator implements Validator{

	private String valuePwd2;
	private UIInput pwdComponent;
	private String valuePwd;

	public password2Validator() {
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		valuePwd2 = value.toString();
		pwdComponent = (UIInput) component.getAttributes().get("pwdTest");
		valuePwd = (String) pwdComponent.getValue();
		
		
		if(valuePwd==null || !valuePwd.equals(valuePwd2)){
			FacesMessage msg = new FacesMessage(
					"Password validation failed : Please enter the same two passwords");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
