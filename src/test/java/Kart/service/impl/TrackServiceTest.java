package Kart.service.impl;

import Kart.model.Track;
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
class TrackServiceTest {
    @Autowired
    TrackRepository trackRepository;

    //MOckmvc


    @Autowired
    WebApplicationContext   webApplicationContext;
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test

    void findAllTracks_validRequest_allTracks() throws Exception {
        // obeterner resultado de este endpoint
        MvcResult mvcResult = mockMvc.perform(get("/api/tracks"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


    }




/*    @Override
    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> findAllTracks(){
        List<Track> tracks = trackService.findAll();
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }*/

}