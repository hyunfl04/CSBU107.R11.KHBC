class Calculator {
    public int add (int a, int b){
        return a + b;
    }
    public double add (double a, double b){
        return a + b;
    }
    public int add (int a, int b, int c){
        return a + b + c;
    }
   public int max(int a , int b){
    return (a > b) ? a : b;
   }
   public double max(double a , double b){
    return (a > b) ? a : b;
   }
   public static void main(String[] args){
    Calculator calc = new Calculator();
    System.out.println("add(10,20) = " + calc.add(10,20));
    System.out.println("add(5.5, 2.3) = " + calc.add(5.5, 2.3));
    System.out.println("add(1,2,3) = " + calc.add(1,2,3));
    System.out.println("max(15, 8) = " + calc.max(15, 8));
    System.out.println("max(4.2, 9.1) = " + calc.max(4.2, 9.1));
   }
}