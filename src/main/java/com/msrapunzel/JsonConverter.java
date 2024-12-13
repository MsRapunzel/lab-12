package com.msrapunzel;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import java.util.List;

public class JsonConverter {
    public static JsonArray convertToJsonArray(List<Users> entities) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Users entity : entities) {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                    .add("id", entity.getId())
                    .add("name", entity.getName());

            arrayBuilder.add(objectBuilder);
        }

        return arrayBuilder.build();
    }

    public static JsonObject convertToJsonObject(Users entity) {
        return Json.createObjectBuilder()
                .add("id", entity.getId())
                .add("name", entity.getName())
                .build();
    }
}
