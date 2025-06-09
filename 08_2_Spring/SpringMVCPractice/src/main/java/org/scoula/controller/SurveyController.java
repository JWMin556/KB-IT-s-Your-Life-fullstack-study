package org.scoula.controller;

import org.scoula.dto.SurveyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/survey")
public class SurveyController {
    private final ConcurrentHashMap<Integer, SurveyDTO> surveyStorage = new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger();

    @GetMapping
    public String showForm() {
        return "survey/form";
    }

    @PostMapping
    public String handleForm(@ModelAttribute SurveyDTO dto) {
        int id =  idGenerator.incrementAndGet();
        surveyStorage.put(id, dto);
        return "redirect:/survey/share?id=" + id;
    }

    @GetMapping("/share")
    public String showSharePage(@RequestParam("id") int id, Model model) {
        SurveyDTO dto = surveyStorage.get(id);
        if (dto == null) {
            throw new IllegalArgumentException("존재하지 않는 ID입니다.");
        }
        model.addAttribute("survey", dto);
        return "survey/share";
    }
}
