package conf;

/**
 * Objects that need to be able to be validated in the Global settings
 * onStart. Follows the Command pattern. 
 * @author Søren Kirkegård
 *
 */
public interface IValidable {
	
	boolean validate();

}
