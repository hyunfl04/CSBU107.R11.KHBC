public class Exercise2 {

    static class Fraction {
        private int numerator;
        private int denominator; 

        public Fraction() {
            this.numerator = 0;
            this.denominator = 1;
        }

        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                System.out.println("Denominator cannot be zero. Defaulting to 1.");
                this.denominator = 1;
            } else {
                this.denominator = denominator;
            }
            this.numerator = numerator;
            this.simplify();
        }

        public Fraction(Fraction other) {
            if (other != null) {
                this.numerator = other.numerator;
                this.denominator = other.denominator;
            } else {
                this.numerator = 0;
                this.denominator = 1;
            }
        }

        public int getNumerator() {
            return this.numerator;
        }

        public int getDenominator() {
            return this.denominator;
        }

        private int gcd(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        public void simplify() {
            if (denominator == 0) return;
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
            int commonFactor = gcd(numerator, denominator);
            if (commonFactor > 1) {
                numerator /= commonFactor;
                denominator /= commonFactor;
            }
        }

        public Fraction add(Fraction other) {
            int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
            int newDenominator = this.denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        public Fraction subtract(Fraction other) {
            int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
            int newDenominator = this.denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        public Fraction multiply(Fraction other) {
            int newNumerator = this.numerator * other.numerator;
            int newDenominator = this.denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        public Fraction divide(Fraction other) {
            if (other.numerator == 0) {
                throw new IllegalArgumentException("Cannot divide by zero fraction");
            }
            int newNumerator = this.numerator * other.denominator;
            int newDenominator = this.denominator * other.numerator;
            return new Fraction(newNumerator, newDenominator);
        }

       
        public void display() {
            if (denominator == 1) {
                System.out.println(numerator);
            } else {
                System.out.println(numerator + "/" + denominator);
            }
        }
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 4); // Tự động rút gọn thành 1/2
        Fraction f2 = new Fraction(3, 5);

        System.out.print("f1: ");
        f1.display();
        System.out.print("f2: ");
        f2.display();

        System.out.println("\n== Ket qua phep tinh ==");
        Fraction sum = f1.add(f2);
        System.out.print("f1 + f2 = ");
        sum.display();

        Fraction difference = f1.subtract(f2);
        System.out.print("f1 - f2 = ");
        difference.display();

        Fraction product = f1.multiply(f2);
        System.out.print("f1 * f2 = ");
        product.display();

        Fraction quotient = f1.divide(f2);
        System.out.print("f1 / f2 = ");
        quotient.display();

        System.out.println("\n== Kiem tra Copy Constructor & Distinct Object ==");
        Fraction f3 = new Fraction(f1);
        System.out.print("f3 (copy of f1): ");
        f3.display();

        
        boolean hasSameValue = (f1.getNumerator() == f3.getNumerator()) && (f1.getDenominator() == f3.getDenominator());
        System.out.println("f1 and f3 have the same values: " + hasSameValue);

        boolean isDistinctObject = (f1 != f3);
        System.out.println("f1 and f3 are distinct objects in memory (f1 != f3): " + isDistinctObject);
    }
}