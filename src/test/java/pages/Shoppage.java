package pages;

import Utils.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shoppage {

        utils util = new utils();
        public WebDriver driver;

        public Shoppage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }

        public Map<String,Integer> itemsAdded = new HashMap<>();

        @FindBy(xpath = "//li[@id='nav-shop']/a")
        WebElement shopPageHeader;

        @FindBy(xpath = "//li[@id='nav-cart']/a")
        WebElement cartOption;

        @FindBy(xpath = "//h4[text()='Funny Cow']")
        WebElement funnyCowItem;

        @FindBy(xpath = "//h4[text()='Funny Cow']/..//a")
        WebElement addFunnyCowItem;

        @FindBy(xpath = "//h4[text()='Fluffy Bunny']")
        WebElement fluffyBunnyItem;

        @FindBy(xpath = "//h4[text()='Fluffy Bunny']/..//a")
        WebElement addFluffyBunnyItem;

        @FindBy(xpath = "//a[text()=\"Check Out\"]")
        WebElement checkout;

        public void userIsOnShopPage() throws InterruptedException {
            if(shopPageHeader.isDisplayed()){
                shopPageHeader.click();
                Thread.sleep(2000);
            }
        }


        public void addItemWithQuantities(String Item, String Quantity) throws InterruptedException {
            Thread.sleep(3000);
            int quantity= Integer.parseInt(Quantity);
            try{
                switch(Item){
                    case "Funny Cow"  : if(funnyCowItem.isDisplayed()){
                        for(int qty=1;qty<=quantity;qty++){
                            addFunnyCowItem.click();}
                        System.out.println(funnyCowItem.getText() + " is added to cart successfully");}
                        itemsAdded.put(funnyCowItem.getText(),quantity);
                        break;
                    case "Fluffy Bunny" : if(fluffyBunnyItem.isDisplayed()){
                        for(int qty=1;qty<=quantity;qty++){
                            addFluffyBunnyItem.click();}
                        System.out.println(fluffyBunnyItem.getText() + " is added to cart successfully");}
                        itemsAdded.put(fluffyBunnyItem.getText(),quantity);
                        break;
                }
            }
            catch(Exception ex){
                System.out.println("Items are not added to the cart");
            }
        }

        public void clickOnCartMenu(){
            if(cartOption.isDisplayed()){
                cartOption.click();
                System.out.println("Cart Menu is clicked");
            }
        }

        public void verifyItemsAddedToCart() throws InterruptedException {
            Thread.sleep(2000);
            HashMap<String, Integer> itemsOnCart= new HashMap<>();
            int count=0;
            if(checkout.isDisplayed()){
                List<WebElement> items =driver.findElements(By.xpath("//tr[@class='cart-item ng-scope']/td[1]"));
                List<WebElement> quantities=driver.findElements(By.xpath("//input[@name='quantity']"));
                for (WebElement item : items) {
                    if(count<quantities.size()){
                        itemsOnCart.put(item.getText(),Integer.parseInt(quantities.get(count).getAttribute("value")));
                        count++;}}
                System.out.println("Items in the cart are " + itemsOnCart);
                if(itemsAdded.equals(itemsOnCart))
                {
                    System.out.println("Items added are present on cart");
                    Assert.assertTrue(itemsAdded.equals(itemsOnCart),"Items added are present on cart");
                }
            }
        }


}
