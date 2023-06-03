Для запуска нужно:
- JDK 11
- Maven 3.9.1

Для начала можно собрать весь проект - "mvn clean install" из корня проекта(где расположен pom.xml).

Далее через командную строку исполнить - "mvn spring-boot:run". Либо через wrapper - "./mvnw spring-boot:run"

Либо запустить в IDE (Idea автоматически определит точку исполнения).

Для доступа к БД через веб-браузер использовать адрес:
- "http://localhost:9000/h2-console/"
- JDBC URL - "jdbc:h2:mem:testdb"
- Логин sa
- Пароль sa

При старте заполняются только две таблицы desktop_computer(3 записи) и monitor(2 записи). 
Отредактировать или добавить записи при старте приложения можно в src/main/resources/data.sql

Доступные ресты:

- POST http://localhost:9000/add с JSON body(xml не добавил, но возможность есть)
- POST http://localhost:9000/edit с JSON body
- GET "http://localhost:9000/get/all/тип_продукта" 
- GET "http://localhost:9000/get/тип_продукта/id_продукта" 

JSON body - обобщен, содержит все поля, которые есть во всех таблицах и поле type.
Т.е. сервис ждет что будет отправлено body со всеми параметрами, где type обязателен, для определения продукта.

Имена параметров, которые распознаются в body:
````java
Long id; // нужно заполнять только для /edit, для добавления работает авто инкремент
String series; 
String manufacturer;
BigDecimal price;
Integer quantity;
Integer volume;
String form;
Double size;
Double diagonal;
String type; // обязательное поле для определения типа. Типы описаны ниже (тип_продукта)
````
Пример json body который ждет сервис для добавления записи в таблицу hdd(жесткий диск):
- Адрес - http://localhost:9000/add
- json body:
````json 
{"type":"hdd", "series":"first", "manufacturer":"LG", "price":"1000", "quantity":"2", "volume":"75"}
````
Пример GET запроса для получения монитора с id = 1:
- http://localhost:9000/get/monitor/1


- тип_продукта(type) - desktop_monitor, hdd, laptop или monitor.
- id_продукта - id продукта, который хотим получить.

