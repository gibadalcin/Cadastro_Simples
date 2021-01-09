package presentation;

import domain.Customer;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import dConnection.dbConnection;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author giba01
 */
public class registerCustomer extends javax.swing.JInternalFrame {
    Customer customer = new Customer();
    dbConnection connection = new dbConnection();
    /**
     * Creates new form registerCustomer
     */
    registerCustomer() {
        super("Cadastrar Clientes",false,true,false,false);
        initComponents();
        getRootPane().setDefaultButton(btnRegister);
        this.setLocation(20,45);
        if(operation.equals("alterar")){
            ftxtCpf.setVisible(false);
        if(mainForm.locationWindow==1){
        this.setLocation(20,354);
            txtName.setText(nome);
            ftxtCpf.setText(cpf);
            ftxtAge.setText(String.valueOf(idade));
            ftxtPhone.setText(telefone);
            txtEmail.setText(email);
            btnRegister.setText("Alterar");
            miRegistered.setText("Alterar");
            this.setTitle("Alterar Cliente");
            btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar1.png")));
            }
        else if(mainForm.locationWindow==2){
        this.setLocation(654,190);
         txtName.setText(nome);
            ftxtCpf.setText(cpf);
            ftxtAge.setText(String.valueOf(idade));
            ftxtPhone.setText(telefone);
            txtEmail.setText(email);
            btnRegister.setText("Alterar");
            miRegistered.setText("Alterar");
            this.setTitle("Alterar Cliente");
            btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar1.png")));
            }
      }
    }

    public void close(){
        dispose();
    }
    
    
    private void clean(){
        txtName.setText("");
        ftxtCpf.setText("");
        ftxtAge.setText(String.valueOf(""));
        ftxtPhone.setText("");
        txtEmail.setText("");
        txtName.requestFocus();
    }

    
    public void register(){
        if(txtName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o nome do cliente!", "Nome", JOptionPane.ERROR_MESSAGE, frameIcon);
            txtName.requestFocus();
        }else if(ftxtCpf.getText().equals("   .   .   -  ")){
            JOptionPane.showMessageDialog(null, "Digite o cpf do cliente!", "Cpf", JOptionPane.ERROR_MESSAGE, frameIcon);
            ftxtCpf.requestFocus();
        }else if(ftxtAge.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite a idade do cliente!", "Idade", JOptionPane.ERROR_MESSAGE, frameIcon);
            ftxtAge.requestFocus();
        }else if(ftxtPhone.getText().equals("(  )     -    ")){
            JOptionPane.showMessageDialog(null, "Digite o telefone do cliente!", "Telefone", JOptionPane.ERROR_MESSAGE, frameIcon);
            ftxtPhone.requestFocus();
        }else if(txtEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o email do cliente!", "Email", JOptionPane.ERROR_MESSAGE, frameIcon);
            txtEmail.requestFocus();
        }else{
            customer.setNome(txtName.getText());
          customer.setCpf(ftxtCpf.getText());
            try{
                customer.setIdade(Integer.parseInt(ftxtAge.getText()));
                customer.setTelefone(ftxtPhone.getText());
                customer.setEmail(txtEmail.getText());
                if(operation.equals("cadastrar")){     
                Customer registered = connection.customerSelect(customer.getCpf());
                if(registered != null){
                    JOptionPane.showMessageDialog(null,"Já existe um cliente cadastrado com este cpf!",
                            "Cliente já cadastrado!",JOptionPane.ERROR_MESSAGE);
                    ftxtCpf.requestFocus();
                    ftxtCpf.selectAll();
                }else {
                    int answer = connection.customerRegister(customer);
                    if(answer==1){
                        JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!",
                            "Cliente cadastrado!",JOptionPane.INFORMATION_MESSAGE);
                        clean();
                    }else
                        JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar cadastrar este cliente!",
                            "Erro!",JOptionPane.ERROR_MESSAGE);
                   }
                }else if(operation.equals("alterar")){
                    boolean changed=connection.updateClient(customer);
                    if(changed==true){
                        JOptionPane.showMessageDialog(null,"Cadastro alterado com sucesso!",
                            "Cadastro alterado!",JOptionPane.INFORMATION_MESSAGE);                           
                             clean();
                             close();
                            operation ="cadastrar";
                    }else{
                        JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar alterar este cliente!",
                            "Erro!",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }catch(HeadlessException | NumberFormatException erro){
                JOptionPane.showMessageDialog(null,"Idade informada inválida!",
                    "Idade!",JOptionPane.ERROR_MESSAGE);
                ftxtAge.requestFocus();
                ftxtAge.selectAll();
            }
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

        lblName = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        ftxtCpf = new javax.swing.JFormattedTextField();
        ftxtAge = new javax.swing.JFormattedTextField();
        ftxtPhone = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        mbMenu = new javax.swing.JMenu();
        miRegistered = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miClose = new javax.swing.JMenuItem();

        setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        lblName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblName.setText("Nome:");
        lblName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCpf.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblCpf.setText("Cpf:");
        lblCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblAge.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblAge.setText("Idade:");
        lblAge.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblPhone.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblPhone.setText("Telefone:");
        lblPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblEmail.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblEmail.setText("Email:");
        lblEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        try {
            ftxtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtCpf.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        try {
            ftxtAge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtAge.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        try {
            ftxtPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtPhone.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        btnRegister.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cadastrar.png"))); // NOI18N
        btnRegister.setText("Cadastrar");
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.setFocusable(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sair.png"))); // NOI18N
        btnClose.setText("Fechar");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setFocusable(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        mbMenu.setText("Menu");
        mbMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mbMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        miRegistered.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        miRegistered.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        miRegistered.setText("Cadastrar");
        miRegistered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegisteredActionPerformed(evt);
            }
        });
        mbMenu.add(miRegistered);
        mbMenu.add(jSeparator1);

        miClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_MASK));
        miClose.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        miClose.setText("Fechar");
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
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhone)
                            .addComponent(lblAge)
                            .addComponent(lblCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftxtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegister, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(26, 26, 26)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addGap(28, 28, 28)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblName))
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCpf))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAge))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhone)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblEmail))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCloseActionPerformed
        operation ="cadastrar";
        clean();
        close();
    }//GEN-LAST:event_miCloseActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
       operation ="cadastrar";
       clean();
       close();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
             register();          
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void miRegisteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegisteredActionPerformed
              register();
    }//GEN-LAST:event_miRegisteredActionPerformed

    
    protected static String operation="";
    protected static String nome="";
    protected static String cpf="";
    protected static int idade=0;
    protected static String telefone="";
    protected static String email="";
    protected static int id=0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRegister;
    private javax.swing.JFormattedTextField ftxtAge;
    private javax.swing.JFormattedTextField ftxtCpf;
    private javax.swing.JFormattedTextField ftxtPhone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JMenu mbMenu;
    private javax.swing.JMenuItem miClose;
    private javax.swing.JMenuItem miRegistered;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}