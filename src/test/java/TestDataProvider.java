import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest{


    //Test Data Related Login Page and Login Tests
    @DataProvider(name = "NegativeLoginTestData")
    public Object[][] getNegativeLoginTestData(){
        return new Object[][]{
                {"invalid@email.com","invalid"},
                {"",""},
                {"student@skillup.study","invalid"},
                {"invalid@email.com","Intern$hip001"}
        };
    }

    @DataProvider(name = "PostiveLoginTestData")
    public Object[][] getPositiveLoginTestData(){
        return new Object[][]{
                {"student@skillup.study","Intern$hip001"}
        };
    }


    //Test Data for Profile and Preferences







}
