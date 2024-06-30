# Дипломный проект по профессии «Инженер по тестированию»

## Запуск приложения и автотестов

1. Склонировать репозиторий с помощью команды  git clone git@github.com:alloenne/qamid_diplom.git
2. Открыть проект в Android Studio (каталог fmh_android_15_03_24)
3. Запустить эмулятор Pixel 3 API 29
4. Установить в настройках локализации английский язык (если не стоит по умолчанию)
5. Запустить тесты командой ./gradlew connectedAndroidTest и дождаться их выполнения
6. Для получения отчетов AllureReport откройте Device Explorer и перейдите в папку по адресу /sdcard/googletest/test_outputfiles/allure-results
7. Скопируйте содержимое указанной папки в папку на вашем компьютере
8. Перейдите в терминале на уровень выше папке с результатами и выполните команду allure serve