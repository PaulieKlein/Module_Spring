package com.bankonet.model;

public class BankonetException extends Exception {
	private static final long serialVersionUID = 1L;
	public BankonetException()
	{
		super();
	}
	
	public BankonetException(String _message) {
		super(_message);
	}
	
}

