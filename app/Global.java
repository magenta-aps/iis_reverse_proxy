import play.GlobalSettings;
import util.IAuthenticationStrategy;
import util.LdapAuthenticationStrategy;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Global is used to handle global settings in the application
 * @see http://www.playframework.com/documentation/2.1.1/JavaGlobal
 * @author srnkrkgrd
 *
 */
public class Global extends GlobalSettings {

    private static final Injector INJECTOR = createInjector(); 

    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
		//TODO: Remove this Logger
		play.Logger.info("getControllerInstance method");
		play.Logger.info(INJECTOR.toString());

      return INJECTOR.getInstance(controllerClass);
    }

    private static Injector createInjector() {
		//TODO: Remove this Logger
		play.Logger.info("createInjector method");

    	
      return Guice.createInjector( new AbstractModule() {
          
    	  @Override
          protected void configure() {
              bind(IAuthenticationStrategy.class)
              .to(LdapAuthenticationStrategy.class);
          }
      }
    	  
       );
     
    }
    
  }

