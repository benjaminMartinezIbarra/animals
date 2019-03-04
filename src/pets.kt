abstract class Pet(var name: String)

class Cat(catName: String): Pet(catName)

class Dog(dogName: String): Pet(dogName)

class Fish(fishName: String): Pet(fishName)


class Contest<T: Pet>(var vet : Veterinary<in T>){
    var scores: MutableMap<T,Int> = mutableMapOf()

    fun addScore(contestant : T, score : Int = 0){
        if (score >= 0)
        scores.put(contestant,score)
    }

    fun getWinners() : Set<T> {
        val winners = mutableSetOf<T>()
       val highScore = scores.values.max()
        for((x, score) in scores){
            if (score == highScore)  winners.add(x)
        }
        return winners
    }

    fun getWinnersLambda():Set<T> {
        val highScore = scores.values.max()
        val winners = scores.filter { it.value == highScore }.keys
         winners.forEach { println("Winner is ${it.name}") }
        return winners
    }


}

fun <T: Pet> listPet(contest : Contest<T>) : MutableList<T> =
        contest.scores.keys.toMutableList()


class PetOwner<T: Pet>(t: T){
    val pets: MutableList<T> = mutableListOf(t)

    fun add(pet : T){
        pets.add(pet)
    }

    fun remove(pet : T){
        pets.remove(pet)
    }
}





fun main(args: Array<String>) {
    var dogContest : Contest<Dog> = Contest(Veterinary())
    dogContest.addScore(Dog("miou"), 3)
    dogContest.addScore(Dog("Toutou"), 6)

    val listDogs = listPet(dogContest)
    for(dog in listDogs) {
        println(dog.name)
    }

    val dogWinner = dogContest.getWinners().first()
    println("winner is ${dogWinner.name}")

    val dogWinnerL = dogContest.getWinnersLambda().first()
    println("winner is ${dogWinnerL.name}")



    val caktuz = Cat("Fuuz")
    val catKa = Cat("fishi")
    val fishCat = Cat("FishiCat")

    val calOwner = PetOwner<Cat>(catKa)
    calOwner.add(caktuz)


    val catR : Retailer<Cat> = CatRetailer()
    val dogR : Retailer<Pet> = DogRetailer() //covariance

    val catVet = Veterinary<Cat>()

    val dogVet = Veterinary<Dog>()

    val petVet = Veterinary<Pet>()

    val catContest = Contest<Cat>(catVet)

     val   catContest2 = Contest<Cat>(petVet) //contravariance

    val petContest = Contest<Pet>(Veterinary())



}

interface Retailer<out T> {

    fun sell() : T
}

class CatRetailer : Retailer<Cat>{


    override fun sell() : Cat {
        return Cat("toto")
    }
}

class DogRetailer : Retailer<Dog>{


    override fun sell() : Dog {
        return Dog("toto")
    }
}

class Veterinary <T: Pet>{

    fun treat(pet : T){
        println("Treat Pet ${pet.name}")
    }
}

