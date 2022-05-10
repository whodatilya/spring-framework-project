package ru.kpfu.itis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.dtos.PostDto;
import ru.kpfu.itis.services.PostService;

@Controller
@RequiredArgsConstructor
public class PostsController {

    private final PostService productService;

    @GetMapping(value = "/posts")
    @Secured({"ROLE_SHOP"})
    public String productAddPage() {
        return "postAddPage";
    }

    @PostMapping( value = "/posts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addProduct(@RequestBody() PostDto postDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(productService.createNew(postDto));
    }
}
