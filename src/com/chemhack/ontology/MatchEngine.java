package com.chemhack.ontology;

import com.chemhack.ontology.matcher.FormulaMatcher;
import com.chemhack.ontology.matcher.PropertyMatcher;
import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.aromaticity.CDKHueckelAromaticityDetector;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.iterator.IteratingMDLReader;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MatchEngine {
    public static void main(String[] args) throws FileNotFoundException {
        String[] classNames=new String[]{"hydrocarbon"};
        for(String className : classNames){
            IteratingMDLReader reader=new IteratingMDLReader(new FileReader(System.getProperty("user.dir")+("/src/com/chemhack/ontology/testset/hydrocarbon_negative.sdf")), DefaultChemObjectBuilder.getInstance());
            PropertyMatcher matcher=new FormulaMatcher("OK");
            while(reader.hasNext()){
                IAtomContainer ac= (IAtomContainer) reader.next();
                try {
                    AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(ac);
                    CDKHueckelAromaticityDetector.detectAromaticity(ac);
                    matcher.matches(ac);                    
                } catch (CDKException e) {
                    e.printStackTrace(); 
                }

            }
        }
    }
}