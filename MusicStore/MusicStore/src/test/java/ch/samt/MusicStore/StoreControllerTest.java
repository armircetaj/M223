package ch.samt.MusicStore;

import ch.samt.MusicStore.controller.StoreController;
import ch.samt.MusicStore.data.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = StoreController.class)
public class StoreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private StoreRepository storeRepository;

    @Test
    public void testInstrumentFilter() throws Exception {
        mockMvc.perform(get("/instruments?type=guitar&brand=gibson"))
                .andExpect(status().isOk())
                .andExpect(view().name("instrumentsList"))
                .andExpect(content().string(containsString("Guitar")))
                .andExpect(content().string(containsString("Gibson")));
    }

    @Test
    public void testAddInstrument() throws Exception {
        mockMvc.perform(get("/instruments/add/1/10"))
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/instruments"));
    }
}
