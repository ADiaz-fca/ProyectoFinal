package com.fca.calidad.funcionales.proyecto;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.Matchers.equalTo;

public class ProyectoTest {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/USUARIO/Documents/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  }
	
	/*
	@Test
	public void loginTest() throws InterruptedException {
		driver.get("https://es.uadyvirtual.uady.mx/login/index.php");
	    WebElement e=driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button"));
	    e.click();
	    //Variables auxiliares para el manejo de los elementos
	    String name="asdfg";
	    String email="asdfg@clout.com";
	    String age ="23";
	    //Ingresando los valores de nombre, email y edad
	    e=driver.findElement(By.name("name"));
	    e.sendKeys(name);
	    e=driver.findElement(By .name("email"));
	    e.sendKeys(email);
	    e=driver.findElement(By .name("age"));
	    e.sendKeys(age);
	    //Eligiendo el genero de una lista
	    e=driver.findElement(By .xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div"));
	    e.click();
	    e=driver.findElement(By .xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div[1]"));
	    e.click();
	 
	    //Presionando el boton agregar
	    e=driver.findElement(By .xpath("/html/body/div[2]/div/div[2]/form/button"));
	    e.click();
	    //Metemos un tiempo de espera para evitar errores
	    TimeUnit.SECONDS.sleep(5);
	    
	    String resultadoEsperado = "Successfully added!";
	    String resultadoEjecucion = "";
	    WebElement r=driver.findElement(By .xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p"));
	    resultadoEjecucion=r.getText();
	    assertThat(resultadoEsperado, equalTo(resultadoEjecucion));
	}
	*/
	
	@Test
	public void loginFailTest() throws InterruptedException {
		//Ingresando a la pagina de login
		driver.get("https://es.uadyvirtual.uady.mx/login/index.php");
		//Ingresando nombre de usuario
	    WebElement e=driver.findElement(By.id("username"));
	    e.click();
	    e.clear();
	    e.sendKeys("a00002950");
	    //Dejmos la contraseña vacía
	    e=driver.findElement(By .xpath("//form[@id='login']/div[3]"));
	    e.clear(); //No ingresamos valores
	    e=driver.findElement(By .id("loginbtn"));
	    e.click();
	 
	    //Presionando el boton ingresar
	    e=driver.findElement(By .id("loginbtn"));
	    e.click();
	    //Metemos un tiempo de espera para evitar errores
	    TimeUnit.SECONDS.sleep(5);
	    
	    String resultadoEsperado = "Datos erróneos. Por favor, inténtelo otra vez";
	    String resultadoEjecucion = "";
	    WebElement r=driver.findElement(By .xpath("/html/body/div/div/div/div/div/div/div/span"));
	    resultadoEjecucion=r.getText();
	    assertThat(resultadoEsperado, equalTo(resultadoEjecucion));	   
	    
	}
	
	/*
	//@TODO Verificar eliminacion
	@Test
	public void eliminarTest() throws InterruptedException{
		driver.get("https://mern-crud.herokuapp.com/");
		//Presionamos el boton eliminar
		WebElement e=driver.findElement(By .xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]"));
		e.click();
		//Presionamos el boton aceptar
		e=driver.findElement(By .xpath("//div[3]/button"));
		e.click();
		//Damos un tiempo de espera de 5 segundos
		TimeUnit.SECONDS.sleep(5);
		
		String resultadoEsperado = "";
		WebElement r=driver.findElement(By .name("qwerty"));
		String resultadoEjecucion = r.getText();
		assertThat(resultadoEsperado,equalTo(resultadoEjecucion));
		 
	}
	*/
	
	@After
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	    
	  }
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }


}
