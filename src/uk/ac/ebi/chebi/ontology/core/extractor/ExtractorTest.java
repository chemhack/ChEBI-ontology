package uk.ac.ebi.chebi.ontology.core.extractor;

import chemaxon.formats.MolImporter;
import chemaxon.struc.Molecule;

import java.io.File;
import java.io.FileInputStream;

import gov.nih.ncgc.algo.graph.MultiMCS;


public class ExtractorTest {
    public static void main(String[] args) throws Exception {
        MolImporter molimporter;
        MultiMCS mcs=new MultiMCS();
        molimporter = new MolImporter(new FileInputStream(new File(System.getProperty("user.dir")+("/src/uk/ac/ebi/chebi/ontology/core/testset/penicillin_positive.sdf"))));
        Molecule molecule;
        for(int i = 0; (molecule = molimporter.read()) != null; i++){
            mcs.add(molecule);    
        }
        molimporter.close();
        if(!mcs.search())
            throw new Exception("Multiple MCS search fails!");
        Molecule[] cores=mcs.getMaxCores();
    }
}
