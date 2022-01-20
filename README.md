/**
* Микросервис обращается к сервису курсов валют https://openexchangerates.org/
* и отдает gif в ответ:
* если курс по отношению к рублю за сегодня стал выше вчерашнего,
* то отдаем случайную картинку отсюда https://giphy.com/search/rich
* если ниже - отсюда https://giphy.com/search/broke
* 
* ------------------------
* Параметры сервиса находятся в файле application.properties
* httpEndpoint - эндпоинт сервиса
* openexchangerates.url
* openexchangerates.apiKey - api-ключ пользователя
* openexchangerates.baseCurrency - валюта по отношению к которой смотрится курс
* 
* giphy.url
* giphy.apiKey - api-ключ пользователя
* 
* gif_name.rich - тег картинки
* gif_name.broke - тег картинки
* ------------------------
* 
* Обращение к сервису с параметрами по-умолчанию: /rnd-gif/get/RUB
* где RUB - валюта для сравнения
  */
* 