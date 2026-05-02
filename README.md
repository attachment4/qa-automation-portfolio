# QA Automation Portfolio

Учебный проект автоматизации тестирования на Java.  
Покрывает UI и API тесты с отчётностью через Allure.

## Стек

- Java 17
- Selenium WebDriver 4
- REST Assured 5
- JUnit 5
- Allure Report
- GitHub Actions (CI/CD)
- Maven

## Структура проекта
<<<<<<< HEAD
src/
├── main/java/ru/netology/qa/
│   ├── config/          # Настройки драйвера и API
│   └── pages/           # Page Object Model
└── test/java/ru/netology/qa/
├── api/             # API тесты (reqres.in)
├── models/          # POJO модели
└── ui/              # UI тесты (demoblaze.com)

## Запуск тестов

```bash
mvn test
```

## Allure отчёт

```bash
mvn allure:serve
```

## CI/CD

Тесты запускаются автоматически при каждом push в `main` через GitHub Actions.  
Статус: ![CI](https://github.com/ТУТ_ТВОЙ_ЮЗЕРНЕЙМ/qa-automation-portfolio/actions/workflows/ci.yml/badge.svg)

## Покрытие

| Модуль | Тесты |
|--------|-------|
| API (reqres.in) | GET user, POST user, 404 not found |
| UI (demoblaze.com) | Авторизация |
=======
>>>>>>> 8ea25b5378c54187803848221ec8ea948540dbb5
