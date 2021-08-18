package org.litnine.coursework.domain;

import java.util.Map;

public class GoogleUserInfo implements UserInfo{

    private final Map<String, Object> attributes;

    public GoogleUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getId() {
        return "google-" + attributes.get("sub");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

}