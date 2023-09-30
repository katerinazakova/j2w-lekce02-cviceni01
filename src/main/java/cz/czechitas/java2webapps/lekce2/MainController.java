package cz.czechitas.java2webapps.lekce2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
@Controller
public class MainController {

    private static final Locale LOCALE = Locale.forLanguageTag("cs-CZ");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d. MMMM yyyy", LOCALE);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm", LOCALE);
    @GetMapping("/")
    public ModelAndView makeHomePage(){
        ModelAndView result = new ModelAndView("index");
        return result;
    }
    @GetMapping("/date")
    public ModelAndView makeDate() {
        ModelAndView result = new ModelAndView("date");
        String formattedDate = LocalDate.now().format(DATE_FORMATTER);
        result.addObject("date", formattedDate);
        return result;
    }

    @GetMapping("/time")

    public ModelAndView makeTime() {
        ModelAndView result = new ModelAndView("time");
        String formattedTime = LocalTime.now().format(TIME_FORMATTER);
        result.addObject("time", formattedTime);
        return result;
    }
}