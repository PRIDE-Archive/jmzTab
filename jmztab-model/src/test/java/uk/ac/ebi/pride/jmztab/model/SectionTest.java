/*
 * Copyright 2016 European Bioinformatics Institute.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.ebi.pride.jmztab.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nilshoffmann
 */
public class SectionTest {

    private Section[] expectedSections;

    public SectionTest() {
        expectedSections = new Section[]{
            Section.Comment,
            Section.Metadata,
            Section.Protein_Header,
            Section.Protein,
            Section.Peptide_Header,
            Section.Peptide,
            Section.PSM_Header,
            Section.PSM,
            Section.Small_Molecule_Header,
            Section.Small_Molecule,
            Section.Small_Molecule_Feature_Header,
            Section.Small_Molecule_Feature,
            Section.Small_Molecule_Evidence_Header,
            Section.Small_Molecule_Evidence
        };
    }

    /**
     * Test of values method, of class Section.
     */
    @Test
    public void testValues() {
        Section[] result = Section.values();
        assertArrayEquals(expectedSections, result);
    }

    /**
     * Test of valueOf method, of class Section.
     */
    @Test
    public void testValueOf() {
        for (Section s : expectedSections) {
            String sectionName;
            switch (s) {
                case Comment:
                    sectionName = "Comment";
                    break;
                case Metadata:
                    sectionName = "Metadata";
                    break;
                case Protein_Header:
                    sectionName = "Protein_Header";
                    break;
                case Protein:
                    sectionName = "Protein";
                    break;
                case Peptide_Header:
                    sectionName = "Peptide_Header";
                    break;
                case Peptide:
                    sectionName = "Peptide";
                    break;
                case PSM_Header:
                    sectionName = "PSM_Header";
                    break;
                case PSM:
                    sectionName = "PSM";
                    break;
                case Small_Molecule_Header:
                    sectionName = "Small_Molecule_Header";
                    break;
                case Small_Molecule:
                    sectionName = "Small_Molecule";
                    break;
                case Small_Molecule_Feature_Header:
                    sectionName = "Small_Molecule_Feature_Header";
                    break;
                case Small_Molecule_Feature:
                    sectionName = "Small_Molecule_Feature";
                    break;
                case Small_Molecule_Evidence_Header:
                    sectionName = "Small_Molecule_Evidence_Header";
                    break;
                case Small_Molecule_Evidence:
                    sectionName = "Small_Molecule_Evidence";
                    break;
                default:
                    sectionName = null;
            }
            Section result = Section.valueOf(sectionName);
            assertEquals(s, result);
        }
    }

    /**
     * Test of getPrefix method, of class Section.
     */
    @Test
    public void testGetPrefix() {
        for (Section s : expectedSections) {
            String prefix;
            switch (s) {
                case Comment:
                    prefix = "COM";
                    break;
                case Metadata:
                    prefix = "MTD";
                    break;
                case Protein_Header:
                    prefix = "PRH";
                    break;
                case Protein:
                    prefix = "PRT";
                    break;
                case Peptide_Header:
                    prefix = "PEH";
                    break;
                case Peptide:
                    prefix = "PEP";
                    break;
                case PSM_Header:
                    prefix = "PSH";
                    break;
                case PSM:
                    prefix = "PSM";
                    break;
                case Small_Molecule_Header:
                    prefix = "SMH";
                    break;
                case Small_Molecule:
                    prefix = "SML";
                    break;
                case Small_Molecule_Feature_Header:
                    prefix = "SFH";
                    break;
                case Small_Molecule_Feature:
                    prefix = "SMF";
                    break;
                case Small_Molecule_Evidence_Header:
                    prefix = "SEH";
                    break;
                case Small_Molecule_Evidence:
                    prefix = "SME";
                    break;
                default:
                    prefix = null;
            }
            assertEquals(s.getPrefix(), prefix);
        }
    }

