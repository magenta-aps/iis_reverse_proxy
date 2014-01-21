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

package util.auth.unboundid.implementations;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;

import play.Configuration;
import util.auth.IAuthentication;
import util.auth.IAuthenticationResponse;
import util.auth.unboundid.IUnboundidAuthentication;
import conf.IConfiguration;
import conf.IValidable;

public class UnboundidLdapAuthentication implements IUnboundidAuthentication, IValidable {
	
	private final IAuthentication authenticationStrategy;
	private final Configuration config;
	
	@Inject
	public UnboundidLdapAuthentication(final IAuthentication authenticationStrategy,
			final IConfiguration configuration) {
		config = configuration.getConfiguration();
		validate();
		
		this.authenticationStrategy = authenticationStrategy;
		

	}
	
	/**
	 * Helper method to validate an IAuthStrategy.
	 * Note this should handle error logging, if the state of the
	 * configuration-object isn't valid.
	 * @param config
	 */
	public boolean validate() {
		/*
		 *  ldap.hostname = "ad.example.com"
			ldap.port = 389
			ldap.ssl = false
			ldap.basedn = "dc=example,dc=com" 
			ldap.usergrouprdn = "OU=people"
			ldap.userattribute = "cn"
			ldap.authorizedgrouprdn = "cn=authorized"
			ldap.authorizedattribute = "member"
		 */
		String[] stringValues = {"ldap.hostname", "ldap.basedn",
				"ldap.usergrouprdn", "ldap.userattribute",
				"ldap.authorizedgrouprdn", "ldap.authorizedattribute"};
		String[] stringSslValues = {"keystorefile", "keystorepassword"};
		
		// All required String values can't be NULL
		for(String value : stringValues) {
			if(config.getString(value) == null) {
				play.Logger.error("GenericLdapAutenticationStrategy lacking configuration string: " + value);
				throw new IllegalStateException("Configuration returns null for " + value);
			}
			play.Logger.info(value + " configured with " + config.getString(value));
		}
				
		if(config.getBoolean("ldap.ssl") == null) {
			play.Logger.error("GenericLdapAutenticationStrategy.validate(): ldap.ssl was NULL.");
			throw new IllegalStateException("GenericLdapAutenticationStrategy.validate(): ldap.ssl was NULL.");
		}
		
		if(config.getBoolean("ldap.ssl") == true) {
		
			// All required String values can't be NULL
			for(String value : stringSslValues) {
				if(config.getString(value) == null) {
					play.Logger.error("GenericLdapAutenticationStrategy.validate(): " + value + " was NULL.");
					throw new IllegalStateException("GenericLdapAutenticationStrategy.validate(): " + value + " was NULL.");
				}
				play.Logger.info(value + " configured with " + config.getString(value));
			}
			
			// Check that the path points to a file
			
			// get the path to the truststore from the application.conf
			String trustStoreString  = config.getString("keystorefile");
			if(trustStoreString.length() == 0) {
				play.Logger.error("GenericLdapAutenticationStrategy.validate(): " + trustStoreString + " was NULL.");
				throw new IllegalStateException("GenericLdapAutenticationStrategy.validate(): " + trustStoreString + " was NULL.");
			}
			try {
				// make a path and check that the file exists
				Path path = Paths.get(trustStoreString);
				if(Files.notExists(path)) {
					throw new FileNotFoundException();
				}
				play.Logger.info("keystoresile configured with " + trustStoreString);
			} catch(FileNotFoundException e) {
				play.Logger.error("GenericLdapAutenticationStrategy.validate(): " + trustStoreString + " doesn't point to a file.");
				System.exit(1);
			}

			
			play.Logger.info("GenericLdapAuthenticationStrategy.validate(): Using SSL");
			
			if(config.getInt("ldap.port") == null) {
				play.Logger.info("GenericLdapAuthenticationStrategy.validate(): No port set. Assuming default port: 389");
			}
			
		} else {
			play.Logger.info("GenericLdapAuthenticationStrategy.validate(): Not using SSL");
			
			if(config.getInt("ldap.port") == null) {
				play.Logger.info("GenericLdapAuthenticationStrategy.validate(): No port set. Assuming default port: 686");
			}
		}
		
		if(config.getInt("ldap.port") != null) {
			play.Logger.info("ldap.port configured with " + config.getInt("ldap.port"));
		}
		
		play.Logger.info("GenericLdapAuthenticationStrategy validated");
		return true;
		
	}

	@Override
	public final IAuthenticationResponse authentication(final String username,
			final String password) {
		return authenticationStrategy.authentication(username, password);
	}
}
