package util;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    static String url;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("./src/test/java/Config/config.properties");
            prop.load(fis);
//            System.out.println(prop);
        } catch (IOException e) {
            e.getMessage();
        }
    }


    public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
//        String destination = "../FailedTestsScreenshots"+ "/"+screenshotName+dateName+".png";
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);
        System.out.println(destination);
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        String reportDestination = "../FailedTestsScreenshots" + "/" + screenshotName + dateName + ".png";
        return reportDestination;
    }

    public static String getValueOrDefault(String value, String defaultValue) {
        return value == null ? defaultValue : value + defaultValue;
    }
    public static String inialization( String env) throws IOException {
        url = getValueOrDefault(env, "url");
        System.out.println("Current testing env is : " + env);
        System.out.println("Current testing url is : " + url);
//        prop = new Properties();
//        FileInputStream fis = new FileInputStream("./src/test/java/Config/config.properties");
//        prop.load(fis);
//        System.out.println(prop);
        System.out.println("Current testing url read from property file is : "+prop.getProperty(url));
        return url;
    }

    public static String getEnvironment() throws Exception {
        String env = System.getProperty("env");
        if (env == null)
            throw new Exception("Enviroment is not set, please restart your test and pass -Denv=\"<your environment>\"");
        return env;
    }


}
