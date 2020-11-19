package com.thoughtworks.capability.gtb.demospringconfig;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class DemoSpringConfigApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@Autowired
	private LevelController levelController;

	@Test
	void should_return_basic_when_levelNumber_less_than_1() throws Exception {
		levelController.setLevelNumber(0);
		mockMvc.perform(get("/level"))
				.andExpect(jsonPath("$", Matchers.is("basic")));
	}

	@Test
	void should_return_basic_when_levelNumber_large_than_1() throws Exception {
		levelController.setLevelNumber(2);
		mockMvc.perform(get("/level"))
				.andExpect(jsonPath("$", Matchers.is("advanced")));
	}

	@Test
	void should_return_basic_when_levelNumber_is_1() throws Exception {
		levelController.setLevelNumber(1);
		mockMvc.perform(get("/level"))
				.andExpect(jsonPath("$", Matchers.is("advanced")));
	}
}
