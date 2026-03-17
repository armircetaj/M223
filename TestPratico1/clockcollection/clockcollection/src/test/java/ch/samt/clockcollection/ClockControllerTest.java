package ch.samt.clockcollection;

import ch.samt.clockcollection.controller.ClockController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClockController.class)
public class ClockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testClocks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/clocks/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("clockList"))
                .andExpect(content().string(containsString("<span>Submariner</span>")))
                .andExpect(content().string(containsString("<span>131000</span>")));
    }

    @Test
    public void testAddClockGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/clocks/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("clockAdd"))
                .andExpect(content().string(containsString("Add a new clock")));
    }

    @Test
    public void testAddClockPost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/clocks/add")
                    .param("id", "5")
                    .param("brand", "Cartier")
                    .param("model", "Iced out")
                    .param("price", "24000"))
                .andExpect(status().is3xxRedirection());

    }
}
