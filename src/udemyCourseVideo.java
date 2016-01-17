
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fortegs on 8/24/15.
 */


//Commented out code is for browsers that dont support HTML5

public class udemyCourseVideo {


    /*@FindBy(xpath = ".//body/script")
    WebElement videoScriptElement;*/

    @FindBy(xpath = ".//*[@id='preview-banner']/ng-include/div/div/div[1]/timer/span")
    WebElement timer;

    @FindBy(css = ".course-title.ellipsis")
    WebElement courseNameElement;


    static WebDriver driver;
    static JavascriptExecutor executor;
    static Writer output;
    static int lecturesSize;
    static String courseName;
    static String cleanCourseName;
    static String cleanName;
    Map<String, String> map = new HashMap<String, String>();
    static String lectureName;
    static String CourseFolderLocation = "";
    //static String CourseFolderLocation = udemyMainTest.prop.getProperty("courseFolderLocation");
   // static String CourseTitleLocation = udemyMainTest.prop.getProperty("courseTitleLocation");
    //static String CourseURLLocation = udemyMainTest.prop.getProperty("courseURLLocation");
    //Writer  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(), "UTF-8"));
    // FileWriter writerURL = new FileWriter("C:\\Users\\haroo\\Desktop\\Udemy\\udemyLinks.txt", true);
//    BufferedWriter writerURL = new BufferedWriter(new FileWriter("C:\\Users\\haroo\\Desktop\\Udemy\\udemyLinks.txt", true));
    //  Writer writerTitle = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\haroo\\Desktop\\Udemy\\udemyTitle.txt"), "UTF-8"));
//    /FileWriter writerTitle = new FileWriter("C:\\Users\\haroo\\Desktop\\Udemy\\udemyTitle.txt", true);
    //  BufferedWriter writerTitle = new BufferedWriter(new FileWriter("C:\\Users\\haroo\\Desktop\\Udemy\\udemyTitle.txt", true));
    //clears file every time

    udemyCourseVideo(WebDriver driver, String courseName) throws IOException {


        this.driver = driver;
        this.courseName = courseName;

        cleanCourseName  = this.courseName.replaceAll("[ ](?=[ ])|[^-_,A-Za-z0-9 ]+","");

        executor = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);


