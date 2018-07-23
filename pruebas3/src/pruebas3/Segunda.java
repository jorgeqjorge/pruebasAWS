/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas3;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 *
 * @author lenovo
 */
public class Segunda {

    static byte[] buffer = new byte[1024];
    static int len = 0;
    private FileOutputStream fileOutputStream = null;
    static int off = 0;
    private URL url = null;
    private String location = null;
    private InputStream inputStream = null;

    public void ruebaSitio() throws InterruptedException, AWTException {
        DesiredCapabilities DesireCaps = new DesiredCapabilities();
        DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:/phantomjs.exe");
        WebDriver driver = new PhantomJSDriver(DesireCaps);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        System.setProperty("webdriver.firefox.marionette", "C:/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        driver.get("http://www.cenace.gob.mx/SIM/VISTA/REPORTES/DemandaRealSist.aspx");
        driver.manage().window().getSize();
        Thread.sleep(1000);
        driver.get("http://www.cenace.gob.mx/SIM/VISTA/REPORTES/DemandaRealSist.aspx");

        WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadDatePickerFIVisualizarPorBalance_dateInput"));
        element.clear();
        element.sendKeys("27/01/2016");
        WebElement element1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadDatePickerFFVisualizarPorBalance_dateInput"));
        element1.clear();
        element1.sendKeys("17/05/2018");

        WebElement element2 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_DescargarArchivosCsv_PorBalance"));
        element2.click();

//        
//        driver.close();
//        System.exit(0);
//        Thread.sleep(60000);
//        try {
//            Download(new URL("http://download1509.mediafire.com/5gir3n2c3x4g/zo02t29t2ikp7ei/AndroPHP_1.2.0.apk"), "C:/Users/lenovo/Desktop/s/");
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(ObtenerZipWeb.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObtenerZipWeb.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void Download(final URL url, String location) throws IOException {
        this.url = url;
        this.location = location;
        try {
            URLConnection urlConnection = this.url.openConnection();
            inputStream = urlConnection.getInputStream();
            String p = url.getFile();
            String name = p.substring(p.lastIndexOf("/") + 1, p.length());
            System.out.println("Nombre del archivo: " + name);
            fileOutputStream = new FileOutputStream(new File(this.location + name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Descargando...");
            while ((len = inputStream.read(buffer)) >= 0) {
                fileOutputStream.write(buffer, off, len);
                fileOutputStream.flush();
            }
            System.out.println("Descarga completada: " + location + this);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException ioException2) {
                ioException2.printStackTrace();
            }

        }
    }

    public void ping() throws IOException, InterruptedException {
        String command = "xvfb-run -a -s \"-screen 0 1024x768x24\" google-chrome";

        Process proc = Runtime.getRuntime().exec(command);

        // Read the output
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
        }

        proc.waitFor();
    }

}
