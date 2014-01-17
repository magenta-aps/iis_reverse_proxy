package conf;
import play.Configuration;
import play.Play;


public class PlayConfiguration implements IConfiguration {
	
	@Override
	public Configuration getConfiguration() {

		return Play.application().configuration();
	}

}
