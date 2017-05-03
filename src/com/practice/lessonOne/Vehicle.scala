package com.practice.lessonOne
/**
 * There are some ground rule we have to follow in the case of multiple constructor in scala.
 * In that case write an auxiliary constructor within the class, and then this auxilary constructor
 * required to call primary constructor, and  the primary constructor is the only one that can
 * call the base constructor. So its kind of funnel you will get which takes all constructor to
 * the primary constructor. This is only because it removes duplication of code , i t removes
 * alot of error that we introduce while writing constructor.
 *
 *
 */
class Vehicle(val year: Int, var miles: Int) {
  println("Created...")
  def drive(dist: Int) = {
    println("driving")
    miles += dist
  }

}
object Vehicle {

  def main(args: Array[String]): Unit = {

    val car = new Vehicle(2005, 0)
    println(car.year)
    car.drive(10)
    println(car.miles)
    car drive 20
    println(car.miles)

  }
  /**
   * In Scala classes are pure, what does it mean??
   * In scala we don't have static methods. Why? because remember when we talk about, in
   * programming  separation of concern. and then what we do?  we say class and then we put
   * instance and static in it. and then instance method and static method. So this is not a
   * separation of concern at all. why becuase we are dealing with instance related stuff and class
   * related stuff at one place and that becomes pain in the neck to deal with.
   * So static things are really evil to put in the class. There is another problem too. lets discuss
   * How do we create a singleton in Java?
   * Of course we write a private constructor to do so, Now the minute we write a private construcor,
   * there are many ways to break singleton(Reflection, Seialization and deserialization etc), of
   * course there are again ways which prevent us doing so, which takes alot of effort and time to get it right ,
   * So In my openion singleton is a  pattern which takes 5 minutes to learn and years to get it right.
   * and Infact its so bad that Java figured out the way to solve it. A right way to do singleton
   * in Java is to write an enum.  because enum implements singleton fairly well.
   *
   * Fine, so if singleton is so hard to do, then its better to leave it to the class loader to do it.
   * So scala says, alright if that is the right thing to do why don't we provide for you.
   * So notice what we had done in above code, In scala we can define singleton with keyword object.
   * So single can have same name as class, and if you do that by the way this singleton have a special
   * name called companion object.
   * Now lets add some more code under singleton.
   */

  object Vehicle {

    def create(year: Int) = new Vehicle(year, 0)
  
      val car = Vehicle.create(2013)
      println(car.year)
      car.drive(10)
      println(car.miles)
      car drive 20
      println(car.miles)
    }
  
    /**
     * Now its a kind of wrapper around it  and Vehicle.create() is a like a factory that is creating
     * instance for us. but Vehicle itself becomes singleton in this case. We can go a step further with this.
     */
  

  object Car {

    def apply(year: Int) = new Vehicle(year, 0)
  
      val car = Car(2013) //equivalent to  val car = Vehicle.apply(2013)
      println(car.year)
      car.drive(10)
      println(car.miles)
      car drive 20
      println(car.miles)
    
  }
  /**
   * So the term apply comes from functional programming where applying a function meaning we are
   * invoking a function, we are executing a function. Well the apply has special meaning in scala.
   *  and we can drop in this case i.e., val car = Car(2013), So when we do like this without any
   *  notation , it implicitly calls apply method. Now Lets understand apply in depth, with below code
   *
   */
  // consider we have a list of numbers
  val numbers = List(1, 2, 3, 4, 5)
  // print first number from list, to do so
  println(numbers(0));
 // which is equivalent to 
   println(numbers.apply(0));
   // that means an apply method is being called under the hud

}