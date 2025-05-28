package Kart.controller.impl;

import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import Kart.repository.CompetitorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
        //competitor = new Competitor(99999, "JimmyJ", "Jackson", 666, CompetitorClass.C2, 44);
        //competitorRepository.save(competitor);

    }

   /* @AfterEach
    void tearDown() {
        competitorRepository.deleteById(99999);
    }*/


    @Test
    void updateCompetitor_validBody_competitorUpdated() throws Exception {

        //due to bugs check if 99999 exists
        //Optional<Competitor> optionalCompetitor = competitorRepository.findById(99999);
        //System.out.println(optionalCompetitor + "exists");

        // Create a new competitor with updated values
        Competitor updatedCompetitor = new Competitor("JimmyJ", "Johnson", 666, CompetitorClass.C2, 44);
        updatedCompetitor = competitorRepository.save(updatedCompetitor);
        System.out.println("Original new Competitor" +updatedCompetitor);


        Integer updatedCompetitorId = updatedCompetitor.getId();
        //check id
        System.out.println("updated competitor ID: " + updatedCompetitorId);
        updatedCompetitor.setLastName("JacksonJr");


        String body = objectMapper.writeValueAsString(updatedCompetitor);

        mockMvc.perform(put("/api/competitors/" +updatedCompetitorId).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("Updated Competitor: " +updatedCompetitor);
        assertTrue(competitorRepository.findAll().toString().contains("Jackson"));

        competitorRepository.deleteById(updatedCompetitorId);
    }


/*    @Test
    void updateCompetitor_validBody_competitorUpdated() throws Exception {
        Optional<Competitor> competitorOptional = competitorRepository.findById(99999);
        assertTrue(competitorOptional.isPresent());
        Competitor competitor1 = competitorOptional.get();

        competitor1.setLastName("Johnson");

        String body = objectMapper.writeValueAsString(competitor1);

        mockMvc.perform(put("/api/competitors/99999").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(competitorRepository.findAll().toString().contains("Johnson"));

    }*/
}

/*    @Test
    void testFindAllCompetitorsClassC3_allC3Competitors()throws Exception{

       // MvcResult result = mockMvc.perform .get("/competitors/class/C1")).contentType(MediaType.APPLICATION_JSON)
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/competitors/class/C3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isFound()) // Status 302 (FOUND)
                .andReturn();

        String responseJson = result.getResponse().getContentAsString();
        List<Competitor> competitorList = objectMapper.readValue(
                responseJson,
                new TypeReference<List<Competitor>>() {}
        );

        assertEquals(8, competitorList.size());



    }*/




