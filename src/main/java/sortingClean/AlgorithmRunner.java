package sortingClean;
import javax.inject.Inject;
import java.util.Random;

// TODO: Add dependency injection and annotations to this file
public class AlgorithmRunner {

    @Inject
    @QuadraticSortClass SortingAlgorithm<Integer> quadraticAlgorithm;
    @Inject
    @nlognSortClass SortingAlgorithm<Integer> nlognAlgorithm;
    @Inject
    int numberOfElements;

    public void runAlgorithms(){
        Random rand = new Random();
        Integer[] ints = rand.ints(1,Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
    }
}