        //output=  new BufferedWriter(new FileWriter("C:\\Users\\haroo\\Desktop\\myCourseTest.txt", true));
    }

    public static int countCourses(){
        List <WebElement> lectures = driver.findElements(By.partialLinkText("Lecture "));
        lecturesSize = lectures.size();
        return lectures.size();

    }

    public void getDownloadlink(int count, String lectureName) throws IOException, InterruptedException {



        System.out.println(courseName);


        cleanCourseName  = courseName.replaceAll("[ ](?=[ ])|[^-_,A-Za-z0-9 ]+","");
        System.out.println("Checking File Location");
        //System.out.println("FolderLocation  - : " + CourseFolderLocation);

        File folder = new File(CourseFolderLocation+cleanCourseName);

        if(!(folder.exists())){
            folder.mkdir();
        }

        
        File url = new File( CourseFolderLocation +cleanCourseName+ "/udemyLinks.txt");
        File title = new File(CourseFolderLocation+cleanCourseName+ "/udemyTitle.txt");
        System.out.println("File Location check Good");


        try {



            System.out.println("Reading File 1");
            BufferedWriter writerURL = new BufferedWriter(new FileWriter(url, true));
            System.out.println("Reading File 2");
            BufferedWriter writerTitle = new BufferedWriter(new FileWriter(title, true));

            Thread.sleep(1000);
          /* String videoLinkPattern = "(\"file\":\"http((?!\\/>).)*?)\",\"label\":\"720p HD/i";
           Pattern pattern = Pattern.compile(videoLinkPattern);*/

            //   System.out.println("Clean name PDF: "+ cleanName);
            WebElement videoFrame = driver.findElement(By.xpath( "//*[starts-with(@name,\"easyXDM\")]"));

            System.out.println(driver.getTitle());
            driver.switchTo().frame(videoFrame);
            //String videoLink = videoScriptElement.getText();
            //videoLink.replaceFirst(videoLinkPattern)
            //videoLink.replaceAll("(\"file\":\"http((?!\\/>).)*?)\",\"label\":\"720p HD/i", "e");
            /*Matcher regexMatcher = pattern.matcher(videoLink);
            regexMatcher.toString()*/


            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement videoURL = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//video")));
       //     WebElement videoURL = driver.findElement(By.xpath(".//video"));
            System.out.println(videoURL.getTagName());
            System.out.println(videoURL.getText());
           // System.out.println(videoFrame.getTagName());
            String VideoRawURL = videoURL.getAttribute("src");

            //   output.append(VideoRawURL);
            //  output.append(System.getProperty("line.separator"));

            System.out.println(VideoRawURL);

            writerURL.append(VideoRawURL);
            writerURL.newLine();
            //  String cleanName1 = lectureName1.replaceAll("[ ](?=[ ])|[^-_,A-Za-z0-9 ]+","");
            //  cleanName = lectureName.replaceAll("[ ](?=[ ])|[^-_,A-Za-z0-9 ]+","");
            writerTitle.append(lectureName);
            writerTitle.newLine();

            writerURL.close();
            writerTitle.close();


            //  map.put(lectureName, VideoRawURL);

            //DownloadActualFile(VideoRawURL, lectureName);

            driver.switchTo().defaultContent();
            System.out.println("2000");
            executor.executeScript("scroll(0, 100);");


        } catch (Exception e) {

            try {


               /*   File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                  FileUtils.copyFile(scrFile, new File("C:\\Users\\haroo\\Desktop\\screenshot-Lecture" + count + ".png"));*/

                System.out.println("Before Article View Element");
                WebDriverWait wait = new WebDriverWait(driver, 2);
                WebElement text = driver.findElement(By.cssSelector(".w3c-default"));

                System.out.println("After Article View Element");


                //   WebElement text = driver.findElement(By.xpath(".//*[@class='article-view']"));

                //  System.out.println(text.getText());

             //   System.out.println("");
                System.out.println("Clean Lecture Name: "+ lectureName);
                File path = new File(CourseFolderLocation+ cleanCourseName +"/" + lectureName+".txt");

                BufferedWriter txtOutput = new BufferedWriter(new FileWriter(path));
                txtOutput.append(text.getText());
                txtOutput.close();

                //System.out.println("SKIP");
                driver.switchTo().defaultContent();

            }catch (Exception c){

                try{

                    driver.switchTo().defaultContent();

                    WebElement ebookFrame = driver.findElement(By.xpath("//*[starts-with(@name,\"easyXDM\")]"));
                    System.out.println("Before PDF iframe");
                    driver.switchTo().frame(ebookFrame);
                    System.out.println(driver.getPageSource());
                    System.out.println("During PDF Frame");
                    String PDFRaw = driver.findElement(By.className("btn")).getAttribute("href");
                            //driver.findElement(By.xpath("//*[starts-with(@data,\"https://\")]")).getAttribute("data");
                    System.out.println(PDFRaw);
                   // String PDFRaw2 = PDFRaw.substring(PDFRaw.indexOf("&file=")+6 , PDFRaw.length());
                   // String PDF = java.net.URLDecoder.decode(PDFRaw2, "UTF-8");

                    System.out.println("After PDF Frame");

                    System.out.println(PDFRaw);

                    URL website = new URL(PDFRaw);
                    System.out.println(getFileSize(website) + "- PDF:  " + cleanCourseName + ":  Download started");
                    ReadableByteChannel rbc = Channels.newChannel(website.openStream());

                    System.out.println("Clean name PDF: " + lectureName);

                    String actualPDF =   lectureName + ".pdf";
                    File path = new File(CourseFolderLocation+ cleanCourseName +"/" + actualPDF);
                    System.out.println(getFileSize(website) + "- PDF:  " + cleanCourseName + ":  Download Finished");
                    if(!path.exists()) {
                        FileOutputStream fos = new FileOutputStream(path);
                        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);


                        if (fos.getChannel().size() == getFileSize(website)) {
                            System.out.println("-- Size Verified");

                        } else {
                            System.out.println("Size not matching");

                        }
                    }
                    else {
                        System.out.println("File already exists");
                    }


                    driver.switchTo().defaultContent();


                }catch (Exception f) {

                    System.out.println(count + " : This is a slide");
                    driver.switchTo().defaultContent();
                }
            }
            driver.switchTo().defaultContent();

        }
    }


    public int updateCount(int count) throws FileNotFoundException, UnsupportedEncodingException {

        return count;
    }

    public static int getFileSize(URL url) {

        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.getInputStream();
            return conn.getContentLength();
        } catch (IOException e) {
            return -1;
        } finally {
            conn.disconnect();
        }
    }


    public void DownloadActualFile() throws IOException {

        System.out.println("Reading Download Links");
        File url = new File(CourseFolderLocation+cleanCourseName+ "/udemyLinks.txt");
        System.out.println("Reading Course Titles");
        File Title = new File(CourseFolderLocation+cleanCourseName+ "/udemyTitle.txt");
       // System.out.println("3");

        if(!url.exists()){
            url.mkdir();

        }

        if(!(Title.exists())){
            Title.mkdir();
        }

        File fin = new  File(CourseFolderLocation + cleanCourseName+ "/udemyLinks.txt");
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        File fin2 = new  File(CourseFolderLocation+cleanCourseName+ "/udemyTitle.txt");
        FileInputStream fis2 = new FileInputStream(fin2);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));

        String line = null;
        String line2 = null;
        while ((line = br.readLine()) != null   ) {


            URL website = new URL(line);
            line2 = br2.readLine() ;
            System.out.println(getFileSize(website)+"KB " + "- " + line2 + ":  Download started");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            //  line2 = br2.readLine() ;
            String actualVideoName =  line2 + ".mp4";
            File path = new File(CourseFolderLocation+ cleanCourseName +"/" + actualVideoName);
            if(!path.exists()) {
                FileOutputStream fos = new FileOutputStream(path);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                System.out.print(getFileSize(website)+"KB " + "- " + line2 + ": Download Finished");

                if (fos.getChannel().size() == getFileSize(website)) {
                    System.out.println("-- Size Verified");

                } else {
                    System.out.println(" Size not matching");

                }
            }
            else {
                System.out.println("File already exists");
            }
        }

        br.close();
        br2.close();
        fin.delete();
        fin2.delete();
        new File(CourseFolderLocation+ "count.txt").delete();
        new File(CourseFolderLocation+ "coureName.txt").delete();
        /*udemyMainTest.countStore.delete();
        udemyMainTest.courseName.delete();*/
    }

    public int clickAndCountCourses(int count) throws IOException, InterruptedException, ParseException {

        if(count == 0) {
            count = 1;
        }


        while (count <= countCourses()) {

            WebElement links = driver.findElement(By.partialLinkText("Lecture " + count + ":"));
            executor.executeScript("arguments[0].scrollIntoView(true);", links);
            lectureName = links.getText().substring(0, links.getText().length() - 6);
            lectureName = lectureName.replaceAll("[ ](?=[ ])|[^-_,A-Za-z0-9 ]+","");
            System.out.println(lectureName);

            executor.executeScript("arguments[0].click();", links);
            // links.click();

            Thread.sleep(1000);

            getDownloadlink(count,lectureName);

            if (!(isTimeUp(count))){
                count++;

                new File(CourseFolderLocation+"count.txt").delete();
                File countStore = new File(CourseFolderLocation+"count.txt");
                FileWriter countStoreFile = new FileWriter(countStore,false);
                countStoreFile.write(Integer.toString(count));
                countStoreFile.close();
                System.out.println(count + " TIME IS UP ---- Restarting Session");
                return updateCount(count);
            }

            new File(CourseFolderLocation+"count.txt").delete();

            File countStore = new File(CourseFolderLocation+"count.txt");
            FileWriter countStoreFile = new FileWriter(countStore,false);
            countStoreFile.write(Integer.toString(count));
            countStoreFile.close();
            System.out.println(count + ": Times Not Up");

            count++;



        }

        //  DownloadActualFile(VideoRawURL, lectureName);
        if (count > countCourses()) {
            udemyMainTest.closeBrowser();
            DownloadActualFile();
        }
        return updateCount(count);


    }

    public boolean isTimeUp(int count) throws InterruptedException, IOException {

        int time = Integer.parseInt(timer.getText().substring(0, timer.getText().length() - 3));
        //  System.out.println(time + ": Time");
        if (time <= 1) {

            if (count < lecturesSize) {

                driver.manage().deleteAllCookies();
                driver.navigate().refresh();
                Thread.sleep(2000);
                return false;
            }

        }


        return true;
    }

}
