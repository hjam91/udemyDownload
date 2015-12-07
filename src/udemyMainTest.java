
        import org.openqa.selenium.Capabilities;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.phantomjs.PhantomJSDriver;
        import org.openqa.selenium.phantomjs.PhantomJSDriverService;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import sun.security.krb5.internal.crypto.Des;

        import java.io.IOException;
        import java.text.ParseException;
        import java.util.ArrayList;
        import java.util.concurrent.TimeUnit;

        import static org.junit.Assert.assertThat;
        import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by fortegs on 8/18/15.
 */
public class udemyMainTest {


    public static WebDriver driver;
    public static String URL = "https://www.udemy.com/selenium-2-webdriver-basics-with-java/";
    public static int count =206;
    public static int courseSize = 99999999;



    @BeforeClass
    public static void beforeClass() {


        System.setProperty("webdriver.chrome.driver", "/home/fortegs/chromedriver");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "/home/fortegs/Downloads/phantomjs-2.0.0/bin/phantomjs");
        driver = new PhantomJSDriver(caps);
        //    driver  = new PhantomJSDriver(capabilities);
        ChromeOptions options;
        options = new ChromeOptions();

        options.addArguments("--disable-internal-flash");
        options.addArguments("--disable-bundled-ppapi-flash");
        options.addArguments("--disable-plugins-discovery");
        options.addArguments("--mute-audio");

       // options.addArguments("--load-extension=C:\\Users\\haroo\\Desktop\\jikbjpjgjmmdhcmlagappehlpiljoaop\\0.5_0\\");
        //options.addArguments("--load-extension=C:\\Users\\haroo\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cfhdojbkjhnklbpkdaibdccddilifddb\\1.9.1_0\\");(
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //  capabilities.setCapability(ChromeOptions.options);

       // driver = new ChromeDriver(options);
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String originalHandle = driver.getWindowHandle();

        //Do something to open new tabs

       /* for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }*/

        //driver.switchTo().window(originalHandle);

    }

    @Test
    public void HomePageSignUp() throws InterruptedException, IOException, ParseException {

        while (count <= (courseSize)) {
            udemyHomePageRepo courseHomePage = new udemyHomePageRepo(driver);
            courseHomePage.getHomePage(driver, URL);


            try {

                Thread.sleep(3000);
                System.out.println("1");
                courseHomePage.fillOutRegInfo();

                Thread.sleep(3000);
                //pageMove(courseHomePage.SumbitButtonElement().click(),Psg2.class);

            } catch (Exception e) {

            }

            Thread.sleep(3000);

            udemyCoursePreviewPageRepo coursePreview = new udemyCoursePreviewPageRepo(driver);

            System.out.println(driver.getCurrentUrl());

            //  assertEquals(coursePreview.FreePreviewButtonElement().getText(), "Start free preview");
            assertEquals(coursePreview.TakeCourseButtonElement().getText(), "Take This Course");

            Thread.sleep(2000);
            String courseName = coursePreview.getCourseTitleText();
            System.out.println(courseName);
            //  String courseTitle= coursePreview.getCourseTitle().getText();

            coursePreview.FreePreviewButtonElement().click();
            //   udemyCourseVideo.courseName = coursePreview.getCourseTitle().getText();


            Thread.sleep(1000);

            udemyCoursePageListRep courseList = new udemyCoursePageListRep(driver);
            courseList.firstCourseLink().click();


            Thread.sleep(2000);

            udemyCourseVideo coursePage = new udemyCourseVideo(driver, courseName);
            courseSize = udemyCourseVideo.countCourses();

            count = coursePage.clickAndCountCourses(count);

            //   System.out.println("Out loop: " + courseSize + " Count : " + count  );


            courseHomePage = null;
            coursePreview =  null;
            courseList = null;
            coursePage = null;
            System.gc();



        }


    }


    @AfterClass
    public static void afterClass() throws IOException {

        driver.quit();



    }

}
