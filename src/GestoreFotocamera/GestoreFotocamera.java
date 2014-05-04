/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestoreFotocamera;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Marchins
 */
public class GestoreFotocamera extends JFrame implements Runnable, ThreadFactory {
    
    private static final long serialVersionUID = 6441489157408381878L;

    private final Executor executor = Executors.newSingleThreadExecutor((ThreadFactory) this);
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    //private JTextArea textarea = null;
        
    
    public GestoreFotocamera() {
        super();

        setLayout(new FlowLayout());
        setTitle("MDB Barcode Scanner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension size = WebcamResolution.QVGA.getSize();

        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);

        //textarea = new JTextArea();
        //textarea.setEditable(false);
        //textarea.setPreferredSize(size);

        add(panel);
        //add(textarea);

        pack();
        setVisible(true);

        executor.execute(this);
    }
    
    
    @Override
    public void run() {
        
        Collection<BarcodeFormat> c = new ArrayList<>();
        c.add(BarcodeFormat.EAN_13);
        
        HashMap<DecodeHintType, Object> decodeHints = new HashMap<>();
        decodeHints.put(DecodeHintType.POSSIBLE_FORMATS,  c);
        decodeHints.put(DecodeHintType.CHARACTER_SET, "ISO-8859-1");
        decodeHints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        decodeHints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
        //decodeHints.put(DecodeHintType.ALLOWED_LENGTHS, 13);

        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            Result result = null;
            BufferedImage image;

            if (webcam.isOpen()) {

                if ((image = webcam.getImage()) == null) {
                    continue;
                }

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    result = new MultiFormatReader().decode(bitmap, decodeHints);
                } catch (NotFoundException e) {
                    // nessun QR o Barcode rilevato
                }
            }

            if (result != null) {
                //textarea.setText(result.getText());
                System.out.println(result.getBarcodeFormat() + " : " + result.getText());
                System.exit(0);
            }

        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "barcode-scanner");
        t.setDaemon(true);
        return t;
    }
    
    /*
    public static String acquisisciIsbn() {
        
        return "";
    }
    
    private static String acquisisciBarcode() {
        
        return "";
    }
    
    private static String convertiBarcode(String barcode) {
        
        return "";
    }
    */
}
