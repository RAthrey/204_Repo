import java.io.File;
import java.io.IOException;
import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface {
    private Graph graph = new Graph();

    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        Town t1 = new Town(town1);
        Town t2 = new Town(town2);
        graph.addVertex(t1);
        graph.addVertex(t2);	
        return graph.addEdge(t1, t2, weight, roadName) != null;
    }

    public String getRoad(String town1, String town2) {
        Road r = graph.getEdge(new Town(town1), new Town(town2));
        return r != null ? r.getName() : null;
    }

    public boolean addTown(String v) {
        return graph.addVertex(new Town(v));
    }

    public Town getTown(String name) {
        for (Town t : graph.vertexSet()) {
            if (t.getName().equals(name)) return t;
        }
        return null;
    }

    public boolean containsTown(String v) {
        return graph.containsVertex(new Town(v));
    }

    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
    }

    public ArrayList<String> allRoads() {
        ArrayList<String> roadList = new ArrayList<>();
        for (Road r : graph.edgeSet()) roadList.add(r.getName());
        Collections.sort(roadList);
        return roadList;
    }

    public boolean deleteRoadConnection(String town1, String town2, String road) {
        Road target = graph.getEdge(new Town(town1), new Town(town2));
        if (target != null && target.getName().equals(road)) {
            return graph.removeEdge(target.getSource(), target.getDestination(), target.getWeight(), target.getName()) != null;
        }
        return false;
    }


    public boolean deleteTown(String v) {
        return graph.removeVertex(new Town(v));
    }

    public ArrayList<String> allTowns() {
        ArrayList<String> townList = new ArrayList<>();
        for (Town t : graph.vertexSet()) townList.add(t.getName());
        Collections.sort(townList);
        return townList;
    }

    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
    }
    public void populateTownGraph(File file) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                String[] roadInfo = parts[0].split(",");
                String roadName = roadInfo[0];
                int weight = Integer.parseInt(roadInfo[1]);
                String town1 = parts[1].trim();
                String town2 = parts[2].trim();
                if (!containsTown(town1)) {
                	addTown(town1);
                }
                if (!containsTown(town2)) {
                	addTown(town2);
                }

                addRoad(town1, town2, weight, roadName);
            }
        }
    }


}