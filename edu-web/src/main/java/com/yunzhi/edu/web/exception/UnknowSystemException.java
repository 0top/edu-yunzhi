package com.yunzhi.edu.web.exception;

public class UnknowSystemException extends Exception {

	/**
	 * unknownSystemException
	 */
	private static final long serialVersionUID = 7614778000067184570L;
	
	public UnknowSystemException() {
		super();
	}

	public UnknowSystemException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UnknowSystemException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UnknowSystemException(String arg0) {
		super(arg0);
	}

	public UnknowSystemException(Throwable arg0) {
		super(arg0);
	}

}
