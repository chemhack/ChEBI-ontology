package uk.ac.ebi.chebi.ontology.core.matcher.skeleton;

import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.isomorphism.UniversalIsomorphismTester;

/**
 * IMatcher implementation class for Matching substructure pattern
 */
public class SubStructureMatcher extends FragmentMatcher {
    public boolean matches(IAtomContainer ac) {
        boolean isSubStructure = false;
        try {
            //which one is the fastest one?            
            isSubStructure = UniversalIsomorphismTester.isSubgraph(ac, query);
        } catch (CDKException e) {
            e.printStackTrace();
        }
        return isSubStructure;
    }
}
