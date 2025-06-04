package Kart.controller.impl;

import Kart.controller.dto.CompetitorTotalRacesDTO;
import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import Kart.repository.CompetitorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CompetitorControllerTest {
    @Autowired
    CompetitorRepository competitorRepository;


    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();


    Competitor competitor;

    //GetPostPutPatch
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        competitor = new  Competitor("Karl", "Karlson", 6969, CompetitorClass.C1, 44);
        competitorRepository.save(competitor);

    }

    @AfterEach
    void tearDown(){
        if (competitor.getId() != null){
            competitorRepository.deleteById(competitor.getId());
        }


    }





    @Test
    void updateCompetitor_validBody_competitorUpdated() throws Exception {


        Competitor updatedCompetitor = new Competitor("JimmyJ", "Johnson", 16, CompetitorClass.C2, 44);
        updatedCompetitor = competitorRepository.save(updatedCompetitor);
        System.out.println("Original new Competitor" +updatedCompetitor);


        Integer updatedCompetitorId = updatedCompetitor.getId();
        //check id
        System.out.println("updated competitor ID: " + updatedCompetitorId);


        updatedCompetitor.setLastName("JacksonJr");
        updatedCompetitor.setId(updatedCompetitorId);

        String body = objectMapper.writeValueAsString(updatedCompetitor);

        mockMvc.perform(put("/api/competitors/" +updatedCompetitorId).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("Updated Competitor: " +updatedCompetitor);
        assertTrue(competitorRepository.findAll().toString().contains("Jackson"));

        competitorRepository.deleteById(updatedCompetitorId);
    }

    //Patch competitorTotalRaces testing


    @Test
    void updateCompetitorTotalRaces_validBody_updatedCompetitorTotalRaces()  throws Exception{
        CompetitorTotalRacesDTO competitorTotalRacesDTO = new CompetitorTotalRacesDTO(666666);

        String body = objectMapper.writeValueAsString(competitorTotalRacesDTO);

        mockMvc.perform(patch("/api/competitors/" + competitor.getId()).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(competitorRepository.findAll().toString().contains("666666"));




    }



}


