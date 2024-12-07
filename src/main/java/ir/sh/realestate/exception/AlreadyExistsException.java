package ir.sh.realestate.exception;

import org.apache.catalina.webresources.TomcatJarInputStream;

public class AlreadyExistsException extends RuntimeException{
    private String [] params;
    public AlreadyExistsException(String message,String...parameters) {
        super(message);
        this.params=parameters;
    }

    public String[] getParams() {
        return params;
    }
}
