# Автотесты для сайта https://www.ubrr.ru/
![01](./img/01.png)

## Используемый стек:
![Java](https://github.com/Mhabibullin/Mhabibullin/raw/main/imgForReadme/java.svg?alt="azure"?width="40"?height="40")

Java, Gradle, JUnit5, Selenide, Jenkins, Selenoid, Allure Reports, Telegram (уведомления)

## Для построения отчета используется Allure Reports

Пример общего отчета о прохождении тестов:

![allure-reports](https://github.com/antsuishch/data_repository/blob/master/resources/newscreen/mainallure.png?raw=true)

Пример подробного отчета:

![allure](https://github.com/antsuishch/data_repository/blob/master/resources/newscreen/suite.png?raw=true)

## Также присутствует интеграция с системой тест-менеджмента Allure TestOps
Dashboards:

![alluretestops](https://github.com/antsuishch/data_repository/blob/master/resources/newscreen/dashboardbase.png?raw=true)

Пример ручных и автоматизированных тестов в Allure TestOps:

![ops](https://github.com/antsuishch/data_repository/blob/master/resources/newscreen/testopscases.png?raw=true)

Пример запуска теста в Selenoid:

![video](https://github.com/antsuishch/data_repository/blob/master/resources/gif/a098cf6c21c1beef.gif?raw=true)

##  Запуск тестов происходит в 2 потока

Количество потоков задается при запуске тестов
![threads](https://github.com/antsuishch/data_repository/blob/master/resources/newscreen/threads.png?raw=true)

## Уведомление о результате прогона отправляется чат-ботом в Telegram:
![bot](https://github.com/antsuishch/data_repository/blob/master/resources/newscreen/telegram.jpg?raw=true)

## Пример запуска
Для удаленного запуска необходимо заполнить файл remote.properties или передать параметры в командной строке:

* browser (default chrome)
* browserVersion (default 91.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)

Запуск с использованием файла remote.properties:
```bash
gradle clean test
```

Запуск с ручным указанием параметров:
```bash
gradle clean test -Dbrowser=chrome -DbrowserVersion=91.0 -DbrowserSize=1920x1080 -DbrowserMobileView= -DremoteDriverUrl=selenoid.autotests.cloud -DremoteDriverUser=user1 -DremoteDriverPassword=1234 -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=2
```
