open class Animal {
    open val image = ""
    open val food = ""
    open val habitat = ""
    val hunger = 10



   open fun makeNoise() {
        println("The Animal is making a noise")
    }

    open fun eat(){
        println("The Animal is eating")
    }

    open fun roam(){
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

open class Canine : Animal() {

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
}