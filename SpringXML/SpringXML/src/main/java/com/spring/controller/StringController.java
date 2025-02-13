
import com.spring.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/string")
public class StringController {
    @Autowired
    private StringService stringService;

    @GetMapping("/search")
    public boolean searchSubstring(@RequestParam String mainString, @RequestParam String substring) {
        return stringService.containsSubstring(mainString, substring);
    }

    @GetMapping("/uppercase")
    public String convertToUpperCase(@RequestParam String input) {
        return stringService.toUpperCase(input);
    }
}