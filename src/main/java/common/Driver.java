package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class Driver {

    public static WebDriver getDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capa = DesiredCapabilities.chrome();
        Map<String, Object> preferences = new Hashtable<String, Object>();

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        preferences.put("plugins.plugins_disabled", new String[]{
                "Adobe Flash Player",
                "Chrome PDF Viewer"
        });

        preferences.put("chrome.switches", Arrays.asList("--incognito", "--disable-web-security", "--user-data-dir"));
        preferences.put("profile.default_content_settings.popups", 0);
        capa.setJavascriptEnabled(true);
        options.setExperimentalOption("prefs", preferences);
        capa.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver(options);
    }
}
