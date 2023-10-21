package part1;

public class RightTriangleStarPattern {
    public static void main(String[] args) {
        int i, j, n = 6;

        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
