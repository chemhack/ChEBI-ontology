package com.chemhack.ontology.matcher;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.interfaces.IElement;
import org.openscience.cdk.interfaces.IMolecularFormula;
import org.openscience.cdk.tools.CDKHydrogenAdder;
import org.openscience.cdk.tools.manipulator.MolecularFormulaManipulator;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormulaMatcher extends PropertyMatcher {
    public FormulaMatcher(String pattern){
        
    }

    public boolean matches(IAtomContainer ac) {
        IMolecularFormula formula=getFormulaWithH(ac);
        Map<String,Integer> elementCountMap=this.countElements(formula);
        return false;
    }

    private IMolecularFormula getFormulaWithH(IAtomContainer ac) {
        IMolecularFormula formula=null;
        try {
            IAtomContainer clone= (IAtomContainer) ac.clone();
            CDKHydrogenAdder ha = CDKHydrogenAdder.getInstance(DefaultChemObjectBuilder.getInstance());
            ha.addImplicitHydrogens(clone);
            AtomContainerManipulator.convertImplicitToExplicitHydrogens(clone);
            formula= MolecularFormulaManipulator.getMolecularFormula(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (CDKException e) {
            e.printStackTrace();
        }
        return formula;
    }

    private Map<String,Integer> countElements(IMolecularFormula formula){
        List<IElement> elements=MolecularFormulaManipulator.elements(formula);
        Map<String,Integer> map=new HashMap<String, Integer>();
        for(IElement element : elements){
            map.put(element.getSymbol(),MolecularFormulaManipulator.getElementCount(formula,element));
        }
        return map;
    }
    
}
