import model.Chromosome;

import java.util.*;

public class CustomGeneticAlgorithm {
    private Scanner scanner = new Scanner(System.in);
    private List<Chromosome> chromosomes = new ArrayList<Chromosome>();
    private TravellingSalesman travellingSalesman = new TravellingSalesman();

    public CustomGeneticAlgorithm() {
        travellingSalesman.setMatrix();
    }

    private void setPopulation() {
        System.out.println("Tamaño de la población");
        int population_size = scanner.nextInt();

        for(int i = 0; i < population_size; i++) {
            Chromosome chromosome = new Chromosome();
            chromosome.setGenotype(travellingSalesman.sart());
            chromosome.setAptitude(chromosome.getGenotype().stream().mapToDouble(w -> w).sum());

            chromosomes.add(chromosome);

            System.out.println("Población");
            for (Chromosome c : chromosomes)
                System.out.println(c.toString());
        }
    }

    private void selectChromosomes(List<Chromosome> chromosomes) {
        Chromosome c1 = Collections.min(chromosomes, Comparator.comparing(c -> c.getAptitude()));
        Chromosome c2 = Collections.min(chromosomes, Comparator.comparing(c -> c.getAptitude() != c1.getAptitude()));
    }
}
