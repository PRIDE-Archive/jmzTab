package uk.ac.ebi.pride.jmztab.model;

import java.net.URI;

import static uk.ac.ebi.pride.jmztab.model.MZTabConstants.*;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.*;
import static uk.ac.ebi.pride.jmztab.model.SmallMoleculeColumn.SML_ID;

/**
 * The small molecule section is table-based. The small molecule section MUST always come after the metadata section.
 * The small molecule section MUST NOT occur if either peptide or protein sections occur. All table columns MUST be Tab separated.
 * There MUST NOT be any empty cells. Missing values MUST be reported using "null". Most columns are mandatory.
 * The order of columns is not specified although for ease of human interpretation, it is RECOMMENDED to follow the
 * order specified below.
 *
 * @author qingwei
 * @since 23/05/13
 */
public class SmallMolecule extends MZTabRecord {
    private Metadata metadata;

    /**
     * Create a small molecule record based on structure defined by {@link MZTabColumnFactory}
     *
     * @param factory SHOULD NOT set null.
     * @param metadata SHOULD NOT set null.
     */
    public SmallMolecule(MZTabColumnFactory factory, Metadata metadata) {
        super(factory);
        this.metadata = metadata;
    }
    
    public Integer getSmallMoleculeId() {
        return getInteger(SmallMoleculeColumn.SML_ID);
    }
    
    public void setSmallMoleculeId(Integer smlId) {
        setValue(SML_ID, smlId);
    }
    
    public SplitList<Integer> getSmallMoleculeFeatureIdRefs() {
        return getSplitList(SmallMoleculeColumn.SMF_ID_REFS, Integer.class);
    }
    
    public boolean addSmallMoleculeFeatureIdRef(Integer smfIdRef) {
        if (smfIdRef == null) {
            return false;
        }

        SplitList<Integer> identifierList = getSmallMoleculeFeatureIdRefs();
        if (identifierList == null) {
            identifierList = new SplitList<Integer>(BAR);
            setSmallMoleculeFeatureIdRefs(identifierList);
        }
        return identifierList.add(smfIdRef);
    }
    
    public void setSmallMoleculeFeatureIdRefs(SplitList<Integer> smfIdRefs) {
        setValue(SmallMoleculeColumn.SMF_ID_REFS, smfIdRefs);
    }
    
    public void setSmallMoleculeFeatureIdRefs(String smfIdRefsLabel) {
        setIdentifier(parseStringList(BAR, smfIdRefsLabel));
    }

    /**
     * A list of "|" separated possible identifiers for these small molecules. The database identifier
     * must be preceded by the resource description followed by a colon (in case this is not already part
     * of the identifier format).
     */
    public SplitList<String> getIdentifier() {
        return getSplitList(SmallMoleculeColumn.DATABASE_IDENTIFIER, String.class);
    }

    /**
     * A list of "|" separated possible identifiers for these small molecules. The database identifier
     * must be preceded by the resource description followed by a colon (in case this is not already part
     * of the identifier format).
     */
    public boolean addIdentifier(String identifier) {
        if (isEmpty(identifier)) {
            return false;
        }

        SplitList<String> identifierList = getIdentifier();
        if (identifierList == null) {
            identifierList = new SplitList<String>(BAR);
            setIdentifier(identifierList);
        }
        return identifierList.add(identifier);
    }

    /**
     * A list of "|" separated possible identifiers for these small molecules. The database identifier
     * must be preceded by the resource description followed by a colon (in case this is not already part
     * of the identifier format).
     */
    public void setIdentifier(SplitList<String> identifier) {
        setValue(SmallMoleculeColumn.DATABASE_IDENTIFIER, identifier);
    }

    /**
     * A list of "|" separated possible identifiers for these small molecules. The database identifier
     * must be preceded by the resource description followed by a colon (in case this is not already part
     * of the identifier format).
     *
     * @param identifierLabel parsed by {@link MZTabUtils#parseStringList(char, String)}
     */
    public void setIdentifier(String identifierLabel) {
        setIdentifier(parseStringList(BAR, identifierLabel));
    }

