
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by fortegs on 8/18/15.
 */
public class udemyHomePageRepo {

    WebDriver driver;

    @FindBy(partialLinkText = "Sign Up")
    WebElement signUpButton;

    @FindBy(id="id_fullname")
    WebElement fullName;

    @FindBy(id = "id_email")
    WebElement emailField;

    @FindBy(id = "id_password")
    WebElement passField;

    @FindBy(id = "submit-id-submit")
    WebElement sumbitButton;

    udemyHomePageRepo(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public WebElement SignUpLinkElement(){
        return signUpButton;
    }

    public WebElement FullNameElement(){
        return fullName;
    }

    public WebElement EmailFieldElement(){
        return emailField;
    }

    public WebElement PassFieldElement(){
        return passField;
    }

    public WebElement SumbitButtonElement(){
        return sumbitButton;
    }

    public String RandomizerfullName(){ return RandomStringUtils.randomAlphanumeric(10); }

    public String RandomizerEmail(){ return RandomStringUtils.randomAlphanumeric(10); }

    public String RandomizerpassWord(){ return RandomStringUtils.randomAlphanumeric(10); }

    public void getHomePage(WebDriver driver, String URL) { driver.get(URL);  }

    public void fillOutRegInfo(){

        String [] name = {"aarika","aaron","aartjan","aasen","ab","abacus","abadines","abagael","abagail","abahri","abasolo","abazari","abba","abbai","abbas","abbatant",
                "abbate","abbe","abbey", "krishnas","krispin","krissie","krissy","krista","kristal","kristan","kriste","kristel","kristen","kristi","kristian","kristie",
                "kimoto","kimstace","kimura","kin","kin-wai","kin-yee","kinahan","kinamon","kincaid","kinch","kindel","kindem","kindra","king","king-hau","kingaby","kingan","kingdon","kingrey",
                "gummadi","gumperz","gun","gunadhi","gunar","gunars","gunaseke","gunawan","gundecha","gunderse","gunderso","gundes","gundlach","gundry","guner","gunfer","gung","gungor","gunilla",
                "eisnor","eiswirth","eitner","ekaterin","ekiert","el","el-am","el-gueba","el-hawar","el-torky","eladio","elaina","elaine","elam","elana","elane","elayne","elbert","elberta","elbertin",
                "curtis","curtt","cusato","cushing","cushman","cusick","cusson","custer","custsupp","cusumano","cuthbert","cuthill","cutrufel","cutter","cuu","cwirzen","cy","cyb","cybil","cybill",
                "norris","norry","norstar","north","northam","northcot","northrop","northrup","norton","norval","norvie","norvig","norwood","nosewort","noslab","nosov","nostrada","notley","nou",
                "ridgway","ridha","ridley","riebl","ried","riedel","riehle","riekie","rieko","rieni","rigby","rigdon","rigel","riggins","riggs","riggsbee","righter","rightmir","rigobert","rigsbee",
                "buggie","buhler","buhr","buhrkuhl","bui","building","buiron","bujold","buker","bukowski","bukta","buky","bulan","bulanda","bulbrook","bulengo","bulent","buley","bulger","bulifant","bulit",
                "sang-mau","sang-woo","sangbong","sangha","sanghami","sangho","sangiova","sangman","sangwook","sanh","sanity","sanja","sanjay","sanjeet","sanjeev","sanjib","sanjiv","sanjiva","sanjoy"};

        int idx = new Random().nextInt(name.length);
        String firstName = (name[idx]);


        int idx1 = new Random().nextInt(name.length);
        String lastName = (name[idx1]);

        SignUpLinkElement().click();
        FullNameElement().sendKeys(firstName+" "+lastName);
        EmailFieldElement().sendKeys(firstName+"."+lastName+ "@gmail.com");
        PassFieldElement().sendKeys(RandomizerpassWord());
        SumbitButtonElement().click();

    }
}