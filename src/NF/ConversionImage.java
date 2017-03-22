package NF;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author JEMCare Solution
 */
public class ConversionImage {

    public void jpegToDicom(File imgEntree, File dmcSortie, String date, String typeExam, String nomMed, String Cr,
            String nomPatient, String genre, String dateNaissance, int IPP) throws Exception {

        try {
            BufferedImage jpeg = ImageIO.read(imgEntree);

            if (jpeg == null) {
                throw new Exception("Le fichier selectionné est invalide.");
            }

//   
//      
//        Attributes att = new Attributes();
//        
//         att.setString(Tag.SpecificCharacterSet, VR.CS, "ISO_IR 100");  
//         att.setString(Tag.PhotometricInterpretation, VR.CS, "RGB"); // choix de paramètre fait à partir de données trouvées sur internet.
//         att.setInt(Tag.SamplesPerPixel, VR.US, 3);  // il est usuel de choisir 3 composants par pixel pour          
//         att.setInt(Tag.Rows, VR.US, jpeg.getHeight());  
//         att.setInt(Tag.Columns, VR.US, jpeg.getWidth());  
//         att.setInt(Tag.BitsAllocated, VR.US, 8);  //nombre de bit alloué à chaque pixel
//         att.setInt(Tag.BitsStored, VR.US, 8); // 8 = BitsAllocated
//         att.setInt(Tag.HighBit, VR.US, 7);  // 7 = bitsAllocated-1
//         att.setInt(Tag.PixelRepresentation, VR.US, 0); // valeur pour non signé
//         att.setString(Tag.ImageType, VR.CS, "ORIGINAL\\PRIMARY"); // Choix fait à partir de la doc https://www.dabsoft.ch/dicom/3/C.7.6.1.1/
//         att.setString(Tag.SOPClassUID, VR.UI, "1.2.840.10008.5.1.4.1.1.7"); // Choix fait à parti de la doc http://www.dicomlibrary.com/dicom/sop/
//                                                                             // Permet d'avoir des multiframes
//         att.setInt(Tag.PlanarConfiguration, VR.US, 0); // valeur O : pour que les couleurs des pixels soient groupées par localisation
//            
//         
//         att.setString(Tag.StudyDate, VR.DA, date);
//         att.setString(Tag.SeriesDate, VR.DA, date);
//         att.setString(Tag.AcquisitionDate, VR.DA, date);
//         att.setString(Tag.AccessionNumber, VR.SH, "LienPacs");
//         att.setString(Tag.Modality, VR.CS, typeExam); // Modality correspond au type de l'examen réalisé
//         att.setString(Tag.ConversionType, VR.CS, "WSD"); //WSD = Worksation, les images vont provenir du bureau de l'ordinateur
//         att.setString(Tag.OperatorsName, VR.CS, nomMed);
//         att.setString(Tag.ResultsComments, VR.CS, Cr);
//         
//         att.setString(Tag.PatientName, VR.PN, nomPatient);
//         att.setString(Tag.PatientID, VR.LO, String.valueOf(IPP));
//         att.setString(Tag.PatientBirthDate, VR.DA, dateNaissance);
//         att.setString(Tag.PatientSex, VR.CS, genre);
//         att.setString(Tag.StudyID, VR.IS, "1");
//         att.setString(Tag.AcquisitionNumber, VR.IS, "1");
//         att.setString(Tag.InstanceNumber, VR.IS, "1");
//            
//
//        Attributes fmi = new Attributes();
//         fmi.setString(Tag.FileMetaInformationVersion, VR.OB, "1");
//         fmi.setString(Tag.TransferSyntaxUID, VR.UI, "1.2.840.10008.1.2.1"); // code pour les Little Endian Explicit
//         fmi.setString(Tag.ImplementationVersionName, VR.SH, "DCM4CHE3");
//         
//        // Maintenant que tous les attributs nécessaires sont renseignés, nous pouvons créer le document DICOM
//         DicomOutputStream dmc = new DicomOutputStream(dmcSortie); 
//         dmc.writeDataset(fmi, att);  
//      
//         
//        // Nous pouvons ensuite créer la variable data qui contiendra l'image sous format byte
//            byte[] pix = new byte[jpeg.getHeight() * jpeg.getWidth() * 3];
//            int c = 0;
//            for (int j = 0; j < jpeg.getHeight(); j++) {
//                for (int i = 0; i < jpeg.getWidth(); i++) {
//                    byte col = (byte) (jpeg.getRGB(i, j) & 255);
//                    pix[c++] = col;
//                    pix[c++] = col;
//                    pix[c++] = col;
//                }
//            }
//            //Nous ajoutons la variable pix au fichier dicom
//            dmc.writeAttribute(Tag.PixelData, VR.OW, pix);
//            
//            dmc.writeHeader(Tag.SequenceDelimitationItem, null, 0);
//            dmc.close(); // la création du fichier Dicom est terminée
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
