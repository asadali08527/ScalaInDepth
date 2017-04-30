package com.practice.lessonOne
/**
 *
 */

object TailRecursion {
  def main(args: Array[String]): Unit = {
    println(factorial(5))
    println(factorialWithRecursion(5))
    println(factorialWithTailRecursion(50, 1))
    println(factorialWithTailRecursion(50, BigInt(1)))
    println(factorialTailRecursion(500))
  }
  /**
   * Below code is very simple code but its imperative style, where mutability of a
   * variable (fact) is being done. This process is called iterative to iterative approach.
   * Where you write you code as iterative and run as iterator
   *
   */
  def factorial(n: Int) = {
    var fact = 1
    for (i <- 1 to n) {
      fact *= i
    }
    fact
  }

  /**
   * Notice we had not mentioned any return type with above function, even though it works,
   * In short scala find out return type by self wherever it can and infers return type automatically.
   *
   *
   * But now lets try the same with recursion. This approach is called recursive to recursive approach
   * Where you write your code with recursive approach and run as recursive
   */
  /*def factorialWithRecursion(n: Int) = {
    if (n == 1) {
      1
    } else {
      n * factorialWithRecursion(n - 1)
    }*/
  /**
   * The above code will not compile ,this is because In this case we need to provide return type, as follows
   */
  def factorialWithRecursion(n: Int): Int = {
    if (n == 1) {
      1
    } else {
      n * factorialWithRecursion(n - 1)
    }
  }

  /**
   * The code works better upto some integer value( Try with different integer range), but fails
   * if you ask to find out the factorial of 50000, Your code will ends up with StackOverFlowError.
   * Here it come the term tail recursion, Now Lets try to solve out this problem to understand.
   * This approach is called recursive to iterative( Use recursion to write your code but run it as iterator)
   *
   */

  def factorialWithTailRecursion(n: Int, factorial: Int): Int = {
    if (n == 1) {
      factorial
    } else {
      factorialWithTailRecursion(n - 1, n * factorial)
    }
  }
  /**
   * Above result works well upto some input but after that it result with zero (but not ends with
   * any exception or error). The reason behind result zero is because of Integer overflow AND
   * could be fixed in following manner
   */

  def factorialWithTailRecursion(n: Int, factorial: BigInt): BigInt = {
    if (n == 1) {
      factorial
    } else {
      factorialWithTailRecursion(n - 1, n * factorial)
    }
  }

  /**
   * But again the above tail call code can be broken if some one replaces  the tail call with
   *
   * 1 * factorialWithTailRecursion(n - 1, n * factorial) or any other changes
   *
   * In this case your code won't work. To make sure its tail call, Scala provides a nice
   * annotation i.e., @scala.annotation.tailrec, Use it and it won't let you change
   */
  /* @scala.annotation.tailrec
  def factorialWithTailRecursion(n: Int, factorial: BigInt): BigInt = {
    if (n == 1) {
      factorial
    } else {
      factorialWithTailRecursion(n - 1, n * factorial)
    }
  }*/

  /**
   *  Now there is a disadvantage with above code and that is we loss the simplicity
   *  and need to pass two parameter, like you can't send 2 or 0 or any other value as second
   *  parameter, as shown below
   *
   *   println(factorialWithTailRecursion(50, BigInt(1)))  -- works fine
   *   println(factorialWithTailRecursion(50, BigInt(2)))  -- can't do
   *   println(factorialWithTailRecursion(50, BigInt(0)))  -- can't do
   *
   *   This un-necessory complexity could again be solved as with an implementation method/function
   *   as follows
   *
   */
  def factorialTailRecursion(n: Int) = {
    factorialWithTailRecursionImpl(n, BigInt(1))
  }
  @scala.annotation.tailrec
  def factorialWithTailRecursionImpl(n: Int, factorial: BigInt): BigInt = {
    if (n == 1) {
      factorial
    } else {
      factorialWithTailRecursionImpl(n - 1, n * factorial)
    }
  }

  /**
   * Because its functional style and we can have functions within functions, So another
   * approach could be as follows.
   */

  /*def factorialTailRecursion(n: Int) = {
    @scala.annotation.tailrec
    def factorialWithTailRecursionImpl(n: Int, factorial: BigInt): BigInt = {
      if (n == 1) {
        factorial
      } else {
        factorialWithTailRecursionImpl(n - 1, n * factorial)
      }
    }
    factorialWithTailRecursionImpl(n, BigInt(1))
  }*/

  /**
   * So this is all about how we can use tail call support , Tail call of course rely on the Scala
   * compiler to do this, The Java compiler doesn't support this. and as a result the bytecode
   * doesn't directly support either. So there is a limitation how far you can go with tail call
   * optimization. Like if there is too big function then tail call optimization may not
   * work (could be because of too many returns ) or in a trambulene call where A calls B and
   * B calls A, back and forth. But scala also provides you a class called tailRec, which you
   * can use to provide the tail call optimzation in a trambulene as well
   *
   */
}