package com.example.myapplication

class MyClass {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val a = 7   // ------->> integer
            var b = "jenish"    // ------->> string
            b = "ghevariya"
            println("Hello World! $a")
            println("Hello World! $b")

            val x = 10
            val y = 15
            val z = 2
            val sum = add(x, y, z)
            val mal = add(x, y)
            println(sum)
            println(mal)
            println("The sum is ${add(5, 10, 15)}") // -->> call the add methods
            println("The mul is ${add(5, 10)}") // -->> call the add methods

            val name = "jenish"
            val roll_no = 7
            val grade = 'A'
            student(name, roll_no, grade)
            student("sahil", 17, 'B')

            // array
            var sums = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).sum()
            println("${sums}")

            var num1 = 25
            var num2 = 20

            var result = num1.rem(num2)
            println("${result}")

            greet("Jenish")
            greet()

            printName("jenish", "ghevariya")

            val name_of_student = "Gaurav"
            val standard_of_student = "VIII"
            val roll_no_of_student = 25
            student(name= name_of_student, roll_no = roll_no_of_student)

            println("Factorial of 5 is :" + Fact(5))

            val array = arrayOf(1,2,3,4,5,6,7,8,9,10)
            val n = array.size
            val results = sum(array,n)
            println("The sum of array elements is : $results")

            val r = find(113)
            println(r)

            // conditional statements
//            print("Enter a number :")
//            val num = readLine()?.toIntOrNull()?:return println("Invalid input")
//            val num = 17
//            var msg = ""
//             msg = if (num>100) "No. is Greater !" else "No. is Smaller!"
//            println(msg)

//            if (num < 100)
//                println("No. is Greater!")
//            else if (num > 100)
//                println("No. is Smaller!")
//            else if (num == 100)
//                println("equals values...")
//            else {
//                println("wrong....")
//            }

//            val A = 1000
//            val B = 999
//            val C = 1199
//            var max1 = if (A > B) A else B
//            var max2 = if (C > A) C else A
//            println("The Maximum Of ${A} and ${B} is $max1")
//            println("The Maximum Of ${C} and ${A} is $max2")
//            println()
        }

        // use the method
        fun add(a: Int, b: Int): Int {
            val c = a.times(b) // ------->> times means multiplication
            return c
        }

        // use the method overloading
        fun add(a: Int, b: Int, c: Int): Any {
            return a + b + c
        }

        fun student(name: String, roll_no: Int, grade: Char) {
            println("Name of student is : $name")
            println("Roll No of student is : $roll_no")
            println("Grade of the student is : $grade")
        }

        fun greet(name: String = "ghevariya") {
            println("hello I am $name")
        }

        fun printName(firstName: String, lastName: String) {
            println("Firts name : $firstName, Last Name : $lastName")
        }

        fun student(name: String = "Ram", standard: String = "IX", roll_no: Int = 11) {
            println("Name of the student is: $name")
            println("Standard of the student is: $standard")
            println("Roll no of the student is: $roll_no")
        }

        fun Fact(num: Int) : Long{
            return if (num == 1)num.toLong()
                else num * Fact(num - 1)
//            return num * Fact(num - 1)

        }

        fun sum(args: Array<Int>, index: Int): Int{

            return if (index <= 0) 0
            else(sum(args,index - 1)+ args[index -1])
        }

        fun Facts(num: Int, x: Int) : Long{
            return if (num == 1)
                x.toLong()
            else
                Facts(num -1,x* num)
                num * Fact(num - 1)
//            return num * Fact(num - 1)

        }

        val find = fun(num: Int): String{
            if (num % 2 == 0 && num < 0 ){
                return "Number is even and negative"
            } else if (num % 2 == 0 && num > 0){
                return "Number is even and positive"
            }
            else if (num % 2 != 0 && num < 0){
                return "Number is odd and negative"
            }else{
                return "Number is odd and positive"
            }
        }
    }
}
