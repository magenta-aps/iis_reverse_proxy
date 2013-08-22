import play.GlobalSettings;
import util.IAuthStrategy;
import util.LdapAuthenticationStrategy;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Global is the place to hook into the application lifecycle, which makes it
 * the place to manage dependency injection. Here Google Guice's injector is
 * placed in the constructor. It is kept 'in the club', due to the nature of
 * the getControllerInstance method, which is called for all managed routes.
 * 
 * Routes can be tagged as managed by placing a @ infront of the controller,
 * which they should manage. A such method can not be static, so remember to
 * make it non-static.
 * 
 * @author Søren Kirkegård
 *
 */
public class Global extends GlobalSettings {
	private final Injector injector;
	
	public Global() {
		super();

		injector = Guice.createInjector(new AbstractModule() {
	        @Override
	        protected void configure() {
	            play.Logger.info("Global constructor ran");
	            bind(IAuthStrategy.class)
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
