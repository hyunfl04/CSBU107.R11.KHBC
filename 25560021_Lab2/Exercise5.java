class Dice{
    private int value;
    public Dice(){
        this.value = 1;
    }
    public int roll(){
        this.value = (int)(Math.random()*6)+1;
        return this.value;
    }
    public static void main(String[] args){
        Dice dice = new Dice();
        int n = 10000;
        int [] counts = new int[7];
        for (int i = 0; i < n; i++){
            int value = dice.roll();
            counts[value]++;
        }
        System.out.println("Ket qua gieo xuc xac sau " + n + " lan:");
        for (int i = 1; i <=6; i++){
            double probability = (double)counts[i]/n;
           System.out.printf("Mặt %d: xuất hiện %d lần - Xác suất: %.2f%%\n", i, counts[i], probability * 100);
        }
    }
}