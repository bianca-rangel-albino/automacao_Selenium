package pl.automationpractice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;


public class criarConta {
    @Test
    public void createAnAccount () {
        System.setProperty("webdriver.chromedriver", "src\\drive\\chromedriver.exe");
        WebDriver navegar = new ChromeDriver();
        navegar.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        Faker faker = new Faker();

        String nome = faker.name().firstName();
        String sobrenome = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String senha = faker.internet().password();

        navegar.findElement(By.id("email_create")).sendKeys(email);
        navegar.findElement(By.name("SubmitCreate")).click();
        navegar.findElement(By.name("customer_firstname")).sendKeys(nome);
        navegar.findElement(By.id("customer_lastname")).sendKeys(sobrenome);
        navegar.findElement(By.id("passwd")).sendKeys(senha);
        navegar.findElement(By.name("submitAccount")).click();

        // Verifica se o redirecionamento para a URL está conforme esperado
        String urlEsperada = "http://www.automationpractice.pl/index.php?controller=my-account";
        String urlAtual = navegar.getCurrentUrl();
        Assert.assertEquals("O redirecionamento não foi para a URL esperada.", urlEsperada, urlAtual);
    }
}
