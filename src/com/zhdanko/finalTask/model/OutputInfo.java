package com.zhdanko.finalTask.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OutputInfo {
    private int cost;
    private int count;

    public int getCost() {
        return cost;
    }

    @XmlElement
    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    @XmlElement
    public void setCount(int count) {
        this.count = count;
    }
}
