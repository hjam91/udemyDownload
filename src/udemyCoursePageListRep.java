import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by fortegs on 8/18/15.
 */
public class udemyCoursePageListRep {

    WebDriver driver;

    @FindBy(partialLinkText = "Lecture 1:")
    WebElement firstCourseLink;

    udemyCoursePageListRep(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement firstCourseLink(){
        return firstCourseLink;
    }

}
