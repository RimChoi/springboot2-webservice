package com.metamong.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDTOTest {

    @Test
    public void lombok_function_test() {

        //given
        String name="TEST";
        int amount = 1000;

        //when
        HelloResponseDTO dto = new HelloResponseDTO(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
