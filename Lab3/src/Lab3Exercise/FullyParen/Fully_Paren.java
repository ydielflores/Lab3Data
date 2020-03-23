package Lab3Exercise.FullyParen;

import java.util.ArrayList;
import java.util.Scanner;

public class Fully_Paren {

	@SuppressWarnings("resource")
	public static void main(String[] args) {



		Scanner sc=new Scanner(System.in);
		ArrayList<String> lst =  new ArrayList<String>();


		int [] valueList = new int[26];

		for(int i=0;i<26;i++){
			valueList[i]=0;
		}

		Expression expression = new Expression();


		while(true){
			System.out.print("Enter expression values or press enter once to terminate : ");
			String s=sc.next();
			s=s.toUpperCase();

			if(s.equals("")){
				break;
			}

			expression.setExpression(s);
			int val = expression.eval(valueList);

			if(val==-1){
				lst.add(s);
			}
		}

		for(int i=0;i<lst.size();i++){
			System.out.println(lst.get(i)+" is invalid");
		}

		System.out.println("\n The final symbol table is : \n");

		for(int i=0;i<26;i++){
			if(valueList[i]!=0){
				System.out.println((char)('A'+i)+"\t"+valueList[i]);
			}
		}
	}

}


