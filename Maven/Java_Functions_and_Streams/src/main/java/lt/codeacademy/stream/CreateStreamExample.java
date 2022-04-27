package lt.codeacademy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class TestClass{
    private final String name;
    private static int count = 0;

    public TestClass(String name) {
        this.name = name;
        count++;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                "count" + count +
                '}';
    }
}
public class CreateStreamExample {
    public static void main(String[] args) {
        // 1. Stream iš kolekcijos
        List<Integer> numbers = List.of(5,8,7,4,5,41);
        Stream<Integer> stream = numbers.stream();
        stream.forEach(System.out::println);

        // 2. Stream.of(...)
        Stream<String> names = Stream.of("Jonas", "Petras", "Antanas");
        names.forEach(System.out::println);

        // 3. Stream.generate()
        Stream<TestClass> testClassStream = Stream.generate(() -> new TestClass("Testing")).limit(5);
        testClassStream.forEach(System.out::println);

        // 4. Arrays.stream (iš masyvo)
        int[] items = {5, 4, 8, 6};
        IntStream itemStream = Arrays.stream(items);
        itemStream.forEach(System.out::println);

        // 5. Random.inits stream
       IntStream randomStream = new Random().ints(10, 50).limit(10);
       randomStream.forEach(System.out::println);
    }
}
