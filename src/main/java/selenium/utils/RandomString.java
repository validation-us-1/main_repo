package selenium.utils;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {
	
	public static String generate() {
		int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    return RandomStringUtils.random(length, useLetters, useNumbers);
	}
}
