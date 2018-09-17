package VI_BreadthFirstSearch;

import java.util.*;

public class QueueGraph {
    private static Map<String, String[]> graph = new HashMap<>();
    private static Queue<String> search_queue = new LinkedList<>();
    private static List<String> alreadySearched = new ArrayList<>();
    static {
        graph.put("you", new String[] {"alice", "bob", "claire"});
        graph.put("bob", new String[] {"anuj", "peggy"});
        graph.put("alice", new String[] {"peggy"});
        graph.put("claire", new String[] {"thom", "jonny"});
        graph.put("anuj", new String[] {});
        graph.put("peggy", new String[] {});
        graph.put("thom", new String[] {});
        graph.put("jonny", new String[] {});
    }

    public static void main(String[] args) {
        search_queue.addAll(Arrays.asList(graph.get("you")));
        String person = null;
        while (!search_queue.isEmpty()) {
            person = search_queue.poll();
            if (!isPersonInList(person)) {
                if (person.endsWith("m")) {
                    System.out.println(person + " is a mango seller!");
                    break;
                } else {
                    search_queue.addAll(Arrays.asList(graph.get(person)));
                    alreadySearched.add(person);
                }
            }
        }
    }

    private static boolean isPersonInList(String name) {
        for (String s : alreadySearched)
            if (name.equals(s)) {
                System.out.println(name + " - Repeat. Ignoring.");
                return true;
            }
        return false;
    }
}