    /**
     * The chemical formula of the identified compound. This should be specified in Hill notation (EA Hill 1900),
     * i.e. elements in the order C, H and then alphabetically all other elements. Counts of one may be omitted.
     * Elements should be capitalized properly to avoid confusion (e.g., "CO" vs. "Co"). The chemical formula
     * reported should refer to the neutral form. Charge state is reported by the charge field. This permits the
     * comparison of positive and negative mode results.
     */
    public String getChemicalFormula() {
        return getString(SmallMoleculeColumn.CHEMICAL_FORMULA);
    }

    /**
     * The chemical formula of the identified compound. This should be specified in Hill notation (EA Hill 1900),
     * i.e. elements in the order C, H and then alphabetically all other elements. Counts of one may be omitted.
     * Elements should be capitalized properly to avoid confusion (e.g., "CO" vs. "Co"). The chemical formula
     * reported should refer to the neutral form. Charge state is reported by the charge field. This permits the
     * comparison of positive and negative mode results.
     */
    public void setChemicalFormula(String chemicalFormula) {
        setValue(SmallMoleculeColumn.CHEMICAL_FORMULA, parseString(chemicalFormula));
    }

    /**
     * The molecules structure in the simplified molecular-input line-entry system (SMILES). If there are more than
     * one SMILES for a given small molecule, use the  "|" separator.
     */
    public SplitList<String> getSmiles() {
        return getSplitList(SmallMoleculeColumn.SMILES, String.class);
    }

    /**
     * The molecules structure in the simplified molecular-input line-entry system (SMILES). If there are more than
     * one SMILES for a given small molecule, use the  "|" separator.
     */
    public boolean addSmile(String smile) {
        if (smile == null) {
            return false;
        }

        SplitList<String> smiles = getSmiles();
        if (smiles == null) {
            smiles = new SplitList<String>(BAR);
            setSmiles(smiles);
        }

        return smiles.add(smile);
    }

    /**
     * The molecules structure in the simplified molecular-input line-entry system (SMILES). If there are more than
     * one SMILES for a given small molecule, use the  "|" separator.
     */
    public void setSmiles(String smilesLabel) {
        setSmiles(parseStringList(BAR, smilesLabel));
    }

    /**
     * The molecules structure in the simplified molecular-input line-entry system (SMILES). If there are more than
     * one SMILES for a given small molecule, use the  "|" separator.
     */
    public void setSmiles(SplitList<String> smiles) {
        setValue(SmallMoleculeColumn.SMILES, smiles);
    }
    
    /* TODO add / update the following columns for SmallMolecule
    public static SmallMoleculeColumn INCHI = new SmallMoleculeColumn("inchi", SplitList.class, false, "06");
    public static SmallMoleculeColumn THEORETICAL_NEUTRAL_MASS = new SmallMoleculeColumn("theoretical_neutral_mass", Double.class, true, "08");
    public static SmallMoleculeColumn RETENTION_TIME = new SmallMoleculeColumn("retention_time", Double.class, true, "10");
    public static SmallMoleculeColumn ADDUCT_IONS = new SmallMoleculeColumn("adduct_ions", SplitList.class, true, "11");
    public static SmallMoleculeColumn RELIABILITY = new SmallMoleculeColumn("reliability", Reliability.class, false, "12");
    public static SmallMoleculeColumn URI = new SmallMoleculeColumn("uri", java.net.URI.class, true, "13");
    public static SmallMoleculeColumn BEST_SEARCH_ENGINE = new SmallMoleculeColumn("search_engine", CVParam.class, true, "14");
    public static SmallMoleculeColumn BEST_SEARCH_ENGINE_SCORE = new SmallMoleculeColumn("best_search_engine_score", Double.class, true, "15");
    */
    
    /**
     * The standard IUPAC International Chemical Identifier (InChI) Key of the given substance. If there are more than
     * one InChI identifier for a given small molecule, use the  "|" separator.
     */
    public SplitList<String> getInchiKey() {
        return getSplitList(SmallMoleculeColumn.INCHI, String.class);
    }

