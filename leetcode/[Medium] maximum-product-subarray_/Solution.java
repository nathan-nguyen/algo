class Solution {
    public int maxProduct(int[] a) {
        int maxNegative = 0, minPositive = 0, accumulatedProduct = 1;
        int result = a[0];
        for (int x: a) {
            result = Math.max(result, x);
            accumulatedProduct *= x;
            result = Math.max(result, accumulatedProduct);
            if (accumulatedProduct > 0) {
                if (minPositive == 0) minPositive = accumulatedProduct;
                else result = Math.max(result, accumulatedProduct / minPositive);
            }
            else if (accumulatedProduct < 0) {
                if (maxNegative == 0) maxNegative = accumulatedProduct;
                else result = Math.max(result, accumulatedProduct / maxNegative);
            }
            else {  // accumulatedProduct == 0
                maxNegative = minPositive = 0;
                accumulatedProduct = 1;
            }
            
        }
        return result;
    }
}
