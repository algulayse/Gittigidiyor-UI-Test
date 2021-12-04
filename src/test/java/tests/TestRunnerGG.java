package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import page.GGMainPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileWriter;
import java.io.IOException;

public class TestRunnerGG {

    @Test
    public void testRunnerGG() throws InterruptedException {


        GGMainPage page = new GGMainPage();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        page.aramaKutusu.sendKeys("bilgisayar");
        page.bulButton.click();


        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", page.ikinciSayfa);

        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals('2', url.charAt(url.length() - 1));

        Thread.sleep(3000);
        page.birinciUrun.click();

        String urunFiyatBilgisi = page.fiyatBilgisi.getText();
        System.out.println(urunFiyatBilgisi);
        String urunBilgisi = page.urunBilgisi.getText();
        System.out.println(urunBilgisi);

        //urun bilgisi ve fiyat bilgisi txt dosyasına yazdır
        resultFileWriter(urunBilgisi, urunFiyatBilgisi);

        Thread.sleep(5000);
        executor.executeScript("arguments[0].click();", page.sepeteEkle);

        page.sepet.click();

        String sepettekiFiyat = page.sepettekiFiyat.getText();
        System.out.println(sepettekiFiyat);

        Thread.sleep(3000);
        Assert.assertEquals(urunFiyatBilgisi, sepettekiFiyat);

        Select select = new Select(page.drapDown);
        select.selectByIndex(1);

        String ikinciSecilen = select.getOptions().get(1).getText();
        System.out.println(ikinciSecilen);


        Assert.assertEquals(ikinciSecilen, "2");

        Thread.sleep(3000);
        page.sil.click();

        Thread.sleep(3000);
        String actualMesaj = page.sepetBosYazisi.getText();
        System.out.println(actualMesaj);

        String mesaj = "Sepetinizde ürün bulunmamaktadır.";

        Assert.assertEquals(mesaj, actualMesaj);

        Driver.closeDriver();


    }

    private void resultFileWriter(String urunBilgisi, String urunFiyatBilgisi) {
        try {
            FileWriter myWriter = new FileWriter("result.txt");
            myWriter.write("Urun Bilgisi : " + urunBilgisi + "\n");
            myWriter.write("Urun Fiyat Bilgisi : " + urunFiyatBilgisi);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred on file writer.");
            e.printStackTrace();
        }
    }
}
