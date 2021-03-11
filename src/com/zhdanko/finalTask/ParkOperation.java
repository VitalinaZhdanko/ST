package com.zhdanko.finalTask;

import com.zhdanko.finalTask.model.Park;
import com.zhdanko.finalTask.model.Plants;
import com.zhdanko.finalTask.model.Tree;
import com.zhdanko.finalTask.model.TreeKind;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.awt.*;
import java.io.File;

public class ParkOperation {
    public static Plants parseXml(String filename) throws JAXBException {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(Plants.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Plants) jaxbUnmarshaller.unmarshal(file);
    }

    public static void plantTree(Plants plants) {
        Tree tree = plants.getTreeList().get(0).getTree().get(0);
        Park park = new Park();
        for (int i = 0; i < tree.getKind().size(); i++) {
            TreeKind kind = tree.getKind().get(i);
            park.addTree(kind, new Point((int) (Math.random() * 10 / 2), (int) (Math.random() * 10 / 2)));
        }
    }
}
