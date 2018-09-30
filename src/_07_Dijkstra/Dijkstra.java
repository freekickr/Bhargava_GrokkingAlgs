package _07_Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    private static List<String> processed = new ArrayList<>();

    static {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);

        graph.put("fin", new HashMap<>());
    }

    private static String findLowestCostNode(Map<String, Double> costs) {
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;

        for (Map.Entry<String, Double> node : costs.entrySet()) {
            Double cost = node.getValue();
            if (cost < lowestCost && !processed.contains(node.getKey())) {
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }
        return lowestCostNode;
    }

    public static void main(String[] args) {
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        String node = findLowestCostNode(costs);
        Double cost = null;
        while (node != null) {
            cost = costs.get(node);
            Map<String, Double> neighbours = graph.get(node);
            for (String n : neighbours.keySet()) {
                double newCost = cost + neighbours.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs);
        }
        System.out.println("Costs from the start to each node:");
        System.out.println(costs);
    }
}
