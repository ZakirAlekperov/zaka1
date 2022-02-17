import java.util.* //Для использования стека


fun main() {
    println("Введите выражение, записанное в обратной польской нотации")
    val str = readLine()  // чтение выражения из консоли.
    if (isNumeric(str.toString())) println("Значение выражения равно " + calc(str?.split(" ")))
    else { //Ошибка, если есть символы не из допустимого набора, то печатаем сообщение и перезапускаем программу.
        println("Ошибка ввода")
        main()
    }
}
fun operatorChars() = arrayOf('+', '-', '*', '/', '0','1','2','3','4','5','6','7','8','9', ' ') //Допустимый набор символов.
fun isNumeric(input: String) = input.all { it in operatorChars() } //Проверка на принадлежность к допустимому набору.
fun calc(formula: List<String>?): Double{ //Вычисление значения выражения
    val stack = Stack<Double>()
    if (formula != null) {
        for (f in formula){
            if(isDigit(f)) stack.push(f.toDouble()) //Если число - пишем в стек
            else { //Если оператор
                //Берем из стека два последних значения
                var x2=stack.pop()
                var x1=stack.pop()
                //Вызываем функцию, в зависимости от оператора
                when(f){
                    "+" -> stack.push(addition(x1,x2))
                    "-" -> stack.push(subtraction(x1,x2))
                    "*" -> stack.push(multiplication(x1,x2))
                    "/" -> stack.push((division(x1,x2)))
                }
            }
        }
    }
    return stack.pop() //Возвращаем последнюю запись в стеке
}
fun isDigit(c: String): Boolean { //Проверка является ли строка числом
    for (char in c){
        if (!(char >='0' && char <= '9')) return false
    }
    return true
}
fun addition(a: Double, b:Double) = a + b
fun subtraction(a: Double, b:Double) = a - b
fun multiplication(a:Double, b: Double) = a * b
fun division(a: Double, b: Double) = a /b