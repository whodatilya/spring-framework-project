package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.models.Post;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.PostService;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainPageController {

    @Autowired
    @Qualifier(value = "postService")
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public ModelAndView getMainPage(Authentication authentication) {
        if (authentication == null)
            return new ModelAndView("redirect:/signIn");
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) authentication.getPrincipal();
        modelAndView.addObject("user", user);
        List<Post> posts = postService.findAllPosts();
        modelAndView.addObject("posts", posts);
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
