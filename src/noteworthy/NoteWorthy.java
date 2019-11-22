/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noteworthy;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.File;
import org.jfugue.player.*;
import org.jfugue.pattern.*;


/**
 *
 * @author mayra
 */
public class NoteWorthy extends javax.swing.JFrame {

    /**
     * Creates new form NoteWorthy
     */
    public NoteWorthy() {
        initComponents();
        pattern = null;
    }
    
    private Pattern pattern;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame_MAPEAMENTO = new javax.swing.JFrame();
        jScrollPane_MAPEAMENTO = new javax.swing.JScrollPane();
        jTable_MAPEAMENTO = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jButton_BUILD = new javax.swing.JButton();
        jButton_DOWNLOAD = new javax.swing.JButton();
        jButton_PLAY = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_FILE = new javax.swing.JMenu();
        jMenuItem_IMPORT = new javax.swing.JMenuItem();
        jMenuItem_EXPORT = new javax.swing.JMenuItem();
        jMenu_HELP = new javax.swing.JMenu();
        jMenuItem_HELP = new javax.swing.JMenuItem();

        jFrame_MAPEAMENTO.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame_MAPEAMENTO.setTitle("Mapping");
        jFrame_MAPEAMENTO.setAlwaysOnTop(true);
        jFrame_MAPEAMENTO.setLocation(new java.awt.Point(0, 0));
        jFrame_MAPEAMENTO.setMinimumSize(new java.awt.Dimension(300, 400));
        jFrame_MAPEAMENTO.setUndecorated(true);

        jScrollPane_MAPEAMENTO.setPreferredSize(new java.awt.Dimension(453, 351));

