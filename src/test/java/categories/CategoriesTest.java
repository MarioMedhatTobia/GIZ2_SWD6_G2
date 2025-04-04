package categories;
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
}