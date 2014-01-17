package conf;
import play.Configuration;

/**
 * Adapter interface for allowing injection of the Play.Configuration object
 * that doesn't have its own interface.
 * @author Søren Kirkegård
 *
 */
public interface IConfiguration {
	
	Configuration getConfiguration();

}
