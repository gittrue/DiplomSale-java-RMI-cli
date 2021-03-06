/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.divotek.level;

import com.divotek.control.formControlAdmin;
import com.divotek.control.formControlTeacher;
import com.divotek.helpers.Singleton;
import com.divotek.users.jpa.hibernate.Person;
import com.divotek.users.jpa.hibernate.Teacher;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author maxxl
 */
public class LoginForm extends javax.swing.JFrame implements LEVEL{
public static LoginForm lf;
    /** Creates new form LoginForm */
    public LoginForm() {
        initComponents();
	  Singleton instance = Singleton.getInstance();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      jLabel3 = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jPasswordField1 = new javax.swing.JPasswordField();
      jTextField1 = new javax.swing.JTextField();
      jButton1 = new javax.swing.JButton();
      jTextField2 = new javax.swing.JTextField();
      jLabel4 = new javax.swing.JLabel();

      jLabel3.setText("jLabel3");

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setBackground(new java.awt.Color(255, 255, 255));

      jLabel1.setText("Логин");

      jLabel2.setText("Пароль");

      jButton1.setText("Войти");
      jButton1.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            jButton1ActionPerformed(evt);
         }
      });

      jTextField2.setText("127.0.0.1");

      jLabel4.setText("IP host");

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jButton1)
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .add(layout.createSequentialGroup()
            .add(90, 90, 90)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
               .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                  .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .add(jLabel4))
            .add(18, 18, 18)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
               .add(jTextField2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
               .add(jPasswordField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
               .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
            .addContainerGap(90, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(59, 59, 59)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel1)
               .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(18, 18, 18)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel2)
               .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 48, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(jLabel4))
            .add(18, 18, 18)
            .add(jButton1)
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents
/** Кнопка войти
 */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
   {//GEN-HEADEREND:event_jButton1ActionPerformed
      
       if (IpValid.validate(jTextField2.getText()))
	{
          
            Singleton ic = Singleton.getInstance();
            ic.setIpConn(jTextField2.getText());
            Teacher T=new Teacher();
            T.setLevel(LEVELADMIN);
            T.setLogin("admin");
            T.setPass("admin");
            T.setId(1);
            
if(T.getLogin().equals(jTextField1.getText())&&T.getPass().equals(jPasswordField1.getText()))
			   {
                            formControlAdmin.fca = new formControlAdmin();
                            formControlAdmin.fca.setVisible(true);
                            lf.setVisible(false);
			   }else {
	
    
	 ic.getManager().createQuery("from Teacher", Teacher.class).getResultList().forEach(g ->{
		  
			ic.setOneTeacher(g); 
			if(g.getLogin().equals(jTextField1.getText())&&g.getPass().equals(jPasswordField1.getText()))
			{
			   ic.setItTeacher(g);
			
			if(g.getLevel().equals(LEVELTEACHER))
			{
				formControlTeacher.fct = new formControlTeacher();
                                formControlTeacher.fct.setVisible(true);
                                lf.setVisible(false);
			}	
			
			}
		   
		});
	
	}}
	else 
	{
	   JOptionPane.showMessageDialog(rootPane, "ИП Адресс не коректен");
	}

	
   }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            lf=   new LoginForm();
            lf.setVisible(true);
       });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButton1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JPasswordField jPasswordField1;
   private javax.swing.JTextField jTextField1;
   private javax.swing.JTextField jTextField2;
   // End of variables declaration//GEN-END:variables

    public void clearField() {
    jTextField1.setText("");
    jPasswordField1.setText("");
    }

}
