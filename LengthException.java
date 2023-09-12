@SuppressWarnings("serial")

public class LengthException extends Exception

{

/*Default constructor */

public LengthException()

{

}

/*Parameterized constructor with parameter type is string*/

public LengthException(String sentence)

{

super(sentence);

}

}