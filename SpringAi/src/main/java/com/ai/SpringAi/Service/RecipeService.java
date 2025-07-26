package com.ai.SpringAi.Service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {
    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    private ChatModel chatModel;

    public String createRecipe(String ingredients,
                               String cuisine,
                               String dietaryRestrictions){
        var template = """
                I want to create a recipe using the following ingredients:{ingrediants}.
                The cuisine type I prefer is {cuisine}.
                Please consider the following dietary restriction: {dietaryRestrictions}.
                please provide me with a detailed recipe including title, list of ingredients ,and cooking instructions
                """;
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String,Object> params = Map.of("ingredients",ingredients,
                "cuisine",cuisine,
                "dietaryRestrictions",dietaryRestrictions
                );
        Prompt prompt = promptTemplate.create(params);
        return chatModel.call(prompt).getResult().getOutput().getText();

    }

}
