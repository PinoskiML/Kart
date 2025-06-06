package Kart.controller.impl;

import Kart.controller.dto.TrackDTO;
import java.util.stream.Collectors;
import Kart.model.Track;
import Kart.repository.TrackRepository;
import com.fasterxml.jackson.core.type.TypeReference;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class TrackControllerTest {
    @Autowired
    TrackRepository trackRepository;

    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    void getAllTracks_allTracks() throws Exception {
        // Get test
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/tracks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println("Request completed status: " + result.getResponse().getStatus());
        String responseJson = result.getResponse().getContentAsString();
        System.out.println("Response: " + responseJson);

        List<Track> trackList = objectMapper.readValue(
                responseJson,
                new TypeReference<List<Track>>() {}
        );

        System.out.println("Track list size: " + trackList.size());
        assertEquals(12, trackList.size());
    }




}