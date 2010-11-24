package com.chemhack.ontology.testset;

import com.chemhack.ontology.matcher.FormulaMatcher;
import com.chemhack.ontology.matcher.PropertyMatcher;
import junit.framework.TestCase;
import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.aromaticity.CDKHueckelAromaticityDetector;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.iterator.IteratingMDLReader;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
* Abstract class for testing ontology classification.
*/
public abstract class OntologyTest extends TestCase {
    protected void testMatch(String fileName,boolean isMatch){
        IteratingMDLReader reader= null;
        try {
            reader = new IteratingMDLReader(new FileReader(System.getProperty("user.dir")+("/src/com/chemhack/ontology/testset/"+fileName+(isMatch?"_positive":"_negative")+".sdf")), DefaultChemObjectBuilder.getInstance());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PropertyMatcher matcher=new FormulaMatcher("OK");
        while(reader.hasNext()){
            IAtomContainer ac= (IAtomContainer) reader.next();
            try {
                AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(ac);
                CDKHueckelAromaticityDetector.detectAromaticity(ac);
                assertEquals(matcher.matches(ac),isMatch);
            } catch (CDKException e) {
                e.printStackTrace();
            }
        }                    
    }
    void testPositive(String fileName){
        testMatch(fileName,true);
    }
    void testNegative(String fileName){
        testMatch(fileName,false);    
    }
}
