object PlaceHolderSyntax extends App{
private def isVIP(firstName:String,lastName:String,IsHighStatus:(String,String)=>Boolean):Boolean={
        IsHighStatus(firstName,lastName)
        }

        println(isVIP("Donald","Trump",_=="Donald"&&_=="Trump"))
        println(isVIP("Not","A Trump",_=="Donald"&&_=="Trump"))
        }
