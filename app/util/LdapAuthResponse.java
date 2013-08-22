package util;

public class LdapAuthResponse implements IAuthResponse {
	
	private final AuthResponseType type;
	private final String message;
	
	public LdapAuthResponse(AuthResponseType newType, String newMessage) {
		type = newType;
		message = newMessage;
	}
	
	@Override
	public String message() {
		return message;
	}

	@Override
	public AuthResponseType type() {
		return type;
	}
	
}
