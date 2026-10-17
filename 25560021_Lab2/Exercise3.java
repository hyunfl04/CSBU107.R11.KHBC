public class Exercise3{
    static class Time{
        private int hour;
        private int minute;
        private int second;
        public Time(){
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
        }
        public Time(int hour, int minute, int second){
            this.hour = (hour >=0 && hour < 24) ? hour : 0;
            this.minute = (minute >=0 && minute < 60) ? minute : 0;
            this.second = (second >=0 && second < 60) ? second : 0;
        }
        public int getHour(){
            return hour;

        }
        public int getMinute(){
            return minute;
        }
        public int getSecond(){
            return second;
        }
        private int toTotalSeconds(){
            return hour * 3600 + minute * 60 + second;
        }
        private void setFromTotalSeconds(int totalSeconds){
            totalSeconds = totalSeconds % 86400; 
            this.hour = totalSeconds / 3600;
            this.minute = (totalSeconds % 3600) / 60;
            this.second = totalSeconds % 60;
        }
        public void addSeconds(int seconds) {
            int totalSeconds = toTotalSeconds() + seconds;
            setFromTotalSeconds(totalSeconds);
        }
        public void subtractSeconds(int seconds){
            int totalSeconds = toTotalSeconds() - seconds;
            setFromTotalSeconds(totalSeconds);
        }
        public void displayTime(){
            System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
        }
    }
    public static void main(String[] args){
        System.out.println("=== TEST CASE 1: 23:59:50 + 20 seconds ===");
        Time t1 = new Time(23, 59, 50);
        System.out.print("Thoi gian ban dau: ");
        t1.displayTime();
        t1.addSeconds(20);
        System.out.print("Sau khi cong 20 giay: ");
        t1.displayTime();  
        System.out.println("\n=== TEST CASE 2: 00:00:10 - 20 seconds ===");
        Time t2 = new Time(0, 0, 10);
        System.out.print("Thoi gian ban dau: ");
        t2.displayTime(); 
        t2.subtractSeconds(20);
        System.out.print("Sau khi tru 20 giay: ");
        t2.displayTime();
        System.out.println("\n=== TEST CASE 3: 12:30:15 + 3600 seconds ===");
        Time t3 = new Time(12, 30, 15);
        System.out.print("Thoi gian ban dau: ");
        t3.displayTime();
        t3.addSeconds(86400 +3600);    
        System.out.print("Sau khi cong 25 gio: ");
        t3.displayTime();

    }
}