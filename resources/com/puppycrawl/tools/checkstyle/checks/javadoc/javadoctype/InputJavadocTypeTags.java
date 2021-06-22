////////////////////////////////////////////////////////////////////////////////
//Test case file for checkstyle.
//Created: 2001
////////////////////////////////////////////////////////////////////////////////
package com.puppycrawl.tools.checkstyle.checks.javadoc.javadoctype;
import java.io.IOException;

/* Config: default */

class InputJavadocTypeTags1 // ok
{

    private int mMissingJavadoc; // ok


    void method1() // ok
    {
    }

    /** @param unused asd **/
    void method2() // ok
    {
    }

    /** missing return **/
    int method3()
    {
        return 3;
    } // ok

    /**
     * <p>missing return
     * @param aOne ignored
     **/
    int method4(int aOne)
    {
        return aOne;
    } // ok

    /** missing throws **/
    void method5()           // ok
        throws Exception
    {
    }

    /**
     * @see missing throws
     * @see need to see tags to avoid shortcut logic
     **/
    void method6() // ok
        throws Exception
    {
    }

    /** @throws WrongException problem **/
    void method7()   // ok
        throws Exception, NullPointerException
    {
    }

    /** missing param **/
    void method8(int aOne) // ok
    {
    }

    /**
     * @see missing param
     * @see need to see tags to avoid shortcut logic
     **/
    void method9(int aOne)  // ok
    {
    }

    /** @param WrongParam problem **/
    void method10(int aOne, int aTwo)  // ok
    {
    }

    /**
     * @param Unneeded parameter
     * @return also unneeded
     **/
    void method11()   // ok
    {
    }

    /**
     * @return first one
     * @return duplicate
     **/
    int method12()
    {
        return 0;
    }  // ok

    /**
     * @param aOne
     * @param aTwo
     *
     *     This is a multiline piece of javadoc
     *     Unlike the previous one, it actually has content
     * @param aThree
     *
     *
     *     This also has content
     * @param aFour

     *
     * @param aFive
     **/
    void method13(int aOne, int aTwo, int aThree, int aFour, int aFive)  // ok
    {
    }

    /** @param aOne Perfectly legal **/
    void method14(int aOne)  // ok
    {
    }

    /** @throws java.io.IOException
     *               just to see if this is also legal **/
    void method14()
       throws java.io.IOException    // ok
    {
    }




    static
    {
        int x = 1; // should not require any javadoc
    }


    {
        int z = 2; // should not require any javadoc
    }

    /** handle where variable declaration over several lines **/
    private static final int
        ON_SECOND_LINE = 2;


    /**
     * Documenting different causes for the same exception
     * in separate tags is OK (bug 540384).
     *
     * @throws java.io.IOException if A happens
     * @throws java.io.IOException if B happens
     **/
    void method15()
       throws java.io.IOException
    {
    }

    /** {@inheritDoc} **/
    public String toString()
    {
        return super.toString();
    }

    /** getting code coverage up **/
    static final int serialVersionUID = 666;



    /**
     * handle the case of an elaborate header surrounding javadoc comments
     *
     * @param aOne valid parameter content
     */

    void method16(int aOne) // ok
    {
    }


    /**
     * @throws ThreadDeath although bad practice, should be silently ignored
     * @throws ArrayStoreException another r/t subclass
     * @throws IllegalMonitorStateException should be told to remove from throws
     */
    void method17()
        throws IllegalMonitorStateException
    {
    }

    /**
     * declaring the imported version of an Exception and documenting
     * the full class name is OK (bug 658805).
     * @throws java.io.IOException if bad things happen.
     */
    void method18()
        throws IOException
    {
        throw new IOException("to make compiler happy");
    }

    /**
     * reverse of bug 658805.
     * @throws IOException if bad things happen.
     */
    void method19()
        throws java.io.IOException
    {
        throw new IOException("to make compiler happy");
    }

    /**
     * Bug 579190, "expected return tag when one is there".
     *
     * Linebreaks after return tag should be legal.
     *
     * @return
     *   the bug that states that linebreak should be legal
     */
    int method20()
    {
        return 579190;
    }

    /**
     * Bug XXXX, "two tags for the same exception"
     *
     * @exception java.io.IOException for some reasons
     * @exception IOException for another reason
     */
    void method21()
       throws IOException
    {
    }

    /**
     * RFE 540383, "Unused throws tag for exception subclass"
     *
     * @exception IOException for some reasons
     * @exception java.io.FileNotFoundException for another reasons
     */
    void method22()
       throws IOException
    {
    }

    /**
     * @exception WrongException exception w/o class info but matched by name
     */
    void method23() throws WrongException
    {
    }

    /**
     * Bug 803577, "allowThrowsTagsForSubclasses/allowMissingThrowsTag interfere"
     *
     * no exception tag for IOException, but here is a tag for its subclass.
     * @exception java.io.FileNotFoundException for another reasons
     */
    void method24() throws IOException
    {
    }

    /**
     * Bug 841942, "ArrayIndexOutOfBounds in JavadocStyle".
     * @param aParam there is no such param in the method.
     * The problem should be reported with correct line number.
     */

    void method25()  // ok
    {
    }

    /** {@inheritDoc} */
    int method26()   // ok
    { return 0;
    }

    /**
     * {@inheritDoc}
     * @return something very important.
     */
    int method27(int aParam)  // ok
    { return 0;
    }

    /**
     * @return something very important.
     * {@inheritDoc}
     */
    int method28(int aParam)
    { return 0;
    }

    /**
     * {@inheritDoc}
     *
     * @return 1
     */
    public int foo(Object _arg) {

        return 1;
    }
}

enum InputJavadocTypeTagsEnum
{
    CONSTANT_A,

    /**
     *
     */
    CONSTANT_B,

    CONSTANT_C
    {
        /**
         *
         */
        public void someMethod()
        {
        }

        public void someOtherMethod()
        {

        }
    }
}

@interface InputJavadocTypeTagsAnnotation
{
    String someField();
    int A_CONSTANT = 0;
    /** Some javadoc. */
    int B_CONSTANT = 1;
    /** @return This tag is valid here and expected with Java 8 */
    String someField2();
}

/**
 * Some javadoc.
 */
public class InputJavadocTypeTags {

    /**
     * Constructor.
     */
    public InputJavadocTypeTags() {
    }

   /**
    * Sample method.
    * @param arg1   first argument
    * @param arg2   second argument
    * @return java.lang.String      the result string
    * @throws java.lang.Exception   in case of problem
    */
    public final String myMethod(final String arg1,
                                 final Object arg2)
      throws Exception
    {
        return null;
    }
}

/**
 *  Added to make this file compilable.
 */
class WrongException extends RuntimeException
{
}
