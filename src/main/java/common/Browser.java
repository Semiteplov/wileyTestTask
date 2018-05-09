package common;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public enum Browser {
    INSTANCE;
    private WebDriver driver;
    private final String DEFAULT_BROWSER = "Chrome";
    private final String browserName;

    public final static int DEFAULT_TIMEOUT = 30;
    public final static int SMALL_TIMEOUT = 3;

    Browser() {
        String name = System.getProperty("browser");

        if (name == null || name.isEmpty()) {
            name = DEFAULT_BROWSER;
        }

        this.browserName = name;

        try {
            driver = Driver.getDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        return INSTANCE.driver;
    }

    public static String getName() {
        return INSTANCE.browserName;
    }

    public static void setDriver(WebDriver driverNew) {
        INSTANCE.driver = driverNew;
        INSTANCE.driver.manage().window().maximize();
        INSTANCE.driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        INSTANCE.driver.manage().deleteAllCookies();
    }

    public static void setSmallTimeout() {
        getDriver().manage().timeouts().implicitlyWait(SMALL_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void setDefaultTimeout() {
        getDriver().manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }
}

