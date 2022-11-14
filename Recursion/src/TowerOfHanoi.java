public class TowerOfHanoi {
    void townerOfHanoi(int n, char from_rod, char to_rod, char helper_rod){
        if(n==1){
            System.out.println("Take disk 1 from "+ from_rod+" to " + to_rod);
            return;
        }
        townerOfHanoi(n-1, from_rod, helper_rod, to_rod);
        System.out.println("Take disk " + n + " from " + from_rod + " to " + to_rod);
        townerOfHanoi(n-1, helper_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        // T(n) = 2*T(n-1) + 1
        TowerOfHanoi ob = new TowerOfHanoi();
        ob.townerOfHanoi(4, 'A', 'C', 'B');
    }
}
