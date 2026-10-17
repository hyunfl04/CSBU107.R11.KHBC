public class Exercise4 {

    static class Circle {
        private double centerX;
        private double centerY;
        private double radius;

     
        public Circle() {
            this.centerX = 0.0;
            this.centerY = 0.0;
            this.radius = 1.0;
        }

        public Circle(double centerX, double centerY, double radius) {
            this.centerX = centerX;
            this.centerY = centerY;
            if (radius <= 0) {
                System.out.println("Radius must be positive. Defaulting to 1.0.");
                this.radius = 1.0;
            } else {
                this.radius = radius;
            }
        } 

      
        public double getCenterX() {
            return centerX;
        }

        public double getCenterY() {
            return centerY;
        }

        public double getRadius() {
            return radius;
        }

 
        public double area() {
            return Math.PI * radius * radius;
        }

        public double perimeter() {
            return 2 * Math.PI * radius;
        }

      
        public boolean contains(double x, double y) {
            double distanceSquared = Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2);
            return distanceSquared <= Math.pow(radius, 2);
        }
    }

    public static void main(String[] args) {

        Circle c1 = new Circle();
        System.out.println("C1 Area: " + c1.area());
        System.out.println("C1 Perimeter: " + c1.perimeter());

        Circle c2 = new Circle(2.0, 3.0, 5.0);
        System.out.println("\nC2 Area: " + c2.area());

        System.out.println("Contains (2, 3) [Center]: " + c2.contains(2.0, 3.0)); // true
        System.out.println("Contains (5, 7) [On circle]: " + c2.contains(5.0, 7.0)); // true
        System.out.println("Contains (10, 10) [Outside]: " + c2.contains(10.0, 10.0)); // false
    }
}