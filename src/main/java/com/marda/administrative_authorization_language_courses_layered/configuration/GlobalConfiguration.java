package com.marda.administrative_authorization_language_courses_layered.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;


@Configuration
public class GlobalConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        // To reed Records and access private fields
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(PRIVATE)
                // to solve null in update
                .setSkipNullEnabled(true);

        // Converter String -> LocalDate
        modelMapper.addConverter(ctx ->
                        ctx.getSource() == null
                                ? null
                                : LocalDate.parse(ctx.getSource()),
                String.class,
                LocalDate.class
        );

        return modelMapper;
    };
}
