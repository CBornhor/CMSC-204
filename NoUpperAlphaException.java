@SuppressWarnings("serial")

public class NoUpperAlphaException extends Exception {

/*Default Constructor */

public NoUpperAlphaException()

{

}

/*Parameterized constructor with type string */

public NoUpperAlphaException(String sentence)

{

super(sentence);

}

}