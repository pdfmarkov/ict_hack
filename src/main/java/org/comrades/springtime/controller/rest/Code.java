package org.comrades.springtime.controller.rest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import java.util.HashMap;
import java.util.Map;

@Component
@ApplicationScope
public class Code {

    private final Map<String, String> codeTable = new HashMap<>();

    public void generateCode(String username) {
        codeTable.put(username, (int) (Math.random() * 100000) + String.valueOf((int) (Math.random() * 100000)));
    }

    public boolean checkCode(String username, String newCode) {
        return newCode.equals(codeTable.get(username));
    }

    public String getCode(String username) {
        return codeTable.get(username);
    }
}
