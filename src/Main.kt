import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.pow
import kotlin.math.sqrt

// 1 задание
fun maxNum(a: Int, b: Int): Int {

    if (a == b) {
        // Оператор throw используется для явного вызова исключения.
        throw IllegalArgumentException("Числа равны!")      // метод вызывается с недопустимым или неподходящим аргументом.
    } else
        return a.coerceAtLeast(b)                           // возвращает большее число
}
//------------------------------------------------------------------------------------------------------------------
// 2 задание
fun calcDiv(dividend: Double, divisor: Double): Double {
    if (divisor == 0.0) {
        throw ArithmeticException("Делить на ноль нельзя!") // исключение во время выполнения, которое возникает при возникновении исключительного арифметического условия, например, при делении на ноль.
    } else {
        return dividend / divisor
    }
}
//------------------------------------------------------------------------------------------------------------------
// 3 задание
fun convertStringToNum(str: String): Int {
    try {
        return str.toInt() //преобразование
    } catch (e: NumberFormatException) {                    // вызывается если входная строка не может быть преобразована в допустимое целое число
        throw NumberFormatException("Строка не может быть преобразована в целое число!")
    }
}
//------------------------------------------------------------------------------------------------------------------
// 4 задание
fun age(age: Int) {
    if (age < 0 || age > 150) {
        throw IllegalArgumentException("Недопустимый возраст!")
    }
}
//------------------------------------------------------------------------------------------------------------------
// 5 задание
fun square(num: Double): Double {
    if (num < 0) {
        throw IllegalArgumentException("Корень отрицательного числа не определен!")
    }
    else {
        return sqrt(num)
    }
}
//------------------------------------------------------------------------------------------------------------------
// 6 задание
fun factorial(num: Int): Int {
    if (num < 0) {
        throw IllegalArgumentException("Факториал отрицательного числа не определен!")
    }
    if (num == 0) {
        return 1
    } else {
        var result = 1
        for (i in 1..num) {
            result *= i
        }
        return result
    }
}
//------------------------------------------------------------------------------------------------------------------
// 7 задание
fun checkArray(array: IntArray) {
    for (num in array) {
        if (num == 0) {
            throw IllegalArgumentException("Массив содержит нули!")
        }
    }
}
//------------------------------------------------------------------------------------------------------------------
// 8 задание
fun deg(base: Int, exponent: Int): Double {
    if (exponent < 0) {
        throw IllegalArgumentException("Степень должна быть положительной!")
    } else {
        return base.toDouble().pow(exponent.toDouble())
    }
}
//------------------------------------------------------------------------------------------------------------------
// 9 задание
fun cutString(str: String, length: Int): String {
    if (length > str.length) {
        throw IllegalArgumentException("Число символов больше длины строки!")
    } else {
        return str.substring(0, length)  // Метод substring возвращает часть строки
    }
}
//------------------------------------------------------------------------------------------------------------------
// 10 задание
fun elMass(mass: IntArray, element: Int): Int {
    for (i in mass.indices) {           // получаем допустимые индексы (0 до длины массива -1)
        if (mass[i] == element) {
            return i
        }
    }
    throw IllegalArgumentException("Элемент не найден!")
}
//------------------------------------------------------------------------------------------------------------------
// 11 задание
fun toBinary(num: Int): String {
    if (num < 0) {
        throw IllegalArgumentException("Число должно быть положительным!")
    }
    else {
        return Integer.toBinaryString(num)
    }
}
//------------------------------------------------------------------------------------------------------------------
// 12 задание
fun isDivisible(dividend: Int, divisor: Int): Boolean {
    if (divisor == 0) {
        throw ArithmeticException("Делить на ноль нельзя!")
    } else {
        return dividend % divisor == 0
    }
}
//------------------------------------------------------------------------------------------------------------------
// 13 задание
fun <T> element(list: List<T>, index: Int): T {
    if (index < 0 || index >= list.size) {        //возвращает список элементов, количество которых равно index, начиная с list
        throw IndexOutOfBoundsException("Индекс выходит за пределы списка!")
    } else {
        return list[index]
    }
}
//------------------------------------------------------------------------------------------------------------------
// 14 задание
fun checkPassword(password: String) {
    if (password.length < 8) {
        throw PasswordException("Пароль не надёжный. Он должен содержать не менее 8 символов!")
    }
    println("Пароль надёжный)")
}
class PasswordException(message: String) : Exception(message)
//------------------------------------------------------------------------------------------------------------------
// 15 задание
fun checkDateFormat(dateString: String) {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    try {
        LocalDate.parse(dateString, formatter)
        println("Дата корректна: $dateString")
    } catch (e: DateTimeParseException) {
        throw DateTimeParseException("Некорректный формат даты. Ожидается dd.MM.yyyy", dateString, 0)
    }
}
//------------------------------------------------------------------------------------------------------------------
// 16 задание
fun concatenateStrings(str1: String?, str2: String?): String {
    if (str1 == null || str2 == null) {
        throw NullPointerException("Одна из строк равна null")
    }
    return str1 + str2
}
//------------------------------------------------------------------------------------------------------------------
// 17 задание
fun remainder(dividend: Int, divisor: Int): Int {
    if (divisor == 0) {
        throw ArithmeticException("Деление на ноль недопустимо")
    }
    return dividend % divisor
}
//------------------------------------------------------------------------------------------------------------------
// 18 задание
fun calculateSquareRoot(number: Double): Double {
    if (number < 0) {
        throw IllegalArgumentException("квадратный корень отрицательного числа не определен!")
    }
    return sqrt(number)
}
//------------------------------------------------------------------------------------------------------------------
// 19 задание
fun celsiusToFahrenheit(celsius: Double): Double {
    if (celsius < -273.15) {
        throw IllegalArgumentException("температура не может быть ниже абсолютного нуля!")
    }
    return (celsius * 9/5) + 32
}
//------------------------------------------------------------------------------------------------------------------
// 20 задание
fun checkNotNullOrEmpty(input: String?) {
    if (input.isNullOrEmpty()) {
        throw IllegalArgumentException("строка не может быть пустой или равной null!")
    }
}
//------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------
fun main() {
    println("Задача 1: Функция для нахождения максимума")
    println("Условие: Напишите функцию, которая принимает два числа и возвращает максимальное из них. " +
                "Если числа равны, выбрасывайте исключение с сообщением об ошибке.")
    print("Введите первое число: ")
    val a = readln().toInt()
    print("Введите второе число: ")
    val b = readln().toInt()
    try {                                       // Конструкция try...catch...finally используется для обработки исключений.
        val max = maxNum(a, b)
        println("Максимальное число: $max")
    } catch (e: IllegalArgumentException) {
        println(e.message)                      // Возвращает подробное сообщение о произошедшем исключении.
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 2: Калькулятор деления")
    println("Условие: Создайте функцию для деления двух чисел. Если делитель равен нулю, " +
                "выбрасывайте ArithmeticException с сообщением о недопустимости деления на ноль.\n")
    print("Введите первое число: ")
    val a1 = readln().toDouble()
    print("Введите второе число: ")
    val b1 = readln().toDouble()
    try {
        val res = calcDiv(a1, b1)
        println("Результат деления: $res")
    } catch (e: ArithmeticException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 3: Конвертер строк в числа")
    println("Условие: Напишите функцию, которая принимает строку и пытается конвертировать её в целое число. " +
                "Если строка не может быть конвертирована, выбрасывайте NumberFormatException.")
    print("введите строку: ")
    val str = readln()
    try {
        val num = convertStringToNum(str)
        println("Преобразованное число: $num")
    } catch (e: NumberFormatException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 4: Проверка возраста")
    println("Условие: Создайте функцию, которая принимает возраст и выбрасывает IllegalArgumentException, " +
                "если возраст меньше нуля или больше 150.")
    print("Введите возраст: ")
    val age = readln().toInt()
    try {
        age(age)
        println("Возраст допустимый)")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 5: Нахождение корня")
    println("Условие: Реализуйте функцию, которая находит корень из числа. Если число отрицательное, " +
                "выбрасывайте IllegalArgumentException.")
    print("Введите число: ")
    val num = readln().toInt()
    try {
        val root = square(num.toDouble())
        println("Корень числа $num = $root")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 6: Факториал")
    println("Условие: Напишите функцию, которая вычисляет факториал числа. Если число отрицательное, выбрасывайте исключение.")
    print("Введите число: ")
    val factorial = readln().toInt()
    try {
        val fact = factorial(factorial)
        println("Факториал числа $factorial = $fact")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 7: Проверка массива на нули")
    println("Условие: Создайте функцию, которая проверяет массив на наличие нулей. Если в массиве есть нули, выбрасывайте исключение.")
    print("Введите размер массива: ")
    val size = readln().toInt()
    val mass = IntArray(size)
    println("Введите элементы массива: ")
    for (i in 0 until size) {
        mass[i] = readln().toInt()
    }
    try {
        checkArray(mass)
        println("Массив не содержит нулей")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 8: Калькулятор возведения в степень")
    println("Условие: Реализуйте функцию, которая возводит число в степень. Если степень отрицательная, " +
                "выбрасывайте исключение.")
    print("Введите число: ")
    val numDeg = readln().toInt()
    print("Введите степень: ")
    val deg = readln().toInt()

    try {
        val result = deg(numDeg, deg)
        println("число $numDeg в степени $deg = $result")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 9: Обрезка строки")
    println("Условие: Напишите функцию, которая принимает строку и число символов. Функция должна возвращать строку, " +
                "обрезанную до указанного числа символов. Если число символов больше длины строки, выбрасывайте исключение.")
    print("Введите строку: ")
    val str1 = readln()
    print("Введите число: ")
    val strlength = readln().toInt()
    println("Установленная длина строки по умолчанию - $strlength") // если оставляю ввод через клавиатуру, выдает ошибку!!!
    try {
        val truncated = cutString(str1, strlength)
        println("Обрезанная строка: $truncated")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 10: Поиск элемента в массиве")
    println("Условие: Напишите функцию, которая ищет элемент в массиве. Если элемент не найден, " +
                "выбрасывайте исключение с сообщением об ошибке.")
    print("Введите размер массива: ")
    val size1 = readln().toInt()

    val mass1 = IntArray(size1)
    println("Введите элементы массива: ")
    for (i in 0 until size1) {
        mass1[i] = readln().toInt()
    }
    try {
        val index = elMass(mass1, size1)
        println("Индекс элемента: $index")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 11: Конвертация в двоичную систему")
    println("Условие: Создайте функцию, которая конвертирует целое число в двоичную строку. " +
                "Если число отрицательное, выбрасывайте исключение.")
    print("Введите число: ")
    val num2 = readln().toInt()
    try {
        val binary = toBinary(num2)
        println("Двоичное представление: $binary")
    } catch (e: IllegalArgumentException) {
        println("Ошибка: " + e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 12: Проверка делимости")
    println(
        "Условие: Реализуйте функцию, которая принимает два числа и проверяет, делится ли первое число на второе. " +
                "Если второе число равно нулю, выбрасывайте ArithmeticException."
    )
    print("Введите первое число: ")
    val num3 = readln().toInt()
    print("Введите второе число: ")
    val num4 = readln().toInt()
    try {
        val divisible = isDivisible(num3, num4)
        println("Делится: $divisible")
    } catch (e: ArithmeticException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 13: Чтение элемента списка")
    println("Условие: Напишите функцию, которая возвращает элемент списка по индексу. Если индекс выходит " +
                "за пределы списка, выбрасывайте IndexOutOfBoundsException.")
    print("Введите первое имя: ")
    val name = readln()
    print("Введите второе имя: ")
    val name1 = readln()
    print("Введите третье имя: ")
    val name2 = readln()
    print("Введите индекс: ")
    val strlength2 = readln().toInt()
    try {
        val names: List<String> = ArrayList(listOf(name, name1, name2))
        val name3 = element(names, strlength2)
        println("Имя: $name3")
    } catch (e: IndexOutOfBoundsException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 14: Парольная проверка")
    println("Условие: Создайте функцию для проверки сложности пароля. Если пароль содержит менее 8 символов, " +
                "выбрасывайте исключение WeakPasswordException.")
    print("Введите пароль: ")
    val password = readln()
    try {
        checkPassword(password)
    } catch (e: PasswordException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 15: Проверка даты")
    println("Условие: Напишите функцию, которая проверяет, является ли строка корректной датой в формате " +
                "dd.MM.yyyy. Если формат неверен, выбрасывайте DateTimeParseException.")
    print("Введите дату в формате dd.MM.yyyy: ")
    val date = readln()
    try {
        checkDateFormat(date)
    } catch (e: DateTimeParseException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 16: Конкатенация строк")
    println("Условие: Реализуйте функцию, которая объединяет две строки. Если одна из строк равна null, " +
                "выбрасывайте NullPointerException.")
    print("Введите первую строчку: ")
    val str2 = readln()
    print("Введите вторую строчку: ")
    val str3 = readln()
    try {
        val result = concatenateStrings(str2, str3)
        println("Результат объединения: $result")
    } catch (e: NullPointerException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 17: Остаток от деления")
    println("Условие: Создайте функцию, которая возвращает остаток от деления двух чисел. " +
                "Если второе число равно нулю, выбрасывайте исключение.")
    print("Введите первое число: ")
    val numb1 = readln().toInt()
    print("Введите второе число: ")
    val numb2 = readln().toInt()
    try {
        val result = remainder(numb1, numb2)
        println("Остаток от деления: $result")
    } catch (e: ArithmeticException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 18: Квадратный корень")
    println("Условие: Реализуйте функцию, которая находит квадратный корень числа. Если число отрицательное, " +
                "выбрасывайте исключение.")
    print("Введите число: ")
    val num5 = readln().toDouble()
    try {
        val result1 = calculateSquareRoot(num5)
        println("Квадратный корень числа $num5 равен $result1")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 19: Конвертер температуры")
    println("Условие: Напишите функцию, которая переводит температуру из Цельсия в Фаренгейт. " +
                "Если температура меньше абсолютного нуля, выбрасывайте исключение.")
    val temp = readln().toDouble()
    try {
        val result1 = celsiusToFahrenheit(temp)
        println("Температура $temp°C равна $result1°F")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    //--------------------------------------------------------------------------------------------------------------
    println("\nЗадача 20: Проверка строки на пустоту")
    println("Условие: Создайте функцию, которая проверяет, является ли строка пустой или null. " +
                "Если строка пустая или равна null, выбрасывайте исключение.")
    val str4 = readln()
    try {
        checkNotNullOrEmpty(str4)
        println("Строка: '$str1' - допустима.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}