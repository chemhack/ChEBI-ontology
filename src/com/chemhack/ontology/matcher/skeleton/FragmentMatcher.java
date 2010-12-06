package com.chemhack.ontology.matcher.skeleton;

import com.chemhack.ontology.matcher.IMatcher;
import org.openscience.cdk.AtomContainer;
import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.aromaticity.CDKHueckelAromaticityDetector;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.MDLReader;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import java.io.StringReader;

public abstract class FragmentMatcher implements IMatcher {
    IAtomContainer query;

    public void readQueryStructure(String fileFormat, String queryString) {
        if (fileFormat.equals("mofile")) {
            MDLReader reader = new MDLReader(new StringReader(queryString));
            try {
                query = (IAtomContainer) reader.read(new AtomContainer());
                AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(query);
                CDKHueckelAromaticityDetector.detectAromaticity(query);
            } catch (CDKException e) {
                e.printStackTrace();
            }
        } else if (fileFormat.equals("smiles")) {
            SmilesParser parser = new SmilesParser(DefaultChemObjectBuilder.getInstance());
            try {
                query = parser.parseSmiles(queryString);
            } catch (InvalidSmilesException e) {
                e.printStackTrace();
            }
        }
    }
}
