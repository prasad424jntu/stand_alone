class Calc {

	  public static double evaluate(String expr) {
			// TODO: Your code here
			if (expr == null || expr.equals(""))
				return 0;

			Stack<Double> stack = new Stack<>();

			double secondOperand = 0.0;
			double firstOperand = 0.0;

			for (String token : expr.split("\\s")) {

				switch (token) {
				case "+":
					secondOperand = stack.pop();
					firstOperand = stack.pop();
					stack.push(firstOperand + secondOperand);
					break;
				case "-":
					secondOperand = stack.pop();
					firstOperand = stack.pop();
					stack.push(firstOperand - secondOperand);
					break;
				case "*":
					secondOperand = stack.pop();
					firstOperand = stack.pop();
					stack.push(firstOperand * secondOperand);
					break;
				case "/":
					secondOperand = stack.pop();
					firstOperand = stack.pop();
					stack.push(firstOperand / secondOperand);
					break;
				default:
					stack.push(Double.parseDouble(token));
					break;
				}

			}

			return stack.pop();
		}

	}


class Challenge {
	  
	  public static String numberToOrdinal( Integer number ) {
			
			if (11 <= lastTwoDigits(number) && lastTwoDigits(number) <= 13) return  number+"th";
			if(number == 0) return "0";
			
			switch (lastDigit(number)) {
			case 1:
				return  number+"st";
		    case 2:
		    	return  number+"nd";
		    case 3:
		    	return  number+"rd";
		    default:
		    	return  number+"th";
			}
		  }

		public static int lastDigit(Integer number) {
			return number.intValue() % 10;
		}
		
		public static int lastTwoDigits(Integer number) {
			return number.intValue() % 100;
		}

}

class CreditCard {
    public static String maskify(String creditCardNumber) {
		
		if(creditCardNumber == null){
			return "";
		}else if(creditCardNumber == "" || creditCardNumber.length() < 6) {
			return creditCardNumber;
		}else{
			char[] charArr = creditCardNumber.toCharArray();
			StringBuilder maskedCardNumber = new StringBuilder();
			maskedCardNumber.append(charArr[0]);
			for(int i=1;i<creditCardNumber.length()-4;i++) {
				if(!Character.isDigit(charArr[i])) 
					maskedCardNumber.append(charArr[i]);
				else
					maskedCardNumber.append("#");
		}
          maskedCardNumber.append(creditCardNumber.substring(creditCardNumber.length()-4,
                                                             creditCardNumber.length()));
              return maskedCardNumber.toString();
		}
    }
}
