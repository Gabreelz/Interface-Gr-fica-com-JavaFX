package com.exemplo.model.exception;

import java.util.HashMap;
import java.util.Map;

public class Validation_exception extends RuntimeException {
    private static final long serialVersionUID = 1l;
    
    private Map<String, String> errors = new HashMap();

    public Validation_exception(String msg){
        super(msg);
    }

    public Map<String, String> getErrors(){
        return errors;
    }

    public void addErros(String fildName, String errorMessage){
        errors.put(fildName, errorMessage);
    }
}
