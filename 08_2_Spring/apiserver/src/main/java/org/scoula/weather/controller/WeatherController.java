package org.scoula.weather.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.weather.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@Log4j2
@RequestMapping("/weather")
@PropertySource({"classpath:/application.properties"})
public class WeatherController {
    @Value("${weather.url}")
    private String URL;

    @Value("${weather.icon_url}")
    private String ICON_URL;

    @Value("${weather.api_key}")
    private String API_KEY;

    @GetMapping({"", "/{city}"})
    public String Weather(Model model, @PathVariable(value = "city", required = false) String city) {
        city = city == null ? "seoul" : city;

        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("q", city)
                .queryParam("units", "metric")
                .queryParam("APPID", API_KEY)
                .queryParam("lang", "kr")
                .toUriString();

        WeatherDTO weather = restTemplate.getForObject(url, WeatherDTO.class);  // 통신시작 -> IO작업임 그렇기에 반드시 예외처리 작업 필요. 그러나 예외처리가 여기는 안되어있다. 그 이유는 runtimeException을 발생시키기 때문
        String iconUrl = ICON_URL.formatted(weather.getWeather().get(0).getIcon());
        log.info("오늘의 날씨: " + weather);
        
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        model.addAttribute("iconUrl", iconUrl);
        
        return "weather/today";
    }
}
