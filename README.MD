### application.properties

````
spring.application.name = repo-tp3c

jwt.secret = monSuperSecretmonSuperSecretmonSuperSecretmonSuperSecretmonSuperSecret
jwt.cookie = AUTH-TOKEN
jwt.expires_in = 8640000

spring.datasource.url = jdbc:h2:mem:testdb
spring.datasource.driverClassName = org.h2.Driver
spring.datasource.username = sa
spring.datasource.password =
spring.jpa.hibernate.ddl-auto = update
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
spring.h2.console.enabled = true
spring.jpa.defer-datasource-initialization = true
````
