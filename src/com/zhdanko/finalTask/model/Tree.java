package com.zhdanko.finalTask.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tree")
public class Tree {
    private List<TreeKind> kind;

    private String type;

    @XmlElement
    public List<TreeKind> getKind() {
        return kind;
    }

    public void setKind(List<TreeKind> kind) {
        this.kind = kind;
    }

    @XmlAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
