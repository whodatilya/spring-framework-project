package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dtos.PostDto;
import services.PostService;

@Controller
@RequiredArgsConstructor
public class PostsController {

    private final PostService productService;

    @GetMapping(value = "/products")
    @Secured({"ROLE_SHOP"})
    public String productAddPage() {
        return "productAddPage";
    }

    @PostMapping( value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addProduct(@RequestBody() PostDto postDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(productService.createNew(postDto));
    }
}
