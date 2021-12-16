import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.touk.throwing.ThrowingPredicate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("John");
        nameList.add("Violet");
        nameList.add("Electra");
        nameList.add("Anker");
        nameList.add("Thorvald");


        List<String> filteredNames = nameList.stream().filter(names -> {
            try {
                String n = names;
                return n.length()>5;
            } catch (Exception ex) {
                logger.error(ex.getMessage());
            }
            return false;
        }).collect(Collectors.toList());
        filteredNames.forEach((e) -> {
            System.out.println(e);
        });


        HashMap<String, Integer> fauna = new HashMap<String, Integer>();
        fauna.put("Lion", 170);
        fauna.put("Jaguar", 80);
        fauna.put("Chimpanzee", 50);
        fauna.put("Cat", 4);
        fauna.put("Horse", 400);
        Map<String, Integer> filteredMap = fauna.entrySet()
                .stream()
                .filter(ThrowingPredicate.unchecked(Main::isheavierthan20))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(filteredMap);
        logger.info("Code executed successfully!");

    }
    public static boolean isheavierthan20(Map.Entry<String, Integer> entry) throws Exception{
        return entry.getValue() > 20;
    }
}



