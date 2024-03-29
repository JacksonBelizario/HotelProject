/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject.ui;

import HotelProject.enums.TipoDocumento;
import HotelProject.persistence.dao.HospedeDao;
import HotelProject.persistence.entities.Hospede;
import HotelProject.utils.DateUtils.DateVerifier;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Jackson
 */
public class HospedesPanel extends javax.swing.JPanel {

    HospedeDao hospedeDao = new HospedeDao();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    MaskFormatter maskDate, phoneMask;
    Hospede hospede;
    NumberFormat numberFormat = NumberFormat.getNumberInstance();
    int editIndex = -1;

    /**
     * Creates new form HospedesPanel
     */
    public HospedesPanel() {
        try {
            maskDate = new MaskFormatter("##/##/####");
            maskDate.setPlaceholderCharacter('_');
            phoneMask = new MaskFormatter("(##) #####-####");
            phoneMask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
        }
        initComponents();
        
        cadastroPanel.setVisible(false);
        listagemPanel.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastroPanel = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        nomeInput = new javax.swing.JTextField();
        enderecoInput = new javax.swing.JTextField();
        cidadeInput = new javax.swing.JTextField();
        estadoInput = new javax.swing.JTextField();
        telefoneInput = new javax.swing.JFormattedTextField(phoneMask);
        btnSave = new javax.swing.JButton();
        dataNascimentoInput = new javax.swing.JFormattedTextField(maskDate);
        paisInput = new javax.swing.JTextField();
        emailInput = new javax.swing.JTextField();
        documentoInput = new javax.swing.JTextField();
        tipoDocInput = new javax.swing.JComboBox<>();
        listagemPanel = new javax.swing.JPanel();
        btnNovoFuncionario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmployee = new javax.swing.JTable();
        btnDelFuncionario = new javax.swing.JButton();
        btnEditFuncionario = new javax.swing.JButton();
        btnBankCard = new javax.swing.JButton();

        setLayout(null);

        cadastroPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        btnVoltar.setBorder(null);
        btnVoltar.setBorderPainted(false);
        btnVoltar.setIconTextGap(0);
        btnVoltar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnVoltar.setMinimumSize(new java.awt.Dimension(10, 10));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        nomeInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome"));

        enderecoInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Endere�o"));

        cidadeInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Cidade"));

        estadoInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        telefoneInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefone"));

        btnSave.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jackson\\Desktop\\NetBeansProjects\\icons\\save_50px.png")); // NOI18N
        btnSave.setBorder(null);
        btnSave.setBorderPainted(false);
        btnSave.setIconTextGap(0);
        btnSave.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        dataNascimentoInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Nascimento"));
        dataNascimentoInput.setInputVerifier(new DateVerifier());

        paisInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Pa�s"));

        emailInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));

        documentoInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento"));

        tipoDocInput.setModel(new DefaultComboBoxModel<>(TipoDocumento.values()));
        tipoDocInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Documento"));

        javax.swing.GroupLayout cadastroPanelLayout = new javax.swing.GroupLayout(cadastroPanel);
        cadastroPanel.setLayout(cadastroPanelLayout);
        cadastroPanelLayout.setHorizontalGroup(
            cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enderecoInput)
                    .addGroup(cadastroPanelLayout.createSequentialGroup()
                        .addComponent(cidadeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(estadoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanelLayout.createSequentialGroup()
                                .addComponent(paisInput, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascimentoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(emailInput)
                    .addGroup(cadastroPanelLayout.createSequentialGroup()
                        .addComponent(documentoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoDocInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(cadastroPanelLayout.createSequentialGroup()
                        .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addComponent(nomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cadastroPanelLayout.setVerticalGroup(
            cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidadeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataNascimentoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paisInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipoDocInput)
                    .addComponent(documentoInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        add(cadastroPanel);
        cadastroPanel.setBounds(0, 0, 622, 369);

        listagemPanel.setBackground(new java.awt.Color(255, 255, 255));
        listagemPanel.setForeground(new java.awt.Color(255, 255, 255));
        listagemPanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listagemPanelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnNovoFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add-user.png"))); // NOI18N
        btnNovoFuncionario.setBorder(null);
        btnNovoFuncionario.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNovoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFuncionarioActionPerformed(evt);
            }
        });

        tableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Endere�o", "Cidade", "Estado", "Pa�s", "Telefone", "Data Nasc.", "Email", "Documento", "Tipo Doc."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableEmployee);

        btnDelFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove-user.png"))); // NOI18N
        btnDelFuncionario.setBorder(null);
        btnDelFuncionario.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnDelFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelFuncionarioMouseClicked(evt);
            }
        });

        btnEditFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit-user.png"))); // NOI18N
        btnEditFuncionario.setBorder(null);
        btnEditFuncionario.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEditFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditFuncionarioActionPerformed(evt);
            }
        });

        btnBankCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bank-card.png"))); // NOI18N
        btnBankCard.setBorder(null);
        btnBankCard.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnBankCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBankCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listagemPanelLayout = new javax.swing.GroupLayout(listagemPanel);
        listagemPanel.setLayout(listagemPanelLayout);
        listagemPanelLayout.setHorizontalGroup(
            listagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listagemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listagemPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBankCard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovoFuncionario)))
                .addContainerGap())
        );
        listagemPanelLayout.setVerticalGroup(
            listagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listagemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovoFuncionario)
                    .addComponent(btnDelFuncionario)
                    .addComponent(btnEditFuncionario)
                    .addComponent(btnBankCard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(listagemPanel);
        listagemPanel.setBounds(0, 0, 622, 363);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        resetForm();
        cadastroPanel.setVisible(false);
        listagemPanel.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        DefaultTableModel dataModel = (DefaultTableModel) tableEmployee.getModel();

        Boolean edit = hospede != null;

        if (!edit) {
            hospede = new Hospede();
        }

        if (nomeInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        hospede.setNome(nomeInput.getText());
        hospede.setTelefone(telefoneInput.getText());
        hospede.setEndereco(enderecoInput.getText());
        hospede.setCidade(cidadeInput.getText());
        hospede.setEstado(estadoInput.getText());
        hospede.setPais(paisInput.getText());
        hospede.setDataNascimento(dataNascimentoInput.getText(), df);
        hospede.setEmail(emailInput.getText());
        hospede.setDocumento(documentoInput.getText());
        hospede.setTipoDoc(((TipoDocumento) tipoDocInput.getSelectedItem()).ordinal());
        

        if (!edit) {
            hospedeDao.save(hospede);
            dataModel.addRow(getHospedeRow(hospede));
        }
        else {
            hospedeDao.update(hospede);
            dataModel.removeRow(editIndex);
            dataModel.insertRow(editIndex, getHospedeRow(hospede));
        }

        resetForm();

        cadastroPanel.setVisible(false);
        listagemPanel.setVisible(true);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNovoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFuncionarioActionPerformed
        resetForm();
        cadastroPanel.setVisible(true);
        listagemPanel.setVisible(false);
    }//GEN-LAST:event_btnNovoFuncionarioActionPerformed

    private void btnDelFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelFuncionarioMouseClicked
        int i = tableEmployee.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Selecione na tabela", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        DefaultTableModel dataModel = (DefaultTableModel) tableEmployee.getModel();

        Integer id = Integer.parseInt(dataModel.getValueAt(i, 0).toString());
        Hospede hospede = hospedeDao.find(id);

        int result = JOptionPane.showConfirmDialog(null, "Remover "+ hospede.getNome()+ "?", "Remover funcion�rio",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            hospedeDao.delete(hospede);
            dataModel.removeRow(i);
        }
    }//GEN-LAST:event_btnDelFuncionarioMouseClicked

    private void btnEditFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditFuncionarioActionPerformed
        editIndex = tableEmployee.getSelectedRow();
        if (editIndex == -1) {
            JOptionPane.showMessageDialog(null, "Selecione na tabela", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        DefaultTableModel dataModel = (DefaultTableModel) tableEmployee.getModel();

        editIndex = tableEmployee.getSelectedRow();
        Integer id = Integer.parseInt(dataModel.getValueAt(editIndex, 0).toString());
        hospede = hospedeDao.find(id);

        nomeInput.setText(hospede.getNome());
        telefoneInput.setText(hospede.getTelefone());
        enderecoInput.setText(hospede.getEndereco());
        cidadeInput.setText(hospede.getCidade());
        estadoInput.setText(hospede.getEstado());
        paisInput.setText(hospede.getPais());
        dataNascimentoInput.setText(formatDate(hospede.getDataNascimento()));
        emailInput.setText(hospede.getEmail());
        documentoInput.setText(hospede.getDocumento());
        tipoDocInput.setSelectedItem(TipoDocumento.values()[hospede.getTipoDoc()]);

        cadastroPanel.setVisible(true);
        listagemPanel.setVisible(false);
    }//GEN-LAST:event_btnEditFuncionarioActionPerformed

    private void listagemPanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listagemPanelAncestorAdded
        fillEmployeeTable();
    }//GEN-LAST:event_listagemPanelAncestorAdded

    private void btnBankCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBankCardActionPerformed
        editIndex = tableEmployee.getSelectedRow();
        if (editIndex == -1) {
            JOptionPane.showMessageDialog(null, "Selecione na tabela", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        DefaultTableModel dataModel = (DefaultTableModel) tableEmployee.getModel();
        Integer idHospede = Integer.parseInt(dataModel.getValueAt(editIndex, 0).toString());

        new CartaoFrame(idHospede).setVisible(true);
    }//GEN-LAST:event_btnBankCardActionPerformed
    
    private void resetForm() {
        nomeInput.setText("");
        enderecoInput.setText("");
        cidadeInput.setText("");
        estadoInput.setText("");
        dataNascimentoInput.setText("");
        telefoneInput.setText("");
        paisInput.setText("");
        emailInput.setText("");
        documentoInput.setText("");
        tipoDocInput.setSelectedItem(TipoDocumento.RG);
        hospede = null;
    }
    
    private void fillEmployeeTable() {
        DefaultTableModel dataModel = (DefaultTableModel) tableEmployee.getModel();
        
        if (dataModel.getRowCount() > 0) {
            return;
        }
        
        List<Hospede> hospedes = hospedeDao.getAll();
        
        Iterator<Hospede> hospedesIterator = hospedes.iterator();
        while (hospedesIterator.hasNext()){
            Hospede hospede = (Hospede) hospedesIterator.next();
            dataModel.addRow(getHospedeRow(hospede));
         }
         
        tableEmployee.setModel(dataModel);
    }
    
    private Object[] getHospedeRow(Hospede hospede) {
        return new Object[] {
            hospede.getId(),
            hospede.getNome(),
            hospede.getEndereco(),
            hospede.getCidade(),
            hospede.getEstado(),
            hospede.getPais(),
            hospede.getTelefone(),
            formatDate(hospede.getDataNascimento()),
            hospede.getEmail(),
            hospede.getDocumento(),
            hospede.getTipoDoc() != null ? TipoDocumento.values()[hospede.getTipoDoc()] :  "",
        };
    }
    
    private String formatDate(Date date) {
        String dateStr =  "";
        try {
            dateStr = df.format(date);
        } catch(Exception ex) {
            //
        }
        return dateStr;
    }
    
    private String formatNumber(Double value) {
        String valueStr =  "0";
        try {
            valueStr = numberFormat.format(value);
        } catch(Exception ex) {
            //
        }
        return valueStr;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBankCard;
    private javax.swing.JButton btnDelFuncionario;
    private javax.swing.JButton btnEditFuncionario;
    private javax.swing.JButton btnNovoFuncionario;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel cadastroPanel;
    private javax.swing.JTextField cidadeInput;
    private javax.swing.JFormattedTextField dataNascimentoInput;
    private javax.swing.JTextField documentoInput;
    private javax.swing.JTextField emailInput;
    private javax.swing.JTextField enderecoInput;
    private javax.swing.JTextField estadoInput;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel listagemPanel;
    private javax.swing.JTextField nomeInput;
    private javax.swing.JTextField paisInput;
    private javax.swing.JTable tableEmployee;
    private javax.swing.JTextField telefoneInput;
    private javax.swing.JComboBox<TipoDocumento> tipoDocInput;
    // End of variables declaration//GEN-END:variables
}
