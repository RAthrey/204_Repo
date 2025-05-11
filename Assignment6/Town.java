public class Town implements Comparable<Town> {
    private String name;

    public Town(String name) {
        this.name = name;
    }

    public Town(Town templateTown) {
        this.name = templateTown.name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
    	if(!(obj instanceof Town)) {
			return false;
		}
		Town newObj = (Town) obj;
		return this.name.equals(newObj.name);
    }

    @Override
    public int compareTo(Town o) {
        return this.name.compareTo(o.name);
    }
} 