    /**
     * The standard IUPAC International Chemical Identifier (InChI) Key of the given substance. If there are more than
     * one InChI identifier for a given small molecule, use the  "|" separator.
     */
    public boolean addInchiKey(String inchiKey) {
        if (inchiKey == null) {
            return false;
        }

        SplitList<String> inchiKeys = getInchiKey();
        if (inchiKeys == null) {
            inchiKeys = new SplitList<String>(BAR);
            setInchiKey(inchiKeys);
        }

        return inchiKeys.add(inchiKey);
    }
    /**
     * The standard IUPAC International Chemical Identifier (InChI) Key of the given substance. If there are more than
     * one InChI identifier for a given small molecule, use the  "|" separator.
     */
    public void setInchiKey(String inchiKeyLabel) {
        setValue(SmallMoleculeColumn.INCHI, parseStringList(BAR, inchiKeyLabel));
    }

    /**
     * The standard IUPAC International Chemical Identifier (InChI) Key of the given substance. If there are more than
     * one InChI identifier for a given small molecule, use the  "|" separator.
     */
    public void setInchiKey(SplitList<String> inchiKey) {
        setValue(SmallMoleculeColumn.INCHI, inchiKey);
    }

    /**
     * The small molecule's description / name.
     */
    public String getDescription() {
        return getString(SmallMoleculeColumn.DESCRIPTION);
    }

    /**
     * The small molecule's description / name.
     */
    public void setDescription(String description) {
        setValue(SmallMoleculeColumn.DESCRIPTION, parseString(description));
    }

    /**
     * The small molecule's experimental mass to charge (m/z).
     */
    public Double getExpMassToCharge() {
        return getDouble(SmallMoleculeColumn.EXP_MASS_TO_CHARGE);
    }

    /**
     * The small molecule's experimental mass to charge (m/z).
     */
    public void setExpMassToCharge(Double expMassToCharge) {
        setValue(SmallMoleculeColumn.EXP_MASS_TO_CHARGE, expMassToCharge);
    }

    /**
     * The small molecule's experimental mass to charge (m/z).
     *
     * @param expMassToChargeLabel parsed by {@link MZTabUtils#parseDouble(String)}
     */
    public void setExpMassToCharge(String expMassToChargeLabel) {
        setExpMassToCharge(parseDouble(expMassToChargeLabel));
    }

    /**
     * A '|'-separated list of time points. Semantics may vary. This time should refer to the small molecule's
     * retention time if determined or the mid point between the first and last spectrum identifying the small molecule.
     * It MUST be reported in seconds. Otherwise, the corresponding unit MUST be specified in the Metadata Section
     * ('columnit_smallmolecule').
     */
    public SplitList<Double> getRetentionTime() {
        return getSplitList(SmallMoleculeColumn.RETENTION_TIME, Double.class);
    }

    /**
     * A '|'-separated list of time points. Semantics may vary. This time should refer to the small molecule's
     * retention time if determined or the mid point between the first and last spectrum identifying the small molecule.
     * It MUST be reported in seconds. Otherwise, the corresponding unit MUST be specified in the Metadata Section
     * ('columnit_smallmolecule').
     */
    public boolean addRetentionTime(Double rt) {
        if (rt == null) {
            return false;
        }

        SplitList<Double> rtList = getRetentionTime();
        if (rtList == null) {
            rtList = new SplitList<Double>(BAR);
            setRetentionTime(rtList);
        }

        return rtList.add(rt);
    }

    /**
     * A '|'-separated list of time points. Semantics may vary. This time should refer to the small molecule's
     * retention time if determined or the mid point between the first and last spectrum identifying the small molecule.
     * It MUST be reported in seconds. Otherwise, the corresponding unit MUST be specified in the Metadata Section
     * ('columnit_smallmolecule').
     *
     * @param rtLabel parsed by {@link MZTabUtils#parseDouble(String)}
     */
    public boolean addRetentionTime(String rtLabel) {
        return !isEmpty(rtLabel) && addRetentionTime(parseDouble(rtLabel));
    }

    /**
     * A '|'-separated list of time points. Semantics may vary. This time should refer to the small molecule's
     * retention time if determined or the mid point between the first and last spectrum identifying the small molecule.
     * It MUST be reported in seconds. Otherwise, the corresponding unit MUST be specified in the Metadata Section
     * ('columnit_smallmolecule').
     */
    public void setRetentionTime(SplitList<Double> retentionTime) {
        setValue(SmallMoleculeColumn.RETENTION_TIME, retentionTime);
    }

