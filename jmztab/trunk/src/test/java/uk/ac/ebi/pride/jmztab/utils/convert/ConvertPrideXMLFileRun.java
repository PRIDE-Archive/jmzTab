package uk.ac.ebi.pride.jmztab.utils.convert;

import org.apache.log4j.Logger;
import uk.ac.ebi.pride.data.util.MassSpecFileFormat;
import uk.ac.ebi.pride.jmztab.model.MZTabFile;
import uk.ac.ebi.pride.jmztab.utils.MZTabFileConverter;
import uk.ac.ebi.pride.jmztab.utils.errors.MZTabErrorList;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * User: qingwei
 * Date: 17/09/13
 */
public class ConvertPrideXMLFileRun {
    private static Logger logger = Logger.getLogger(ConvertPrideXMLFile.class);

    private void convert(File inFile, File outFile) throws Exception {
        logger.debug("Input file name is: " + inFile.getAbsoluteFile());
        MZTabFileConverter converter = new MZTabFileConverter(inFile, MassSpecFileFormat.PRIDE);
        MZTabErrorList errorList = converter.getErrorList();

        OutputStream out = new BufferedOutputStream(new FileOutputStream(outFile));
        if (errorList.isEmpty()) {
            MZTabFile tabFile = converter.getMZTabFile();
            if (tabFile.isEmpty()) {
                logger.debug("Not data included in mztab file.");
            } else {
                logger.debug("Finish convert, no error in it. Output file name is " + outFile.getAbsoluteFile());
                tabFile.printMZTab(out);
            }
        } else {
            logger.debug("There exists errors in convert files.");
            logger.debug(errorList);
        }
        out.close();
    }

    public static void main(String[] args) throws Exception {
        ConvertPrideXMLFileRun run = new ConvertPrideXMLFileRun();
//        run.convert(new File("testset/PRIDE_Exp_Complete_Ac_16649.xml"), new File("temp/Pride_16649.mztab"));
//        run.convert(new File("testset/PRIDE_Exp_Complete_Ac_17910.xml"), new File("temp/Pride_17910.mztab"));
//        run.convert(new File("testset/PRIDE_Exp_Complete_Ac_1643.xml"), new File("temp/Pride_1643.mztab"));
//        run.convert(new File("testset/PRIDE_Exp_Complete_Ac_2030.xml"), new File("temp/Pride_2030.mztab"));
        run.convert(new File("temp/PRIDE_Exp_Complete_Ac_31257.xml"), new File("temp/PRIDE_Exp_Complete_Ac_31257.mztab"));
    }
}