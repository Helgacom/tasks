package stream;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethod {
    /*Чаще всего Вам предстоит создавать стрим из коллекций. Для это достаточно вызвать метод stream().
Например, List.of(1, 2, 3).stream(). Заметьте, что метода stream() в Map и его реализациях нет. Но есть
методы keySet, entrySet(), values() которые возвращают реализации Collection, поэтому после вызовов этих
методов можно вызвать метод stream()*/
    public static Stream<Integer> createStream(Collection<Integer> data) {
        return data.stream();
    }

    /*Иногда у нас есть последовательность и мы хотим создать стрим из этой последовательности. Для этого мы
    можем использовать метод Stream.of(T...)*/

    public static Stream<Character> createStream() {
        return Stream.of('a', 'b', 'c');
    }

    /*Массивы это часто используемая конструкция, поэтому важно знать как создать стрим из массива. Для создания
    стрима служит метод Arrays.stream()*/
    public static Stream<Integer> createStream(Integer[] data) {
        return Arrays.stream(data);
    }

    /*Бывает, что возникает ситуация, что нужно обойти массив, при этом зная индекс. Т.е. так как мы это делаем
    с обычным for. Arrays.stream() вернет нам стрим элементов массива, но что если нам нужен еще индекс?
    Есть метод Stream.iterate() который позволяет сгенерировать нам стрим, по заданным условиям. Его мы можем
    использовать для нашей задачи, мы генерируем стрим индексов, а потом их используем для обхода массива.
    Синтаксис такой: Stream.iterate(начальное значение счетчика, условие, увеличение счетчика), когда условие
    перестанет выполнятся перестанет генерироваться индекс. Пример:
    Stream.iterate(0, i -> i < 5, i -> i + 1) => сгенерируются 0, 1, 2, 3, 4
    Обратите внимание, что увеличение счетчика нельзя писать так i++, потому что i++ эквивалентно i += 1, а это
    предполагает изменение переменной внутри лямбда, что нельзя делать*/

    public static void showArray(Integer[] data) {
        Stream.iterate(0, i -> i < data.length, i -> i + 2)
                .forEach(i -> System.out.println(data[i]));
    }

    /*Иногда нужно создать стрим выборочно из нескольких элементов. Для этого бывает полезно использовать
    метод Stream.builder(), он возвращает объект для построения стрима. У этого объекта мы можем вызвать
    метод add() для добавления элемента в стрим и build() для окончательного построения стрима.
    Пример,
    Stream<Object> stream = Stream.builder().add(1).add(2).build()*/

    public static Stream<Object> createStreamWithBuilder(Integer[] data) {
        //создать стрим из первого и последнего элементов массива
        Stream<Object> stream1 = Stream.builder().add(data[0]).add(data[data.length - 1]).build();
        return stream1;
    }

    public static Integer collect(List<Integer> list) {
        // сюда сложим элементы
        Supplier<List<Integer>> supplier = LinkedList::new;
        // говорим, как добавлять элементы
        BiConsumer<List<Integer>, Integer> consumer = List::add;
        // не вдаемся в подробности. Просто нужно
        BinaryOperator<List<Integer>> merger = (xs, ys) -> {
            xs.addAll(ys);
            return xs;
        };
        // это функция, которая обработает наш список после сборки
        // здесь вся логика
        Function<List<Integer>, Integer> function = (ns) -> {
            int number = 100;
            for (Integer n : ns) {
                number /= n;
            }
            return number;
        };

        return List.of(4, 5).stream()
                .collect(Collector.of(supplier, consumer, merger, function));
    }
    /*Сборка в произвольную реализацию Collection
    Методы toList(), toSet() формируют нам уже заданную коллекцию. toList() создает ArrayList,
    toSet() создает HashSet. Если нам нужно использовать заданную нами коллекцию мы можем использовать
    методы collect() и Collectors.toCollection(). Например,
    List<Integer> result = List.of(1, 2).stream().collect(Collectors.toCollection(LinkedList::new));
    В качестве аргумента мы указываем создание пустой коллекции, в которую будут собираться наши значение.
    В примере выше мы получим реализацию List, но только теперь LinkedList.
    создать из стрима коллекцию LinkedHashSet: */

    public static Set<Integer> collect(Stream<Integer> data) {
        return data.collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /*Сборка в произвольную реализацию Map
    Для того чтобы собрать данные в мап, мы можем использовать методы collect() и Collectors.toMap().
    Сборка идет в HashMap. Например - toMap с тремя аргументами,
    Map<Integer, Integer> result = Set.of(1, 2).stream().collect(Collectors.toMap(k -> k, v -> v));
    В качестве первого аргумента мы указываем, как мы будет строить ключ из элемента стрима, а в качестве
    второго как будем строить значение. В примере, ключом и значением будет сам элемент.
    Этот метод перегружен и имеет реализацию с четырьмя аргументами, где в качестве четвертого аргумента
    мы можем указать реализацию Map, которую мы хотим получить
    Например
    Map<Integer, Integer> map = List.of(1, 2, 1).stream()
                          .collect(Collectors.toMap(k -> k, v -> v, (prev, curr) -> prev, TreeMap::new));
    В данном случае мы получим реализацию Map, но только TreeMap.
    задача собрать Map из стрима чисел, где ключ это само число,
    а значение его квадрат. Сборка в LinkedHashMap */

    public static Map<Integer, Integer> collectToMap(Stream<Integer> data) {
        return data.collect(Collectors.toMap(k -> k, v -> v * v, (prev, curr) -> prev, LinkedHashMap::new));
    }
}