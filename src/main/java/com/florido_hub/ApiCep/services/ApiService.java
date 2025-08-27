package com.florido_hub.ApiCep.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.florido_hub.ApiCep.dtos.EnderecoDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    EnderecoDto enderecoDto = new EnderecoDto();

    public EnderecoDto getEndereco(String cep){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/"+ cep +"/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            EnderecoDto enderecoDto = mapper.readValue(response.body(), EnderecoDto.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return enderecoDto;
    }
}
