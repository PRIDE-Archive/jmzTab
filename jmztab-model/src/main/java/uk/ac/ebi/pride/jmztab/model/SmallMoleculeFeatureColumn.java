package uk.ac.ebi.pride.jmztab.model;

/**
 * Define the stable columns and optional columns which have stable order in small molecule feature header line.
 *
 * @author nilshoffmann
 * @since 19/09/16
 */
public class SmallMoleculeFeatureColumn<T> extends MZTabColumn<T> {
    SmallMoleculeFeatureColumn(String name, Class<T> columnType, boolean optional, String order) {
        super(name, columnType, optional, order);
    }

    SmallMoleculeFeatureColumn(String name, Class<T> columnType, boolean optional, String order, Integer id) {
        super(name, columnType, optional, order, id);
    }
    
    public static SmallMoleculeFeatureColumn<Integer> SMF_ID = new SmallMoleculeFeatureColumn<>("smf_id", Integer.class, false, "01");
    public static SmallMoleculeFeatureColumn<SplitList> SME_ID_REFS = new SmallMoleculeFeatureColumn<>("sme_id_refs", SplitList.class, false, "02");
    public static SmallMoleculeFeatureColumn<Integer> SME_ID_REF_AMBIGUITY_CODE = new SmallMoleculeFeatureColumn<>("sme_id_ref_ambiguity_code", Integer.class, false, "03");
    public static SmallMoleculeFeatureColumn<Integer> CHARGE = new SmallMoleculeFeatureColumn<>("charge", Integer.class, false, "04");
    public static SmallMoleculeFeatureColumn<SplitList> MODIFICATIONS = new SmallMoleculeFeatureColumn<>("modifications", SplitList.class, false, "05");
    public static SmallMoleculeFeatureColumn<String> ADDUCT_ION = new SmallMoleculeFeatureColumn<>("adduct_ion", String.class, false, "06");
    public static SmallMoleculeFeatureColumn<Double> EXP_MASS_TO_CHARGE = new SmallMoleculeFeatureColumn<>("exp_mass_to_charge", Double.class, false, "07");
    public static SmallMoleculeFeatureColumn<SplitList> RETENTION_TIME = new SmallMoleculeFeatureColumn<>("retention_time", SplitList.class, false, "08");
    public static SmallMoleculeFeatureColumn<Double> RETENTION_TIME_START = new SmallMoleculeFeatureColumn<>("retention_time_start", Double.class, false, "09");
    public static SmallMoleculeFeatureColumn<Double> RETENTION_TIME_END = new SmallMoleculeFeatureColumn<>("retention_time_end", Double.class, false, "10");

    //TODO smf_abundance_assay[1-n] 
}
