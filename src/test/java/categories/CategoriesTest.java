package categories;

import org.testng.annotations.Test;
import pages.Categories;

public class CategoriesTest {
    final Categories categories = new Categories();

    @org.testng.annotations.Test(priority=1)
    public void CategoriesFeaturesTest(){
        categories.verifyCategoryNavigation();
    }

    @org.testng.annotations.Test(priority=2)
        public void verifyCategoryPageUIElementsTest(){
            categories.verifyCategoryPageUIElements();}

 //   @org.testng.annotations.Test(priority=3)
  // public void verifyBreadcrumbNavigationTest(){
   //     categories.verifyBreadcrumbNavigation();}


}
