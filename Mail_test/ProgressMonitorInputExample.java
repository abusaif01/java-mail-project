import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.ProgressMonitorInputStream;

public class ProgressMonitorInputExample {

  public ProgressMonitorInputExample(String filename) {
    ProgressMonitorInputStream monitor;
    try {
      monitor = new ProgressMonitorInputStream(null, "Loading "
          + filename, new FileInputStream(filename));
      while (monitor.available() > 0) {
        byte[] data = new byte[38];
        monitor.read(data);
        System.out.write(data);
      }
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Unable to find file: "
          + filename, "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException e) {
      ;
    }
  }

  public static void main(String args[]) {
    new ProgressMonitorInputExample(args[0]);
  }
}