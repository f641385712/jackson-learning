package com.yourbatman.java.treemode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

public class TreeModeTest {

    @Test
    public void test1() throws JsonProcessingException {
        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18,\"dog\":{\"name\":\"旺财\",\"color\":\"WHITE\"},\"hobbies\":[\"篮球\",\"football\"]}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonStr);


        String color = jsonNode.get("dog").get("color").asText();
        System.out.println(color);


        // 把json扩充属性
        // 强转为ObjectNode
        ObjectNode objectNode = (ObjectNode)jsonNode;
        objectNode.with("myDiy").put("contry", "China");
        jsonStr = objectMapper.writeValueAsString(objectNode);
        System.out.println(jsonStr);
    }

}
