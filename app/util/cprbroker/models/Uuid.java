package util.cprbroker.models;

import util.cprbroker.IUuid;

public class Uuid implements IUuid {
	
	private final String uuid;
	private final String message;
	private final int code;
	
	
	public Uuid(final String newUuid, final int newCode, final String newMessage) {
		uuid = newUuid;
		message = newMessage;
		code = newCode;
	}

	@Override
	public String message() {
		return message;
	}

	@Override
	public int code() {
		return code;
	}

	@Override
	public String uuid() {
		return uuid;
	}

}
