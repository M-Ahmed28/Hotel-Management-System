package hotel.management.system;

import javax.swing.SwingUtilities;

public class Start1 extends javax.swing.JFrame {

    public Start1() {
        initComponents();
        startLoadingProcess();
    }

    // Refactoring: Extract Method (Separating threading logic)
    private void startLoadingProcess() {
        new Thread(() -> {
            for (int progress = 0; progress <= 100; progress++) {
                try {
                    updateProgressUI(progress);
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }

    // Refactoring: Extract Method (Centralizing UI updates on the EDT)
    private void updateProgressUI(int value) {
        SwingUtilities.invokeLater(() -> {
            jProgressBar1.setValue(value);
            updateStatusText(value);
            
            if (value == 100) {
                navigateToSignIn();
            }
        });
    }

    // Refactoring: Substitute Algorithm (Using integer logic instead of String checks)
    private void updateStatusText(int value) {
        if (value == 25) {
            jLabel2.setText("Connecting Database....");
        } else if (value == 50) {
            jLabel2.setText("Loading Modules.....");
        } else if (value == 95) {
            jLabel2.setText("Launching Application....");
        }
    }

    private void navigateToSignIn() {
        new SignIn().setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 24)); // NOI18N
        jLabel1.setText("Kushwaha Hotel");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 370, 53));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.blue);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Loading......");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 680, 30));

        jProgressBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(0, 0, 204));
        jProgressBar1.setRequestFocusEnabled(false);
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 680, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loasd.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 630, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
