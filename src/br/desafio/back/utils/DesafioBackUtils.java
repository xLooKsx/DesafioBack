package br.desafio.back.utils;

import java.util.ResourceBundle;

public class DesafioBackUtils {
	
	
	public static String getProperty(String key) {
		return getConfig().getString(key);
	}

	public static ResourceBundle getConfig() {
		ResourceBundle bundle = ResourceBundle.getBundle("br.desafio.back.resources.Config");
		return bundle;
	}
}
