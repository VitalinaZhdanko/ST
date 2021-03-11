package com.zhdanko.finalTask.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "plants")
public class Plants {
    private List<TreeList> treeList;

    @XmlElement(name = "trees")
    public List<TreeList> getTreeList() {
        return treeList;
    }

    public void setTreeList(List<TreeList> treeList) {
        this.treeList = treeList;
    }
}
