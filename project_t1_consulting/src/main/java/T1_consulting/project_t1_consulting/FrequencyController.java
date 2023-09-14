package T1_consulting.project_t1_consulting;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FrequencyController {

    @PostMapping("/frequency")
    public Map<String, Integer> calculateFrequency(@RequestBody Map<String, String> request) {
        String inputString = request.get("inputString");
        String[] arr = inputString.split("");

        // Подсчет символов
        Map<String, Integer> frequencyMap = Arrays.stream(arr)
                .collect(Collectors.toMap(
                        letter -> letter,
                        letter -> 1,
                        (v1, v2) -> v1 + v2
                ));

        return frequencyMap;
    }
}





