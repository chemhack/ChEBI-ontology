package com.chemhack.ontology.matcher;

import org.openscience.cdk.interfaces.IAtomContainer;

public interface IMatcher {
    public abstract boolean matches(IAtomContainer ac);
}
