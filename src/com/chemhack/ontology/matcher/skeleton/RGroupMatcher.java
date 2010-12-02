package com.chemhack.ontology.matcher.skeleton;

import org.openscience.cdk.Molecule;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.MDLV2000Reader;

import java.io.StringReader;

/**
 * IMatcher implementation class for Matching R-Group pattern
 */
public class RGroupMatcher extends FragmentMatcher {
    IAtomContainer ac=null;
    public boolean matches(IAtomContainer ac) {
        return false;
    }
    public void readRGFile(String content){
        MDLV2000Reader reader=new MDLV2000Reader(new StringReader(content));

        try {
            ac=reader.read(new Molecule());
        } catch (CDKException e) {
            e.printStackTrace();
        }

//        RGroupQueryReader reader=new RGroupQueryReader(new StringReader(content));
//        RGroupQuery rGroupQuery=null;
//        try {
//            rGroupQuery = (RGroupQuery)reader.read(new RGroupQuery());
//        } catch (CDKException e) {
//            e.printStackTrace();
//        }
        
    }
}
