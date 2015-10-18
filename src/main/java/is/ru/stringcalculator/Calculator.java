package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
        else if(text.contains("//"))
        {
            String delimiters = "";
            if(text.contains("//["))
            {
                int i = text.indexOf('[') + 1 ;
                while(text.charAt(i) != ']')
                {
                    delimiters += "\\";
                    delimiters += text.charAt(i);
                    i++;
                }
            }
            else
            {
                delimiters = text.substring(text.indexOf("//") + 2, text.indexOf("\n"));
            }
            String numbers = text.substring(text.lastIndexOf("\n") + 1);
            return sum(splitNumbers(numbers, delimiters));
        }
		else if(text.contains(",") || text.contains("\n")){
            String delimiters = ",|\n";
			return sum(splitNumbers(text, delimiters));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimiters){
	    return numbers.split(delimiters);
	}
      
    private static int sum(String[] numbers){
        int total = 0;
 	    String negativeNumbers = "";
        for(String number : numbers)
        {
        	if(toInt(number) < 0)
            {
        		negativeNumbers += number + ",";
        	}
            if(toInt(number) < 1001)
            {
                total += toInt(number);
            }
		}

		if(negativeNumbers.isEmpty())
        {
			return total;
		}
		
        String negNumbers = negativeNumbers.substring(0, negativeNumbers.length()-1);
			throw new RuntimeException("Negatives not allowed:"+ negNumbers);
    }



}