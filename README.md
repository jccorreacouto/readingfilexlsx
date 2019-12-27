# Reading File .xlsx
Este projeto permite a leitura de arquivos com extensão ``.xlsx`` localizados no diretório ``/Downloads/promocao`` do usuário logado (``HOMEPATH``).

### Características do desenvolvimento
* Linguagem de Programação Java, versão 8 (1.8.0_231), para desenvolvimento do código fonte.
* Pacote Lombok, para anotações dos atributos e métodos das classes.
* Framework Spring Boot (versão 2.2.2.RELEASE) e suas bibliotecas, para publicação e gerenciamento da aplicação.
* Junit 4, para criação dos testes unitários.

### Notas importantes
1. Após iniciado o container, é possível executar o processo de leitura dos arquivos fazendo uma chamada *GET* 
para a [localhost](http://localhost:8080/sorteio/vencedores).

### Possibilidades de melhorias
1. Criar no arquivo ``application.properties`` as variáveis do sistema para:
    * Diretório de entrada de arquivos
2. Tratar os métodos privados (``Code Smell``) para ampliar a cobertura dos testes unitários.

### Documentação referência

* [Java 8](https://docs.oracle.com/javase/8/docs/)
* [Lombok](https://projectlombok.org/)
* [Spring Boot](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/html/getting-started.html)
* [JUnit 4](https://junit.org/junit4/)

### Documentação complementar
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/maven-plugin/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#using-boot-devtools)

