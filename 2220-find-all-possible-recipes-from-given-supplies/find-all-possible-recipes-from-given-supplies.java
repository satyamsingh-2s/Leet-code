import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> available = new HashSet<>(Arrays.asList(supplies)); // What we already have
        Map<String, List<String>> needs = new HashMap<>(); // Recipe → Required Ingredients

        for (int i = 0; i < recipes.length; i++) {
            needs.put(recipes[i], ingredients.get(i));
        }

        boolean updated = true;
        while (updated) { // Keep going until we can't make anything new
            updated = false;
            for (String r : recipes) {
                if (available.contains(r)) continue; // Already made
                
                boolean canMake = true;
                for (String ing : needs.get(r)) {
                    if (!available.contains(ing)) {
                        canMake = false;
                        break;
                    }
                }
                
                if (canMake) {
                    available.add(r);
                    updated = true;
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (String r : recipes) {
            if (available.contains(r)) res.add(r);
        }
        return res;
    }
}