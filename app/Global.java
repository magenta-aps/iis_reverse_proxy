import play.Application;
import play.GlobalSettings;
import util.IAuthenticationStrategy;
import util.LdapAuthenticationStrategy;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Empty GlobalSettings added because Jacoco wouldn't run otherwise,
 * which is kind of weird.
 * @author srnkrkgrd
 *
 */
public class Global extends GlobalSettings {
	private Injector injector;
	
	@Override
	public void onStart(Application app) {
		injector = Guice.createInjector(new AbstractModule() {
	        @Override
	        protected void configure() {
	            play.Logger.info("On start configure ran");
	            bind(IAuthenticationStrategy.class)
	            	.to(LdapAuthenticationStrategy.class);
	        }
        });
	}
	
	 @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
		play.Logger.info("getControllerInstance ran - called by " + controllerClass.getName());
        return injector.getInstance(controllerClass);
    }
}
