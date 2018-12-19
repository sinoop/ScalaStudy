def abs(x:Int) = {
  x.abs
}

abs(-10)


def fac(number:Int):Int = {
  number match {
    case 1 => 1
    case zeroOrNegative if zeroOrNegative <= 0  => 1
    case _ => number * fac(number -1)
  }
}


fac(-5)


val double = (i:Int)=> i*2.0
val square = (i:Int)=> Math.pow(i,2)

def higherOrderFunction (x:Int, y:Int=>Double) : Double = y(x)

higherOrderFunction(5,double)
higherOrderFunction(5,square)
