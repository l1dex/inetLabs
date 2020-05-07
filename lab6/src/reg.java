import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class reg {
    public static void main(String[] args) {
        String inetRegex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        String myPhoneRegex = "^[0-9][0-9]{10}|\\+[0-9] \\([0-9]{3}\\) [0-9]{3}-[0-9]{2}-[0-9]{2}";



        List<String> numbers = new ArrayList<>();
        for(int i = 0; i < 5_000_000;i++){
            StringBuilder number1 = new StringBuilder("+7 ("); // type +7 (960) 587-72-30
            StringBuilder number2 = new StringBuilder("8");//type 89605877230

            number2.append((int)(Math.random() * 999_999)); //960 587
            number2.append((int)(Math.random() * 99_99)); //72 30
            while (number2.length()<11) number2.append("0");


            number1.append((int)(Math.random() * 899 + 100) + ") ");//960
            number1.append((int)(Math.random() * 899 + 100) + //587-72-30
                    "-" + (int)(Math.random()*89 + 10) +
                    "-" + (int)(Math.random()*89 + 10));

            numbers.add(number1.toString());
            numbers.add(number2.toString());
        }

        long start = System.nanoTime();
        for (String str : numbers){
            if(!str.matches(inetRegex)) System.out.println(str);
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);

        long start1 = System.nanoTime();
        for(String str : numbers){
            if(!str.matches(myPhoneRegex)) System.out.println(str + "myphone");
        }
        long stop1 = System.nanoTime();
        System.out.println(stop1 - start1);
    }
}