    /**
     * Test of getName method, of class Section.
     */
    @Test
    public void testGetName() {
        for (Section s : expectedSections) {
            String sectionName;
            switch (s) {
                case Comment:
                    sectionName = "Comment";
                    break;
                case Metadata:
                    sectionName = "Metadata";
                    break;
                case Protein_Header:
                    sectionName = "Protein_Header";
                    break;
                case Protein:
                    sectionName = "Protein";
                    break;
                case Peptide_Header:
                    sectionName = "Peptide_Header";
                    break;
                case Peptide:
                    sectionName = "Peptide";
                    break;
                case PSM_Header:
                    sectionName = "PSM_Header";
                    break;
                case PSM:
                    sectionName = "PSM";
                    break;
                case Small_Molecule_Header:
                    sectionName = "Small_Molecule_Header";
                    break;
                case Small_Molecule:
                    sectionName = "Small_Molecule";
                    break;
                case Small_Molecule_Feature_Header:
                    sectionName = "Small_Molecule_Feature_Header";
                    break;
                case Small_Molecule_Feature:
                    sectionName = "Small_Molecule_Feature";
                    break;
                case Small_Molecule_Evidence_Header:
                    sectionName = "Small_Molecule_Evidence_Header";
                    break;
                case Small_Molecule_Evidence:
                    sectionName = "Small_Molecule_Evidence";
                    break;
                default:
                    sectionName = null;
            }
            assertEquals(s.name(), sectionName);
        }
    }

    /**
     * Test of getLevel method, of class Section.
     */
    @Test
    public void testGetLevel() {
        int i = 0;
        for (Section s : expectedSections) {
            assertEquals(i, s.getLevel());
            i++;
        }
    }

    /**
     * Test of findSection method, of class Section.
     */
    @Test
    public void testFindSection_int() {
        int i = 0;
        for (Section s : expectedSections) {
            assertEquals(s, Section.findSection(i));
            i++;
        }
    }

    /**
     * Test of isComment method, of class Section.
     */
    @Test
    public void testIsComment() {
        for (Section s : expectedSections) {
            switch (s) {
                case Comment:
                    assertTrue(s.isComment());
                    break;
                default:
                    assertFalse(s.isComment());
            }
        }
    }

    /**
     * Test of isMetadata method, of class Section.
     */
    @Test
    public void testIsMetadata() {
        for (Section s : expectedSections) {
            switch (s) {
                case Metadata:
                    assertTrue(s.isMetadata());
                    break;
                default:
                    assertFalse(s.isMetadata());
            }
        }
    }

    /**
     * Test of isHeader method, of class Section.
     */
    @Test
    public void testIsHeader() {
        for (Section s : expectedSections) {
            switch (s) {
                case PSM_Header:
                case Peptide_Header:
                case Protein_Header:
                case Small_Molecule_Header:
                case Small_Molecule_Feature_Header:
                case Small_Molecule_Evidence_Header:
                    assertTrue(s.isHeader());
                    break;
                default:
                    assertFalse(s.isHeader());
            }
        }
    }

    /**
     * Test of isData method, of class Section.
     */
    @Test
    public void testIsData() {
        for (Section s : expectedSections) {
            switch (s) {
                case PSM:
                case Peptide:
                case Protein:
                case Small_Molecule:
                case Small_Molecule_Feature:
                case Small_Molecule_Evidence:
                    assertTrue(s.isData());
                    break;
                default:
                    assertFalse(s.isData());
            }
        }
    }

    /**
     * Test of toHeaderSection method, of class Section.
     */
    @Test
    public void testToHeaderSection() {
        for (Section s : expectedSections) {
            Section headerSection;
            switch (s) {
                case Comment:
                    headerSection = null;
                    break;
                case Metadata:
                    headerSection = null;
                    break;
                case Protein_Header:
                case Protein:
                    headerSection = Section.Protein_Header;
                    break;
                case Peptide_Header:
                case Peptide:
                    headerSection = Section.Peptide_Header;
                    break;
                case PSM_Header:
                case PSM:
                    headerSection = Section.PSM_Header;
                    break;
                case Small_Molecule_Header:
                case Small_Molecule:
                    headerSection = Section.Small_Molecule_Header;
                    break;
                case Small_Molecule_Feature_Header:
                case Small_Molecule_Feature:
                    headerSection = Section.Small_Molecule_Feature_Header;
                    break;
                case Small_Molecule_Evidence_Header:
                case Small_Molecule_Evidence:
                    headerSection = Section.Small_Molecule_Evidence_Header;
                    break;
                default:
                    headerSection = null;
            }
            assertEquals(headerSection, Section.toHeaderSection(s));
        }
    }

