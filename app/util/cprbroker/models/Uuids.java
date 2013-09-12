package util.cprbroker.models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.cprbroker.IUuids;

public class Uuids implements IUuids {

	private final List<String> uuids;
	private final String message;
	private final int code;
	
	public Uuids(final int newCode, final String newMessage, final List<String> newUuids) {
		
		uuids = defensiveCopyOfValues(newUuids);
		message = newMessage;
		code = newCode;
	}
	
	@Override
	public String message() { return message; }

	@Override
	public int code() {	return code; }

	@Override
	public List<String> values() { return uuids; }
	
	/**
	 * helper method to make the class immutable
	 * @param referencedValues String representations of Uuids
	 * @return Collections.unmodifiableList of a copy of the referencedValues
	 */
	private List<String> defensiveCopyOfValues(List<String> referencedValues) {
		
		List<String> copy = new LinkedList<String>();
		
		for(String uuid : referencedValues) {
			copy.add(uuid);
		}
		
		return Collections.unmodifiableList(copy);
	}
	
}
