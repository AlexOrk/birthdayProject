package matiaslogrus.drproject.controller;

import matiaslogrus.drproject.model.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DrController {
    private static final Logger log = LoggerFactory.getLogger(Logger.class);

    @GetMapping("/")
    public String showHelloPage() {
        log.info("Web application was started!");
        return "main";
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        log.info("ShowFormController was chosen");
        Test test = new Test();
        model.addAttribute("test", test);
        return "test-form";
    }

    @PostMapping("/check")
    public String checkTest(@ModelAttribute("test") Test test) {
        log.info("Form was checked");
        int count = 0;
        if (test.getAnswer_1().equals(test.getCorrect_answer_1())) count++;
        if (test.getAnswer_2().equals(test.getCorrect_answer_2())) count++;
        if (test.getAnswer_3().equals(test.getCorrect_answer_3())) count++;
        if (test.getAnswer_4().equals(test.getCorrect_answer_4())) count++;
        if (test.getAnswer_5().equals(test.getCorrect_answer_5())) count++;
        if (test.getAnswer_6().equals(test.getCorrect_answer_6())) count++;
        if (test.getAnswer_7().equals(test.getCorrect_answer_7())) count++;
        if (test.getAnswer_8().equals(test.getCorrect_answer_8())) count++;
        if (test.getAnswer_9().equals(test.getCorrect_answer_9())) count++;
        if (test.getAnswer_10().equals(test.getCorrect_answer_10())) count++;

        if (count == 10) {
            log.info("best-result view was chosen");
            return "best-result";
        } else {
            log.info("result view was chosen");
            return "result";
        }
    }

    @GetMapping("/showSpecial")
    public String showSpecial() {
        log.info("ShowSpecialController was chosen");
        return "special";
    }
}


