package uk.ac.ebi.chebi.ontology.core.matcher;

import org.openscience.cdk.interfaces.IAtomContainer;

public interface IMatcher {
    public abstract boolean matches(IAtomContainer ac);
}
