package _08_GreedyAlgs;

import java.util.*;

public class RadioStations {
    private static HashSet<String> states_needed = new HashSet<String>() {{ add("wa"); add("mt"); add("id"); add("ut"); add("nv"); add("or"); add("ca"); add("az");}};
    private static HashSet<String> finalStations = new HashSet<>();
    private static LinkedHashMap<String, HashSet<String>> stations = new LinkedHashMap<>();
    static {
        stations.put("kone", new HashSet<String>() {{ add("id"); add("nv"); add("ut"); }});
        stations.put("ktwo", new HashSet<String>() {{ add("wa"); add("id"); add("mt"); }});
        stations.put("kthree", new HashSet<String>() {{ add("or"); add("nv"); add("ca"); }});
        stations.put("kfour", new HashSet<String>() {{ add("nv"); add("ut"); }});
        stations.put("kfive", new HashSet<String>() {{ add("ca"); add("az"); }});
    }

    public static void main(String[] args) {
        while (!states_needed.isEmpty()) {
            String bestStation = null;
            HashSet<String> states_covered = new HashSet<String>();
            for (Map.Entry<String, HashSet<String>> pair : stations.entrySet()) {
                HashSet<String> covered = new HashSet<String>(states_needed);
                covered.retainAll(pair.getValue());
                if (covered.size() > states_covered.size()) {
                    bestStation = pair.getKey();
                    states_covered = covered;
                }
                states_needed.removeIf(states_covered::contains);
                if (bestStation != null) {
                    finalStations.add(bestStation);
                }
            }
        }
        for (String s : finalStations) {
            System.out.print(s + " ");
        }
    }
}
