package uk.ac.ebi.pride.jmztab.model;

import java.net.URI;

/**
 * Define the stable columns and optional columns which have stable order in peptide header line.
 *
 * @author qingwei
 * @since 23/05/13
 */
public class PeptideColumn<T> extends MZTabColumn<T> {
    PeptideColumn(String name, Class<T> columnType, boolean optional, String order) {
        super(name, columnType, optional, order);
    }

    PeptideColumn(String name, Class<T> columnType, boolean optional, String order, Integer id) {
        super(name, columnType, optional, order, id);
    }

    public static PeptideColumn<String> SEQUENCE = new PeptideColumn<>("sequence", String.class, false, "01");
    public static PeptideColumn<String> ACCESSION = new PeptideColumn<>("accession", String.class, false, "02");
    public static PeptideColumn<MZBoolean> UNIQUE = new PeptideColumn<>("unique", MZBoolean.class, false, "03");
    public static PeptideColumn<String> DATABASE = new PeptideColumn<>("database", String.class, false, "04");
    public static PeptideColumn<String> DATABASE_VERSION = new PeptideColumn<>("database_version", String.class, false, "05");
    public static PeptideColumn<SplitList> SEARCH_ENGINE = new PeptideColumn<>("search_engine", SplitList.class, false, "06");
    public static PeptideColumn<Double> BEST_SEARCH_ENGINE_SCORE = new PeptideColumn<>("best_search_engine_score", Double.class, true, "07");
    public static PeptideColumn<Double> SEARCH_ENGINE_SCORE = new PeptideColumn<>("search_engine_score", Double.class, true, "08");
    public static PeptideColumn<Reliability> RELIABILITY = new PeptideColumn<>("reliability", Reliability.class, true, "09");
    public static PeptideColumn<SplitList> MODIFICATIONS = new PeptideColumn<>("modifications", SplitList.class, false, "10");
    public static PeptideColumn<SplitList> RETENTION_TIME = new PeptideColumn<>("retention_time", SplitList.class, false, "11");
    public static PeptideColumn<SplitList> RETENTION_TIME_WINDOW = new PeptideColumn<>("retention_time_window", SplitList.class, false, "12");
    public static PeptideColumn<Integer> CHARGE = new PeptideColumn<>("charge", Integer.class, false, "13");
    public static PeptideColumn<Double> MASS_TO_CHARGE = new PeptideColumn<>("mass_to_charge", Double.class, false, "14");
    public static PeptideColumn<URI> URI = new PeptideColumn<>("uri", java.net.URI.class, true, "15");
    public static PeptideColumn<SplitList> SPECTRA_REF = new PeptideColumn<>("spectra_ref", SplitList.class, false, "16");
}
