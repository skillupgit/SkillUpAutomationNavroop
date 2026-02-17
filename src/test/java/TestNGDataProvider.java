import org.testng.annotations.DataProvider;

import java.util.UUID;

public class TestNGDataProvider extends BaseTest {

    @DataProvider(name="NegativeLoginTestData")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"invalid@koel.dev", "Intern$hip001"},
                {"student@skillup.study", "invalidPassword"},
                {"", ""}
        };
    }

    @DataProvider(name = "AddProfileTestData")
    public Object[][] getTestDataFromDataProvider() {
        return new Object[][]{
                {"Intern$hip001","Intern$hip001",generateRandomName(),"student@skillup.study"},
                {"Intern$hip001","Intern$hip001",generateRandomName(),"student@skillup.study"}
        };
    }
    public String generateRandomName() {

        return UUID.randomUUID().toString().replace("-", "");
    }
    }

