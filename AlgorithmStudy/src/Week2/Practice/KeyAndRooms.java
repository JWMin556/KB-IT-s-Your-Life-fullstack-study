package Week2.Practice;

import java.util.*;

public class KeyAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            for (int key : rooms.get(currentRoom)) {
                if (!visited.contains(key)) {
                    queue.add(key);
                    visited.add(key);
                }
            }
        }

        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add(List.of(1,3));
        rooms.add(List.of(3,0,1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        System.out.println(canVisitAllRooms(rooms));
    }
}
