package com.org.dentys.uitl;



import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Component;
@Component
public class JsonUtil {
   //  private static final Logger log = Logger.getLogger(JsonUtil.class);

    public String convertJavaToJson(Object obj){
        String jsonString = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonString = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e){
           // log.error("Exception occurred while converting Object to JSON", e);
        	System.out.println(":::::Exception occurred while converting Object to JSON"+e);
        }
        return jsonString;
    }

    public <T> Optional<T> convertJsonToJava(String json, Class<T> cls) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return Optional.of(objectMapper.readValue(json, cls));
        } catch (JsonParseException | JsonMappingException e) {
          //  log.error("Exception occurred while converting JSON to Object", e);
            System.out.println("::::::Exception occurred while converting Object to JSON"+e);
        } catch (IOException e){
           // log.error("Exception occurred while converting JSON to Object", e);
            System.out.println("::::::Exception occurred while converting Object to JSON"+e);
        }
        return Optional.empty();
    }
}
