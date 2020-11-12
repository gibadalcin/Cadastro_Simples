/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import domain.Customer;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dConnection.dbConnection; 
/**
 
 * @author giba01
 */
public class searchCustomers extends javax.swing.JInternalFrame { 
    /**
     * Creates new form searchCustomers
     */
    public searchCustomers(){
        super("Consultar Clientes", false,true,false,false);
        initComponents();
        getRootPane().setDefaultButton(btnSearch);    
    }
    
    
    public void close(){
        dispose();    
    }
    
    
    private void search(){
        if(txtSearch.getText().isEmpty() && cbTypeSearch.getSelectedItem().equals("Idade")){
            JOptionPane.showMessageDialog(null,"Informe os dados para pesquisa!","Preencha os dados!",
                    JOptionPane.ERROR_MESSAGE);
            txtSearch.requestFocus();
        }else{
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            if(model.getRowCount()!=0){
                for(int i=model.getRowCount()-1;i>=0;i--)
                    model.removeRow(i);
            }           
            dbConnection connection = new dbConnection();
            List<Customer> customers = null;          
            if(cbTypeSearch.getSelectedItem().equals("Nome"))
                customers = connection.searchCustomers("nome",txtSearch.getText());
            else if(cbTypeSearch.getSelectedItem().equals("Cpf"))
                customers = connection.searchCustomers("cpf",txtSearch.getText());
            else if(cbTypeSearch.getSelectedItem().equals("Idade"))
                customers = connection.searchCustomers("idade",txtSearch.getText());
            else if(cbTypeSearch.getSelectedItem().equals("Telefone"))
                customers = connection.searchCustomers("telefone",txtSearch.getText());
            else if(cbTypeSearch.getSelectedItem().equals("Email"))
                customers = connection.searchCustomers("email",txtSearch.getText());           
            if(!customers.isEmpty()){
                for(Customer c:customers)
                    model.addRow(new Object[]{
                        c.getNome(),
                        c.getCpf(),
                        c.getIdade(),
                        c.getTelefone(),
                        c.getEmail()
                    });
            }else
                JOptionPane.showMessageDialog(null,"Nenhum registro encontrado!", "Nenhum registro!",
                        JOptionPane.INFORMATION_MESSAGE);           
        } 
    }
    
    
    private void delete(){
        if(table.getSelectedRow()>=0){
            Object[] choice={"Sim","Não"};
            int answer = JOptionPane.showOptionDialog(null,"Tem certeza que deseja excluir?","Excluir",
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
            if(answer == 0){
                 DefaultTableModel model = (DefaultTableModel) table.getModel();
                 dbConnection dbConnection = new dbConnection();
            boolean deletedCustomer = dbConnection.deleteCustomer(model.getValueAt(table.getSelectedRow(),1).toString());
            if(deletedCustomer == true){
                model.removeRow(table.getSelectedRow());
                JOptionPane.showMessageDialog(null,"Cadastro excluído com sucesso!","Excluído!",
                   JOptionPane.INFORMATION_MESSAGE);
            }else
                JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o cliente!","Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(null, "Selecione um registro na tabela antes de clicar no botão excluir!",
               "Erro",JOptionPane.ERROR_MESSAGE);     
    }
    
    
    private void change(){
        if(table.getSelectedRow()>=0){
            registerCustomer.operation="alterar";
            DefaultTableModel model =(DefaultTableModel)table.getModel();
            registerCustomer.nome=model.getValueAt(table.getSelectedRow(),0).toString();
            registerCustomer.cpf=model.getValueAt(table.getSelectedRow(),1).toString();
            registerCustomer.idade=Integer.parseInt(model.getValueAt(table.getSelectedRow(),2).toString());
            registerCustomer.telefone=model.getValueAt(table.getSelectedRow(),3).toString();
            registerCustomer.email=model.getValueAt(table.getSelectedRow(),4).toString();
            registerCustomer change = new registerCustomer();
            mainForm.dpPane.add(change);
            change.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Selecione um registro da tabela antes de clicar alterar!",
                    "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void clean(){
        txtSearch.setText("");
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        if(model.getRowCount()!=0){
            for(int i= model.getRowCount()-1;i>=0;i--)
                model.removeRow(i);
        }
        txtSearch.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTypeSearch = new javax.swing.JLabel();
        cbTypeSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        mbMenu = new javax.swing.JMenu();
        miSearch = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miDelete = new javax.swing.JMenuItem();
        miChange = new javax.swing.JMenuItem();
        miClean = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miClose = new javax.swing.JMenuItem();

        setTitle("Consultar Clientes");
        setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(630, 340));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        lblTypeSearch.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblTypeSearch.setText("Consulta por :");

        cbTypeSearch.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cbTypeSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Cpf", "Idade", "Telefone", "Email" }));
        cbTypeSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbTypeSearch.setFocusable(false);

        txtSearch.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnSearch.setText("Consultar");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cpf", "Idade", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(250);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(180);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(2).setPreferredWidth(60);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(3).setPreferredWidth(180);
            table.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        btnDelete.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnDelete.setText("Excluir");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnChange.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnChange.setText("Alterar");
        btnChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnClean.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/limpar.png"))); // NOI18N
        btnClean.setText("Limpar");
        btnClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sair2.png"))); // NOI18N
        btnClose.setText("Fechar");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        mbMenu.setText("Menu");
        mbMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mbMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        miSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        miSearch.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        miSearch.setText("Consultar");
        miSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSearchActionPerformed(evt);
            }
        });
        mbMenu.add(miSearch);
        mbMenu.add(jSeparator1);

        miDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        miDelete.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        miDelete.setText("Excluir");
        miDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteActionPerformed(evt);
            }
        });
        mbMenu.add(miDelete);

        miChange.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        miChange.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        miChange.setText("Alterar");
        miChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miChangeActionPerformed(evt);
            }
        });
        mbMenu.add(miChange);

        miClean.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        miClean.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        miClean.setText("Limpar");
        miClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCleanActionPerformed(evt);
            }
        });
        mbMenu.add(miClean);
        mbMenu.add(jSeparator2);

        miClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_MASK));
        miClose.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        miClose.setText("Fechar");
        miClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCloseActionPerformed(evt);
            }
        });
        mbMenu.add(miClose);

        jMenuBar.add(mbMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTypeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTypeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTypeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTypeSearch))
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteActionPerformed
        delete();
    }//GEN-LAST:event_miDeleteActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void miSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSearchActionPerformed
        search();
    }//GEN-LAST:event_miSearchActionPerformed

    private void miChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miChangeActionPerformed
        change();
    }//GEN-LAST:event_miChangeActionPerformed

    private void miCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCleanActionPerformed
        clean();
    }//GEN-LAST:event_miCleanActionPerformed

    private void miCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCloseActionPerformed
        close();
    }//GEN-LAST:event_miCloseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        change();
         clean();
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clean();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        close();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        clean();
    }//GEN-LAST:event_formPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbTypeSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblTypeSearch;
    private javax.swing.JMenu mbMenu;
    private javax.swing.JMenuItem miChange;
    private javax.swing.JMenuItem miClean;
    private javax.swing.JMenuItem miClose;
    private javax.swing.JMenuItem miDelete;
    private javax.swing.JMenuItem miSearch;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
