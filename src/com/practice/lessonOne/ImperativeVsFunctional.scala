package com.practice.lessonOne

import java.util.ArrayList

/**
 * Why Scala?
 * Concyrrnecy Model
 * Functional Programming
 * statically typed language
 * Language on JVM
 * Hybrid functional langauge(Use it as dial to code imperative or functional style)
 */

object Intro {
  /*
   * Problem statements- adding element of list .
   */
  def main(args: Array[String]): Unit = {
    /**
     * Imperative Style of coding
     */
    val numbers = List(1, 2, 3, 4, 5, 6)
    /*
     * declare a variable and mutate it in the loop
     */
    var total = 0
    for (i <- numbers) { // its similar to each loop in java
      /**
       * constantly modifying total in loop
       */
      total += i
    }
    println(total)
    /**
     * Note- There are two things we should observe in imperative syle of coding
     * The 1st thing with imperative style is, you have to tell the code every step not only what to do but how to do it?
     * In above case loop through each value and total each value
     * The 2nd issue with the above imperative style is the mutability of the variable that you can see above i.e.,  variable total,
     *
     * In functional style of coding we lean towards declarative style of coding rather than being imperative.
     * In other words, in functional style of coding you have to tell what to do, instead of how to do?
     * Functional style of coding in much more expressive because its declarative, easier to write,
     *
     * Lets try to code above example in declarative style i.e., functional style of coding
     *
     *
     */

    println(numbers.foldLeft(0) {
      (c, e) => c + e
    })

    /**
     * Now notice first thing, we didn't mutated any variable at all.
     * Now what does foldLeft() doing?
     * fold left takes two abject as parameter, first object is an initial value as parameter,
     * in above case we passed 0, and then we pass second object i.e carry and element,
     * {(c, e) => c + e} actually it doesn't look like object but instead its a funtion value.
     *
     * Scala says a function value is nothing but an object which represents function.
     * In other words in functional programming, we do with function what we normally do with
     * object.That means we can create object within function, we can return objects from function,
     * and we can pass object to function. That means Now we can create function within function,
     * returns function from function, and also pass function to function as well.
     * In above example we created an anonymous function(actually we call it lambda expressions)
     * and then we pass that function to fold left method.
     *
     * So fold left method says, i am going to start value zero to begin with, and i am going to
     * call this given lamda expression which binds the variable c with initial value we gave and
     * it binds with the current element e in the collections. and returns the result to c. now on
     * next iteration c will be added with next element of collection and result will be again
     * stored at c and so on till last element of collection.
     *
     * So basically we had wrote a code in way that what we want to acheive and let foldLeft() method
     * do how to acheive?
     *
     */

    //Lets do same problem with Java, but to double the list of element.
    //Lets do it with imperative style, i.e use Java 7 and before
    /* List<Integer> double=new ArrayList<>();
        for(int e: numbers){
              double.add(e*2);
          }
         System.out.println(double);*/

    //Now lets try to do same with Scala in functional style i.e declarative style
    println(numbers.map { e => e * 2 })
  }

}