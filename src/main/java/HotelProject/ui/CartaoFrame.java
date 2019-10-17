/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject.ui;

import HotelProject.persistence.dao.DadosCartaoDao;
import HotelProject.persistence.entities.DadosCartao;
import java.awt.Toolkit;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Jackson
 */
public class CartaoFrame extends javax.swing.JFrame {
    
    DadosCartaoDao dadosCartaoDao = new DadosCartaoDao();
    DadosCartao dadosCartao;
    Boolean edit = true;
    
    MaskFormatter cardMask, monthMask, myMask, cvvMask;
    Integer idHospede;
    int mpX, mpY;

    /**
     * Creates new form CartaoFrame
     * @param idHospede
     */
    public CartaoFrame(Integer idHospede) {
        this.idHospede = idHospede;

        try {
            cardMask = new MaskFormatter("#### #### #### ####");
            myMask = new MaskFormatter("##");
            cvvMask = new MaskFormatter("###");
        } catch (ParseException e) {
        }
        initComponents();
        
        dadosCartao = dadosCartaoDao.findByHospede(idHospede);
        edit = dadosCartao != null;
                
        if (edit) {
            cardNumberInput.setText(dadosCartao.getNumero());
            holderInput.setText(dadosCartao.getNomeCartao());
            cvvInput.setText(dadosCartao.getCodigoSeguranca());
            monthInput.setText(dadosCartao.getValidadeMes());
            yearInput.setText(dadosCartao.getValidadeAno());
        } else {
            dadosCartao = new DadosCartao();
            dadosCartao.setCodigoHospede(idHospede);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        holderInput = new javax.swing.JTextField();
        cardNumberInput = new javax.swing.JFormattedTextField(cardMask);
        monthInput = new javax.swing.JFormattedTextField(myMask);
        yearInput = new javax.swing.JFormattedTextField(myMask);
        cvvInput = new javax.swing.JFormattedTextField(cvvMask);
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cart�o de Cr�dito");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/bank-card.png")) );
        setResizable(false);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bank-card-bg.png"))); // NOI18N

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        holderInput.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        holderInput.setBorder(null);
        holderInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holderInputActionPerformed(evt);
            }
        });
        jPanel2.add(holderInput);
        holderInput.setBounds(25, 25, 251, 28);

        cardNumberInput.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        cardNumberInput.setBorder(null);
        cardNumberInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberInputActionPerformed(evt);
            }
        });
        jPanel2.add(cardNumberInput);
        cardNumberInput.setBounds(25, 71, 251, 26);

        monthInput.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        monthInput.setBorder(null);
        monthInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthInputActionPerformed(evt);
            }
        });
        jPanel2.add(monthInput);
        monthInput.setBounds(25, 145, 56, 26);

        yearInput.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        yearInput.setBorder(null);
        yearInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearInputActionPerformed(evt);
            }
        });
        jPanel2.add(yearInput);
        yearInput.setBounds(120, 145, 56, 26);

        cvvInput.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        cvvInput.setBorder(null);
        cvvInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cvvInputActionPerformed(evt);
            }
        });
        jPanel2.add(cvvInput);
        cvvInput.setBounds(320, 150, 54, 26);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save_25px.png"))); // NOI18N
        btnSave.setBorder(null);
        btnSave.setBorderPainted(false);
        btnSave.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);
        btnSave.setBounds(370, 10, 25, 25);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(bg)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cvvInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cvvInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cvvInputActionPerformed

    private void yearInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearInputActionPerformed

    private void monthInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthInputActionPerformed

    private void cardNumberInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardNumberInputActionPerformed

    private void holderInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holderInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_holderInputActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        if (cardNumberInput.getText().trim().isEmpty()
                || holderInput.getText().trim().isEmpty()
                || cvvInput.getText().trim().isEmpty()
                || monthInput.getText().trim().isEmpty()
                || yearInput.getText().trim().isEmpty()
            ) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        dadosCartao.setNumero(cardNumberInput.getText());                                 
        dadosCartao.setNomeCartao(holderInput.getText());                           
        dadosCartao.setCodigoSeguranca(cvvInput.getText());                           
        dadosCartao.setValidadeMes(monthInput.getText());                         
        dadosCartao.setValidadeAno(yearInput.getText());
        if (!edit) {
            dadosCartaoDao.save(dadosCartao);
        }
        else {
            dadosCartaoDao.update(dadosCartao);
        }
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField cardNumberInput;
    private javax.swing.JTextField cvvInput;
    private javax.swing.JTextField holderInput;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField monthInput;
    private javax.swing.JTextField yearInput;
    // End of variables declaration//GEN-END:variables
}
