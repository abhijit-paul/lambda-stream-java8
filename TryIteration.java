import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class TryIteration {
    public static void display(Integer n) {
        System.out.println(n);
    }

    public void displayHello(Integer n) {
        System.out.println(n);
    }

    public static void appendToSum(String m, List<AtomicInteger> sums) {
        AtomicInteger index = new AtomicInteger(0);
        sums.forEach(s -> s.getAndAdd(
            Character.getNumericValue(
                m.charAt(index.getAndIncrement())
            )
        ));
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        //External Iterator
        System.out.println("\nExternal line:-");
        for(int n : nums) {
            System.out.println(n);
        }

        //Internal iterator
        System.out.println("\nInternal line:-");
        nums.forEach(new Consumer<Integer>() {
            public void accept(Integer n) {
                System.out.println(n);
            }
        });

        //Single line lambda
        System.out.println("\nSingle line:-");
        nums.forEach((Integer n) -> System.out.println(n));

        //Lambda with type inference
        System.out.println("\nLambda with type inference line:-");
        nums.forEach((n) -> System.out.println(n));

        //Lambda with single param does not need paren
        System.out.println("\nLambda with no parenthesis:-");
        nums.forEach(n -> System.out.println(n));

        //Lambda without explicitly use a variable when being used as passthrough
        System.out.println("\nLambda with pass-through:-");
        nums.forEach(System.out::println);

        System.out.println("\nLambda with custom function as pass-through:-");
        nums.forEach(TryIteration::display);

        System.out.println("\nLambda with custom method as pass-through:-");
        TryIteration tI = new TryIteration();
        nums.forEach(tI::displayHello);

        //Multi line is possible. But UGLY
        System.out.println("\nMulti line lambda is possible, BUT UGLY:-");
        nums.forEach((Integer n) -> {
            System.out.println(n);
        });

        List<String> menu = Arrays.asList("1234","5678", "9376");
        List<AtomicInteger> sums = new ArrayList<>();

        IntStream.range(0, 4).forEach(idx -> sums.add(new AtomicInteger(0)));
        menu.forEach(m -> appendToSum(m, sums));

        System.out.println("\nArray sums:-");
        sums.forEach(s -> System.out.println(s.get()));
    }
}