package br.com.globality.gam.console.model.util;

import org.apache.commons.lang.StringUtils;

import br.com.globality.gam.console.util.annotation.RESTful;

public class ModelUtil {
	
	private static final String BASE_PACKAGE = "br.com.globality.gam.model.";
	
	public static Class<?> getSuppportedClass(String entity) {
		try {
			Class<?> c = Class.forName(BASE_PACKAGE+StringUtils.capitalize(entity));
	    	if (c.isAnnotationPresent(RESTful.class)) {
	    		return c;
	    	}
	    	return null;
		}
		catch (Exception e) {
			return null;
		}
	}
	
}
