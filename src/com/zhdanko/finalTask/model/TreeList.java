package com.zhdanko.finalTask.model;

import com.zhdanko.finalTask.model.Tree;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "trees")
public class TreeList {
    private List<Tree> tree;

    @XmlElement
    public List<Tree> getTree() {
        return tree;
    }

    public void setTree(List<Tree> tree) {
        this.tree = tree;
    }
}
