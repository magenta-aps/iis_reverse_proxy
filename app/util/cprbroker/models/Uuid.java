package util.cprbroker.models;

import util.cprbroker.IUuid;

public class Uuid implements IUuid {
	
	private final String uuid;
	private final String message;
	private final int code;
	
	/**
	 * 
	 * @param newUuid String representation of a hyphenated Guid with a length of 36
	 * @param newCode CPR Broker status code
	 * @param newMessage CPR Broker message
	 * @throws IllegaArgumentException Throws if newUuid length != 36
	 */
	public Uuid(final String newUuid, final int newCode, final String newMessage) {
		//TODO make a pattern match instead!
		if(newUuid.length() != 36) throw new IllegalArgumentException("A uuid must be a String representation of a hyphenated Guid with a length of 36");
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
	public String value() {
		return uuid;
	}
	
	@Override
	public String toString() {
		return uuid;
	}

}
