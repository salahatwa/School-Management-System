/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author salah
 */
@FacesValidator("com.atwaGroup.validators.cfPasswordValidator")
public class ConfirmPasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent cmp, Object value)
            throws ValidatorException {
        String compareTo = (String) cmp.getAttributes().get("compareTo");
        UIInput input = (UIInput) cmp.findComponent(compareTo);
        String otherValue = (String) input.getSubmittedValue();
        boolean error = false;
        if (value != null) {
            if (!value.equals(otherValue)) {
                error = true;
            }
        } else {
            if (otherValue != null) {
                error = true;
            }
        }
        if (error) {
           FacesMessage msg =
				new FacesMessage("Password don't match.",
						"Invalid password confirmation.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
        }
    }
}
