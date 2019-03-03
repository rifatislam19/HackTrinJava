/**
Introduction to Java demo for HackTrin VI, by Cleo de Rocco and Rifat Islam
 */
import java.awt.Graphics;


public class ComplexNumber {

private double a;
private double b;

/**
* Creates a new ComplexNumber with both real and imaginary components
* @param a the real component of the complex number
* @param b the imaginary component of the complex number
*/
public ComplexNumber(double a, double b){
this.a = a;
this.b = b;
}

/**
* The "copy constructor",
* Creates a new ComplexNumber from an existing ComplexNumber
* @param c a ComplexNumber
*/
public ComplexNumber(ComplexNumber c){
a = c.getReal();
b = c.getImaginary();
}

/**
* The "default constructor",
* Creates a ComplexNumber with the real and scalar being equal to 0
*/
public ComplexNumber(){
this.a = 0;
this.b = 0;
}

/**
* An "accessor" method,
* Returns the real component of this ComplexNumber
* @return a the private real component of this ComplexNumber
*/
public double getReal(){
return a;
}

/**
* An "accessor" method,
* Returns the imaginary component of this ComplexNumber
* @return b the private imaginary component of this ComplexNumber
*/
public double getImaginary(){
return b;
}

/**
* An "conjugate" method,
* private method
* Returns the conjugate of a ComplexNumber
*/
private ComplexNumber conjugate() {
return new ComplexNumber(this.a,this.b*-1);
}

/**
* An "add" method,
* Instance method,
* Returns the addition of two ComplexNumbers
*/
public ComplexNumber add(ComplexNumber c2) {
return new ComplexNumber(this.a + c2.getReal(),this.b + c2.getImaginary());
}

/**
* An "add" method,
* Static method,
* Returns the addition of two ComplexNumbers
*/
public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
double aNew = c1.getReal() + c2.getReal();
double bNew = c1.getImaginary() + c2.getImaginary();
return new ComplexNumber(aNew,bNew);
}

/**
* An "subtract" method,
* Instance method,
* Returns the subtraction of two ComplexNumbers
*/
public ComplexNumber subtract(ComplexNumber c2) {
double aNew = this.a - c2.getReal();
double bNew = this.b - c2.getImaginary();
return new ComplexNumber(aNew,bNew);
}

/**
* An "subtract" method,
* Static method,
* Returns the subtraction of two ComplexNumbers
*/
public static ComplexNumber subtract(ComplexNumber c1, ComplexNumber c2) {
double aNew = c1.getReal() - c2.getReal();
double bNew = c1.getImaginary() - c2.getImaginary();
return new ComplexNumber(aNew,bNew);
}


/**
* An "multiply" method,
* Instance method,
* Returns the multiplication of two ComplexNumbers
*/
public ComplexNumber multiply(ComplexNumber c2) {
double a2 = c2.getReal();
double b2 = c2.getImaginary();
double aNew = (this.a*a2) + (-1*this.b * b2);
double bNew = (this.a*b2 + a2*this.b);
return new ComplexNumber(aNew,bNew);
}

/**
* An "multiply" method,
* Static method,
* Returns the multiplication of two ComplexNumbers
*/
public static ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2) {
double a1 = c1.getReal();
double b1 = c1.getImaginary();
double a2 = c2.getReal();
double b2 = c2.getImaginary();
double aNew = (a1*a2) + (-1*b1*b2);
double bNew = (a1*b2 + a2*b1);
return new ComplexNumber(aNew,bNew);
}


/**
* A "square" method,
* Instance method,
* Returns the square of a ComplexNumber
*/
public ComplexNumber square() {
return new ComplexNumber((square(this.a))+(-1*square(this.b)),2*this.a*this.b);
}

/**
* A "square" method,
* Static method,
* Returns the square of a ComplexNumber
*/
public static ComplexNumber square(ComplexNumber c) {
return new ComplexNumber((square(c.getReal()))+(-1*square(c.getImaginary())),2*c.getReal()*c.getImaginary());
}

/**
* A "square" method for a double,
* static method,
* Returns the square of a double
*/
public static double square(double value) {
return value*value;
}

/**
* A "divide" method,
* Instance method,
* Returns the divison of two ComplexNumbers
*/
public ComplexNumber divide(ComplexNumber c2) {
ComplexNumber numerator = this.multiply(c2.conjugate());
double denominator = square(c2.getReal()) + square(c2.getImaginary());
if(denominator == 0) {
throw new IllegalArgumentException("Argument 'divsor' is 0");
}
return new ComplexNumber(numerator.getReal()/denominator,numerator.getImaginary()/denominator);
}

