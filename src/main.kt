import java.lang.NumberFormatException

fun main() {

    fun callResident(){
        var seniorOut = false
        //gather the information
        //going to put the information gathering from the user into a try catch block, most error prone
        try {
            println("Please enter customer name:")
            val customerName = readLine()!!
            println("Please enter Phone number:")
            val customerPhone = readLine()!!
            println("Please enter your address:")
            val customerAddress = readLine()!!
            println("Please enter the square footage:")
            val squareFootage = readLine()!!.toDouble()
            println("Are you a Senior Citizen? (Y/N):")
            val senior = readLine()!!

            if (senior == "Y") {seniorOut = true} else {seniorOut = false}

            val myResident = Residential(customerName,customerPhone,customerAddress,squareFootage,seniorOut)
            myResident.weeklycharge()

        } catch (e:KotlinNullPointerException){
            println("Value was Null")
        } catch (e:NumberFormatException){
            println("${e.message} is not a number")
        }
    }

    fun callCommercial(){
        var multiPropertyOut = false
        //gather the information
        //going to put the information gathering from the user into a try catch block, most error prone
        try {
            println("Please enter customer name:")
            val customerName = readLine()!!
            println("Please enter Phone number:")
            val customerPhone = readLine()!!
            println("Please enter your address:")
            val customerAddress = readLine()!!
            println("Please enter the square footage:")
            val squareFootage = readLine()!!.toDouble()
            println("Please enter a name by which to reference address:")
            val propertyName = readLine()!!
            println("Do you have multiple properties that require service? (Y/N):")
            val multiProperty = readLine()!!
            multiPropertyOut = multiProperty == "Y"

            val myCommercial =
                Commercial(customerName, customerPhone, customerAddress, squareFootage, propertyName, multiPropertyOut)
            myCommercial.weeklycharge()
        } catch (e:KotlinNullPointerException){
            println("Value was Null")
        } catch (e:NumberFormatException){
            println("${e.message} is not a number")
        }
    }

    //Define our arrays of items and quantities
    val servicetypes = arrayOf("Residential","Commercial", "Done")

    // Then we get to offering up the option to guide the creation
    var writeout = ""
    var choice = -1

    fun listall() {
        for (i in 0..2) {
            println((i + 1).toString() + ". ${servicetypes[i]}")
        }
    }

    while(choice !in 0..servicetypes.size - 1){
        println("Please enter a number to receive a quote or exit.")
        listall()
        print("")
        choice = readLine()!!.toInt() - 1

        if (choice !in 0..servicetypes.size - 1)
            println("Invalid Entry, try again")
    }

    when (choice){
        0 -> callResident()
        1 -> callCommercial()
        !in 0..1 -> writeout = "Thank you for visiting. Goodbye!"
        else -> writeout = "We are experiencing a system error please try again later."
    }

    println(writeout)
}