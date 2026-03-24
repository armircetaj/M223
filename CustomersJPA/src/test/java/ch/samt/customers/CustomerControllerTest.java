package ch.samt.customers;


import ch.samt.customers.controller.CustomerController;
import ch.samt.customers.data.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private CustomerRepository customerRepository;
//
//    @Test
//    public void testLoadCustomers() throws Exception {
//        mockMvc.perform(get("/customers"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("customerList"))
//                .andExpect(content().string(containsString("<th>ID</th>")))
//                .andExpect(content().string(containsString("<th>Name</th>")));
//    }
//
//    @Test
//    public void testLoadInsertPage() throws Exception {
//        mockMvc.perform(get("/insert"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("insertCustomer"))
//                .andExpect(content().string(containsString("form")));
//    }
//
//    @Test
//    public void testInsertCustomerPost() throws Exception {
//        mockMvc.perform(post("/insert")
//                        .param("id", "4")
//                        .param("name", "Luca")
//                        .param("surname", "Neri")
//                        .param("age", "25")
//                        .param("city", "Zurigo")
//                        .param("number", "1234567812345678")
//                        .param("expiration", "12/30")
//                        .param("cvv", "123"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/customers"));
//    }
//
//    @Test
//    public void testLoadCustomerById() throws Exception {
//        mockMvc.perform(get("/customers")
//                        .param("id", "101"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("customerList"));
//    }
}
