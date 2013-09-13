package util.cprbroker.models;

import util.cprbroker.IUuid;

public class Uuid implements IUuid {
	
	private final String uuid;
	private final String message;
	private final int code;
	
	// Lazy initialized, cached hashCode
	private volatile int hashCode;
	
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
	
	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			result = 5;
			result = result + message.hashCode();
			result = result + code;
			result = result + uuid.hashCode();
		}
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!( obj instanceof Uuid))
			return false;
		Uuid u = (Uuid) obj;
		return code == u.code() && message == u.message() && uuid == u.value();
		
	}


}
