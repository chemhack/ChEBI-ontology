package uk.ac.ebi.chebi.ontology.core.matcher.logical;

import uk.ac.ebi.chebi.ontology.core.matcher.IMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Base class for matching AND and OR operation.
 */
public abstract class LogicalMatcher implements IMatcher {
    protected List<IMatcher> children=new ArrayList<IMatcher>();
    
    public boolean addChild(IMatcher iMatcher) {
        return children.add(iMatcher);
    }

    public boolean addAll(Collection<? extends IMatcher> c) {
        return children.addAll(c);
    }

    public boolean removeChild(IMatcher o) {
        return children.remove(o);
    }

    public int countChildren() {
        return children.size();
    }

}
