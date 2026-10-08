class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        int sumB = 0;

        for (int x : aliceSizes) {
            sumA += x;
        }

        for (int x : bobSizes) {
            sumB += x;
        }

        int diff = (sumA - sumB) / 2;

        for (int a : aliceSizes) {
            for (int b : bobSizes) {
                if (a - b == diff) {
                    return new int[]{a, b};
                }
            }
        }

        return new int[]{};
    }
}