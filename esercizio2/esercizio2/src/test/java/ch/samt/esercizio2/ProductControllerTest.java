package ch.samt.esercizio2;


import ch.samt.esercizio2.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(content().string(containsString("<span>Prodotto3</span> -")))
                .andExpect(content().string(containsString("<span>14.99</span>")));
    }

    @Test
    public void testNewProductGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/newproduct"))
                .andExpect(status().isOk())
                .andExpect(view().name("newProductPage"))
                .andExpect(content().string(containsString("Inserisci nuovo prodotto")));
    }

    @Test
    public void testNewProductsPost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/newproduct")
                        .param("id", "4")
                        .param("name", "Prodotto4")
                        .param("price", "1.99")
                        .param("expirationDate", LocalDate.of(2027, 1, 1).toString())
                        .param("description", "Prodotto di qualità pessima"))
                .andExpect(status().is3xxRedirection());
    }
}
