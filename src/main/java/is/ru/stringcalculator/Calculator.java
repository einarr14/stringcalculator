package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
        else if(text.contains("//"))
        {
            String delimiters = text.substring(text.indexOf("//") + 2, text.indexOf("\n"));
            String numbers = text.substring(text.lastIndexOf("\n") + 1);
            return sum(splitNumbers(numbers, delimiters));
        }
		if(text.contains(",") || text.contains("\n")){
            String delimiters = ",|\n";
			return sum(splitNumbers(text, delimiters));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimiters){
	    return numbers.split(delimiters);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}