public class Exercise1 {
    static class Rectangle {
        private double width;
        private double height;

        public Rectangle() {
            this(1, 1);
        }

        public Rectangle(double width, double height) {
            this.width = width > 0 ? width : 1;
            this.height = height > 0 ? height : 1;
        }

        public double area() {
            return width * height;
        }

        public double perimeter() {
            return 2 * (width + height);
        }

        public void displayInfo() {
            System.out.println("Width: " + width + ", Height: " + height
                    + ", Area: " + area() + ", Perimeter: " + perimeter());
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(5, 10);
        Rectangle rectangle3 = new Rectangle(-2, 4);

        Rectangle[] rectangles = {rectangle1, rectangle2, rectangle3};
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Rectangle " + (i + 1) + ":");
            Rectangle rectangle = rectangles[i];
            rectangle.displayInfo();
            System.out.println();
        }
    }
}
