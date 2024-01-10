package com.springai.service;

import com.springai.request.Request;
import com.springai.request.Response;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.parser.Parser;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageTranslatorServiceImpl implements ILanguageTranslatorService{
    private final ChatClient chatClient;

    public Response translateLanguage(Request req) {
//        BeanOutputParser<Response> parser=new BeanOutputParser<>(Response.class);
        String text="Translate the following {language1} text into {language2}: {text} ";
        PromptTemplate promptTemplate=new PromptTemplate(text);
        promptTemplate.add("language1",req.getFrom());
        promptTemplate.add("language2",req.getTo());
        promptTemplate.add("text",req.getText());

        Prompt prompt = promptTemplate.create();
        ChatResponse chatResponse = chatClient.generate(prompt);
        String content = chatResponse.getGeneration().getContent();
        Response response=new Response();
        response.setText(req.getText());
        response.setTranslatedText(content);
        return response;

    }

}
