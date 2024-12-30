package pl.automationpractice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class filtrarProduto {
    @Test
    public void pesquisarPorProduto () {

        System.setProperty("webdriver.chromedriver", "src\\drive\\chromedriver.exe");
        WebDriver navegar = new ChromeDriver();
        navegar.get("http://www.automationpractice.pl/");

        String produto = "Printed Chiffon Dress";

        navegar.findElement(By.name("search_query")).sendKeys(produto);
        navegar.findElement(By.name("submit_search")).click();


        // Verifica se o redirecionamento para a URL está conforme esperado
        String urlEsperada = "http://www.automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=Printed+Chiffon+Dress&submit_search=";
        String urlAtual = navegar.getCurrentUrl();
        Assert.assertEquals("O redirecionamento não foi para a URL esperada.", urlEsperada, urlAtual);

        // Verifica se o produto filtrado aparece na tela
        WebElement produtoEncontrado = navegar.findElement(By.cssSelector("a.product-name[title='Printed Chiffon Dress']"));
        String nomeProdutoEncontrado = produtoEncontrado.getText().trim();
        Assert.assertEquals("O produto exibido não corresponde ao produto pesquisado.", produto, nomeProdutoEncontrado);

        navegar.quit();
    }
}
