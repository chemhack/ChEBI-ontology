package com.chemhack.ontology.extractor;

import chemaxon.formats.MolImporter;
import chemaxon.struc.Molecule;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import gov.nih.ncgc.algo.graph.MultiMCS;


public class ExtractorTest {
    public static void main(String[] args) throws Exception {
        String s = "";
        MolImporter molimporter;
        MultiMCS mcs=new MultiMCS();

        molimporter = new MolImporter(new FileInputStream(new File(System.getProperty("user.dir")+("/src/com/chemhack/ontology/testset/penicillin_positive.sdf"))));
        int i;
        Molecule molecule;
        for(i = 0; (molecule = molimporter.read()) != null; i++){
            mcs.add(molecule);    
        }
        molimporter.close();
        if(!mcs.search())
            throw new Exception("Multiple MCS search fails!");
        Molecule[] cores=mcs.getMaxCores();
        
    }
}
