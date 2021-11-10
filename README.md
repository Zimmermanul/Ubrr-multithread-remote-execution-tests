# Автотесты для сайта https://www.ubrr.ru/
![01](./img/01.png)

## Используемый стек:
<p align="left"> 
  <a href="https://www.java.com/" target="_blank"> <img src="imgForReadme/java.svg" alt="azure" width="40" height="40"/> </a> 
  <a href="https://gradle.org/" target="_blank"> <img src="imgForReadme/Gradle.svg" alt="azure" width="40" height="40"/> </a> 
  <a href="https://junit.org/" target="_blank"> <img src="imgForReadme/JUnit5.svg" alt="azure" width="40" height="40"/> </a> 
  <a href="https://selenide.org/" target="_blank"> <img src="imgForReadme/Selenide.svg" alt="azure" width="40" height="40"/> </a>
  <a href="https://www.jenkins.io" target="_blank"> <img src="imgForReadme/Jenkins.svg" alt="azure" width="40" height="40"/> </a> 
  <a href="http://allure.qatools.ru/" target="_blank"> <img src="imgForReadme/Allure_Report.svg" alt="azure" width="40" height="40"/> </a> 
  <a href="https://qameta.io/" target="_blank"> <img src="imgForReadme/Allure_EE.svg" alt="azure" width="40" height="40"/> </a> 
  <a href="https://aerokube.com/selenoid/" target="_blank"> <img src="imgForReadme/Selenoid.svg" alt="azure" width="40" height="40"/> </a> 
  <a href="https://t.me/avadhutabrahman" target="_blank"><img src="https://www.vectorlogo.zone/logos/telegram/telegram-icon.svg" alt="Maksim Khabibullin" height="30" width="30" /></a>
    <a href="https://www.atlassian.com/ru/software/jira" target="_blank"> <img src="imgForReadme/Jira.svg" alt="azure" width="40" height="40"/> </a> </p>

  <a href="https://www.atlassian.com/ru/software/jira" target="_blank"> <img src="imgForReadme/Jira.svg" alt="azure" width="40" height="40"/> </a> </p>


![java](https://github.com/antsuishch/data_repository/blob/master/resources/icons/Java.png?raw=true "Java")
![gradle](https://github.com/antsuishch/data_repository/blob/master/resources/icons/Gradle.png?raw=true "Gradle")
![jUnit5](https://github.com/antsuishch/data_repository/blob/master/resources/icons/JUnit5.png?raw=true "JUnit5")
![selenide](https://github.com/antsuishch/data_repository/blob/master/resources/icons/Selenide.png?raw=true "Selenide")
![jenkins](https://github.com/antsuishch/data_repository/blob/master/resources/icons/Jenkins.png?raw=true "Jenkins")
![Selenoid](https://github.com/antsuishch/data_repository/blob/master/resources/icons/Selenoid.png?raw=true "Selenoid")
![allure-logo](https://github.com/antsuishch/data_repository/blob/master/resources/icons/Allure_Report.png?raw=true "Allure_Report")
![telegram-logo](https://github.com/antsuishch/data_repository/blob/master/resources/icons/Telegram.png?raw=true "Telegram")

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
