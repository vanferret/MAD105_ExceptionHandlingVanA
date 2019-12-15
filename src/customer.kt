import java.text.DecimalFormat

open class Customer constructor(customerName: String,
                                customerPhone: String,
                                customerAddress: String,
                                squareFootage: Double
){
    var customerName: String = ""
    var customerPhone: String  = ""
    var customerAddress: String = ""
    var squareFootage: Double = 0.00

    init {
        //leave it empty for now
        this.customerName = customerName
        this.customerPhone = customerPhone
        this.customerAddress = customerAddress
        this.squareFootage = squareFootage
    }
}

class Commercial constructor( customerName: String,
                              customerPhone: String,
                              customerAddress: String,
                              squareFootage: Double,
                              propertyName: String,
                              multiProperty: Boolean
):
    Customer(customerName,customerPhone,customerAddress,squareFootage){
    var propertyName = ""
    var rate: Double = 5.0
    var multiProperty = false

    init {
        this.customerName = customerName
        this.customerPhone = customerPhone
        this.customerAddress = customerAddress
        this.squareFootage = squareFootage
        this.propertyName = propertyName
        this.rate = rate
        this.multiProperty = multiProperty
        //leave it empty for now
    }
    fun weeklycharge() {
        val formatter = DecimalFormat("\u00A4###,###,###.00")
        var finalOut = this.squareFootage * this.rate / 1000
        var rateOut = formatter.format(this.rate)
        var mpText = ""

        if (this.multiProperty) {
            finalOut *= 0.9
            mpText = "(Multi-property discount of 15% applied.)"
        }
        var finalOutStr = formatter.format(finalOut)
        println("$customerName  has a Phone number of $customerPhone. \nThis property will be referred to as $propertyName \nThe address is $customerAddress." +
                "\nThe square footage is $squareFootage. At $rateOut per 1000 square feet, the weekly charge is $finalOutStr.\n" + mpText)
    }
}

class Residential constructor( customerName: String,
                               customerPhone: String,
                               customerAddress: String,
                               squareFootage: Double,
                               senior: Boolean
):
    Customer(customerName,customerPhone,customerAddress,squareFootage){
    var rate: Double = 6.0
    var senior = false

    init {
        this.customerName = customerName
        this.customerPhone = customerPhone
        this.customerAddress = customerAddress
        this.squareFootage = squareFootage
        this.rate = rate
        this.senior = senior
    }
    fun weeklycharge() {
        val formatter = DecimalFormat("\u00A4###,###,###.00")
        var seniorText = ""
        var finalOut = this.squareFootage * this.rate / 1000
        var rateOut = formatter.format(this.rate)

        if (this.senior) {
            finalOut *= 0.85
            seniorText = "(Senior discount of 15% applied.)"
        }
        var finalOutStr = formatter.format(finalOut)
        println("$customerName has a phone number of $customerPhone. \nThe address is $customerAddress." +
                "\nThe square footage is $squareFootage. At $rateOut per 1000 square feet, the weekly charge would be $finalOutStr \n" + seniorText)
    }
}