import org.junit.Test;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;

public class TestLis {

    @Test
    public void allTestsCheck(){
        testMainForm(); //1
        testAgreeWithCity(); //2
        testClosePopup(); //3
        testWriteInChat();//4
        testChangeCity(); //5
        testCloseCookieBanner(); //6
        testSeeOffers(); //7
        testOpenSofas(); //8
        testOpenPage2(); //9
        testFilterSofa(); //10
        testSearchSofa(); //11
        testAddInFavourite(); //12
        testClickOnProductPage(); //13
        testOpenReviews(); //14
        testCheckCharacteristics(); //15
        testAddInCart(); //16
        testOpenFavourites(); //17
        testOpenCart(); //18
        testDeleteFromCart(); //19
        testCheckDeliveryInfo(); //20

        //testMakeAnOrderWithoutProfile(); //bonus
    }

    // 1
    @Test
    public void testMainForm(){
        open("https://novosib.stolplit.ru/");
    }

    // 2
    @Test
    public void testAgreeWithCity(){
        sleep(1000);
        $(".btn-group--inline .js-yes").click();
        $(".city-btn__text").shouldHave(text("Новосибирск"));
    }

    //3
    @Test
    public void testClosePopup(){
        sleep(3000);
        $(".popmechanic-close").click();
        $(".popmechanic-info").shouldNotBe(visible);
    }

    //4
    @Test
    public void testWriteInChat(){
        sleep(1000);
        $(".page-header__chat.header-icon.js-jivo-key").click();
        $("textarea.inputField_f267").setValue("Добрый день, это автотест. Извините за беспокойство");
        $(".sendButton_d25f").click();
        sleep(3000);
    }

    //5
    @Test
    public void testChangeCity(){
        sleep(1000);
        $("#js-switch-region-btn").click();
        $("[name='search-city']").setValue("Тюмень");
        $("a[data-region-id='17']").click();
        sleep(3000);
        $(".city-btn__text").shouldHave(text("Тюмень"));
    }

    //6
    @Test
    public void testCloseCookieBanner(){
        sleep(1000);
        $(".js-cookie-accept").click();
        $("#cookie_notification").shouldNotBe(visible);
    }

    //7
    @Test
    public void testSeeOffers(){
        sleep(1000);
        $(".btn.btn-secondary--outline.btn-md--circle.main-slider__next").click();
        $(".btn.btn-secondary--outline.btn-md--circle.main-slider__next").click();
        $(".btn.btn-secondary--outline.btn-md--circle.main-slider__next").click();
    }

    //8
    @Test
    public void testOpenSofas(){
        sleep(1000);
        element(byText("Диваны")).click();
    }

    //9
    @Test
    public void testOpenPage2(){
        sleep(1000);
        testClosePopup();
        $("#nav_2").click();
    }

    //10
    @Test
    public void testFilterSofa(){
        sleep(1000);
        $("input[name='price_max']").setValue("50000");
        //$("input[value='4426'][name='color[]']").click();
        $(".btn-info.btn-sm.js-filter-find").click();
    }

    // 11
    @Test
    public void testSearchSofa(){
        sleep(1000);
        $("#search-input").setValue("Диван Диваныч");
        $(".search-form__button").click();
    }

    //12
    @Test
    public void testAddInFavourite(){
        sleep(1000);
        $(".favorite__btn.js-favorite-btn").click();
    }

    //13
    @Test
    public void testClickOnProductPage(){
        sleep(1000);
        element(byText("Диван Диваныч")).click();
        $("body").shouldHave(Condition.text("Диван Диваныч"));
    }

    //14
    @Test
    public void testOpenReviews(){
        sleep(1000);
        $(".tab__item.js-reviews").click();
    }

    //15
    @Test
    public void testCheckCharacteristics(){
        sleep(1000);
        element(byText("Характеристики")).click();
        $("a[data-text-hide='Развернуть описание']").click();
        sleep(3000);
    }

    //16
    @Test
    public void testAddInCart(){
        sleep(1000);
        executeJavaScript("document.getElementById('js-cart-detail-78568956').click();");
        sleep(3000);
        $(".badge__counter").shouldHave(text(String.valueOf("1")));
    }

    //17
    @Test
    public void testOpenFavourites(){
        sleep(1000);
        $(".page-header__favorite-link").click();
    }

    //18
    @Test
    public void testOpenCart(){
        sleep(1000);
        $("#bx_basketFKauiI .page-header__cart-link").click();
    }

    //19
    @Test
    public void testDeleteFromCart(){
        sleep(1000);
        $(".js-basket_item_delete").click();
        $("#confirmDeleteItem").click();
    }

    //20
    @Test
    public void testCheckDeliveryInfo(){
        sleep(1000);
        element(byText("Доставка")).click();
        $(byClassName("slideToggle")).click();
        sleep(1000);
        $(byClassName("slideToggle")).click();
    }


    @Test
    public void testDeleteFromFavourites(){
        sleep(1000);
        $(".page-header__favorite-link").click();
    }

    @Test
    public void testMakeAnOrderWithoutProfile(){
        sleep(1000);
        testSearchSofa();
        testClickOnProductPage();
        testAddInCart();
        testOpenCart();

        //$("a.btn.btn-primary.btn--block.right-checkout__btn").shouldBe(visible).click();
        $(".right-checkout__btn").click();

        $("#address_city").setValue("тест");
        $("#address_street").setValue("тест");

        $("#userfield_name").setValue("тест");
        $("#userfield_last_name").setValue("тест");
        $("#userfield_second_name").setValue("тест");
        $("#userfield_personal_phone").setValue("1111111111");

        //$("input[name='personal']").click();

        $("#comment").setValue("Это автотест, извините :( ");

        $("#js-btn-order-submit").click();
    }
}
