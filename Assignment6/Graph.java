import java.util.*;
public class Graph implements GraphInterface<Town, Road> {
    private Set<Town> towns;
    private Set<Road> roads;
    private Map<Town, List<Road>> adjList;

    public Graph() {
        towns = new HashSet<>();
        roads = new HashSet<>();
        adjList = new HashMap<>();
    }

    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        for (Road r : roads) {
            if ((r.getSource().equals(sourceVertex) && r.getDestination().equals(destinationVertex)) ||
                (r.getSource().equals(destinationVertex) && r.getDestination().equals(sourceVertex))) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException, NullPointerException {
    	if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		if (!(containsVertex(sourceVertex) && containsVertex(destinationVertex))) {
			throw new IllegalArgumentException();
		}
        Road road = new Road(sourceVertex, destinationVertex, weight, description);
        roads.add(road);
        adjList.get(sourceVertex).add(road);
		adjList.get(destinationVertex).add(road);
        return road;
    }

    @Override
    public boolean addVertex(Town v) throws NullPointerException {
        if (v == null) {
        	throw new NullPointerException();
        }
        if (towns.contains(v)) {
        	return false;
        }
        towns.add(v);
        adjList.put(v, new LinkedList<>());
        return true;
    }

    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        return getEdge(sourceVertex, destinationVertex) != null;
    }

    @Override
    public boolean containsVertex(Town v) {
        return towns.contains(v);
    }

    @Override
    public Set<Road> edgeSet() {
        return roads;
    }

    @Override
    public Set<Town> vertexSet() {
        return towns;
    }

    @Override
    public Set<Road> edgesOf(Town vertex) throws IllegalArgumentException, NullPointerException {
    	if(vertex == null) {
			throw new NullPointerException();
		}
        if (!adjList.containsKey(vertex)) {
        	throw new IllegalArgumentException();
        }
        return new HashSet<>(adjList.get(vertex));
    }

    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        Road target = getEdge(sourceVertex, destinationVertex);
        if (target != null && target.getWeight() == weight && target.getName().equals(description)) {
            roads.remove(target);
            adjList.get(sourceVertex).remove(target);
            adjList.get(destinationVertex).remove(target);
            return target;
        }
        return null;
    }

    @Override
    public boolean removeVertex(Town v) {
        if (!towns.contains(v)) {
        	return false;
        }
        towns.remove(v);
        for (Road r : new HashSet<>(adjList.get(v))) {
            removeEdge(r.getSource(), r.getDestination(), r.getWeight(), r.getName());
        }
        adjList.remove(v);
        return true;
    }

    private Map<Town, Integer> distances;
    private Map<Town, Town> previous;

    @Override
    public void dijkstraShortestPath(Town source) {
        distances = new HashMap<>();
        previous = new HashMap<>();
        Set<Town> visited = new HashSet<>();
        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        for (Town t : towns) {
            distances.put(t, Integer.MAX_VALUE);
            previous.put(t, null);
        }
        distances.put(source, 0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Town current = pq.poll();
            visited.add(current);

            for (Road r : adjList.get(current)) {
                Town neighbor = r.getDestination().equals(current) ? r.getSource() : r.getDestination();
                if (visited.contains(neighbor)) continue;

                int newDist = distances.get(current) + r.getWeight();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        dijkstraShortestPath(sourceVertex);
        ArrayList<String> path = new ArrayList<>();
        if (previous.get(destinationVertex) == null) {
        	return path;
        }

        Town current = destinationVertex;
        while (previous.get(current) != null) {
            Town prev = previous.get(current);
            Road r = getEdge(prev, current);
            path.add(0, prev + " via " + r.getName() + " to " + current + " " + r.getWeight()+" mi");
            current = prev;
        }
        return path;
    }
}