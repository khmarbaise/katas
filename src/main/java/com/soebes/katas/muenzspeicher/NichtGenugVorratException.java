package com.soebes.katas.muenzspeicher;

public class NichtGenugVorratException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NichtGenugVorratException() {
        super();
    }

    public NichtGenugVorratException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public NichtGenugVorratException(String arg0) {
        super(arg0);
    }

    public NichtGenugVorratException(Throwable arg0) {
        super(arg0);
    }


}
