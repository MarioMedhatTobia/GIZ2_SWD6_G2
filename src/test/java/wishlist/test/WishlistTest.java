package wishlist.test;

import org.testng.annotations.Test;
import pages.Wishlist;

public class WishlistTest {
    final Wishlist wishlist = new Wishlist();





    @Test(priority = 1)
    public void validatePersistentWishlist() throws InterruptedException {
        wishlist.PersistentWishlistValidation();



    }
    @Test(priority = 2)
    public void verifyWishlistIsEmpty() throws InterruptedException {
        wishlist.isWishlistEmpty();



    }


    @Test(priority = 3)
    public void verifyItemMovedToCart() throws InterruptedException {
        wishlist.moveItemToCart();
    }

    @Test(priority = 4)
    public void verifyItemRemoved() throws InterruptedException {
        wishlist.removeProduct();

}}