
___
        Микросервис обращается к сервису курсов валют https://openexchangerates.org/ и отдает URL gif-картинки в ответ:
    если курс по отношению к рублю за сегодня стал выше вчерашнего,
    то отдаем случайную картинку отсюда https://giphy.com/search/rich
    если ниже - отсюда https://giphy.com/search/broke

___
    **Обращение к сервису:**
    /{endpoint}/get/{currency}
    где:
    {endpoint} - httpEndpoint из файла конфигурации application.properties
    {currency} - тег валюты для сравнения с базовой

___
    application.properties

    - httpEndpoint - эндпоинт сервиса
    - openexchangerates.url - эндпоинт RESTapi OpenChangeRates.org
    - openexchangerates.apiKey - api-ключ (получаем на OpenExchangeRate.org)
    - openexchangerates.baseCurrency - валюта по отношению к которой смотрится курс

    - giphy.url - эндпоинт RESTapi Giphy.com
    giphy.apiKey - api-ключ (получаем на Giphy.com)

    gif_name.rich - тег картинки, если today rate >= yesterday rate
    gif_name.broke - тег картинки, если today rate < yesterday rate