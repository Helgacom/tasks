package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class OptionalExamples {
    public static void main(String[] args) {
        /*case 1, min exists*/
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println(min.get());  // 1

        /*case 2, list is empty*/

        /*ArrayList<Integer> numbers1 = new ArrayList<Integer>();
        Optional<Integer> min1 = numbers1.stream().min(Integer::compare);
        System.out.println(min1.get()) - java.util.NoSuchElementException*/

        /*предварительная проверка наличия значения в Optional с помощью метода isPresent().
        Он возврашает true, если значение присутствует в Optional, и false, если значение отсутствует*/
        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        Optional<Integer> min2 = numbers2.stream().min(Integer::compare);
        if(min2.isPresent()){
            System.out.println(min2.get());
        }

        /*orElse() позволяет определить альтернативное значение, которое будет возвращаться,
        если Optional не получит из потока какого-нибудь значения*/
        // пустой список
        ArrayList<Integer> numbers3 = new ArrayList<Integer>();
        Optional<Integer> min3 = numbers3.stream().min(Integer::compare);
        System.out.println(min3.orElse(-1)); // -1

        // непустой список
        numbers.addAll(Arrays.asList(new Integer[]{4,5,6,7,8,9}));
        min = numbers.stream().min(Integer::compare);
        System.out.println(min.orElse(-1)); // 4

        /*orElseGet() позволяет задать функцию, которая будет возвращать значение по умолчанию*/
        ArrayList<Integer> numbers4 = new ArrayList<Integer>();
        Optional<Integer> min4 = numbers4.stream().min(Integer::compare);
        Random rnd = new Random();
        System.out.println(min4.orElseGet(()->rnd.nextInt(100)));

        /*orElseThrow позволяет сгенерировать исключение, если Optional не содержит значения*/
        ArrayList<Integer> numbers5 = new ArrayList<Integer>();
        Optional<Integer> min5 = numbers5.stream().min(Integer::compare);
        // генеррация исключения IllegalStateException
        System.out.println(min5.orElseThrow(IllegalStateException::new));

        /*ifPresent() определяет действия со значением в Optional, если значение имеется*/
        ArrayList<Integer> numbers6 = new ArrayList<Integer>();
        numbers6.addAll(Arrays.asList(new Integer[]{4,5,6,7,8,9}));
        Optional<Integer> min6 = numbers6.stream().min(Integer::compare);
        min6.ifPresent(v->System.out.println(v)); // 4

        /*ifPresentOrElse() позволяет определить альтернативную логику на случай, если
        значение в Optional отсутствует. В метод ifPresentOrElse передается две функции. Первая
        обрабатывает значение в Optional, если оно присутствует. Вторая функция представляет действия,
        которые выполняются, если значение в Optional отсутствует*/
        ArrayList<Integer> numbers7 = new ArrayList<Integer>();
        Optional<Integer> min7 = numbers7.stream().min(Integer::compare);
        min7.ifPresentOrElse(
                v -> System.out.println(v),
                () -> System.out.println("Value not found")
        );
    }
}
