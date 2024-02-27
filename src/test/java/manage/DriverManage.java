package manage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManage {

    public static WebDriver driver;

    static DesiredCapabilities capabilities = new DesiredCapabilities();

    public WebDriver remoteChromeSetUp() {

        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName(ConfigReader.getProperty("chromeBrowser"));
        capabilities.setVersion(ConfigReader.getProperty("chromeVersion"));

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);

        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubURL")), chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        System.out.println("***** Remote Chrome Driver *****");

        return driver;
    }


    public WebDriver remoteFirefoxSetUp() {

        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName(ConfigReader.getProperty("firefoxBrowser"));
        capabilities.setVersion(ConfigReader.getProperty("firefoxVersion"));

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.merge(capabilities);

        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubURL")), firefoxOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        System.out.println("***** Remote Firefox Driver *****");

        return driver;
    }


    public static void setDriver(String browser) {

        switch (browser) {

            case "grid_chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubURL")), chromeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("***** Selenium Grid ChromeDriver *****");
                break;
            }

            case "grid_firefox": {

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubURL")), firefoxOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("***** Selenium Grid FirefoxDriver *****");
                break;
            }

            case "grid_edge": {

                EdgeOptions edgeOptions = new EdgeOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubURL")), edgeOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("***** Selenium Grid EdgeDriver *****");
                break;
            }

            case "grid_IE": {

                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                try {
                    driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("hubURL")), ieOptions);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("***** Selenium Grid IExplorerDriver *****");
                break;
            }

            case "chrome": {
                //  WebDriverManager.chromedriver().browserVersion("122.0.6261.70").setup();

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println(" ***** Chrome WebDriver *****");
                break;
            }

            case "firefox": {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println(" ***** Firefox WebDriver *****");
                break;
            }

            case "edge": {

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                System.out.println(" ***** Edge WebDriver *****");
                break;
            }

            case "IE": {

                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                System.out.println(" ***** IE WebDriver *****");
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("***** Default Chrome WebDriver *****");
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }

    }


    public static void closeDriver() {

        if (driver != null) {
            driver.close();
        }
    }


}
