package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.TrainerNotFoundException;
import com.revature.models.Party;
import com.revature.models.Role;
import com.revature.models.Storage;
import com.revature.models.Trainer;
import com.revature.services.PartyService;
import com.revature.services.StorageService;
import com.revature.services.TrainerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TrainerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;

    @MockBean
    private TrainerService ts;
    @MockBean
    private StorageService ss;
    @MockBean
    private PartyService ps;

    @MockBean
    private CommandLineRunner clr;

    @Test
    public void getTrainerById() throws Exception {
        Trainer expected = new Trainer();
        expected.setId(1);
        expected.setUsername("kev");
        expected.setPassword("pass");
        expected.setRole(Role.ADMIN);

        when(ts.getbyId(1)).thenReturn(expected);

        mockMvc.perform(get("/trainers/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(om.writeValueAsString(expected)));
    }

    @Test
    public void getUserByIdNotExist() throws Exception {

        when(ts.getbyId(3)).thenThrow(TrainerNotFoundException.class);

        mockMvc.perform(
                        get("/trainers/3"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getTrainers() throws Exception {
        Trainer u1 = new Trainer();
        u1.setId(1);
        u1.setUsername("kev");
        u1.setPassword("pass");
        u1.setRole(Role.ADMIN);

        List<Trainer> trainers = new ArrayList<>();
        trainers.add(u1);

        when(ts.getTrainers()).thenReturn(trainers);

        mockMvc.perform(
                        get("/trainers"))
                .andExpect(status().isOk())
                .andExpect(content().json(om.writeValueAsString(trainers)));
    }

    @Test
    public void saveTrainer() throws Exception {
        Trainer expected = new Trainer();
        expected.setId(1);
        expected.setUsername("kev");
        expected.setPassword("pass");
        expected.setRole(Role.ADMIN);

        when(ts.saveTrainer(expected)).thenReturn(expected);
        when(ss.createStorage(new Storage())).thenReturn(null);
        when(ps.saveParty(new Party())).thenReturn(null);

        mockMvc.perform(post("/trainers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(expected))
                )
                .andExpect(status().isCreated());
    }

    @Test
    public void updateTrainer() throws Exception {
        // TODO: finish later
    }
}
