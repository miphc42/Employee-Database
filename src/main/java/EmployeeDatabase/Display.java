/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeDatabase;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author miphc
 */
public class Display extends javax.swing.JFrame {
    public DefaultTableModel model;
    MyHashTable myHash = new MyHashTable();
    public static EmployeeInfo temp;
    static int count2;
    FTE fte;
    PTE pte;
    
    /**
     * Creates new form Display
     */
    public Display() {
        initComponents();
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setForeground(Color.BLACK);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
headerRenderer.setBackground(new Color(255, 255, 255));
DefaultTableCellRenderer headerRenderer2 = new DefaultTableCellRenderer();
headerRenderer.setForeground(new Color(0, 0, 0));
for (int i = 0; i < table.getModel().getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer2);
        
}
for (int i = 0; i < table.getModel().getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        
}
table.setOpaque(false);
scroll.getViewport().setBackground(new Color(51,51,51));

        
        count2 = 0;
        myHash.displayEmployees();
    Action action = new AbstractAction(){
    @Override
    public void actionPerformed(ActionEvent e)
    {
        search();
    }
};
table.addMouseListener(new java.awt.event.MouseAdapter() {
@Override
 public void mouseClicked(java.awt.event.MouseEvent evt) {
    
     if(count2==0){
    int row = table.rowAtPoint(evt.getPoint());
    int col = table.columnAtPoint(evt.getPoint());
    int count = -1;
     System.out.println("ROW"+ row);
    String x =  table.getModel().getValueAt(row, 0).toString();
    temp = myHash.getFromTable(Integer.parseInt(x));
     
    
//    for (int i = 0; i < MyHashTable.buckets.length; i++) {
//        for(int c = 0; c < MyHashTable.buckets[i].size();c++){  
//            temp = MyHashTable.buckets[i].get(c);
//            count++;
//        }
//        if(count == row){   
//            break;
//        }
//      
//        
//        }
        System.out.println(temp.firstName);
        count2++;
        DisplayEmployee display = new DisplayEmployee();
        display.setVisible(true);
     }
    
//        try{
//        String partfull = "";
//        double salary = 0;
//        if(temp instanceof FTE){
//            fte = (FTE) temp;
//            partfull = "Full Time";
//            salary = fte.annualSalary;
//        }
//        else if(temp instanceof PTE){
//            pte = (PTE) temp;
//            partfull = "Part Time";
//            salary = pte.calcAnnualNetIncome();
//            
//        }
//        JOptionPane.showMessageDialog(null, partfull+" Employee"+"\n\n"+"Employee Number:  "+temp.employeeNumber+"\n"+"First Name:  "+temp.firstName+"\n"+"Last Name:  "+temp.lastName+"\n"+"Annual Salary:  "+"$"+salary+"\n","Employee Information", JOptionPane.PLAIN_MESSAGE);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Employee Not In System","", JOptionPane.PLAIN_MESSAGE);
//        }
    }      
});
        EN.addActionListener(action);
        model = (DefaultTableModel)table.getModel();
        try{
            ArrayList<EmployeeInfo> list = new ArrayList<>();
            for (ArrayList<EmployeeInfo> bucket : MyHashTable.buckets) 
                for (EmployeeInfo x : bucket) 
                    list.add(x);
                    
            myHash.displayEmployees();
            for (ArrayList<EmployeeInfo> bucket : MyHashTable.buckets) {
                for (EmployeeInfo x : bucket) {
                    String temp = "";
                    String gender1 = "";
                    double salary = 0;
                    if(x.gender ==0){
                        gender1 = "Male";
                    }
                    else if(x.gender == 1){
                        gender1 = "Female";
                    }
                    if(x instanceof PTE){
                        temp = "Part Time";
                        salary = ((PTE) x).calcAnnualNetIncome();
                    }
                    if(x instanceof FTE){
                        temp = "Full Time";
                        salary =   ((FTE) x).annualSalary;
                        
                    }
                    model.insertRow(model.getRowCount(), new Object[]{x.employeeNumber, x.firstName, x.lastName, gender1, "$"+salary, temp});  
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       invis();
        
        
    }
       public void invis(){
     homeSep.setVisible(false);
     addSep.setVisible(false);
     editSep.setVisible(false);
     removeSep.setVisible(false);
     settingSep.setVisible(false);   
    homeSep.setForeground(Color.white.brighter()); // top line color
    homeSep.setBackground(Color.white.brighter());
    addSep.setForeground(Color.white.brighter()); // top line color
    addSep.setBackground(Color.white.brighter());
    editSep.setForeground(Color.white.brighter()); // top line color
    editSep.setBackground(Color.white.brighter());
    removeSep.setForeground(Color.white.brighter()); // top line color
    removeSep.setBackground(Color.white.brighter());
    settingSep.setForeground(Color.white.brighter()); // top line color
    settingSep.setBackground(Color.white.brighter());  
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
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        setting = new javax.swing.JLabel();
        settingSep = new javax.swing.JSeparator();
        removeLabel = new javax.swing.JLabel();
        homeSep = new javax.swing.JSeparator();
        addLabel = new javax.swing.JLabel();
        addSep = new javax.swing.JSeparator();
        editLabel = new javax.swing.JLabel();
        editSep = new javax.swing.JSeparator();
        removeSep = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        EN = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display / Search");
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll.setBorder(null);

        table.setBackground(new java.awt.Color(51, 51, 51));
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Gender", "Salary", "FTE/PTE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFocusable(false);
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setRowHeight(25);
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 730, 390));

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EmployeeDatabase/icons8-back-24.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel3.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 40, -1));

        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EmployeeDatabase/icons8-home-24.png"))); // NOI18N
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeMouseExited(evt);
            }
        });
        jPanel3.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EmployeeDatabase/icons8-view-26.png"))); // NOI18N
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingMouseExited(evt);
            }
        });
        jPanel3.add(setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        settingSep.setOpaque(true);
        jPanel3.add(settingSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 24, 2));

        removeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EmployeeDatabase/icons8-remove-24 (1).png"))); // NOI18N
        removeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeLabelMouseExited(evt);
            }
        });
        jPanel3.add(removeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        homeSep.setForeground(new java.awt.Color(255, 255, 255));
        homeSep.setOpaque(true);
        jPanel3.add(homeSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 24, 2));

        addLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EmployeeDatabase/icons8-plus-24.png"))); // NOI18N
        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addLabelMouseExited(evt);
            }
        });
        jPanel3.add(addLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        addSep.setForeground(new java.awt.Color(255, 255, 255));
        addSep.setOpaque(true);
        jPanel3.add(addSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 24, 2));

        editLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EmployeeDatabase/icons8-edit-24 (2).png"))); // NOI18N
        editLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editLabelMouseExited(evt);
            }
        });
        jPanel3.add(editLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        editSep.setOpaque(true);
        jPanel3.add(editSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 24, 2));

        removeSep.setOpaque(true);
        jPanel3.add(removeSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 24, 2));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 460));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee Data Table");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 50));

        EN.setBackground(new java.awt.Color(51, 51, 51));
        EN.setForeground(new java.awt.Color(255, 255, 255));
        EN.setBorder(null);
        jPanel1.add(EN, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 250, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 250, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EmployeeDatabase/icons8-search-30 (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        try {
            MainMenu m = new MainMenu();
            m.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backMouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        try {
            MainMenu m = new MainMenu();
            m.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HomeMouseClicked

    private void HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseEntered
        homeSep.setVisible(true);
    }//GEN-LAST:event_HomeMouseEntered

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        homeSep.setVisible(false);
    }//GEN-LAST:event_HomeMouseExited

    private void settingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseClicked
        Display d = new Display();
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_settingMouseClicked

    private void settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseEntered
        settingSep.setVisible(true);
    }//GEN-LAST:event_settingMouseEntered

    private void settingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseExited
        settingSep.setVisible(false);
    }//GEN-LAST:event_settingMouseExited

    private void removeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeLabelMouseClicked
        Remove r = new Remove();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_removeLabelMouseClicked

    private void removeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeLabelMouseEntered
        removeSep.setVisible(true);
    }//GEN-LAST:event_removeLabelMouseEntered

    private void removeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeLabelMouseExited
        removeSep.setVisible(false);
    }//GEN-LAST:event_removeLabelMouseExited

    private void addLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLabelMouseClicked
        try {
            AddEmployee f = new AddEmployee();
            f.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addLabelMouseClicked

    private void addLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLabelMouseEntered
        addSep.setVisible(true);
    }//GEN-LAST:event_addLabelMouseEntered

    private void addLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLabelMouseExited
        addSep.setVisible(false);
    }//GEN-LAST:event_addLabelMouseExited

    private void editLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLabelMouseClicked
        Edit e = new Edit();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editLabelMouseClicked

    private void editLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLabelMouseEntered
        editSep.setVisible(true);
    }//GEN-LAST:event_editLabelMouseEntered

    private void editLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLabelMouseExited
        editSep.setVisible(false);
    }//GEN-LAST:event_editLabelMouseExited

    public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_ENTER){
        search();
    }
    }
    
    public void search(){
        try{
        temp =  myHash.getFromTable(Integer.parseInt(EN.getText()));
        DisplayEmployee display = new DisplayEmployee();
        display.setVisible(true);
        }catch(Exception e){
             // JOptionPane.showMessageDialog(null, "Employee Not In System","", JOptionPane.ERROR_MESSAGE);
              Error i = new Error();
            i.setVisible(true);
        }
        
//        try{
//        String partfull = "";
//        double salary = 0;
//        if(temp instanceof FTE){
//            fte = (FTE) temp;
//            partfull = "Full Time";
//            salary = fte.annualSalary;
//        }
//        else if(temp instanceof PTE){
//            pte = (PTE) temp;
//            partfull = "Part Time";
//            salary = pte.calcAnnualGrossIncome();
//            
//        }
//        JOptionPane.showMessageDialog(null, partfull+" Employee"+"\n\n"+"Employee Number:  "+temp.employeeNumber+"\n"+"First Name:  "+temp.firstName+"\n"+"Last Name:  "+temp.lastName+"\n"+"Annual Salary:  "+"$"+salary+"\n","Employee Information", JOptionPane.PLAIN_MESSAGE);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Employee Not In System","", JOptionPane.PLAIN_MESSAGE);
//        }
    }

   
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display().setVisible(true);
          
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EN;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel addLabel;
    private javax.swing.JSeparator addSep;
    private javax.swing.JLabel back;
    private javax.swing.JLabel editLabel;
    private javax.swing.JSeparator editSep;
    private javax.swing.JSeparator homeSep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel removeLabel;
    private javax.swing.JSeparator removeSep;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel setting;
    private javax.swing.JSeparator settingSep;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
