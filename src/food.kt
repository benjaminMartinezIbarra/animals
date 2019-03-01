open class Food

class VeganFood : Food()

interface Seller<out T>

class FoodSeller : Seller<Food>

class VeganFoodSeller : Seller<VeganFood>

interface Consumer<in T>

class Person: Consumer<Food>

class Vegan: Consumer<VeganFood>

fun main(args: Array<String>){



    var foodSeller: Seller<Food>
    foodSeller = FoodSeller()
    foodSeller = VeganFoodSeller()

    var veganFoodConsumer: Consumer<VeganFood>
    veganFoodConsumer = Vegan()

    veganFoodConsumer = Person()

}