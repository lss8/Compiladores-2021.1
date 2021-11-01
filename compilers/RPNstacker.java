import java.util.*;
import java.io.*;

public class RPNstacker { 
    public static void main(String[] args) throws FileNotFoundException {     
        File RPN = new File("/home/lucas/Documents/compilers/Calc1.stk");
        Scanner in = new Scanner(RPN); 
        Stack<Integer> pile = new Stack<Integer>();
        int result=0;
        
        while (in.hasNext()) {
                String line = in.nextLine();
        
                if (isNumeric(line)) {
                    int num = Integer.parseInt(line) ;
                    pile.push(num);
                }
                else {
                    int num2 = pile.pop();
                    int num1 = pile.pop();
                    if (line.equals("+")) {
                        result = num1+num2;
                    }
                    if (line.equals("-")) {
                        result = num1-num2;
                    }
                    if (line.equals("*")) {
                        result = num1*num2;
                    }
                    if (line.equals("/")) {
                        result = num1/num2;
                    }
                    pile.push(result);
                }
        }
        System.out.println(pile.pop());
    } 

    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }

}