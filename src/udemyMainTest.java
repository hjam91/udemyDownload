
        import org.openqa.selenium.Capabilities;
        import org.openqa.selenium.Point;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
       // import org.openqa.selenium.phantomjs.PhantomJSDriver;
       // import org.openqa.selenium.phantomjs.PhantomJSDriverService;
        //import org.openqa.selenium.phantomjs.PhantomJSDriver;
        //import org.openqa.selenium.phantomjs.PhantomJSDriverService;
        import org.openqa.selenium.remote.DesiredCapabilities;
       /* import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
       */ import sun.security.krb5.internal.crypto.Des;

        import java.io.*;
        import java.text.ParseException;
        import java.util.*;
        import java.util.concurrent.TimeUnit;

        import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
        /*import static org.junit.Assert.assertThat;
        import static org.testng.AssertJUnit.assertEquals;
*/
/**
 * Created by fortegs on 8/18/15.
 * Updated 12/31/15
 */
public class udemyMainTest {

    static Properties prop;
    public static WebDriver driver;
    public static String URL;
    public static int count;
    public static int courseSize = 99999999;
    public static String resume;
    public static File countStore;
    public static File courseName;
    public static String USB ="";


    public static void main(String[]args) throws IOException, ParseException, InterruptedException {

        beforeClass();
        HomePageSignUp();

    }

   /* public static Properties loadProp() throws IOException {

        //Change this location
        File file = new File("config.prop");
        FileInputStream fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        fileInput.close();

        return prop;
    }*/


