package uk.ac.ebi.pride.jmztab.model;

import java.net.URI;

/**
 * Define the stable columns and optional columns which have stable order in PSM header line.
 *
 * @author qingwei
 * @since 23/05/13
 */
public class PSMColumn<T> extends MZTabColumn<T> {
    PSMColumn(String name, Class<T> columnType, boolean optional, String order) {
        super(name, columnType, optional, order);
    }

    PSMColumn(String name, Class<T> columnType, boolean optional, String order, Integer id) {
        super(name, columnType, optional, order, id);
    }

    public static PSMColumn<String> SEQUENCE = new PSMColumn<>("sequence", String.class, false, "01");
    public static PSMColumn<Integer> PSM_ID = new PSMColumn<>("PSM_ID", Integer.class, false, "02");
    public static PSMColumn<String> ACCESSION = new PSMColumn<>("accession", String.class, false, "03");
    public static PSMColumn<MZBoolean> UNIQUE = new PSMColumn<>("unique", MZBoolean.class, false, "04");
    public static PSMColumn<String> DATABASE = new PSMColumn<>("database", String.class, false, "05");
    public static PSMColumn<String> DATABASE_VERSION = new PSMColumn<>("database_version", String.class, false, "06");
    public static PSMColumn<SplitList> SEARCH_ENGINE = new PSMColumn<>("search_engine", SplitList.class, false, "07");
    public static PSMColumn<Double> SEARCH_ENGINE_SCORE = new PSMColumn<>("search_engine_score", Double.class, true, "08");
    public static PSMColumn<Reliability> RELIABILITY = new PSMColumn<>("reliability", Reliability.class, true, "09");
    public static PSMColumn<SplitList> MODIFICATIONS = new PSMColumn<>("modifications", SplitList.class, false, "10");
    public static PSMColumn<SplitList> RETENTION_TIME = new PSMColumn<>("retention_time", SplitList.class, false, "11");
    public static PSMColumn<Integer> CHARGE = new PSMColumn<>("charge", Integer.class, false, "12");
    public static PSMColumn<Double> EXP_MASS_TO_CHARGE = new PSMColumn<>("exp_mass_to_charge", Double.class, false, "13");
    public static PSMColumn<Double> CALC_MASS_TO_CHARGE = new PSMColumn<>("calc_mass_to_charge", Double.class, false, "14");
    public static PSMColumn<URI> URI = new PSMColumn<>("uri", java.net.URI.class, true, "15");
    public static PSMColumn<SplitList> SPECTRA_REF = new PSMColumn<>("spectra_ref", SplitList.class, false, "16");
    public static PSMColumn<String> PRE = new PSMColumn<>("pre", String.class, false, "17");
    public static PSMColumn<String> POST = new PSMColumn<>("post", String.class, false, "18");
    public static PSMColumn<Integer> START = new PSMColumn<>("start", Integer.class, false, "19");
    public static PSMColumn<Integer> END = new PSMColumn<>("end", Integer.class, false, "20");
}
