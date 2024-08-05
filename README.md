## H2O тестовое задание
___

#### Быстрый запуск (используя Docker)
+ Запустите Docker на вашем устройстве
+ Выполните команду:
```
docker run -d -p 8080:8080 bondarevm/computer-storage-app
```
___
#### Быстрый запуск (без Docker)
+ Скачайте репозиторий:
```
git clone https://github.com/BondarevM/H2O.git
```
+ Выполните команду в директории приложения:

```
mvn clean install
```
+ Запустите скомпилированный JAR-файл:
```
java -jar target/computer-store-0.0.1-SNAPSHOT.jar
```
___
API методы
+ GET /api/desktop
+ GET /api/desktop/{id}
+ POST /api/desktop
+ PUT /api/desktop/{id}
___
+ GET /api/laptop
+ GET /api/laptop/{id}
+ POST /api/laptop
+ PUT /api/laptop/{id}
___
+ GET /api/monitor
+ GET /api/monitor/{id}
+ POST /api/monitor
+ PUT /api/monitor/{id}
___
+ GET /api/hard-drive
+ GET /api/hard-drive/{id}
+ POST /api/hard-drive
+ PUT /api/hard-drive/{id}
___
Для удобства тестирования API приложен файл computer-storage-collection.postman_collection.json
