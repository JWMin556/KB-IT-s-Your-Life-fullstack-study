package org.scoula.icecream.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.scoula.icecream.service.IcecreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        RootConfig.class,
        ServletConfig.class
})
@Log4j2
class IcecreamControllerTest {

    @Autowired
    IcecreamService service;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void list() throws Exception {
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/icecream/list"))
                .andReturn().getModelAndView().getModelMap();

        List<?> list = (List<?>) model.get("list");
        for (Object item : list) {
            log.info(item);
        }
    }

    @Test
    void create() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/icecream/create")
                .param("name", "딸기요거트")
                .param("flavor", "달콤한 딸기와 상큼한 요거트")
                .param("price", "3500"))
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info(resultPage);
    }

}