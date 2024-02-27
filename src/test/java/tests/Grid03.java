package tests;

import org.testng.annotations.*;
import static manage.DriverManage.*;


public class Grid03 {

    @BeforeTest
    @Parameters("browser")
    void beforeTest(@Optional("browser") String browser) {
        setDriver("grid_firefox");

    }

    @Test
    void test01(){
        driver.get("https://www.easybusticket.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    void test02(){
        driver.get("https://www.ebay.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    void test03(){
        driver.get("https://www.n11.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }


    @AfterTest
    void afterTest(){
        closeDriver();
    }



}
