import play.GlobalSettings;
import play.Play;
import util.auth.IAuthStrategy;
import util.auth.ldap.LdapAuthenticationStrategy;
import util.cprbroker.ICprBrokerAccessor;
import util.cprbroker.jaxws.JaxWsCprBroker;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

import dk.magenta.cprbrokersoapfactory.CPRBrokerSOAPFactory;

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
            	.toProvider(new Provider<IAuthStrategy>() {

					@Override
					public IAuthStrategy get() {			            
			        	play.Configuration conf = Play.application().configuration();
			    		String hostname = conf.getString("ldap.hostname");
			    		int port = conf.getInt("ldap.port");
			    		String basedn  = conf.getString("ldap.basedn");
			    		String groupdn = conf.getString("ldap.groupdn");
			    		String groupfield = conf.getString("ldap.groupfield");
			            
	            		return new LdapAuthenticationStrategy(hostname, port, basedn, groupdn, groupfield);
					}	
            	});
	            
	            
	            bind(ICprBrokerAccessor.class)
            	.toProvider(new Provider<ICprBrokerAccessor>() {

					@Override
					public ICprBrokerAccessor get() {		            
			        	play.Configuration conf = Play.application().configuration();
			    		String endpoint = conf.getString("cprbroker.endpoint");
			    		String appToken  = conf.getString("cprbroker.applicationtoken");
			    		String userToken = conf.getString("cprbroker.usertoken");
			            
	            		return new JaxWsCprBroker(endpoint, appToken, userToken, new CPRBrokerSOAPFactory());
					}	
            	});	            
	            
	        }
        });
	}
		
	@Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
		play.Logger.info("getControllerInstance ran - called by " + controllerClass.getName());
        return injector.getInstance(controllerClass);
    }
}
