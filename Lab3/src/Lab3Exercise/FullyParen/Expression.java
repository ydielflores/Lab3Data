package Lab3Exercise.FullyParen;

public class Expression {
	
	private String expression;

	public Expression(){
		this.expression="";
	}

	public void setExpression(String s){
		this.expression=s;
	}
	
	
	public boolean isValid(){

		String [] splt=this.expression.split("=|:");
		if(splt.length!=2){
			return false;
		}

		if(this.expression.charAt(1)==':' && !(splt[1].charAt(0)=='(' || splt[1].charAt(0)=='{' || splt[1].charAt(0)=='[')){
			return false;
		}

		ExpressionStack<Character> characterStack = new ExpressionStack<Character>();

		for (int i = 0; i<splt[1].length(); i++) {
			char c = splt[1].charAt(i);
			if(!(c=='(' || c=='{' || c=='[' || c==')' || c=='}' || c==']' || c=='+' || c=='-' || c=='*' || c=='/' || c=='^' || (c>='A' && c<='Z') || (c>='0' && c<='9') )){
				return false;
			}
			if (c == ')'){
				if(characterStack.isEmpty()==true) {
					return false;
				}

				while(characterStack.isEmpty()!=true){
					if(characterStack.top()=='(') {
						characterStack.pop();
						break;
					}
					characterStack.pop();
				}
			}
			if (c == '}'){
				if(characterStack.isEmpty()==true) {
					return false;
				}
				while(characterStack.isEmpty()!=true && characterStack.top()!='{' ){
					if(characterStack.top()=='{') {
						characterStack.pop();
						break;
					}
					characterStack.pop();
				}
			}
			if (c == ']'){
				if(characterStack.isEmpty()==true) {
					return false;
				}
				while(characterStack.isEmpty()!=true && characterStack.top()!='[' ){
					if(characterStack.top()=='[') {
						characterStack.pop();
						break;
					}
					characterStack.pop();
				}
			}

			if(c=='(' || c=='{' || c=='['){
				characterStack.push(c);
			}
		}


		if(characterStack.isEmpty()!=true) {
			return false;
		}
		return true;
	}

	

	public int prec(char c){
		if(c == '^')
			return 3;
		else if(c == '*' || c == '/')
			return 2;
		else if(c == '+' || c == '-')
			return 1;
		else
			return -1;
	}

	
	public String infixToPostfix(String expression) {
		String result = new String("");

		ExpressionStack<Character> characterStack = new ExpressionStack<Character>();

		for (int i = 0; i<expression.length(); i++){
			char c = expression.charAt(i);
			if (Character.isLetterOrDigit(c)){
				result += c;
			}
			else if (c == '(' || c == '{' || c == '['){
				characterStack.push(c);
			}

			else if (c == ')' || c == '}' || c == ']')
			{
				while (!characterStack.isEmpty() && !(characterStack.top() == '(' || characterStack.top() == '{' || characterStack.top() == '['))
					result += characterStack.pop();

				if (!characterStack.isEmpty() && !(characterStack.top() == '(' || characterStack.top() == '{' || characterStack.top() == '['))
					return "" ;
				else
					characterStack.pop();
			}
			else
			{
				while (!characterStack.isEmpty() && prec(c) <= prec(characterStack.top())){
					if(characterStack.top() == '(' || characterStack.top() == '{' || characterStack.top() == '[')
						return "" ;
					result += characterStack.pop();
				}
				characterStack.push(c);
			}
		}

		while (!characterStack.isEmpty()){
			if(characterStack.top() == '(' || characterStack.top() == '{' || characterStack.top() == '[')
				return "" ;
			result += characterStack.pop();
		}
		return result;
	}

	public int eval(int [] val){
		int result=-1;
		if(this.isValid()){

			if(this.expression.charAt(1)=='='){
				String [] epr=this.expression.split("=");
				val[(int)( epr[0].charAt(0)-'A')]=Integer.parseInt(epr[1]);
			}

			if(this.expression.charAt(1)==':'){
				String [] epr=this.expression.split(":");
				String exp=this.infixToPostfix(epr[1]);


				ExpressionStack<Integer> integerStack=  new ExpressionStack<Integer>();

				for(int i=0;i<exp.length();i++) {
					char c=exp.charAt(i);

					if(Character.isAlphabetic(c)) {
						int add=val[(int)( c-'A')];
						integerStack.push(add);
					}
					else
					{
						int val1 = integerStack.pop();
						int val2 = integerStack.pop();

						switch(c)
						{
						case '+':
							integerStack.push(val2+val1);
							break;

						case '-':
							integerStack.push(val2- val1);
							break;

						case '/':
							integerStack.push(val2/val1);
							break;

						case '*':
							integerStack.push(val2*val1);
							break;
						}
					}
				}
				val[(int)( epr[0].charAt(0)-'A')]=integerStack.pop();
			}
			result=0;
		}

		return result;
	}

}
