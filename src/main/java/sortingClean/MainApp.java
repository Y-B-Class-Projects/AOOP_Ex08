package sortingClean;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.Produces;


public class MainApp {
    private static WeldContainer container;

    public static void main(String[] args) {
        container = new Weld().initialize();

        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();

        algorithmRunner.runAlgorithms();
    }

    @Produces
    public @QuadraticSortClass
    SortingAlgorithm<Integer> BubbleSortGenerator() {
        return container.select(BubbleSort.class).get();
    }

    @Produces
    public @nlognSortClass
    SortingAlgorithm<Integer> QuickSortGenerator() {
        return container.select(QuickSort.class).get();
    }

    @Produces
    public int getN() {
        return 100000;
    }
}
