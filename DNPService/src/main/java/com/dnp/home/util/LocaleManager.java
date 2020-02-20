package com.dnp.home.util;

import java.util.Locale;

public class LocaleManager {

	private static Locale serverLocale = Locale.getDefault();
	private static ThreadLocal<Locale> clientLocaleThreadLocal = new ThreadLocal<Locale>();

	public static Locale getServerLocale() {
		return (Locale)serverLocale.clone();
	}

	public static Locale getClientLocale() {
		Locale clientLocale = clientLocaleThreadLocal.get();
		if (clientLocale == null) {
			clientLocaleThreadLocal.set(serverLocale);
			return (Locale)serverLocale.clone();
		} else {
			return clientLocale;
		}
	}

	public static void setClientLocale(Locale locale) {
		clientLocaleThreadLocal.set(locale);
	}

	public static void removeClientLocale() {
		clientLocaleThreadLocal.remove();
	}

}