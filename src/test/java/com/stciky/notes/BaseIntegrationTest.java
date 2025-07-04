package com.stciky.notes;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(
        classes = NotesApplication.class,
        webEnvironment = RANDOM_PORT
)
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class BaseIntegrationTest {
}
