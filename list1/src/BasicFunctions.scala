/**
 * Expressions are split into objects by topic (note in Scala it is normal to nest functions, object, classes)
 * One can copy expressions from any object into REPL
 */
object BasicFunctions {

  /**
   * Try to understand declarations, signatures
   * Distinguish between val, var, def
   */
  abstract class Declarations {
    /*
      f. that multiply 2 Ints
      analyse below, try to run in REPL and write tests to see the difference
     */
    def d1: (Int, Int) => Int             // just signature, abstract method
    def d2(a: Int, b: Int): Int = ???     // declaration with no implementation (will throw not implemented exception)
    def d3(a: Int, b: Int) = a+b          // return type can be skipped and the compilator will inference it
    def d4 = (a: Int, b: Int) => a+b      // produce a function
    val a5 = (a: Int, b: Int) => a+b      // value is a function
    var a6 = (a: Int, b: Int) => a+b      // variable is a function
    val a7: (Int, Int) => Int = (a, b) => a+b  // val with signature and then anonymous definition,
                                               // because of inference of type there is no need to declare type in definition

    /*
      a5-a7 are functions, we can easily reuse them in other definitions
     */
    def mix1 = a5
    def mix2 = a6
    def mix3 = a7

    /*
      note d1-d3 are not yet a functions - they produce functions after arguments are applied
      so below is incorrect:
     */
    // def incorrect = d3

    /*
      note d4 has takes no arguments, so it produce a function immediately
     */
    def correct = d4

    /*
      and we can reuse d1-d3
     */
    def reused2 = d2(_,_)

    /*
      Practise those constructions, analyse REPL answers and look at Scala API
      to get familiar with above notations.
     */
  }

  object CurryingAndPartial {
    def f(a: Int)(b: Int) = a-b

    f(5)(3)                  // invocation

    val partial = f(5)_      // partial function with first arg applied
    partial(3) == f(5)(3)

    // how to apply a second argument?
    val partial2 = (a:Int) => f(a)(3)
    partial2(5) == f(5)(3)

    // how to change to normal function?
    def normal(a: Int, b: Int) = f(a)(b)

    // we can swap arguments
    def swapped(a: Int, b: Int) = f(b)(a)
  }

  object HigherOrderFunctions {


  }

  object Recurency {

  }

  object Generics {

  }

}
