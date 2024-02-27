package tests;

import manage.DriverManage;
import org.testng.annotations.Test;

import java.sql.DriverManager;

public class Grid04 {

    DriverManage driverManager = new DriverManage();


    @Test
    void test01(){

        driverManager.remoteChromeSetUp().get("https://www.wisequarter.com");
    }
    @Test
    void test02(){
        driverManager.remoteFirefoxSetUp().get("https://www.wisequarter.com");
    }
    @Test
    void test03(){
        driverManager.remoteChromeSetUp().get("https://www.testotomasyonu.com");
    }
    @Test
    void test04(){
        driverManager.remoteFirefoxSetUp().get("https://www.testotomasyonu.com");
    }
    @Test
    void test05(){
        driverManager.remoteChromeSetUp().get("https://www.stackoverflow.com");
    }
    @Test
    void test06(){
        driverManager.remoteFirefoxSetUp().get("https://www.stackoverflow.com");
    }
    @Test
    void test07(){
        driverManager.remoteChromeSetUp().get("https://www.youtube.com");
    }
    @Test
    void test08(){
        driverManager.remoteFirefoxSetUp().get("https://www.youtube.com");
    }
    @Test
    void test09(){
        driverManager.remoteChromeSetUp().get("https://www.google.com");
    }
    @Test
    void test10(){
        driverManager.remoteFirefoxSetUp().get("https://www.google.com");
    }







}