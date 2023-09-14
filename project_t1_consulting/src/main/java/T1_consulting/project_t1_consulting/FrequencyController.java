package T1_consulting.project_t1_consulting;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class FrequencyController {

    @PostMapping("/frequency")
    public Map<Character, Integer> calculateFrequency(@RequestBody Map<String, String> request) {
        String inputString = request.get("inputString");
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        // Сортировка по убыванию количества вхождений
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return sortedMap;
    }
}
