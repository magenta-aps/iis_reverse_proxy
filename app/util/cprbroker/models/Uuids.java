package util.cprbroker.models;

import java.util.List;

import util.cprbroker.IUuids;

public class Uuids implements IUuids {

	private final List<String> uuids;
	private final String message;
	private final int code;
	
	public Uuids(int newCode, String newMessage, List<String> newUuids) {
		uuids = newUuids;
		message = newMessage;
		code = newCode;
	}
	
	@Override
	public String message() { return message; }

	@Override
	public int code() {	return code; }

	//TODO Make defensive copy
	@Override
	public List<String> uuids() { return uuids; }

}
