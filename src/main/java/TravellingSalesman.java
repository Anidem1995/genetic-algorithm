import model.Node;
import model.Tuple;

import java.util.*;

public class TravellingSalesman {

    private List<Node> cities;
    private List<Integer> genotype = new ArrayList<Integer>();
    private Scanner scanner = new Scanner(System.in);
    int[][] matrix;

    public TravellingSalesman() {
        cities = new ArrayList<Node>();
    }

    public void setMatrix() {
        System.out.println("Número de ciudades");
        int number_of_cities = scanner.nextInt();
        generateMatrix(number_of_cities);
    }

    public List<Integer> sart() {
        return closestNeighbour(matrix);
    }

    private void generateMatrix(int number_of_cities) {
        matrix = new int[number_of_cities][number_of_cities];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ((int) (Math.random() * 90));
            }
        }
    }

    private List<Integer> closestNeighbour(int matrix[][]) {
        genotype.clear();
        int start_point = ((int) Math.random() * matrix.length);
        Node start_node = new Node(start_point);
        start_node.setVisited(true);
        start_node.setNeighbours(search_neighbours(start_node, matrix));
        cities.add(start_node);
        Tuple closest_neighbour_data = getClosestNeighbour(start_node);
        genotype.add(closest_neighbour_data.getWeight());
        Node next_node = new Node(closest_neighbour_data.getNode_number());

        while(!isAllCitiesVisited() && cities.size() < matrix.length && start_node.getNode_number() != next_node.getNode_number()) {
            next_node.setVisited(true);
            next_node.setNeighbours(search_neighbours(next_node, matrix));
            cities.add(next_node);
            closest_neighbour_data = getClosestNeighbour(next_node);
            genotype.add(closest_neighbour_data.getWeight());
            next_node = new Node(closest_neighbour_data.getNode_number());
        }
        return genotype;
    }

    private List<Tuple> search_neighbours(Node start_node, int matrix[][]) {
        List<Tuple> neighbours = new ArrayList<Tuple>();
        for(int i = 0; i < matrix[start_node.getNode_number()].length; i++) {
            if(matrix[start_node.getNode_number()][i] != 0 && !start_node.isVisited())
                neighbours.add(new Tuple(i, matrix[start_node.getNode_number()][i]));
        }
        return neighbours;
    }

    private Tuple getClosestNeighbour(Node node) {
        return Collections.min(node.getNeighbours(), Comparator.comparing(t -> t.getWeight()));
    }

    private boolean isAllCitiesVisited() {
        boolean all_visited = false;
        for(Node node : cities)
            all_visited = (node.isVisited() ? true : false);
        return all_visited;
    }
}
