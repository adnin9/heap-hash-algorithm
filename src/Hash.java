public class Hash {

    private static void findSub(int[] arr) {
        // hash table to store the last index of each element
        int[] lastUse = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lastUse[i] = -1;
        }

        int start = 0;
        int end = 0;
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            // current not visited or not part of subarray
            if (lastUse[current] == -1 || lastUse[current] < start) {
                currentLength++;
            } 
            else {
                // current is part of the current subarray
                start = lastUse[current] + 1;
                currentLength = i - start + 1;
            }

            lastUse[current] = i;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                end = i;
            }
        }

        System.out.print("Largest Subarray: ");
        for (int i = end - maxLength + 1; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 2, 2, 1, 4, 3, 1, 0};
        findSub(array);
    }
}
