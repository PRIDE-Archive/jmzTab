package uk.ac.ebi.pride.jmztab.model;

import java.net.URI;

/**
 * Define the stable columns and optional columns which have stable order in small molecule evidence header line.
 *
 * @author nilshoffmann
 * @since 09/11/16
 */
public class SmallMoleculeEvidenceColumn<T> extends MZTabColumn<T> {
    SmallMoleculeEvidenceColumn(String name, Class<T> columnType, boolean optional, String order) {
        super(name, columnType, optional, order);
    }

    SmallMoleculeEvidenceColumn(String name, Class<T> columnType, boolean optional, String order, Integer id) {
        super(name, columnType, optional, order, id);
    }

    public static SmallMoleculeEvidenceColumn<Integer> SME_ID = new SmallMoleculeEvidenceColumn<>("sme_id", Integer.class, false, "01");
    public static SmallMoleculeEvidenceColumn<String> DATABASE_IDENTIFIER = new SmallMoleculeEvidenceColumn<>("database_identifier", String.class, false, "02");
    public static SmallMoleculeEvidenceColumn<String> CHEMICAL_FORMULA = new SmallMoleculeEvidenceColumn<>("chemical_formula", String.class, false, "03");
    public static SmallMoleculeEvidenceColumn<String> INCHI = new SmallMoleculeEvidenceColumn<>("inchi", String.class, false, "04");
    public static SmallMoleculeEvidenceColumn<String> CHEMICAL_NAME = new SmallMoleculeEvidenceColumn<>("chemical_name", String.class, false, "05");
    public static SmallMoleculeEvidenceColumn<SplitList> MODIFICATIONS = new SmallMoleculeEvidenceColumn<>("modifications", SplitList.class, false, "06");
    public static SmallMoleculeEvidenceColumn<Double> EXP_MASS_TO_CHARGE = new SmallMoleculeEvidenceColumn<>("exp_mass_to_charge", Double.class, false, "07");
    public static SmallMoleculeEvidenceColumn<Integer> CHARGE = new SmallMoleculeEvidenceColumn<>("charge", Integer.class, false, "08");
    public static SmallMoleculeEvidenceColumn<Double> CALC_MASS_TO_CHARGE = new SmallMoleculeEvidenceColumn<>("calc_mass_to_charge", Double.class, false, "09");
    public static SmallMoleculeEvidenceColumn<Double> CALC_NEUTRAL_MASS = new SmallMoleculeEvidenceColumn<>("calc_neutral_mass", Double.class, false, "10");
    public static SmallMoleculeEvidenceColumn<URI> URI = new SmallMoleculeEvidenceColumn<>("uri", java.net.URI.class, true, "11");
    public static SmallMoleculeEvidenceColumn<SplitList> IDENTIFICATION_METHOD = new SmallMoleculeEvidenceColumn<>("identification_method", SplitList.class, false, "12");
    public static SmallMoleculeEvidenceColumn<Integer> MS_LEVEL = new SmallMoleculeEvidenceColumn<>("ms_level", Integer.class, false, "13");
    public static SmallMoleculeEvidenceColumn<Integer> RANK = new SmallMoleculeEvidenceColumn<>("rank", Integer.class, false, "14");
    public static SmallMoleculeFeatureColumn<String> ADDUCT_ION = new SmallMoleculeFeatureColumn<>("adduct_ion", String.class, false, "15");

    //TODO smallmolecule_id_confidence_measure[1-n]
}
