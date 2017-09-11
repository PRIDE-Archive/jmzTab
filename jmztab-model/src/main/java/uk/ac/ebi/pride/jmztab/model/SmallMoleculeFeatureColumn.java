package uk.ac.ebi.pride.jmztab.model;

/**
 * Define the stable columns and optional columns which have stable order in small molecule feature header line.
 *
 * @author nilshoffmann
 * @since 19/09/16
 */
public class SmallMoleculeFeatureColumn extends MZTabColumn {
    SmallMoleculeFeatureColumn(String name, Class columnType, boolean optional, String order) {
        super(name, columnType, optional, order);
    }

    SmallMoleculeFeatureColumn(String name, Class columnType, boolean optional, String order, Integer id) {
        super(name, columnType, optional, order, id);
    }

    //TODO update to actual columns for small molecule feature
    public static SmallMoleculeFeatureColumn IDENTIFIER = new SmallMoleculeFeatureColumn("identifier", SplitList.class, false, "01");
    public static SmallMoleculeFeatureColumn CHEMICAL_FORMULA = new SmallMoleculeFeatureColumn("chemical_formula", String.class, false, "02");
    public static SmallMoleculeFeatureColumn SMILES = new SmallMoleculeFeatureColumn("smiles", SplitList.class, false, "03");
    public static SmallMoleculeFeatureColumn INCHI_KEY = new SmallMoleculeFeatureColumn("inchi_key", SplitList.class, false, "04");
    public static SmallMoleculeFeatureColumn DESCRIPTION = new SmallMoleculeFeatureColumn("description", String.class, false, "05");
    public static SmallMoleculeFeatureColumn EXP_MASS_TO_CHARGE = new SmallMoleculeFeatureColumn("exp_mass_to_charge", Double.class, false, "06");
    public static SmallMoleculeFeatureColumn CALC_MASS_TO_CHARGE = new SmallMoleculeFeatureColumn("calc_mass_to_charge", Double.class, false, "07");
    public static SmallMoleculeFeatureColumn CHARGE = new SmallMoleculeFeatureColumn("charge", Integer.class, false, "08");
    public static SmallMoleculeFeatureColumn RETENTION_TIME = new SmallMoleculeFeatureColumn("retention_time", SplitList.class, false, "09");
    public static SmallMoleculeFeatureColumn TAXID = new SmallMoleculeFeatureColumn("taxid", Integer.class, false, "10");
    public static SmallMoleculeFeatureColumn SPECIES = new SmallMoleculeFeatureColumn("species", String.class, false, "11");
    public static SmallMoleculeFeatureColumn DATABASE = new SmallMoleculeFeatureColumn("database", String.class, false, "12");
    public static SmallMoleculeFeatureColumn DATABASE_VERSION = new SmallMoleculeFeatureColumn("database_version", String.class, false, "13");
    public static SmallMoleculeFeatureColumn RELIABILITY = new SmallMoleculeFeatureColumn("reliability", Reliability.class, true, "14");
    public static SmallMoleculeFeatureColumn URI = new SmallMoleculeFeatureColumn("uri", java.net.URI.class, true, "15");
    public static SmallMoleculeFeatureColumn SPECTRA_REF = new SmallMoleculeFeatureColumn("spectra_ref", SplitList.class, false, "16");
    public static SmallMoleculeFeatureColumn SEARCH_ENGINE = new SmallMoleculeFeatureColumn("search_engine", SplitList.class, false, "17");
    public static SmallMoleculeFeatureColumn BEST_SEARCH_ENGINE_SCORE = new SmallMoleculeFeatureColumn("best_search_engine_score", Double.class, true, "18");
    public static SmallMoleculeFeatureColumn SEARCH_ENGINE_SCORE = new SmallMoleculeFeatureColumn("search_engine_score", Double.class, true, "19");
    public static SmallMoleculeFeatureColumn MODIFICATIONS = new SmallMoleculeFeatureColumn("modifications", SplitList.class, false, "20");
}
