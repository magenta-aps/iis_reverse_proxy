/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 * Søren Kirkegård
 *
 * The code is currently governed by OS2 - Offentligt digitaliserings-
 * fællesskab / http://www.os2web.dk .
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

import play.Application;
import play.GlobalSettings;
import play.Play;
import util.auth.IAuthStrategy;
import util.auth.ldap.TestAuthenticationStrategy;
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
	        	
	            bind(IAuthStrategy.class)
            	.toProvider(new Provider<IAuthStrategy>() {

					@Override
					public IAuthStrategy get() {
					
						play.Configuration config = Play.application().configuration();
						
						return new TestAuthenticationStrategy(config);
//	            		return new GenericLdapAuthenticationStrategy(config);
					}	
            	});
	            
	            
	            bind(ICprBrokerAccessor.class)
            	.toProvider(new Provider<ICprBrokerAccessor>() {

					@Override
					public ICprBrokerAccessor get() {		            
			        	play.Configuration conf = Play.application().configuration();
			        	boolean usingSsl = conf.getBoolean("cprbroker.usingssl");
			    		String endpoint = conf.getString("cprbroker.endpoint");
			    		String appToken  = conf.getString("cprbroker.applicationtoken");
			    		String userToken = conf.getString("cprbroker.usertoken");
			    		int allowedSourceUsageOrderHeader = conf.getInt("cprbroker.accesslevel");
			            String keystore = conf.getString("keystorefile");
			            String keystorePassword = conf.getString("keystorepassword");
			    		
			            play.Logger.debug("Global.bind(ICprBrokerAccessor.class).get(), endpoint: " + endpoint);
			            play.Logger.debug("Global.bind(ICprBrokerAccessor.class).get(), usingSsl: " + usingSsl);
			            play.Logger.debug("Global.bind(ICprBrokerAccessor.class).get(), appToken: " + appToken);
			            play.Logger.debug("Global.bind(ICprBrokerAccessor.class).get(), userToken: " + userToken);
			            play.Logger.debug("Global.bind(ICprBrokerAccessor.class).get(), allowedSourceUsageOrderHeader: " + allowedSourceUsageOrderHeader);
			            play.Logger.debug("Global.bind(ICprBrokerAccessor.class).get(), keystore: " + keystore);
			            play.Logger.debug("Global.bind(ICprBrokerAccessor.class).get(), keystorePassword: " + keystorePassword);
			            
	            		return new JaxWsCprBroker(endpoint,
	            									usingSsl,
	            									appToken,
	            									userToken,
	            									keystore,
	            									keystorePassword,
	            									allowedSourceUsageOrderHeader,
	            									new CPRBrokerSOAPFactory());
					}	
            	});	            
	            
	        }
        });
	}
	
	@Override
	public void onStart(Application app) {
		super.onStart(app);
		
		TestAuthenticationStrategy.validate(app.configuration());
		play.Logger.info("CPReader has started");
	}
	
	@Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        return injector.getInstance(controllerClass);
    }
}
