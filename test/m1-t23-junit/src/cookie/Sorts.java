package cookie;

public class Sorts {

    public void bubble(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sorts srts = new Sorts();
        int[] arr = {9, 8, 7, 6, 4, 2, 4, 1};
        int[] arr2 = {};
        srts.bubble(arr);
        srts.bubble(arr2);

        for (int a: arr) {
            System.out.print(a + " ");
        }
        for (int a: arr2) {
            System.out.print(a + " ");
        }

    }
}
