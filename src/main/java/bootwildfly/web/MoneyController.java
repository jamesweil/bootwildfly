package bootwildfly.web;

import bootwildfly.util.MoneyUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/money")
public class MoneyController {

    @RequestMapping(value = "/c/{number}", method = RequestMethod.GET)
    public String convert(@PathVariable(value = "number") String number) {
        return MoneyUtil.convert(number);
    }
}
