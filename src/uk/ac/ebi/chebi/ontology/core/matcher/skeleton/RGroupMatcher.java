package uk.ac.ebi.chebi.ontology.core.matcher.skeleton;

import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.isomorphism.UniversalIsomorphismTester;
import org.openscience.cdk.isomorphism.matchers.IQueryAtomContainer;
import org.openscience.cdk.isomorphism.matchers.QueryAtomContainerCreator;

/**
 * IMatcher implementation class for Matching R-Group pattern
 */
public class RGroupMatcher extends FragmentMatcher {
    public boolean matches(IAtomContainer ac) {
        boolean isSubStructure = false;
        try {
            //which one is the fastest one?
            IQueryAtomContainer queryAtomContainer = QueryAtomContainerCreator.createAnyAtomForPseudoAtomQueryContainer(query);
            isSubStructure = UniversalIsomorphismTester.isSubgraph(ac, queryAtomContainer);
        } catch (CDKException e) {
            e.printStackTrace();
        }
        return isSubStructure;
    }
}
