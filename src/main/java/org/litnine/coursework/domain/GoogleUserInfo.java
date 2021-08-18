package org.litnine.coursework.domain;

import java.util.HashMap;
import java.util.Map;

public class GoogleUserInfo {

    private final Map<String, Object> attributes;

    public GoogleUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public static GoogleUserInfo fromGithubAttributes(Map<String, Object> attributes){
        Map<String, Object> newAttributes = new HashMap<>(attributes);
        newAttributes.put("sub", "github-" + attributes.get("id").toString());
        return new GoogleUserInfo(newAttributes);
    }

    public String getId() {
        return (String) attributes.get("sub");
    }

    public String getName() {
        return (String) attributes.get("name");
    }

}