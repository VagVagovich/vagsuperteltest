# vagsuperteltest
Тестовое задание от VagVagovich

Объект Port проиндексирован набором последовательностей чисел произвольной длины, описанной в массиве строк indexes .
Каждая строка из массива indexes представляет из себя последовательность
чисел, перечисленных через дефис и(или) через запятую. К примеру, запись 1-5,7,9-11 является последовательностью следующих чисел: 1,2,3,4,5,7,9,10,11 .

Требуется разработать:
1. Метод, преобразовывающий массив строк indexes в массив
последовательностей чисел;
2. Метод, возвращающий всевозможные уникальные упорядоченные группы
элементов полученных массивов чисел;
3. Графический интерфейс пользователя для ввода данных и отображения
результатов.

Пример:
Массив строк {"1,3-5", "2", "3-4"} преобразуется в следующий массив чисел:
{[1, 2, 3], [1, 2, 4], [3, 2, 3], [3, 2, 4], [4, 2, 3], [4, 2, 4], [5, 2, 3], [5, 2, 4]}

Детали:

Для реализации используйте Java 8, 11;
Проект обязательно должен собираться с помощью фреймворка Maven ;
При написании методов допускается использовать только возможности стандартной библиотеки Java;
В результате решения задачи должна получиться библиотека;

Графический интерфейс пользователя должен быть реализован с использованием библиотеки Swing;

Покрытие библиотеки unit тестами будет плюсом. Вы можете выбрать любой фреймворк для тестирования;
Завершенное задание следует разместить на GitHub или GitLab
