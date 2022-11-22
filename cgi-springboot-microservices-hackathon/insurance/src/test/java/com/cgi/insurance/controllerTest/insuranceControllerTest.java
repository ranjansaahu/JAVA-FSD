package com.cgi.insurance.controllerTest;

import com.cgi.insurance.controller.InsuranceController;
import com.cgi.insurance.model.Insurance;
import com.cgi.insurance.service.InsuranceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cgi.insurance.exception.insuranceExistException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(InsuranceController.class)
class insuranceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InsuranceService insuranceService;


    public static String convertProductToJson(Insurance insurance) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(insurance);
    }

    public static Insurance convertJsonToProduct(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json,Insurance.class);
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void addProduct1() {


//    	insert dummy data
        Insurance insurance = new Insurance();
        Insurance reponseProduct = null;

        when(insuranceService.postInsurance(insurance)).thenReturn(insurance);

        try{
            MvcResult result = mockMvc.perform(post("/add")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(convertProductToJson(insurance))).andDo(print()).andReturn();

            String json = result.getResponse().getContentAsString();
            reponseProduct = convertJsonToProduct(json);


        }catch(Exception e){
            e.printStackTrace();
        }

        assertEquals(insurance,reponseProduct);
    }

    @Test
    void addProduct2() {

        Insurance product = new Insurance();
        String reponseString = null;
        String json = null;

        when(insuranceService.postInsurance(product)).thenThrow(new insuranceExistException());

        try{
            MvcResult result = mockMvc.perform(post("/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(convertProductToJson(product))).andDo(print()).andReturn();

            reponseString = result.getResponse().getContentAsString();

        }catch(Exception e){
            e.printStackTrace();
        }


        assertEquals("errorMessage", "already present with same id",reponseString);
    }

 
}