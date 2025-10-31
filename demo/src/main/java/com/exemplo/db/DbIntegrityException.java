package com.exemplo.db;

public class DbIntegrityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

	public DbIntegrityException(String msg) {
		super(msg);
	}
}
