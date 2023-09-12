@SuppressWarnings("serial")

public class NoSpecialCharacterException extends Exception {

/*Default constructor */

public NoSpecialCharacterException()

{

}

/*Parameterized constructor with parameter type string */

public NoSpecialCharacterException(String message)

{

super(message);

}

}