    /**
     * Test of toDataSection method, of class Section.
     */
    @Test
    public void testToDataSection() {
        for (Section s : expectedSections) {
            Section dataSection;
            switch (s) {
                case Comment:
                    dataSection = null;
                    break;
                case Metadata:
                    dataSection = null;
                    break;
                case Protein_Header:
                case Protein:
                    dataSection = Section.Protein;
                    break;
                case Peptide_Header:
                case Peptide:
                    dataSection = Section.Peptide;
                    break;
                case PSM_Header:
                case PSM:
                    dataSection = Section.PSM;
                    break;
                case Small_Molecule_Header:
                case Small_Molecule:
                    dataSection = Section.Small_Molecule;
                    break;
                case Small_Molecule_Feature_Header:
                case Small_Molecule_Feature:
                    dataSection = Section.Small_Molecule_Feature;
                    break;
                case Small_Molecule_Evidence_Header:
                case Small_Molecule_Evidence:
                    dataSection = Section.Small_Molecule_Evidence;
                    break;
                default:
                    dataSection = null;
            }
            assertEquals(dataSection, Section.toDataSection(s));
        }
    }

    /**
     * Test of findSection method, of class Section.
     */
    @Test
    public void testFindSection_String() {
        for (Section s : expectedSections) {
            String prefix;
            switch (s) {
                case Comment:
                    prefix = "COM";
                    break;
                case Metadata:
                    prefix = "MTD";
                    break;
                case Protein_Header:
                    prefix = "PRH";
                    break;
                case Protein:
                    prefix = "PRT";
                    break;
                case Peptide_Header:
                    prefix = "PEH";
                    break;
                case Peptide:
                    prefix = "PEP";
                    break;
                case PSM_Header:
                    prefix = "PSH";
                    break;
                case PSM:
                    prefix = "PSM";
                    break;
                case Small_Molecule_Header:
                    prefix = "SMH";
                    break;
                case Small_Molecule:
                    prefix = "SML";
                    break;
                case Small_Molecule_Feature_Header:
                    prefix = "SFH";
                    break;
                case Small_Molecule_Feature:
                    prefix = "SMF";
                    break;
                case Small_Molecule_Evidence_Header:
                    prefix = "SEH";
                    break;
                case Small_Molecule_Evidence:
                    prefix = "SME";
                    break;
                default:
                    prefix = null;
            }
            assertEquals(s, Section.findSection(prefix));
        }
        
        for (Section s : expectedSections) {
            String sectionName;
            switch (s) {
                case Comment:
                    sectionName = "Comment";
                    break;
                case Metadata:
                    sectionName = "Metadata";
                    break;
                case Protein_Header:
                    sectionName = "Protein_Header";
                    break;
                case Protein:
                    sectionName = "Protein";
                    break;
                case Peptide_Header:
                    sectionName = "Peptide_Header";
                    break;
                case Peptide:
                    sectionName = "Peptide";
                    break;
                case PSM_Header:
                    sectionName = "PSM_Header";
                    break;
                case PSM:
                    sectionName = "PSM";
                    break;
                case Small_Molecule_Header:
                    sectionName = "Small_Molecule_Header";
                    break;
                case Small_Molecule:
                    sectionName = "Small_Molecule";
                    break;
                case Small_Molecule_Feature_Header:
                    sectionName = "Small_Molecule_Feature_Header";
                    break;
                case Small_Molecule_Feature:
                    sectionName = "Small_Molecule_Feature";
                    break;
                case Small_Molecule_Evidence_Header:
                    sectionName = "Small_Molecule_Evidence_Header";
                    break;
                case Small_Molecule_Evidence:
                    sectionName = "Small_Molecule_Evidence";
                    break;
                default:
                    sectionName = null;
            }
            assertEquals(s, Section.findSection(sectionName));
        }
        
    }

}
