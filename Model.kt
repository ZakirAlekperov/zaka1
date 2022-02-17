val bankDepositors: ArrayList<BankDepositors> = ArrayList<BankDepositors>()
val phonebooks: ArrayList<Phonebook> = ArrayList<Phonebook>()
val cars: ArrayList<Car> = ArrayList<Car>()
fun main(args: Array<String>) {
    initData()
    println("Выберите нужный метод поиска: 1 - поиск по номеру, 2 - быстрый поиск по номеру, 3 - поиск по фамилии и городу")
    var type_find = readLine()?.toInt()
    when(type_find){
        1 -> {
            println("Введите номер")
            println("Результат поиска "+ find_to_phone_long(readLine().toString()))
        }
        2 -> {
            println("Введите номер")
            println("Результат поиска "+ find_to_phone_short(readLine().toString()))
        }
        3 -> {
            println("Введите город")
            var city = readLine().toString()
            println("Введите фамилию")
            var surname = readLine().toString()
            println("Результат поиска "+ find_sourname_city(surname, city))
        }
    }
}

fun find_to_phone_long(phone:String): MutableList<String>{
    var result = mutableListOf<String>()
    var get_id:Long = 0
    for(p in phonebooks){
        if (p.phone == phone){
            result.add(p.surname)
            get_id =p.phonebook_id
            break
        }
    }
    for(c in cars){
        if(c.owner_id ==get_id){
            result.add(c.model)
            result.add(c.price.toString())
        }
    }
    return result
}
fun find_to_phone_short(phone: String):MutableList<String>{
    var list = find_to_phone_long(phone)
    var result = mutableListOf<String>()
    for(i in 1 until list.lastIndex){
        if(i%2 ==1) result.add(list[i])
    }
    return result

}
fun find_sourname_city(surname: String, city: String): MutableList<String>{
    var result = mutableListOf<String>()
    var get_id:Long = 0
    for(p in phonebooks){
        if(p.surname == surname && p.address["сity"]==city){
            result.add(p.address["street"].toString())
            result.add(p.phone)
            get_id = p.phonebook_id
        }
    }
    for(b in bankDepositors){
        if(b.owner_id == get_id){
            result.add(b.banks_name)
        }
    }
    return result
}
class BankDepositors {
    var deposit_id: Long
    var owner_id: Long
    var banks_name: String
    var bank_account: String
    var balance: Double

    constructor(deposit_id: Long, owner_id: Long, banks_name: String, bank_account: String, balance: Double) {
        this.deposit_id = deposit_id
        this.owner_id = owner_id
        this.banks_name = banks_name
        this.bank_account = bank_account
        this.balance = balance
    }
}
class Phonebook {
    var phonebook_id:Long
    var surname:String
    var phone: String
    var address = mapOf<String, String>(
        "сity" to "",
        "street" to "",
        "house" to "",
        "apartment" to ""
    )

    constructor(phonebook_id:Long, surname: String, phone:String, address: Map<String,String>){
        this.phonebook_id = phonebook_id
        this.surname = surname
        this.phone = phone
        this.address = address
    }
}
class Car{
    var car_id:Long
    var owner_id:Long
    var model: String
    var color: String
    var price:Double

    constructor(car_id:Long, owner_id: Long,model:String, color:String,price:Double){
        this.car_id =car_id
        this.owner_id = owner_id
        this.model = model
        this.color = color
        this.price = price
    }

}

fun initData() {
    bankDepositors.add(BankDepositors(1,1,"Сбербанк","11111111111",1000000.0))
    bankDepositors.add(BankDepositors(2,2,"Тинькофф","2222222222",1000000.0))
    bankDepositors.add(BankDepositors(3,3,"ВТБ","3333333333",1000000.0))
    bankDepositors.add(BankDepositors(4,4,"Сбербанк","4444444444",1000000.0))
    bankDepositors.add(BankDepositors(5,1,"ВТБ","5555555555",1000000.0))

    phonebooks.add(Phonebook(1,"Иванов","1 111 111 11 11", address = mapOf<String, String>(
        "сity" to "Москва",
        "street" to "Ленина",
        "house" to "1",
        "apartment" to "2"
    )))
    phonebooks.add(Phonebook(2,"Иванов","2 222 222 22 22", address = mapOf<String, String>(
        "сity" to "Волгоград",
        "street" to "Строителей",
        "house" to "1",
        "apartment" to "2"
    )))
    phonebooks.add(Phonebook(3,"Петров","3 333 333 33 33", address = mapOf<String, String>(
        "сity" to "Москва",
        "street" to "Ленина",
        "house" to "1",
        "apartment" to "2"
    )))
    phonebooks.add(Phonebook(4,"Сидоров","4 444 444 44 44", address = mapOf<String, String>(
        "сity" to "Москва",
        "street" to "Ленина",
        "house" to "1",
        "apartment" to "2"
    )))

    cars.add(Car(1,1,"Audi","белая", 2000000.0))
    cars.add(Car(2,1,"BMW","черная", 1000000.0))
    cars.add(Car(3,2,"Lexus","красная", 3000000.0))
    cars.add(Car(4,2,"Kia","синяя", 5000000.0))
    cars.add(Car(5,2,"Ford","белая", 2000000.0))
    cars.add(Car(6,3,"Honda","черная", 1000000.0))
    cars.add(Car(7,4,"Lada","серая", 1000000.0))
}