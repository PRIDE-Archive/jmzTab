package uk.ac.ebi.pride.jmztab.model;

/**
 * Every line in an mzTab file MUST start with a three letter code identifying the type of line delimited by
 * a Tab character. The three letter codes are as follows :
 * - MTD for metadata
 * - PRH for the protein table header line (the column labels)
 * - PRT for rows of the protein table
 * - PEH for the peptide table header line (the column labels)
 * - PEP for rows of the peptide table
 * - PSH for the PSM table header (the column labels)
 * - PSM for rows of the PSM table
 * - SMH for small molecule table header line (the column labels)
 * - SML for rows of the small molecule table
 * - COM for comment lines
 *
 * @author qingwei
 * @author jgriss
 * @since 31/01/13
 */
public enum Section {
    Comment                          ("COM", "comment",                  0),
    Metadata                         ("MTD", "metadata",                 1),
    Protein_Header                   ("PRH", "protein_header",           2),
    Protein                          ("PRT", "protein",                  3),
    Peptide_Header                   ("PEH", "peptide_header",           4),
    Peptide                          ("PEP", "peptide",                  5),
    PSM_Header                       ("PSH", "psm_header",               6),
    PSM                              ("PSM", "psm",                      7),
    Small_Molecule_Header            ("SMH", "small_molecule_header",    8),
    Small_Molecule                   ("SML", "small_molecule",           9),
    Small_Molecule_Feature_Header    ("SFH", "small_molecule_feature_header",   10),
    Small_Molecule_Feature           ("SMF", "small_molecule_feature",          11),
    Small_Molecule_Evidence_Header   ("SEH", "small_molecule_evidence_header",   12),
    Small_Molecule_Evidence          ("SME", "small_molecule_evidence",          13);
    

    private String prefix;
    private String name;
    private int level;

