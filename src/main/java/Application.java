import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\source\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Scanner sc=new Scanner(System.in);

        System.out.println("Choose 1 for Finding Element");
        System.out.println("Choose 2 for Finding Multiple Elements");
        System.out.println("Choose 3 for Accessing Forms");
        var input = sc.nextInt();
        var shouldContinue = true;
        while(true) {
            switch(input) {
                case 1:
                    FindElement(driver);
                    break;
                case 2:
                    FindElements(driver);
                    break;
                case 3:
                    AccessForm(driver);
                    break;
                default:
                    shouldContinue = false;
                    break;
            }
            if(!shouldContinue) {
                break;
            }
            input = sc.nextInt();
        }
        sc.close();
    }

    public static void FindElement(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/ajax.html");
        driver.findElement(By.id("no")).click();
        driver.findElement(By.id("buttoncheck")).click();
    }

    public static void FindElements(WebDriver driver) {
        driver.get("http://demo.guru99.com/test/ajax.html");
        List<WebElement> elements = driver.findElements(By.name("name"));
        System.out.println("Number of elements:" +elements.size());
        for (int i=0; i<elements.size();i++){
            System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
        }
    }

    public static void AccessForm(WebDriver driver) {
        String baseUrl = "http://demo.guru99.com/test/login.html";
        driver.get(baseUrl);
        // Get the WebElement corresponding to the Email Address(TextField)
        WebElement email = driver.findElement(By.id("email"));
        // Get the WebElement corresponding to the Password Field
        WebElement password = driver.findElement(By.name("passwd"));
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        System.out.println("Text Field Set");
        // Deleting values in the text box
        email.clear();
        password.clear();
        System.out.println("Text Field Cleared");
        // Find the submit button
        WebElement login = driver.findElement(By.id("SubmitLogin"));
        // Using click method to submit form
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.click();
        System.out.println("Login Done with Click");
        //using submit method to submit the form. Submit used on password field
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        driver.findElement(By.id("SubmitLogin")).submit();
        System.out.println("Login Done with Submit");
    }
}
