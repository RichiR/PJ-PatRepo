package pj2014.patrepo.factories;

import pj2014.patrepo.interfaces.IPatientRepository;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

public class PatRepoProxyFactory {

	public static IPatientRepository getProxy(String baseUrl) {
			
			RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
			return ProxyFactory.create(IPatientRepository.class, baseUrl);						
			
		}
	
	
}



