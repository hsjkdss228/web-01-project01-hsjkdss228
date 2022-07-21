package components;

import javax.swing.*;
import java.awt.*;

public class NotificationDialog extends JDialog {
  public void showDialog(String message) {
    JDialog dialog = new JDialog();
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    dialog.setSize(200, 100);
    dialog.setLocationRelativeTo(null);
    dialog.setLayout(new BorderLayout());

    JLabel messageLabel = new JLabel(message);
    messageLabel.setHorizontalAlignment(JLabel.CENTER);
    dialog.add(messageLabel, BorderLayout.CENTER);

    JButton acceptButton = new JButton("확인");
    acceptButton.addActionListener(dialogEvent -> {
//      dialog.dispose();
      dialog.setVisible(false);
    });
    dialog.add(acceptButton, BorderLayout.PAGE_END);

    dialog.setVisible(true);
  }
}