/**
* A "divide" method,
* Static method,
* Returns the divison of two ComplexNumbers
*/
public static ComplexNumber divide(ComplexNumber c1, ComplexNumber c2) {
  ComplexNumber numerator = c1.multiply(c2.conjugate());
  double denominator = square(c2.getReal()) + square(c2.getImaginary());
  if(denominator == 0) {
  throw new IllegalArgumentException("Argument 'divsor' is 0");
  }
  return new ComplexNumber(numerator.getReal()/denominator,numerator.getImaginary()/denominator);

}


/**
* A "toString" method,
* Returns the ComplexNumber in string form
* @return string, the string form of the ComplexNumber
*/
public String toString(){
String sign1,sign2,a,b;

if(this.a == 0 && this.b ==0)
{
  sign1 = "0";
  return sign1;
}
if (this.b < 0)
{
sign2 = "-";
}
else{
sign2 = "+";
}
if(this.a < 0)
{
  sign1 = "-";
}
else{
  sign1 = "";
}
if(Math.abs(this.a) == 0)
{
  a = "";
  sign1 = "";
}
else {
  a = ("" + Math.abs(this.a));
}
if(Math.abs(this.b) == 0)
{
  b = "";
  sign2 = "";
}
else if (Math.abs(this.b) == 1) {
  b = "i";
}
else {
  b = ("" + Math.abs(this.b) + "i");
}
sign1 = sign1 + a + sign2 + b;
return sign1;
}

/**
* A "magnitude" method,
* Returns the complex number's distance from the origin
* @return double, the distance
*/
public double magnitude(){
return Math.sqrt(square(this.a) + square(this.b));
}

/**
* A "compareTo" method,
* Compares the magnitudes of two complexNumbers
* Returns negative int if the magnitude of this is less
* than the magnitude of the parameter, 0 if they are
* equal, and a pos int if the magnitude of this is
* greater than than the magnitude of the paramter.
* @return integer, the distance
*/
public int compareTo(ComplexNumber c){

  if(Math.abs(this.magnitude() - c.magnitude()) < .000001)
  {
    return 0;
  }
  else if(this.magnitude() - c.magnitude() < 0){
    return -1;
  }
  else
  {
    return 1;
  }
}

/**
* Checks if Strings are Equal
*/
public static void assertStringsAreEqual(String actual, String expected, String errorMessage){
    System.out.println("Checking... Expected:"+expected+" Actual:"+actual);
    assert expected.equals(actual): errorMessage;
    System.out.println("++++++++");
  }

  /**
  * Checks if Doubles are equal
  */
public static void assertDoublesAreEqual(double expected, double actual, String errorMessage){
     System.out.println("Checking... Expected:"+expected+" Actual:"+actual);
     assert (expected == actual): errorMessage;
     System.out.println("++++++++");
    }

    /**
    * Checks if ints are equal
    */
  public static void assertIntsAreEqual(int expected, int actual, String errorMessage){
       System.out.println("Checking... Expected:"+expected+" Actual:"+actual);
       assert (expected == actual): errorMessage;
       System.out.println("++++++++");
      }


