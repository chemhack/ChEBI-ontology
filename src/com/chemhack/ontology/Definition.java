package com.chemhack.ontology;

import com.chemhack.ontology.matcher.IMatcher;

public class Definition {
    private String id;
    private IMatcher matcher;
    private String comment;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IMatcher getMatcher() {
        return matcher;
    }

    public void setMatcher(IMatcher matcher) {
        this.matcher = matcher;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
