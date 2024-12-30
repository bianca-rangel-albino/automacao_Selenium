


## Cenário: Verificar criação de conta
- Dado que o usuário esteja na página “automation practice” 
- Quando o usuário inserir o email, o primeiro nome, o ultimo nome e senha
- Então o site deve redirecionar o usuário para a página ‘My account’


## Cenário: Verificar filtro de produto 
- Dado que o usuário esteja na página “automation practice” 
- Quando o usuário clicar no campo de pesquisa no topo da página
- E filtrar o nome de um produto existente
- Então o site deve redirecionar o usuário para a página com apenas o produto filtrado


## Cenário: Verificar cadastro de conta, com um email existente na base de dados.
- Dado que o usuário esteja na página “automation practice” 
- Quando o usuário adicionar um email de uma conta cadastrada anteriormente
- Então a página deve retornar uma mensagem ‘An account using this email address has already been registered. Please enter a valid password or request a new one.’ para o usuário

# Testes automatizados 
- Tecnologias utilizadas: Selenium, Java, JUnit e o plugin Faker
- IDE: IntellijIdea
