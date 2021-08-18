package org.litnine.coursework.domain;

import java.util.HashMap;
import java.util.Map;

public class GithubUserInfo implements UserInfo{

    private final Map<String, Object> attributes;

    public GithubUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getId() {
        return "github-" + attributes.get("id");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }
}
