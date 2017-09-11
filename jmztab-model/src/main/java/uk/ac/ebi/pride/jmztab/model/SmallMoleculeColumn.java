package uk.ac.ebi.pride.jmztab.model;

/**
 * Define the stable columns and optional columns which have stable order in small molecule header line.
 *
 * @author qingwei
 * @since 23/05/13
 */
public class SmallMoleculeColumn extends MZTabColumn {
    SmallMoleculeColumn(String name, Class columnType, boolean optional, String order) {
        super(name, columnType, optional, order);
    }

    SmallMoleculeColumn(String name, Class columnType, boolean optional, String order, Integer id) {
        super(name, columnType, optional, order, id);
    }

    public static SmallMoleculeColumn SML_ID = new SmallMoleculeColumn("sml_id", Integer.class, false, "01");
    public static SmallMoleculeColumn SMF_ID_REFS = new SmallMoleculeColumn("smf_id_refs", SplitList.class, true, "02");
    public static SmallMoleculeColumn IDENTIFIER = new SmallMoleculeColumn("identifier", SplitList.class, false, "03");
    public static SmallMoleculeColumn CHEMICAL_FORMULA = new SmallMoleculeColumn("chemical_formula", String.class, false, "04");
    public static SmallMoleculeColumn SMILES = new SmallMoleculeColumn("smiles", SplitList.class, false, "05");
    public static SmallMoleculeColumn INCHI = new SmallMoleculeColumn("inchi", SplitList.class, false, "06");
    public static SmallMoleculeColumn DESCRIPTION = new SmallMoleculeColumn("description", String.class, false, "07");
    public static SmallMoleculeColumn THEORETICAL_NEUTRAL_MASS = new SmallMoleculeColumn("theoretical_neutral_mass", Double.class, true, "08");
    public static SmallMoleculeColumn EXP_MASS_TO_CHARGE = new SmallMoleculeColumn("exp_mass_to_charge", Double.class, false, "09");
    public static SmallMoleculeColumn RETENTION_TIME = new SmallMoleculeColumn("retention_time", Double.class, true, "10");
    public static SmallMoleculeColumn ADDUCT_IONS = new SmallMoleculeColumn("adduct_ions", SplitList.class, true, "11");
    public static SmallMoleculeColumn RELIABILITY = new SmallMoleculeColumn("reliability", Reliability.class, false, "12");
    public static SmallMoleculeColumn URI = new SmallMoleculeColumn("uri", java.net.URI.class, true, "13");
    public static SmallMoleculeColumn BEST_SEARCH_ENGINE = new SmallMoleculeColumn("search_engine", CVParam.class, true, "14");
    public static SmallMoleculeColumn BEST_SEARCH_ENGINE_SCORE = new SmallMoleculeColumn("best_search_engine_score", Double.class, true, "15");
}
