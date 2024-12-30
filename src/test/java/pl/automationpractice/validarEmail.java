package pl.automationpractice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class validarEmail {
    @Test
    public void criarContaEmailExistente () {
        System.setProperty("webdriver.chromedriver", "src\\drive\\chromedriver.exe");
        WebDriver navegar = new ChromeDriver();
        navegar.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        String email = "teste@gmail.com";

        navegar.findElement(By.id("email_create")).click();
        navegar.findElement(By.id("email_create")).sendKeys(email);
        navegar.findElement(By.name("SubmitCreate")).click();

        // Verifica o aparecimento da mensagem de erro
        WebDriverWait wait = new WebDriverWait(navegar, Duration.ofSeconds(10));
        WebElement mensagemErro = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")));

        String mensagemEsperada = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        String mensagemAtual = mensagemErro.getText();
        Assert.assertTrue("A mensagem de erro não foi encontrada ou está incorreta.", mensagemAtual.contains(mensagemEsperada));

        navegar.quit();
    }
}
