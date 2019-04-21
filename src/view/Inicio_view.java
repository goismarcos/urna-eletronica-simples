package view;

import java.awt.Color;
import javax.swing.JOptionPane;
import model.bean.Eleitor;
import model.dao.EleitorDAO;

/**
 *
 * @author Marcos
 */
public class Inicio_view extends javax.swing.JFrame 
{

    /**
     * Creates new form Inicio_view
     */
    public Inicio_view() 
    {
        //INICIALIZADOR
        initComponents();
        
        //MUDANDO A COR DE FUNDO DO FORM 
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_comecar_votacao = new javax.swing.JButton();
        btn_adm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Urna eletronica");

        btn_comecar_votacao.setBackground(new java.awt.Color(51, 51, 51));
        btn_comecar_votacao.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_comecar_votacao.setForeground(new java.awt.Color(255, 255, 255));
        btn_comecar_votacao.setText("Iniciar votação");
        btn_comecar_votacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comecar_votacaoActionPerformed(evt);
            }
        });

        btn_adm.setBackground(new java.awt.Color(51, 51, 51));
        btn_adm.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_adm.setForeground(new java.awt.Color(255, 255, 255));
        btn_adm.setText("Administrativo");
        btn_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_admActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marcos\\Desktop\\misis.png")); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(btn_comecar_votacao, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(146, Short.MAX_VALUE)
                    .addComponent(btn_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(142, 142, 142)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(btn_comecar_votacao, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(btn_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(241, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_comecar_votacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comecar_votacaoActionPerformed
        String num = null;
        num = JOptionPane.showInputDialog("Digite seu numero de eleitor.");
        
        EleitorDAO eleitor_dao = new EleitorDAO();
        Eleitor eleitor = new Eleitor();
        
        eleitor.setNum_eleitor(Integer.parseInt(num));
        
        int result = eleitor_dao.Verifica_eleitor(eleitor);
        
        if(result > 0)
        {
            //DESABILITA O ELEITOR PARA NAO VOTAR DUAS VEZES
            eleitor_dao.Desabilita_eleitor(eleitor);
            //INICIA A VOTAÇÃO
            //INSTANCIANDO A CLASSE URNA_VIEW E DEIXANDO VISIVEL
            Urna_view u = new Urna_view();
            u.setVisible(true);

            //FECHANDO INICIO
            setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro: Eleitor não encontrado ou já voltou!");
        }
        
        
    }//GEN-LAST:event_btn_comecar_votacaoActionPerformed

    private void btn_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_admActionPerformed
        
        //INSTANCIANDO A CLASSE INICIO_VIEW E DEIXANDO VISIVEL
        Central_adm_view c = new Central_adm_view();
        c.setVisible(true);
        
        //FECHANDO INICIO
        setVisible(false);
    }//GEN-LAST:event_btn_admActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> 
        {
            new Inicio_view().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adm;
    private javax.swing.JButton btn_comecar_votacao;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
