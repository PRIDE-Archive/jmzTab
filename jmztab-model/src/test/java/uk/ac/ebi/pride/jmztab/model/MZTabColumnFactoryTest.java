package uk.ac.ebi.pride.jmztab.model;

import org.junit.Test;

import java.util.SortedMap;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * @author qingwei
 * @since 29/05/13
 */
public class MZTabColumnFactoryTest {

    @Test
    public void testProteinColumns() throws Exception {
        MZTabColumnFactory factory = MZTabColumnFactory.getInstance(Section.Protein_Header);
        factory.addDefaultStableColumns();

        SortedMap<String, MZTabColumn> stableColumns = factory.getStableColumnMapping();
        SortedMap<String, MZTabColumn> optionalColumns = factory.getOptionalColumnMapping();

        assertEquals(10, stableColumns.size());
        assertEquals(0, optionalColumns.size());
        int optionSize = 0;

        factory.addGoTermsOptionalColumn();
        factory.addReliabilityOptionalColumn();
        factory.addURIOptionalColumn();
        optionSize += 3;
        assertEquals(optionSize, optionalColumns.size());

        MsRun msRun1 = new MsRun(1);
        MsRun msRun2 = new MsRun(2);
        Assay assay1 = new Assay(1);
        StudyVariable studyVariable1 = new StudyVariable(1);
        StudyVariable studyVariable2 = new StudyVariable(2);

        factory.addOptionalColumn(ProteinColumn.NUM_PSMS, msRun1);
        factory.addOptionalColumn(ProteinColumn.NUM_PEPTIDES_DISTINCT, msRun1);
        factory.addOptionalColumn(ProteinColumn.NUM_PEPTIDES_UNIQUE, msRun1);
        optionSize += 3;
        assertEquals(optionSize, optionalColumns.size());

        factory.addOptionalColumn(ProteinColumn.NUM_PSMS, msRun2);
        factory.addOptionalColumn(ProteinColumn.NUM_PEPTIDES_DISTINCT, msRun2);
        optionSize += 2;
        assertEquals(optionSize, optionalColumns.size());

        factory.addBestSearchEngineScoreOptionalColumn(ProteinColumn.BEST_SEARCH_ENGINE_SCORE, 1);
        factory.addSearchEngineScoreOptionalColumn(ProteinColumn.SEARCH_ENGINE_SCORE, 1, msRun1);
        optionSize += 2;
        assertEquals(optionSize, optionalColumns.size());
        System.out.println(factory);

        factory.addAbundanceOptionalColumn(assay1);
        optionSize += 1;
        assertEquals(optionSize, optionalColumns.size());

        factory.addAbundanceOptionalColumn(studyVariable1);
        optionSize += 3;
        assertEquals(optionSize, optionalColumns.size());

        factory.addOptionalColumn(msRun1, "my_value", String.class);
        optionSize += 1;
        assertEquals(optionSize, optionalColumns.size());

        CVParam param = new CVParam("MS", "MS:1002217", "decoy peptide", null);
        factory.addOptionalColumn(param, String.class);
        optionSize += 1;
        assertEquals(optionSize, optionalColumns.size());

        factory.addAbundanceOptionalColumn(studyVariable2);
        optionSize += 3;
        assertEquals(optionSize, optionalColumns.size());

        assertEquals(stableColumns.size() + optionalColumns.size(), factory.getColumnMapping().size());
    }

    /**
     * https://github.com/PRIDE-Utilities/jmzTab/issues/11
     */
    @Test
    public void testOptionalColumnsAndManyRows() {
        Metadata mtd = new Metadata();
        mtd.setMZTabMode(MZTabDescription.Mode.Summary);
        mtd.setMZTabType(MZTabDescription.Type.Quantification);

        MZTabColumnFactory factory = MZTabColumnFactory.getInstance(Section.Small_Molecule);
        factory.addDefaultStableColumns();
        factory.addURIOptionalColumn();
        factory.addBestSearchEngineScoreOptionalColumn(SmallMoleculeColumn.BEST_SEARCH_ENGINE_SCORE, 1);
        int nonAssayColumns = factory.getColumnMapping().size();

        for (int fileCounter = 1; fileCounter <= 50; fileCounter++) {

            MsRun msRun = new MsRun(fileCounter);
            mtd.addMsRun(msRun);
            mtd.addAssayMsRun(fileCounter, msRun);
            Assay assay = mtd.getAssayMap().get(fileCounter);

            factory.addOptionalColumn(assay, "peak_mz", String.class);
            factory.addOptionalColumn(assay, "peak_rt", String.class);
            factory.addOptionalColumn(assay, "peak_height", String.class);

            System.out.println("count: " + fileCounter + " factory: " + factory.toString());
            assertEquals(nonAssayColumns+(fileCounter*3), factory.getColumnMapping().size());
        }
    }
}
