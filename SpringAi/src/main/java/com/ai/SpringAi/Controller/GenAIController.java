package com.ai.SpringAi.Controller;

import com.ai.SpringAi.Service.ChatService;
import com.ai.SpringAi.Service.ImagineService;
import com.ai.SpringAi.Service.RecipeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GenAIController {


    ImagineService imagineService;

     ChatService chatService;

     RecipeService recipeService;

    public GenAIController(ChatService chatService,ImagineService imagineService, RecipeService recipeService) {
        this.chatService = chatService;
        this.imagineService = imagineService;
        this.recipeService =recipeService;
    }

    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt){
        return chatService.getResponseOptions(prompt);
    }

//    @GetMapping("generate-image")
//    public void generateImages(@RequestParam String prompt, HttpServletResponse response) throws IOException {
//        ImageResponse imageResponse = imagineService.generateImage(prompt);
//       String ans = imageResponse.getResult().getOutput().getUrl();
//         response.sendRedirect(ans);
//    }
        @GetMapping("generate-image")
    public List<String> generateImages(@RequestParam String prompt,
                                       @RequestParam(defaultValue = "hd") String quality,
                                       @RequestParam(defaultValue = "1") int n,
                                       @RequestParam(defaultValue = "1024") int width,
                                       @RequestParam(defaultValue = "1024") int heigth,
                                       HttpServletResponse response) throws IOException {
        ImageResponse imageResponse = imagineService.generateImage(prompt,quality,n,width,heigth);
       List<String> ans = imageResponse.getResults().stream().map(result->result.getOutput().getUrl()).toList();
        return ans;
    }

    @GetMapping("generate-recipe")
    public String recipeCreator(@RequestParam String ingredients,@RequestParam(defaultValue = "any") String cuisine,@RequestParam(defaultValue = "none") String dietaryRestrictions){
        return recipeService.createRecipe(ingredients,cuisine,dietaryRestrictions);

    }
}
