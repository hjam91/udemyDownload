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
    @FindBy(xpath= "//*[starts-with(@data-purpose,\"start-free-preview\")]")
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

