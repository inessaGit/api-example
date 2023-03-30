package api.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
public class ConfigurationManager {
	private static final Logger LOG = LoggerFactory.getLogger(ConfigurationManager.class);

	private ConfigurationManager() throws IOException {
		PROPERTIES.load(getInputStream("default.properties")); //src/main/resources
		PROPERTIES.load(getInputStream("test.properties")); //src/test/resources overrides default.properties
	}
	private static ConfigurationManager manager;
	private static final Properties PROPERTIES = new Properties();
	public static ConfigurationManager getInstance() {
		if (manager == null) {
			synchronized (ConfigurationManager.class) {
				if (manager == null) {
					try {
						manager = new ConfigurationManager();
					} catch (IOException e) {
                       LOG.debug(e.getMessage());
					}
				}
			}
		}
		return manager;
	}

	public String getProperty(String name) {
		return System.getProperty(name, PROPERTIES.getProperty(name));
	}

	private InputStream getInputStream(String file) {
		try {
			List<URL> urls = Collections.list(Thread.currentThread().getContextClassLoader().getResources(file));
			return urls == null || urls.isEmpty() ? null : urls.get(0).openStream();
		} catch (IOException e) {
			e.printStackTrace();
			LOG.debug((e.getMessage()));
		}
		return null;
	}

}