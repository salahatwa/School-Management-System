/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.validators;

import java.net.URI;
import java.net.URISyntaxException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author salah
 */
@FacesValidator("com.atwaGroup.validators.UrlValidator")
public class UrlValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        StringBuilder url = new StringBuilder();
        String urlValue = value.toString();

        if (!urlValue.startsWith("http://", 0)) {
            url.append("http://");
        }
        url.append(urlValue);

        try {
            new URI(url.toString());
        } catch (URISyntaxException e) {
            FacesMessage msg
                    = new FacesMessage("URL validation failed", "Invalid URL format");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }

}
