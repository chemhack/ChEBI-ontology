package com.chemhack.ontology.matcher.logical;

import org.openscience.cdk.interfaces.IAtomContainer;


public class AndMatcher extends LogicalMatcher {
    public boolean matches(IAtomContainer ac) {
        if(children.size()==0){
            throw new RuntimeException("Can not do AND operation on nothing");
        }else{
            boolean result=children.get(0).matches(ac);
            for(int i=1;i<children.size();i++){
                if(result==false){
                    return result;
                }
                result=result&&children.get(i).matches(ac);
            }
            return result;
        }
    }
}
