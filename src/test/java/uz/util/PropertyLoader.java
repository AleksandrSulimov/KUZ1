package uz.util;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Class that extracts properties from the prop file.
 */
public class PropertyLoader {

  private static final String DEBUG_PROPERTIES = "/debug.properties";

  public static Capabilities loadCapabilities() throws IOException {
    return loadCapabilities(System.getProperty("application.properties", DEBUG_PROPERTIES));
  }

  public static Capabilities loadCapabilities(String fromResource) throws IOException {
    Properties props = new Properties();
    props.load(PropertyLoader.class.getResourceAsStream(fromResource));
    String capabilitiesFile = props.getProperty("capabilities");

    Properties capsProps = new Properties();
    capsProps.load(PropertyLoader.class.getResourceAsStream(capabilitiesFile));

    DesiredCapabilities capabilities = new DesiredCapabilities();
    for (String name : capsProps.stringPropertyNames()) {
      String value = capsProps.getProperty(name);
      if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
        capabilities.setCapability(name, Boolean.valueOf(value));
      } else if (value.startsWith("file:")) {
        capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
      } else {
        capabilities.setCapability(name, value);
      }
    }

    return capabilities;
  }

  public static String loadProperty(String name) throws IOException {
    return loadProperty(name, System.getProperty("application.properties", DEBUG_PROPERTIES));
  }

  public static String loadProperty(String name, String fromResource) throws IOException {
    Properties props = new Properties();
    props.load(PropertyLoader.class.getResourceAsStream(fromResource));

    return props.getProperty(name);
  }
  public static String convert(String message) {
  	message = message.replace("È", "è");
  	byte[] bytesInUTF8 = null;
		try {
			bytesInUTF8 = message.getBytes("UTF8");
			if(message.contains("È")){
				byte[] cp1251 = message.getBytes("cp1251");
				byte[] utf8 = new String(cp1251, "cp1251").getBytes("UTF-8");
				return new String(utf8);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	return new String(bytesInUTF8);
	}
  public static String loadPropertyLocale(String name, String fromResource) throws IOException {
	    Properties props = new Properties();
	    props.load(PropertyLoader.class.getResourceAsStream(fromResource));
	    String incorrect = props.getProperty(name);
	    return new String(incorrect.getBytes("ISO-8859-1"), "UTF-8");
	  }

}