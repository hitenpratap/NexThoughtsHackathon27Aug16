import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities

//import org.openqa.selenium.htmlunit.HtmlUnitDriver
//import org.openqa.selenium.htmlunit.HtmlUnitDriver
//import org.openqa.selenium.firefox.FirefoxDriver
//import org.openqa.selenium.firefox.FirefoxProfile
//import org.openqa.selenium.Platform
//import org.openqa.selenium.chrome.ChromeDriver

//driver = {
//    FirefoxProfile profile = new FirefoxProfile()
//    profile.setPreference("intl.accept_languages", "en-us")
//    profile.setPreference("browser.download.folderList", 2)
//    profile.setPreference("browser.helperApps.alwaysAsk.force", false)
//    profile.setPreference("browser.download.manager.showWhenStarting", false)
//    profile.setPreference("browser.download.dir", "/Users/hitenpratap/Desktop/icici/")
//    profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel,text/csv")
//    profile.setPreference("pdfjs.disabled", true)
//    def driverInstance = new FirefoxDriver(profile)
//    driverInstance.manage().window().maximize()
//    driverInstance.manage().deleteAllCookies()
//    driverInstance
//}

//driver = {
//    System.setProperty("webdriver.chrome.driver", "/Users/hitenpratap/opt/WebDriver/chromedriver");
//    new ChromeDriver()
//}

driver = {
    ArrayList cliArgsCap = new ArrayList();
    cliArgsCap.add("--web-security=false");
    cliArgsCap.add("--ssl-protocol=any");
    cliArgsCap.add("--ignore-ssl-errors=true");
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities()
    desiredCapabilities.setJavascriptEnabled(true);
    WebDriver driver = new PhantomJSDriver(desiredCapabilities)
    driver.manage().window().setSize(new Dimension(1028, 100))
    driver.manage().deleteAllCookies()
    return driver
}