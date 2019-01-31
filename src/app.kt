interface Roamable {

    fun roam(){
    }
}
class MyRoamable {
    fun to(r:Roamable) {
        //var r: Roamable = Wolf()
        when (r) {
            is Wolf -> println("There is a wolf and ${r.eat()}")
            else -> r.roam()
        }
    }
}


abstract class Animal: Roamable {
    abstract val image : String
    abstract val food : String
    abstract val habitat : String
    val hunger = 10


   abstract fun makeNoise()

    abstract fun eat()


    override fun roam(){
        println("The Animal is roaming")
    }

    fun sleep(){
        println("The Animal is sleeping")
    }
}

class Hippo : Animal() {

    override val image = "hippo.jpg"
    override val food = "grass"
    override var habitat = "water"


    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The hippo is eating $food")
    }
}

abstract class Canine : Animal() {

    override fun roam(){
        println("The Canine is roaming ")
    }
}

class Wolf : Canine() {
    override val image  = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"
    override fun makeNoise() {
        println("Hoooowl!")
    }

    override fun eat()
    {
        println("The wolf is eating food")
    }
}


class Vet() {
    fun giveShot(animal : Animal) {
        animal.makeNoise()
    }
}

fun main(args : Array<String>) {
    val animals = arrayOf(Hippo(), Wolf())
    for (animal in animals) {
        animal.roam()
        animal.eat()
    }

    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()
    vet.giveShot(wolf)
    vet.giveShot(hippo)

    val roamables = arrayOf(Hippo(), Wolf(), Vehicle())
    for (item in roamables) {
        item.roam()
        if(item is Animal){
            item.eat()
        }
        }
}