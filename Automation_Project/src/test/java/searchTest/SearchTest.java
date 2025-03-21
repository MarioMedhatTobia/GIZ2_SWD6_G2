package searchTest;

import Pages.Search;
import org.testng.annotations.Test;

public class SearchTest {
    final Search search = new Search();

    @Test(priority = 1)
    public void searchHappyScenario(){
        search.searchWithValidCredintials();
    }

    @Test(priority = 2)
    public void searchNonExist(){
        search.searchWithNonExist();
    }

    @Test(priority = 3)
    public void searchWithGeneralWord(){
        search.searchWithOneWord();
    }

    @Test(priority = 4)
    public void searchCaseSensitive(){
        search.searchCaseInsensitive();
    }

    @Test(priority = 5)
    public void searchAscendingAlphabetically(){
        search.SortAZAfterSearch();
    }

    @Test(priority = 6)
    public void searchDesendingPrices(){
        search.SortHighLowAfterSearch();
    }

    @Test(priority = 7)
    public void searchView4(){
        search.searchDisplay4();
    }

    @Test(priority = 8)
    public void searchView8(){
        search.searchDisplay8();
    }

    @Test(priority = 9)
    public void searchView12(){
        search.searchDisplay12();
    }
}
