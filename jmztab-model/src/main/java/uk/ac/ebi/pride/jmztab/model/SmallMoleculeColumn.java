package uk.ac.ebi.pride.jmztab.model;

import java.net.URI;

/**
 * Define the stable columns and optional columns which have stable order in small molecule header line.
 *
 * @author qingwei
 * @since 23/05/13
 */
public class SmallMoleculeColumn<T> extends MZTabColumn<T> {
    SmallMoleculeColumn(String name, Class<T> columnType, boolean optional, String order) {
        super(name, columnType, optional, order);
    }

    SmallMoleculeColumn(String name, Class<T> columnType, boolean optional, String order, Integer id) {
        super(name, columnType, optional, order, id);
    }

    public static SmallMoleculeColumn<Integer> SML_ID = new SmallMoleculeColumn<>("sml_id", Integer.class, false, "01");
    public static SmallMoleculeColumn<SplitList> SMF_ID_REFS = new SmallMoleculeColumn<>("smf_id_refs", SplitList.class, true, "02");
    public static SmallMoleculeColumn<SplitList> DATABASE_IDENTIFIER = new SmallMoleculeColumn<>("database_identifier", SplitList.class, false, "03");
    public static SmallMoleculeColumn<String> CHEMICAL_FORMULA = new SmallMoleculeColumn<>("chemical_formula", String.class, false, "04");
    public static SmallMoleculeColumn<SplitList> SMILES = new SmallMoleculeColumn<>("smiles", SplitList.class, false, "05");
    public static SmallMoleculeColumn<SplitList> INCHI = new SmallMoleculeColumn<>("inchi", SplitList.class, false, "06");
    public static SmallMoleculeColumn<SplitList> CHEMICAL_NAME = new SmallMoleculeColumn<>("chemical_name", SplitList.class, false, "07");
    public static SmallMoleculeColumn<String> DESCRIPTION = new SmallMoleculeColumn<>("description", String.class, false, "08");
    public static SmallMoleculeColumn<SplitList> THEORETICAL_NEUTRAL_MASS = new SmallMoleculeColumn<>("theoretical_neutral_mass", SplitList.class, true, "09");
    public static SmallMoleculeColumn<Double> EXP_MASS_TO_CHARGE = new SmallMoleculeColumn<>("exp_mass_to_charge", Double.class, false, "10");
    public static SmallMoleculeColumn<Double> RETENTION_TIME = new SmallMoleculeColumn<>("retention_time", Double.class, true, "11");
    public static SmallMoleculeColumn<SplitList> ADDUCT_IONS = new SmallMoleculeColumn<>("adduct_ions", SplitList.class, true, "12");
    public static SmallMoleculeColumn<Reliability> RELIABILITY = new SmallMoleculeColumn<>("reliability", Reliability.class, false, "13");
    public static SmallMoleculeColumn<SplitList> URI = new SmallMoleculeColumn<>("uri", SplitList.class, true, "14");
    public static SmallMoleculeColumn<Param> BEST_SEARCH_ENGINE = new SmallMoleculeColumn<>("search_engine", Param.class, true, "15");
    
    //TODO best_smallmolecule_id_confidence_measure[1_n] 
    //TODO smallmolecule_abundance_assay[1-n] 
    //TODO smallmolecule_abundance_study_variable[1-n] 
    //TODO smallmolecule_abundance_coeffvar_study_variable [1-n] 

}
