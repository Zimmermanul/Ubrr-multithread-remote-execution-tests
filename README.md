# Автотесты для сайта https://www.ubrr.ru/
![01](./img/01.png)

## Используемый стек:
| Java | Gradle | Junit5 | Selenide | Jenkins | Selenoid | Allure Reports | Allure TestOps | Telegram | Jira |
|:----:|:------:|:------:|:--------:|:-------:|:--------:|:--------------:|:--------------:|:--------:|:----:|
| <img src="img/imgForReadme/java.svg" width="40" height="40"> | <img src="img/imgForReadme/Gradle.svg" width="40" height="40"> | <img src="img/imgForReadme/JUnit5.svg" width="40" height="40"> | <img src="img/imgForReadme/Selenide.svg" width="40" height="40"> | <img src="img/imgForReadme/Jenkins.svg" width="40" height="40"> | <img src="img/imgForReadme/Selenoid.svg" width="40" height="40"> | <img src="img/imgForReadme/Allure_Report.svg" width="40" height="40"> | <img src="img/imgForReadme/Allure_EE.svg" width="40" height="40"> | <img src="img/imgForReadme/telegram.svg" width="40" height="40"> | <img src="img/imgForReadme/Jira.svg" width="40" height="40"> |

## Запуск тестов через Jenkins

1. Открыть ссылку на [проект](https://jenkins.autotests.cloud/job/UBRR%20Tests/build?delay=0sec)
2. Выбрать пункт "Собрать с параметрами"
3. Указать параметры или оставить параметры по умолчанию, нажать "Собрать"

   ![06.png](img/06.png)

### Возможности параметризации, которые были добавлены в сборку:

* браузер
* версия браузера
* размер окна браузера
* мобильная версия сайта (Android, IOS)
* адрес удаленного сервера
* адрес удаленного видео хранилища
* количество потоков запуска

## Тесты запускаются в Selenoid

![alt "Video from Selenoid"](./img/test.gif "Video from Selenoid")

##  Запуск тестов происходит в 5 потоков

![threads](./img/05.png)

## Для построения отчета используется Allure Reports

Пример общего отчета о прохождении тестов:

![allure-reports](./img/09.png)

Пример подробного отчета (с приложенными скриншотами, логами, видео):

![allure](./img/08.png)


## Уведомления о результатах отправляются чат-ботом в Telegram:
![bot](./img/07.png)


## Тесты интегрированы в систему тест-менеджмента Allure TestOps

Пример ручных и автоматизированных тестов в Allure TestOps:

![ops](./img/02.png)

Dashboards:

![alluretestops](./img/04.png)


## Тесты интегрированы в систему таск-трекинга Jira

![ops](./img/11.png)





