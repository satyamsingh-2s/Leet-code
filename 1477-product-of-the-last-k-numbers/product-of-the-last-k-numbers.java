import java.util.*;

class ProductOfNumbers {
    private List<Long> values; 
    private long product; 

    public ProductOfNumbers() {
        values = new ArrayList<>();
        product = 1; 
    }

    public void add(int num) {
        if (num == 0) {
            values.clear();
            product = 1;
        } else {
            product *= num; // Multiply with previous product
            values.add(product); // Store updated prefix product
        }
    }

    // \U0001f7e2 Returns the product of the last k elements
    public int getProduct(int k) {
        if (k > values.size()) {
            return 0; // If there are fewer than k elements, return 0
        }
        long divisor = (k == values.size()) ? 1 : values.get(values.size() - k - 1);
        return (int) (values.get(values.size() - 1) / divisor); // Compute the product using division
    }
}