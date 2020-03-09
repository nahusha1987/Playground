public class Tester {
    int [][] array;
    int numOpenSites;

    public Tester(int n) {
        this.array = new int[n][n];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                //System.out.println("(" + i + "," + j + ")" + " = " + array[i][j]);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Number of open sites = " + numOpenSites);
    }

    public static void main(String[] args) {
        Tester tester = new Tester(5);
    }
}
