public class Road implements Comparable<Road> {
    private Town source, destination;
    private int weight;
    private String name;

    public Road(Town source, Town destination, int degrees, String name) {
        this.source = source;
        this.destination = destination;
        this.weight = degrees;
        this.name = name;
    }

    public Road(Town source, Town destination, String name) {
        this(source, destination, 1, name);
    }

    public boolean contains(Town town) {
        return source.equals(town) || destination.equals(town);
    }

    public Town getSource() {
        return source;
    }

    public Town getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + ", " + weight + ";" + source + ";" + destination;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Road)) {
        	return false;
        }
        Road other = (Road) obj;
        return (source.equals(other.source) && destination.equals(other.destination) ||
                source.equals(other.destination) && destination.equals(other.source));
    }

    @Override
    public int compareTo(Road o) {
        return this.name.compareTo(o.name);
    }
} 