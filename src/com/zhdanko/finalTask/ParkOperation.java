package com.zhdanko.finalTask;

import com.zhdanko.finalTask.model.OutputInfo;
import com.zhdanko.finalTask.model.Park;
import com.zhdanko.finalTask.model.Plants;
import com.zhdanko.finalTask.model.Tree;
import com.zhdanko.finalTask.model.TreeKind;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.awt.Point;
import java.io.File;

public class ParkOperation {
    public static Plants parseXml(String filename) throws JAXBException {
            JAXBContext jaxbContext = JAXBContext.newInstance(Plants.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Plants) jaxbUnmarshaller.unmarshal(new File(filename));
    }

    public static void plantTree(Plants plants, Park park) {
        Tree tree = plants.getTreeList().get(0).getTree().get(0);
        for (int i = 0; i < tree.getKind().size(); i++) {
            TreeKind kind = tree.getKind().get(i);
            park.addTree(kind, new Point((int) (Math.random() * 10 / 2), (int) (Math.random() * 10 / 2)));
        }
    }

    public static void printInfo(String filename, Park park) throws JAXBException {
        OutputInfo info = new OutputInfo();
        info.setCost(park.getCost());
        info.setCount(park.getCount());

        JAXBContext context = JAXBContext.newInstance(OutputInfo.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(info, new File(filename));
    }
}
