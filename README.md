### Test microservice with Spring Boot

Микросервис обращается к сервису курсов валют https://openexchangerates.org/ и отдает URL gif-картинки в ответ:
если курс по отношению к рублю за сегодня стал выше вчерашнего,
то отдаем случайную картинку отсюда https://giphy.com/search/rich
если ниже - отсюда https://giphy.com/search/broke

___
**Использование сервиса:**

    host:8080/rnd-gif/get/{currency}
    где:
    /rnd-gif - httpEndpoint, указанный в файле конфигурации application.properties
    {currency} - тег валюты для сравнения с базовой

___
**Ответ:**

    URL gif-картинки с сервиса Giphy.com
    либо текст ошибки


___
**application.properties**

    httpEndpoint - эндпоинт сервиса
    openexchangerates.url - RESTapi OpenChangeRates.org
    openexchangerates.apiKey - api-ключ (получаем на OpenExchangeRate.org)
    openexchangerates.baseCurrency - валюта по отношению к которой смотрим курс

    giphy.url - RESTapi Giphy.com
    giphy.apiKey - api-ключ (получаем на Giphy.com)

    gif_name.rich - тег картинки, если today rate >= yesterday rate
    gif_name.broke - тег картинки, если today rate < yesterday rate

___
**docker-hub repo pull command**

    docker pull madthreed/currency-service:latest