package com.chemhack.ontology.matcher.skeleton;

import org.openscience.cdk.interfaces.IAtomContainer;

/**
 * IMatcher implementation class for Matching R-Group pattern
 */
public class RGroupMatcher extends FragmentMatcher {
    public boolean matches(IAtomContainer ac) {
        return false;
    }
}
