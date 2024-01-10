package com.springai.controller;

import com.springai.request.Request;
import com.springai.request.Response;
import com.springai.service.ILanguageTranslatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LanguageTranslator {
    private final ILanguageTranslatorService translatorService;
   private final ChatClient chatClient;
   @GetMapping("/translate")
    public Response translateLanguage (@RequestBody Request req){
       Response response = translatorService.translateLanguage(req);
       // String generate = chatClient.generate(prompt);
    return response;
   }


}
