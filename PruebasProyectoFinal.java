package com.fca.calidad.funcionales.proyecto;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;


public class PruebasProyectoFinal {
	//Variables globales de apoyo
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
	
	@Test
	public void agregarTest() throws InterruptedException {
		driver.get("https://mern-crud.herokuapp.com/");
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
	
	@Test
	public void editarTest() throws InterruptedException {
		driver.get("https://mern-crud.herokuapp.com/");
		//Presionando el boton editar
	    WebElement e=driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button"));
	    e.click();
	    //Variables auxiliares para el manejo de los elementos
	    String name="qwerty";
	    String email="qwerty@cloud1.com";
	    String age ="25";
	    //Ingresando los valores de nombre, email y edad
	    e=driver.findElement(By.name("name"));
	    e.clear();
	    e.sendKeys(name);
	    e=driver.findElement(By .name("email"));
	    e.clear();
	    e.sendKeys(email);
	    e=driver.findElement(By .name("age"));
	    e.clear();
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
	    
	    String resultadoEsperado = "Successfully updated!";
	    String resultadoEjecucion = "";
	    WebElement r=driver.findElement(By .xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p"));
	    resultadoEjecucion=r.getText();
	    assertThat(resultadoEsperado, equalTo(resultadoEjecucion));	   
	    
	}
	
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
			
			
			WebElement r=driver.findElement(By .name("qwerty"));
			String resultadoEjecucion = r.getText();
			
			 
		}
		
		
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
