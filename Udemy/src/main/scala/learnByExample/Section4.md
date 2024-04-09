# Example 34 : Placeholder Syntax - [PlaceholderSyntax.scala](PlaceholderSyntax.scala)

## 1. eta expansion

1. _ (underscore) can be used to convert methods to functions
2. This is called eta expansion
3. Functions are objects, methods are not

# Example 35 : Partially Applied Functions - [PartiallyAppliedFunctions.scala](PartiallyAppliedFunctions.scala)

1. For facilitating code reuse
2. Convert 4 argument function to a one parameter function
   1. `Java` -> You would do `function overloading`.
      Drawback of this is that now we have 2 versions of the same function
      ``` java
      // Original Function
      getOptionPrice(double underlyingPrice, double strike, double volatility, double interestRate) {
          getOptionPrice(100, strike, 0.35, 0.05) 
      }
      
      // New Function with only one paramter 
      getOptionPrice(double strike) {
          // Essentially we are fixing the other 3 parameters to constant
          getOptionPrice(100, strike, 0.35, 0.05) 
      }
      ```
   2. `Scala` ->
      ```scala
      object PartiallyAppliedFunctions {
         val defaultCompare = smartCompare(_:String, _:String, compareStrings)
      
         def compareStrings(s1: String, s2: String): Int = {
            if (s1 == s2) 0
            else if (s1 > s2) -1
            else {
               1
            }
         }
      
         def smartCompare(s1: String, s2: String, cmpFn: (String, String) => Int): Int = {
         cmpFn(s1, s2)
         }
      }
      ```

# Example 36 : Currying - [Currying.scala](Currying.scala)

1. 