        jTable_MAPEAMENTO.setFont(new java.awt.Font("Ebrima", 0, 13)); // NOI18N
        jTable_MAPEAMENTO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"a", "Lá"},
                {"b", "Sí"},
                {"c", "Dó"},
                {"d", "Ré"},
                {"e", "Mi"},
                {"f", "Fá"},
                {"g", "Sol"},
                {"i", "Repete nota/pausa anterior"},
                {"o", "Repete nota/pausa anterior"},
                {"u", "Repete nota/pausa anterior"},
                {"space", "Pausa"},
                {"+", "Aumenta volume em 2x"},
                {"-", "Diminui volume em 2x"},
                {"B+", "Aumenta 50 BPMs"},
                {"B-", "Diminui 50 BPMs"},
                {"O+", "Aumenta uma oitava"},
                {"O-", "Diminui uma oitava"},
                {".", "Oitava e volume padrão"},
                {"?", "Oitava e volume padrão"},
                {"\n", "Troca instrumento"}
            },
            new String [] {
                "CHAR", "SOM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_MAPEAMENTO.setColumnSelectionAllowed(true);
        jTable_MAPEAMENTO.setName("Mapeamento");
        jScrollPane_MAPEAMENTO.setViewportView(jTable_MAPEAMENTO);
        jTable_MAPEAMENTO.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jFrame_MAPEAMENTOLayout = new javax.swing.GroupLayout(jFrame_MAPEAMENTO.getContentPane());
        jFrame_MAPEAMENTO.getContentPane().setLayout(jFrame_MAPEAMENTOLayout);
        jFrame_MAPEAMENTOLayout.setHorizontalGroup(
            jFrame_MAPEAMENTOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame_MAPEAMENTOLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane_MAPEAMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jFrame_MAPEAMENTOLayout.setVerticalGroup(
            jFrame_MAPEAMENTOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_MAPEAMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NoteWorthy");
        setLocation(new java.awt.Point(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea.setLineWrap(true);
        jTextArea.setRows(5);
        jTextArea.setText("Sphinx of black quartz, judge my vow.");
        jTextArea.setToolTipText("");
        jTextArea.setWrapStyleWord(true);
        jTextArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextArea.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(jTextArea);

        jButton_BUILD.setBackground(new java.awt.Color(102, 102, 102));
        jButton_BUILD.setForeground(new java.awt.Color(255, 255, 255));
        jButton_BUILD.setText("Build");
        jButton_BUILD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BUILDActionPerformed(evt);
            }
        });

        jButton_DOWNLOAD.setBackground(new java.awt.Color(102, 102, 102));
        jButton_DOWNLOAD.setForeground(new java.awt.Color(255, 255, 255));
        jButton_DOWNLOAD.setText("Download");
        jButton_DOWNLOAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DOWNLOADActionPerformed(evt);
            }
        });

        jButton_PLAY.setBackground(new java.awt.Color(102, 102, 102));
        jButton_PLAY.setForeground(new java.awt.Color(255, 255, 255));
        jButton_PLAY.setText("Play");
        jButton_PLAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PLAYActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton_DOWNLOAD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_BUILD, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_PLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_BUILD)
                    .addComponent(jButton_DOWNLOAD)
                    .addComponent(jButton_PLAY))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));

        jMenu_FILE.setBackground(new java.awt.Color(204, 204, 204));
        jMenu_FILE.setForeground(new java.awt.Color(102, 102, 102));
        jMenu_FILE.setText("File");
        jMenu_FILE.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N

        jMenuItem_IMPORT.setText("Import .txt file");
        jMenuItem_IMPORT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_IMPORTActionPerformed(evt);
            }
        });
        jMenu_FILE.add(jMenuItem_IMPORT);

        jMenuItem_EXPORT.setText("Export .txt file");
        jMenuItem_EXPORT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_EXPORTActionPerformed(evt);
            }
        });
        jMenu_FILE.add(jMenuItem_EXPORT);

        jMenuBar1.add(jMenu_FILE);

        jMenu_HELP.setBackground(new java.awt.Color(204, 204, 204));
        jMenu_HELP.setForeground(new java.awt.Color(102, 102, 102));
        jMenu_HELP.setText("Help");
        jMenu_HELP.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N

        jMenuItem_HELP.setText("Show char map");
        jMenuItem_HELP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CHARMAPActionPerformed(evt);
            }
        });
        jMenu_HELP.add(jMenuItem_HELP);

        jMenuBar1.add(jMenu_HELP);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BUILDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BUILDActionPerformed
        try {
            // Operaçao para contruir nova Pattern a partir do texto presente na caixa de texto
            Music music = new Music(jTextArea.getText());
            pattern = music.build(); //devolve Pattern construida, atribui ela a classe NoteWorthy para ser reproduzida indefinidamente ou até outra pattern ser construida
            JOptionPane.showMessageDialog(null, "Sucesso"); //aviso (temporário pq eh mt feio) que pode reproduzir pattern em PLAY
        } catch (Exception ex) {
            Logger.getLogger(NoteWorthy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_BUILDActionPerformed

    private void jButton_DOWNLOADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DOWNLOADActionPerformed
        //Operação para salvar Pattern construida em arquivo MIDI
        Files file = new Files();
        File directory = file.selectFile(false);
        //if(directory != null)
            //file.write(directory, jTextArea.getText(), ".midi"); //depois corrijo atributos
    }//GEN-LAST:event_jButton_DOWNLOADActionPerformed

    private void jMenuItem_IMPORTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_IMPORTActionPerformed
        // operação de importação de arquivo .txt
        Files files = new Files();
        File directory = files.selectFile(true);
        if(directory != null){
            try {
                jTextArea.setText(files.read(directory));
            } catch (IOException ex) {
                Logger.getLogger(NoteWorthy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem_IMPORTActionPerformed

    private void jMenuItem_EXPORTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_EXPORTActionPerformed
        Files files = new Files();
        File directory = files.selectFile(false);
        if(directory != null)
            files.write(directory, jTextArea.getText(), ".txt");
    }//GEN-LAST:event_jMenuItem_EXPORTActionPerformed

    private void jMenuItem_CHARMAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CHARMAPActionPerformed
        // TODO add your handling code here:
        jTable_MAPEAMENTO.setVisible(true);
    }//GEN-LAST:event_jMenuItem_CHARMAPActionPerformed

    private void jButton_PLAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PLAYActionPerformed
        // Toca o Pattern (do JFugue) já construído por Music e atribuido em NoteWorthy
        if(pattern != null){
            Player player = new Player();
            player.play(pattern);
        }
    }//GEN-LAST:event_jButton_PLAYActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NoteWorthy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NoteWorthy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NoteWorthy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NoteWorthy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new NoteWorthy().setVisible(true);                    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_BUILD;
    private javax.swing.JButton jButton_DOWNLOAD;
    private javax.swing.JButton jButton_PLAY;
    private javax.swing.JFrame jFrame_MAPEAMENTO;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_EXPORT;
    private javax.swing.JMenuItem jMenuItem_HELP;
    private javax.swing.JMenuItem jMenuItem_IMPORT;
    private javax.swing.JMenu jMenu_FILE;
    private javax.swing.JMenu jMenu_HELP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane_MAPEAMENTO;
    private javax.swing.JTable jTable_MAPEAMENTO;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
