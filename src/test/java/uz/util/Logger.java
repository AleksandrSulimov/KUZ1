package uz.util;

import java.io.UnsupportedEncodingException;




import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.*;
import org.junit.Assert;





public class Logger {

	public enum Locale{
		EN,RU
	}
    //private static Locale DEF_LOCALE = Locale.RU;
	//private static final String AQA_LOCALE = "aqa.locale";
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);
    private static Logger instance = null;
    public static final String LOG_DELIMITER = "::";
    // This flag allows/restricts logging step names 
    private static boolean logSteps = true;
    //public static PropertiesResourceManager localManager = new PropertiesResourceManager(String.format("localization/loc_%1$s.properties",
    //		System.getProperty(AQA_LOCALE, DEF_LOCALE.toString().toLowerCase())));
    
    //protected static String getLoc(String key){
	//	return localManager.getProperty(key, key);
	//}

    public static String convert(String message) {
    	message = message.replace("И", "и");
    	byte[] bytesInUTF8 = null;
		try {
			bytesInUTF8 = message.getBytes("UTF8");
			if(message.contains("И")){
				byte[] cp1251 = message.getBytes("cp1251");
				byte[] utf8 = new String(cp1251, "cp1251").getBytes("UTF-8");
				return new String(utf8);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	return new String(bytesInUTF8);
	}
    
    /**
     * local info
     * @param message
     */
    public void infoLoc(String message) {
    	//message = localManager.getProperty(message, message);
        String m = convert(message);
    	logger.info(m);
        //Reporter.log(m+"<br>");
    }
    
    private Logger() {
    }

    /**
     * Implementation of the Singleton pattern
     */
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    /**
     * Logging a step number
     * @param step - step number
     */
    public void step(int step) {
        logDelimMsg("Шаг" + String.valueOf(step));
    }

    /**
     * Logging a several steps in a one action
     * @param fromStep - the first step number to be logged
     * @param toStep - the last step number to be logged
     */
    public void step(int fromStep, int toStep) {
        logDelimMsg("Шаги" + String.valueOf(fromStep) + "-" + String.valueOf(toStep));
    }

    //This method is using for formatting almost all log records
    private void logDelimMsg(String msg) {
        if (logSteps) {
        	info(String.format("--------==[ %1$s ]==--------", msg));
        }
    }

    /**
     * This method logs test's name
     * @param testName test's name
     */
    public void logTestName(String testName) {
        if (logSteps) {
            String formattedName = String.format("=====================  %1$s: '%2$s' =====================", "Тест", testName);
			
			String delims = "";
			int nChars = formattedName.length();
			for(int i = 0;i<nChars;i++){
				delims+="-";
			}
            info(delims);
            info(formattedName);
            info(delims);
            logDelimMsg("Предусловия");
        }
    }
    
       
    public void printDots(int count){
    	String delims = "";
		for(int i = 0;i<count;i++){
			delims+=".";
		}
		 info(delims);
    }
    
    public void logTestEnd(String testName) {
        if (logSteps) {
        	info("");
            String formattedEnd = String.format("***** ТЕСТ КЕЙС ЗАВЕРШЕН *****");
			String stars = "";
			int nChars = formattedEnd.length();
			for(int i = 0;i<nChars;i++){
				stars+="*";
			}
			info(stars);
			info(formattedEnd);
            info(stars);
            info("");          
        }
    }
    
    /**
     * This method logs test's name
     * @param testName test's name
     */
    public void logPrereqName(String testName) {
        if (logSteps) {
            info(String.format("=====================  %1$s: '%2$s' =====================","Тест", testName));
            info("----------------------------------------------------------------------------------------------------");
            logDelimMsg("Preconditions");
        }
    }
    
    public void logPrereq(String testName) {
        if (logSteps) {
        	info("----------------------------------------------------------------------------------------------------");
            info(String.format("=====================  %1$s: '%2$s' =====================","Тест создание", testName));
            info("----------------------------------------------------------------------------------------------------");
        }
    }
    
    public void logPrereqEnd(String testName) {
        if (logSteps) {
            info(String.format("===================== %1$s: '%2$s' =====================","завершен", testName));
            info("----------------------------------------------------------------------------------------------------");
        }
    }
    
    public void logResult(String testName, boolean isSuccess) {
        if (logSteps) {
        	if (isSuccess){
        	info("----------------------------------------------------------------------------------------------------");
            info(String.format("=====================  %1$s: '%2$s'  %3$s  =====================", "Тест", testName, "пройден успешно!"));
            info("----------------------------------------------------------------------------------------------------");
        	}
        	else {
        		info("----------------------------------------------------------------------------------------------------");
                info(String.format("!!!!!!!!!!!!!!!!!!!  %1$s: '%2$s'  %3$s !!!!!!!!!!!!!!!!!!!", "Тест", testName, "НЕ ПРОЙДЕН!"));
                info("----------------------------------------------------------------------------------------------------");
        		
        	}
        }
    }
    
    public void logErrorMessage(String message) {
        if (logSteps) {
        	info("------------------------------------------------------------------------");
            info(String.format("=====================  %1$s =====================","Вывод текста ошибки:"));
            info(message);
        }
    }
    
    public void logErrorMessageEnd() {
        if (logSteps) {
            info(String.format("=================  %1$s =================","Конец вывода текста ошибки"));
            info("------------------------------------------------------------------------");
        }
    }
    // All methods below are using for creation messages with a different level of importance 
    public void debug(String message) {
        logger.debug(message);
        String m = convert(message);
        message = "<div class=\"skipped\">"+m+"</div>"; //yellow color from reportng css
        //Reporter.log(message+"<br>");
    }

    public static void info(String message) {
        logger.info(message);
        String m = convert(message);
        //Reporter.log(m+"<br>");
    }

    public void warn(String message) {
        logger.warn(message);
        String m = convert(message);
        message = "<div class=\"skipped\">"+m+"</div>"; //yellow color from reportng css
       // Reporter.log(message+"<br>");
    }

    public void error(String message) {
        logger.error(message);
        String m = convert(message);
        //Reporter.log(m+"<br>");
    }

    public void fatal(String message) {
        logger.fatal(message);
        String m = convert(message);
        message = "<div class=\"failedConfig\">"+m+"</div>"; //red color from reportng css
        //Reporter.log(message+"<br>");
        Assert.assertTrue(false);
    }
    public void logStep(int step, String description) {
		logger.info(String.format("===[ %1$s:%2$s]===", step, description));
	}
}