/**
* A tester method
* @param args
*/
public static void main(String[] args) {


ComplexNumber basic = new ComplexNumber(2,3);
assertStringsAreEqual(basic.toString(), "2.0+3.0i", "subtract does not work");
ComplexNumber negIm = new ComplexNumber(1,-2);
assertStringsAreEqual(negIm.toString(), "1.0-2.0i", "subtract does not work");
ComplexNumber imOne = new ComplexNumber(-1,1);
assertStringsAreEqual(imOne.toString(), "-1.0+i", "subtract does not work");
ComplexNumber negImOne = new ComplexNumber(2,-1);
assertStringsAreEqual(negImOne.toString(), "2.0-i", "subtract does not work");
ComplexNumber zeroIm = new ComplexNumber(3,0);
assertStringsAreEqual(zeroIm.toString(), "3.0", "subtract does not work");
ComplexNumber zeroReal = new ComplexNumber(0,-2);
assertStringsAreEqual(zeroReal.toString(), "-2.0i", "subtract does not work");
ComplexNumber zeroZero = new ComplexNumber(0,0);
assertStringsAreEqual(zeroZero.toString(), "0", "subtract does not work");

//test that regular and a copy of regular are the same
ComplexNumber cRegular = new ComplexNumber(7, -19);
ComplexNumber cReg2 = new ComplexNumber(15, 54);
ComplexNumber cReg2neg = new ComplexNumber(-15, -54);
ComplexNumber cCopy = new ComplexNumber(cRegular);

//testing Copy equals regular
assertStringsAreEqual(cRegular.toString(), cCopy.toString(), "The complex Numbers are not equal");

ComplexNumber cDefault = new ComplexNumber();
//test that default is a = 0.0, b=0.0
assertStringsAreEqual(cDefault.toString(), "0", "The default complex Number is not 0");

//tests conjugate
assertStringsAreEqual(cDefault.conjugate().toString(), "0", "conjugate of 0 does not work");
assertStringsAreEqual(cReg2neg.conjugate().toString(), "-15.0+54.0i", "conjugate of negReg does not work");
assertStringsAreEqual(cRegular.conjugate().toString(), "7.0+19.0i", "conjugate of 0 reg does not work");

//test adds
assertStringsAreEqual(cDefault.add(cRegular).toString(), "7.0-19.0i", "add does not work");
assertStringsAreEqual(cRegular.add(cReg2).toString(), "22.0+35.0i", "add does not work");
assertStringsAreEqual(cRegular.add(cReg2neg).toString(), "-8.0-73.0i", "add does not work");
assertStringsAreEqual(cReg2.add(cReg2neg).toString(), "0", "add does not work");

//test subtract
assertStringsAreEqual(cDefault.subtract(cRegular).toString(), "-7.0+19.0i", "subtract does not work");
assertStringsAreEqual(cRegular.subtract(cReg2).toString(), "-8.0-73.0i", "subtract does not work");
assertStringsAreEqual(cRegular.subtract(cReg2neg).toString(), "22.0+35.0i", "subtract does not work");
assertStringsAreEqual(cRegular.subtract(cRegular).toString(), "0", "subtract does not work");

//test multiply
assertStringsAreEqual(cDefault.multiply(cRegular).toString(), "0", "multiply does not work");
assertStringsAreEqual(cRegular.multiply(cReg2).toString(), "1131.0+93.0i", "multiply does not work");
assertStringsAreEqual(cRegular.multiply(cReg2neg).toString(), "-1131.0-93.0i", "multiply does not work");
assertStringsAreEqual(cReg2neg.multiply(cReg2neg).toString(), cReg2neg.square().toString(), "multiply does not work");
//-1131-93i

//test square + multiply
assertStringsAreEqual(cRegular.multiply(cRegular).toString(), cRegular.square().toString(), "multiply and sqaure do not work");
assertStringsAreEqual(cRegular.square().toString(), square(cRegular).toString(), "square static and sqaure instance do not work");

//test divide
assertStringsAreEqual(cRegular.divide(cRegular).toString(), "1.0", "divide does not work");
ComplexNumber c1 = new ComplexNumber(3, 3);
ComplexNumber c2 = new ComplexNumber(1,1);
ComplexNumber c1neg = new ComplexNumber(-3, -3);
assertStringsAreEqual(cRegular.divide(cRegular).toString(), divide(cRegular,cRegular).toString(), "divide does not work");
assertStringsAreEqual(c1.divide(c2).toString(), "3.0", "divide does not work");
assertStringsAreEqual(c1.divide(c2).toString(), divide(c1,c2).toString(), "divide does not work");
assertStringsAreEqual(c1.divide(c1neg).toString(), divide(c1,c1neg).toString(), "divide does not work");

//test magnitude
assertDoublesAreEqual(cRegular.magnitude(), cCopy.magnitude(), "magnitude does not work");
assertDoublesAreEqual(cRegular.magnitude(), Math.sqrt(410), "magnitude does not work");
assertDoublesAreEqual(cReg2neg.magnitude(), 3*Math.sqrt(349), "magnitude does not work");

//test CompareTo
assertIntsAreEqual(cRegular.compareTo(cCopy), 0, "CompareTo does not work");
assertIntsAreEqual(cRegular.compareTo(cReg2neg), -1, "CompareTo does not work");
assertIntsAreEqual(cReg2neg.compareTo(cRegular), 1, "CompareTo does not work");

}
}
