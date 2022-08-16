import java.util.Map;
import java.util.HashMap;

class Main {
    static String LoremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    static String LoremIpsumLower = LoremIpsum.toLowerCase();// приведение текста к нижнему регистру

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < LoremIpsumLower.length(); i++) {
            char simvol = LoremIpsumLower.charAt(i);
            if (map.containsKey(simvol)) {
                int value = map.get(simvol) + 1;
                map.put(simvol, value);
            } else {
                map.put(simvol, 1);
            }
        }
        int max = -1;
        int min = Integer.MAX_VALUE;
        char keyMax = 'N';
        char keyMin = 'N';
        for (char key : map.keySet()) {
            int value = map.get(key);
            // if (value > max) {
            if ((value > max) && (key != 32) && (key != 44) && (key != 46)) {// исключение по hashCode() пробел, запятая и точка
                max = value;
                keyMax = key;
            }
            if (value < min && (key != 32) && (key != 44) && (key != 46)) {// исключение по hashCode() пробел, запятая и точка
                min = value;
                keyMin = key;
            }
        }
        System.out.println(keyMax + " максимальное число повторений - " + max);
        System.out.println(keyMin + " минимальное число повторений - " + min);
        System.out.println(map.entrySet());
    }
}