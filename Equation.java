public class Equation {
  public int op1;
  public int op2;
  public String operation; // *, /, +, -

  public boolean parse (String eq) {
    int ix = eq.indexOf ("/");
    if (ix < 0)
      ix = eq.indexOf ("*");
    if (ix < 0)
      ix = eq.indexOf ("+");
    if (ix < 0)
      ix = eq.indexOf ("-");
    if (ix < 0)
      return false;

    operation = eq.substring(ix, ix+1);
    String o1 = eq.substring(0, ix).trim();
    String o2 = eq.substring(ix+1).trim();

    try {
      op1 = Integer.parseInt(o1);
      op2 = Integer.parseInt(o2);
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  public String toString () {
    return op1 + operation + op2;
  }
}