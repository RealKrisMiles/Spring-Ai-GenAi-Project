package com.ai.SpringAi.Service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImagineService {
    private final OpenAiImageModel model;

    public ImagineService(OpenAiImageModel model) {
        this.model = model;
    }

    public ImageResponse generateImage(String prompt, String quality, int n, int width, int heigth){
     ImageResponse img =   model.call(
                new ImagePrompt(prompt,
                        OpenAiImageOptions.builder()
                                .quality(quality)
                                .N(n)
                                .height(heigth)
                                .width(width)
                                .build()
                )

        );
     return img;
    }


}
