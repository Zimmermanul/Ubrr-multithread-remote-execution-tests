# Autotests for [**ubrr.ru**](https://www.ubrr.ru/)
![01](./img/01.png)

## Stack:
| Java | Gradle | Junit5 | Selenide | Jenkins | Selenoid | Allure Reports | Allure TestOps | Telegram | Jira |
|:----:|:------:|:------:|:--------:|:-------:|:--------:|:--------------:|:--------------:|:--------:|:----:|
| <img src="img/imgForReadme/java.svg" width="40" height="40"> | <img src="img/imgForReadme/Gradle.svg" width="40" height="40"> | <img src="img/imgForReadme/JUnit5.svg" width="40" height="40"> | <img src="img/imgForReadme/Selenide.svg" width="40" height="40"> | <img src="img/imgForReadme/Jenkins.svg" width="40" height="40"> | <img src="img/imgForReadme/Selenoid.svg" width="40" height="40"> | <img src="img/imgForReadme/Allure_Report.svg" width="40" height="40"> | <img src="img/imgForReadme/Allure_EE.svg" width="40" height="40"> | <img src="img/imgForReadme/telegram.svg" width="40" height="40"> | <img src="img/imgForReadme/Jira.svg" width="40" height="40"> |

## Tests launch

### How to run tests from the command line
Run tests with default parameters:
```bash
gradle clean test
```

### Generate Allure report:
```bash
allure serve build/allure-results
```

### Running tests from Jenkins:

1. Open link to [project](https://jenkins.autotests.cloud/job/UBRR%20Tests/build?delay=0sec)
2. Select "Collect with parameters"
3. Specify parameters or leave the default parameters, click "Collect"

   ![06.png](img/06.png)

### Parameterization features added to the build:

* browser type
* browser version
* browser window size
* mobile version of the site (Android, IOS)
* remote server address
* remote video storage address
* number of startup threads

## Tests run in Selenoid

![alt "Video from Selenoid"](./img/test.gif "Video from Selenoid")

##  Tests run in 5 threads

![threads](./img/05.png)

## Allure Report is used to build the report

An example of a general test report:

![allure-reports](./img/09.png)

An example of a detailed report (with attached screenshots, logs, videos):

![allure](./img/08.png)


## Results notifications are sent by the chatbot to Telegram:
![bot](./img/07.png)


## Tests are integrated into the Allure TestOps test management system

An example of manual and automated tests in Allure TestOps:

![ops](./img/02.png)

Dashboards:

![alluretestops](./img/04.png)


## Tests are integrated into the Jira task tracking system

![ops](./img/11.png)


## Contact me

:rocket: [**Telegram - @Avadhutabrahman**](https://t.me/avadhutabrahman)
