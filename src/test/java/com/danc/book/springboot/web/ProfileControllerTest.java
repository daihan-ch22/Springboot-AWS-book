package com.danc.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.env.MockEnvironment;
import com.danc.book.springboot.*;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ProfileControllerTest {

    @Test
    public void Check_real_Profile() {
        //given
        String expectedProfile = "real";

        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void Chech_DefaultProfile_If_NO_activeProfile() {
        //given
        String expectedProfile = "default";

        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        assertThat(profile).isEqualTo(expectedProfile);
    }

}