    /**
     * A '|'-separated list of time points. Semantics may vary. This time should refer to the small molecule's
     * retention time if determined or the mid point between the first and last spectrum identifying the small molecule.
     * It MUST be reported in seconds. Otherwise, the corresponding unit MUST be specified in the Metadata Section
     * ('columnit_smallmolecule').
     *
     * @param retentionTimeLabel parsed by {@link MZTabUtils#parseDoubleList(String)}
     */
    public void setRetentionTime(String retentionTimeLabel) {
        setRetentionTime(parseDoubleList(retentionTimeLabel));
    }

    /**
     * The reliability of the given small molecule identification. This must be supplied by the resource
     * and has to be one of the following values:
     * <ol>
     *     <li>high reliability</li>
     *     <li>medium reliability</li>
     *     <li>poor reliability</li>
     * </ol>
     */
    public Reliability getReliability() {
        return getReliability(SmallMoleculeColumn.RELIABILITY);
    }

    /**
     * The reliability of the given small molecule identification. This must be supplied by the resource
     * and has to be one of the following values:
     * <ol>
     *     <li>high reliability</li>
     *     <li>medium reliability</li>
     *     <li>poor reliability</li>
     * </ol>
     *
     * @see Reliability
     */
    public void setReliability(Reliability reliability) {
        setValue(SmallMoleculeColumn.RELIABILITY, reliability);
    }

    /**
     * The reliability of the given small molecule identification. This must be supplied by the resource
     * and has to be one of the following values:
     * <ol>
     *     <li>high reliability</li>
     *     <li>medium reliability</li>
     *     <li>poor reliability</li>
     * </ol>
     *
     * @param reliabilityLabel parsed by {@link Reliability#findReliability(String)}
     *
     * @see Reliability
     */
    public void setReliability(String reliabilityLabel) {
        setReliability(Reliability.findReliability(reliabilityLabel));
    }

    /**
     * A URI pointing to the small molecule's entry in the experiment it was identified in (e.g.,
     * the small molecule's PRIDE entry).
     */
    public URI getURI() {
        return getURI(SmallMoleculeColumn.URI);
    }

    /**
     * A URI pointing to the small molecule's entry in the experiment it was identified in (e.g.,
     * the small molecule's PRIDE entry).
     */
    public void setURI(URI uri) {
        setValue(SmallMoleculeColumn.URI, uri);
    }

    /**
     * A URI pointing to the small molecule's entry in the experiment it was identified in (e.g.,
     * the small molecule's PRIDE entry).
     *
     * @param uriLabel parsed by {@link MZTabUtils#parseURI(String)}
     */
    public void setURI(String uriLabel) {
        setURI(parseURI(uriLabel));
    }

    /**
     * The best search engine score (for this type of score) for the given protein across
     * all replicates reported. The type of score MUST be defined in the metadata section.
     * If the protein was not identified by the specified search engine “null” must be reported
     *
     * @param id search_engine_score[id] which MUST be defined in the metadata section.
     */
    public Double getBestSearchEngineScore(Integer id) {
        return getDouble(getLogicalPosition(SmallMoleculeColumn.BEST_SEARCH_ENGINE_SCORE, id, null));
    }


    /**
     * The best search engine score (for this type of score) for the given protein across
     * all replicates reported. The type of score MUST be defined in the metadata section.
     * If the protein was not identified by the specified search engine “null” must be reported
     *
     * @param id search_engine_score[id] which MUST be defined in the metadata section.
     */
    public void setBestSearchEngineScore(Integer id, Double bestSearchEngineScore) {
        setValue(getLogicalPosition(SmallMoleculeColumn.BEST_SEARCH_ENGINE_SCORE, id, null), bestSearchEngineScore);
    }

    /**
     * The best search engine score (for this type of score) for the given protein across
     * all replicates reported. The type of score MUST be defined in the metadata section.
     * If the protein was not identified by the specified search engine “null” must be reported
     *
     * @param id search_engine_score[id] which MUST be defined in the metadata section.
     */
    public void setBestSearchEngineScore(Integer id, String searchEngineScoreLabel) {
        setBestSearchEngineScore(id, parseDouble(searchEngineScoreLabel));
    }

    /**
     * Print small molecule record to a tab-split string.
     *
     * SML  value1  value2  value3  ...
     */
    @Override
    public String toString() {
        return Section.Small_Molecule.getPrefix() + TAB + super.toString();
    }
}