    private Section(String prefix, String name, int level) {
        this.prefix = prefix;
        this.name = name;
        this.level = level;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public static Section findSection(int level) {
        switch (level) {
            case 0:
                return Comment;
            case 1:
                return Metadata;
            case 2:
                return Protein_Header;
            case 3:
                return Protein;
            case 4:
                return Peptide_Header;
            case 5:
                return Peptide;
            case 6:
                return PSM_Header;
            case 7:
                return PSM;
            case 8:
                return Small_Molecule_Header;
            case 9:
                return Small_Molecule;
            case 10:
                return Small_Molecule_Feature_Header;
            case 11:
                return Small_Molecule_Feature;
            case 12:
                return Small_Molecule_Evidence_Header;
            case 13:
                return Small_Molecule_Evidence;
            default:
                return null;
        }
    }

    /**
     * Judge the section is comment section or not.
     */
    public boolean isComment() {
        return this == Comment;
    }

    /**
     * Judge the section is metadata section or not.
     */
    public boolean isMetadata() {
        return this == Metadata;
    }

    /**
     * Judge the section is protein_header, peptide_header, psm_header or small_molecule_header section.
     */
    public boolean isHeader() {
        return this == Protein_Header || this == Peptide_Header || this == PSM_Header || this == Small_Molecule_Header || this == Small_Molecule_Feature_Header || this == Small_Molecule_Evidence_Header;
    }

    /**
     * Judge the section is protein, peptide, psm or small_molecule section.
     */
    public boolean isData() {
        return this == Protein || this == Peptide || this == PSM || this == Small_Molecule || this == Small_Molecule_Feature || this == Small_Molecule_Evidence;
    }

    /**
     * Translate the section to corresponding header section. If can not mapping, return null.
     * Metadata, Comment --> null
     * Protein, Protein_Header --> ProteinHeader
     * Peptide, Peptide_Header --> PeptideHeader
     * PSM, PSM_Header --> PSMHeader
     * SmallMolecule, SmallMolecule_Header --> SmallMoleculeHeader
     *
     * @see #toDataSection(Section)
     */
    public static Section toHeaderSection(Section section) {
        switch (section) {
            case Peptide:
            case Peptide_Header:
                return Section.Peptide_Header;
            case Protein:
            case Protein_Header:
                return Section.Protein_Header;
            case PSM:
            case PSM_Header:
                return Section.PSM_Header;
            case Small_Molecule:
            case Small_Molecule_Header:
                return Section.Small_Molecule_Header;
            case Small_Molecule_Feature:
            case Small_Molecule_Feature_Header:
                return Section.Small_Molecule_Feature_Header;
            case Small_Molecule_Evidence:
            case Small_Molecule_Evidence_Header:
                return Section.Small_Molecule_Evidence_Header;
            default:
                return null;
        }
    }

    /**
     * Translate the section to corresponding data section. If can not mapping, return null.
     * Metadata, Comment --> null
     * Protein, Protein_Header --> Protein
     * Peptide, Peptide_Header --> Peptide
     * PSM, PSM_Header --> PSMHeader
     * SmallMolecule, SmallMolecule_Header --> SmallMolecule
     *
     * @see #toHeaderSection(Section)
     */
    public static Section toDataSection(Section section) {
        switch (section) {
            case Peptide:
            case Peptide_Header:
                return Section.Peptide;
            case Protein:
            case Protein_Header:
                return Section.Protein;
            case PSM:
            case PSM_Header:
                return Section.PSM;
            case Small_Molecule:
            case Small_Molecule_Header:
                return Section.Small_Molecule;
            case Small_Molecule_Feature:
            case Small_Molecule_Feature_Header:
                return Section.Small_Molecule_Feature;
            case Small_Molecule_Evidence:
            case Small_Molecule_Evidence_Header:
                return Section.Small_Molecule_Evidence;
            default:
                return null;
        }
    }

    /**
     * Query section based on its name or prefix with case-insensitive. For example:
     * findSection("protein") == findSection("PRT");
     * Both of them to locate the {@link Section#Protein}
     *
     * @param key if empty, return null.
     */
    public static Section findSection(String key) {
        if (MZTabUtils.isEmpty(key)) {
            return null;
        }

        key = key.trim();

        if (key.equalsIgnoreCase(Comment.getName()) || key.equalsIgnoreCase(Comment.getPrefix())) {
            return Comment;
        } else if (key.equalsIgnoreCase(Metadata.getName()) || key.equalsIgnoreCase(Metadata.getPrefix())) {
            return Metadata;
        } else if (key.equalsIgnoreCase(Peptide_Header.getName()) || key.equalsIgnoreCase(Peptide_Header.getPrefix())) {
            return Peptide_Header;
        } else if (key.equalsIgnoreCase(Peptide.getName()) || key.equalsIgnoreCase(Peptide.getPrefix())) {
            return Peptide;
        } else if (key.equalsIgnoreCase(Protein_Header.getName()) || key.equalsIgnoreCase(Protein_Header.getPrefix())) {
            return Protein_Header;
        } else if (key.equalsIgnoreCase(Protein.getName()) || key.equalsIgnoreCase(Protein.getPrefix())) {
            return Protein;
        } else if (key.equalsIgnoreCase(PSM_Header.getName()) || key.equalsIgnoreCase(PSM_Header.getPrefix())) {
            return PSM_Header;
        } else if (key.equalsIgnoreCase(PSM.getName()) || key.equalsIgnoreCase(PSM.getPrefix())) {
            return PSM;
        } else if (key.equalsIgnoreCase(Small_Molecule_Header.getName()) || key.equalsIgnoreCase(Small_Molecule_Header.getPrefix())) {
            return Small_Molecule_Header;
        } else if (key.equalsIgnoreCase(Small_Molecule.getName()) || key.equalsIgnoreCase(Small_Molecule.getPrefix())) {
            return Small_Molecule;
        } else if (key.equalsIgnoreCase(Small_Molecule_Feature_Header.getName()) || key.equalsIgnoreCase(Small_Molecule_Feature_Header.getPrefix())) {
            return Small_Molecule_Feature_Header;
        } else if (key.equalsIgnoreCase(Small_Molecule_Feature.getName()) || key.equalsIgnoreCase(Small_Molecule_Feature.getPrefix())) {
            return Small_Molecule_Feature;
        } else if (key.equalsIgnoreCase(Small_Molecule_Evidence_Header.getName()) || key.equalsIgnoreCase(Small_Molecule_Evidence_Header.getPrefix())) {
            return Small_Molecule_Evidence_Header;
        } else if (key.equalsIgnoreCase(Small_Molecule_Evidence.getName()) || key.equalsIgnoreCase(Small_Molecule_Evidence.getPrefix())) {
            return Small_Molecule_Evidence;
        } else {
            return null;
        }
    }
}
