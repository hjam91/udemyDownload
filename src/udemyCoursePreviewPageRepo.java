import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by fortegs on 8/18/15.
 */
public class udemyCoursePreviewPageRepo {

    WebDriver driver;

    @FindBy(css = ".course-title")
    WebElement courseTitle;

    @FindBy(linkText = "Take This Course")
    WebElement takeCourseButton;

    //@FindBy(linkText = "Start Free Preview")
    @FindBy(xpath= ".//*[@id='udemy']/div[4]/div[3]/div/div/div[2]/div/div[1]/div[1]/ul/li[2]/a")
    WebElement freePreviewButton;


    udemyCoursePreviewPageRepo(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebElement TakeCourseButtonElement(){
        return takeCourseButton;
    }

    public WebElement FreePreviewButtonElement(){
        return freePreviewButton;
    }

    public WebElement getCourseTitle(){ return courseTitle;}

    public String getCourseTitleText(){ return  getCourseTitle().getText();}



}

