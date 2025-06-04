package Kart.controller.impl;


import Kart.model.Track;
import Kart.repository.RaceDetailRepository;
import Kart.repository.TrackRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class RaceDetailControllerTest {

    @Autowired
    RaceDetailRepository raceDetailRepository;



    @Autowired
    WebApplicationContext   webApplicationContext;
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }



    @Test

    void findAllRaceDetails_validRequest_allRaceDetails() throws Exception {
        // obterner resultado de este endpoint
        MvcResult mvcResult = mockMvc.perform(get("/api/details"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

    }


    @Test
    void findRaceDetailById_validRequest_correctRaceDetail() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/api/details/6"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("750"));
        System.out.println(mvcResult.getResponse().getContentAsString());
    }




}