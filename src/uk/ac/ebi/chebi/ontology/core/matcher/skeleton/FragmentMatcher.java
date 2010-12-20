package uk.ac.ebi.chebi.ontology.core.matcher.skeleton;

import uk.ac.ebi.chebi.ontology.core.matcher.IMatcher;
import org.openscience.cdk.ChemFile;
import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.aromaticity.CDKHueckelAromaticityDetector;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.interfaces.IChemModel;
import org.openscience.cdk.io.MDLReader;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import java.io.StringReader;

public abstract class FragmentMatcher implements IMatcher {
    IAtomContainer query;

    public void readQueryStructure(String fileFormat, String queryString) {
        if (fileFormat.equals("molfile")) {
            MDLReader reader = new MDLReader(new StringReader(queryString));
            try {
                ChemFile chemFile = (ChemFile) reader.read(new ChemFile());
                IChemModel model = chemFile.getChemSequence(0).getChemModel(0);
                query = model.getMoleculeSet().getAtomContainer(0);
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