    public static void resumeDownload() throws IOException {
        countStore = new File(USB+"count.txt");

      //  System.out.println(countStore);
        if(countStore.exists()) {

            System.out.println("Wait it seems like you stopped the last download or It got interrupted, " +
                    "Do you want to resume or start over? If I has been over 5 hours" +
                    " since you last ran it then you should start all over," +
                    "Press Y to resume, Press N to start over");

            Scanner in = new Scanner(System.in);
            resume = in.nextLine();

            if (resume.contains("Y") || resume.contains("y")) {

                FileReader fileReader = new FileReader(USB+"courseName.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                URL = bufferedReader.readLine();

                FileReader fileReader2 = new FileReader(USB+"count.txt");
                BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

                count = Integer.parseInt(bufferedReader2.readLine());
            } else {

                new File(USB+"count.txt").delete();
                new File(USB+"courseName.txt").delete();

                System.out.println("First, enter the Udemy Course URL: ");
                Scanner in2 = new Scanner(System.in);
                URL = in2.nextLine();
                System.out.println("Verifying the URL you enter was:  " + URL);

                System.out.println("Start From Which Lecture Number: ");
                count = in2.nextInt();
                System.out.println("Verifying you entered lecture number:  " + count);
            }


        }else{
            System.out.println("First, enter the Udemy Course URL: ");
            Scanner in2 = new Scanner(System.in);
            URL = in2.nextLine();
            System.out.println("Verifying the URL you enter was:  " + URL);

            System.out.println("Start From Which Lecture Number: ");
            count = in2.nextInt();
            System.out.println("Verifying you entered lecture number:  " + count);
        }
    }


    public static void beforeClass() throws IOException {

        System.out.println("===================================================================" +
                "==============================================================================" +
                "========================================================");
        System.out.println("Hello This is Udemy Video Downloader, Videos will Download" +
                " when they have gone through the whole course, Remember that" +
                " and please be patient......PLEASE LEAVE EVRYTHING MINIMIZED OR WEIRD THINGS WILL HAPPEN");
        System.out.println("===================================================================" +
                "==============================================================================" +
                "========================================================");

            resumeDownload();


      //  prop = loadProp();
        //URL = prop.getProperty("URL");
   //     String BROWSER = prop.getProperty("browser");
      //  count = Integer.parseInt(prop.getProperty("count"));

    //    System.out.println(  prop.getProperty("phantomDriverLocation"));
       /* if(BROWSER.equals("phantom")) {
           String[] cli_args = new String[]{ "--ignore-ssl-errors=true" };

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability( PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args);
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    prop.getProperty("phantomDriverLocation"));
            caps.setCapability("phantomjs.cli.args", Collections.singletonList("--ignore-ssl-errors=yes"));
            caps.setCapability("phantomjs.cli.args", Collections.singletonList("--web-security=no"));

            driver = new PhantomJSDriver(caps);

        }

        else if (BROWSER.equals("chrome")) {


            System.setProperty("webdriver.chrome.driver",*//* System.getProperty("user.dir") +*//*  "chromedriver");
            Properties prop = new Properties();
            ChromeOptions options;
            options = new ChromeOptions();
            //  options.addArguments("--no-startup-window");
            //options.addArguments("--hide");
            options.addArguments("--disable-internal-flash");
            options.addArguments("--disable-bundled-ppapi-flash");
            options.addArguments("--disable-plugins-discovery");

            options.addArguments("--mute-audio");
            // options.addArguments("--load-extension=C:\\Users\\haroo\\Desktop\\jikbjpjgjmmdhcmlagappehlpiljoaop\\0.5_0\\");
            //options.addArguments("--load-extension=C:\\Users\\haroo\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cfhdojbkjhnklbpkdaibdccddilifddb\\1.9.1_0\\");(
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //  capabilities.setCapability(ChromeOptions.options);
            driver = new ChromeDriver(options);

        } else if (BROWSER.equals("IE")) {

            driver = new InternetExplorerDriver();

        } else
            driver = new FirefoxDriver();
*/

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        ChromeOptions options;
        options = new ChromeOptions();


        //  options.addArguments("--no-startup-window");
        //options.addArguments("--hide");


        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");
        options.addArguments("--disable-internal-flash");
        options.addArguments("--disable-bundled-ppapi-flash");
        options.addArguments("--disable-plugins-discovery");

        options.addArguments("--mute-audio");
        // options.addArguments("--load-extension=C:\\Users\\haroo\\Desktop\\jikbjpjgjmmdhcmlagappehlpiljoaop\\0.5_0\\");
        //options.addArguments("--load-extension=C:\\Users\\haroo\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cfhdojbkjhnklbpkdaibdccddilifddb\\1.9.1_0\\");(
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("chrome.switches", Arrays.asList("--disable-extensions"));
        //  capabilities.setCapability(ChromeOptions.options);
          driver = new ChromeDriver(options);
         courseName = new File(USB+"courseName.txt");



        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    public static void HomePageSignUp() throws InterruptedException, IOException, ParseException {

        while (count <= (courseSize)) {
            udemyHomePageRepo courseHomePage = new udemyHomePageRepo(driver);
            courseHomePage.getHomePage(driver, URL);

            FileWriter courseNameFile = new FileWriter(courseName,false);
                courseNameFile.write(URL);
                courseNameFile.close();

                Thread.sleep(3000);
                System.out.println("1");

                udemyCoursePreviewPageRepo coursePreview = new udemyCoursePreviewPageRepo(driver);
                coursePreview.FreePreviewButtonElement().click();

                courseHomePage.fillOutRegInfo();


                Thread.sleep(3000);
                //pageMove(courseHomePage.SumbitButtonElement().click(),Psg2.class);



            Thread.sleep(3000);
            System.out.println("Success Phantom 1");


            System.out.println(driver.getCurrentUrl());

            //  assertEquals(coursePreview.FreePreviewButtonElement().getText(), "Start free preview");
         //   assertEquals(coursePreview.TakeCourseButtonElement().getText(), "Take This Course");

            Thread.sleep(2000);
            System.out.println("Success Phantom 2");
            String courseName = coursePreview.getCourseTitleText();
            System.out.println(courseName);
            //  String courseTitle= coursePreview.getCourseTitle().getText();

          //  coursePreview.FreePreviewButtonElement().click();
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


    public static void closeBrowser() throws IOException {
        driver.quit();
    }

}
