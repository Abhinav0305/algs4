package util;
import java.util.*;
public class Expressions
{

  private static final String DELIMITERS = " ()+-/*";

  public static ArrayList<String> tokenize(String s)
  {
    StringTokenizer tokenizer = new StringTokenizer(s, DELIMITERS, true);
    ArrayList<String> tokenList = new ArrayList<String>();

    String token = "";
    while (tokenizer.hasMoreTokens()) {
      if (!(token = tokenizer.nextToken()).equals(" "))
        tokenList.add(token);
    }
    return tokenList;
  }
  public static Stack<String> reverseInput(String s)
  {
    StringTokenizer tokenizer = new StringTokenizer(s, DELIMITERS, true);
    Stack<String> input = new Stack<String>();

    String token = "";
    while (tokenizer.hasMoreTokens()) {
      if (!(token = tokenizer.nextToken()).equals(" "))
        input.push(token);
    }

    return input;
  }
  public static boolean hasPrecedence(String left, String right)
  {
    if (left.equals(")"))
      throw new IllegalArgumentException(String.format("Undefined comparison: left '%s', right '%s'\n", left, right));
    // beginning of sub-expression
    if (left.equals("("))
      return false;
    // both operators are the same
    if (left.equals(right))
      return true;
    // arithmetic operator precedence
    if ((left.equals("*") || left.equals("/")) && (right.equals("+") || right.equals("-")))
      return true;
    // end of sub-expression, which has precedence over anything that will follow
    if (!left.equals("(") && right.equals(")"))
      return true;

    // False cases:
    //     right == (
    //     left == + or - && right == * or /
    return false;
  }
  public static boolean isParen(String s)
  {
    if (s.equals("(") || s.equals(")"))
      return true;
    return false;
  }
  public static boolean isOperator(String s)
  {
    if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
      return true;
    return false;
  }
}
