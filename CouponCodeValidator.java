import java.util.*;

class Solution {

    public List<String> getValidCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Map<String, Integer> order = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
        );

        List<String[]> validCoupons = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isValid(code[i], businessLine[i], isActive[i], order)) {
                validCoupons.add(new String[]{code[i], businessLine[i]});
            }
        }

        validCoupons.sort((a, b) -> {
            int cmp = Integer.compare(order.get(a[1]), order.get(b[1]));
            return (cmp != 0) ? cmp : a[0].compareTo(b[0]);
        });

        List<String> result = new ArrayList<>();
        for (String[] coupon : validCoupons) {
            result.add(coupon[0]);
        }

        return result;
    }

    private boolean isValid(String code, String businessLine, boolean isActive, Map<String, Integer> order) {
        return isActive
            && order.containsKey(businessLine)
            && code != null
            && !code.isEmpty()
            && code.matches("[a-zA-Z0-9_]+");
    }
}
